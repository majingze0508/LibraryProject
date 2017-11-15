/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author majin_000
 */
public class userEditUI extends JFrame  implements ActionListener{
    JTextField userNameTF, lastNameTF, firstNameTF,
            countryTF, provinceTF, cityTF, addressTF, zipTF, emailTF, phoneTF;
    JPasswordField passwordPF, confirmPasswordPF;
    JComboBox roleTypeCB;
    String[] roleStrings = { "sysadmin", "bookadmin", "user"};
    User myUser;
    String roleTypeStr = "";
    public userEditUI(User currentUser, String operation) {
        myUser = currentUser;
        if (!operation.equals("Register")) {
            setTitle("Library System - User Edit");
        }
        else {
            setTitle("Library System - Register New User");
        }
        roleTypeCB = new JComboBox(roleStrings);
        roleTypeCB.addActionListener(this);
        roleTypeStr = roleTypeCB.getItemAt(0).toString();
        JLabel userNameL = new JLabel("username: ", SwingConstants.RIGHT);
        JLabel passwordL = new JLabel("password: ", SwingConstants.RIGHT);
        JLabel confirmPasswordL = new JLabel("confirm password: ", SwingConstants.RIGHT);
        JLabel fnameL = new JLabel("First Name: ", SwingConstants.RIGHT);
        JLabel lnameL = new JLabel("Last Name: ", SwingConstants.RIGHT);
        JLabel roleTypeL = new JLabel("Role Type: ", SwingConstants.RIGHT);
        JLabel countryL = new JLabel("Country: ", SwingConstants.RIGHT);
        JLabel provinceL = new JLabel("Province: ", SwingConstants.RIGHT);
        JLabel cityL = new JLabel("City: ", SwingConstants.RIGHT);
        JLabel addressL = new JLabel("Address: ", SwingConstants.RIGHT);
        JLabel zipL = new JLabel("Zip: ", SwingConstants.RIGHT);
        JLabel emailL = new JLabel("email: ", SwingConstants.RIGHT);
        JLabel phoneL = new JLabel("Mobile Number: ", SwingConstants.RIGHT);
        
        userNameTF = new JTextField(8);
        passwordPF = new JPasswordField(8);
        confirmPasswordPF = new JPasswordField(8);
        firstNameTF = new JTextField(8);
        lastNameTF = new JTextField(8);
        countryTF = new JTextField(8);
        provinceTF = new JTextField(8);
        cityTF = new JTextField(8);
        addressTF = new JTextField(8);
        zipTF = new JTextField(8);
        emailTF = new JTextField(8);
        phoneTF = new JTextField(8);
        
        JButton addB = new JButton("Add");
        addB.addActionListener(this);
        JButton updateB = new JButton("Update");
        updateB.addActionListener(this);
        JButton resetB = new JButton("Reset");
        resetB.addActionListener(this);
        JButton exitB = new JButton("Exit");
        exitB.addActionListener(this);
        
        Container pane = getContentPane();
        if (!operation.equals("Register")) {
            pane.setLayout(new GridLayout(20, 2));
        } else {
            pane.setLayout(new GridLayout(16, 2));
        }
        
        pane.add(userNameL);
        pane.add(userNameTF);
        pane.add(passwordL);
        pane.add(passwordPF);
        pane.add(confirmPasswordL);
        pane.add(confirmPasswordPF);
        pane.add(fnameL);
        pane.add(firstNameTF);
        pane.add(lnameL);
        pane.add(lastNameTF);
        pane.add(roleTypeL);
        pane.add(roleTypeCB);
        pane.add(countryL);
        pane.add(countryTF);
        pane.add(provinceL);
        pane.add(provinceTF);
        pane.add(cityL);
        pane.add(cityTF);
        pane.add(addressL);
        pane.add(addressTF);
        pane.add(zipL);
        pane.add(zipTF);
        pane.add(emailL);
        pane.add(emailTF);
        pane.add(phoneL);
        pane.add(phoneTF);
        pane.add(addB);
        if (!operation.equals("Register")) {
            pane.add(updateB);
        } 
        pane.add(resetB);
        pane.add(exitB);
        
        if (currentUser != null && !currentUser.getUserName().isEmpty()) {
            userNameTF.setText(currentUser.getUserName());
            passwordPF.setText(currentUser.getPassword());
            confirmPasswordPF.setText(currentUser.getPassword());
            firstNameTF.setText(currentUser.getFname());
            lastNameTF.setText(currentUser.getLname());
            roleTypeCB.setSelectedItem(currentUser.getMyRole());
            countryTF.setText(currentUser.getCountry());
            provinceTF.setText(currentUser.getProvince());
            cityTF.setText(currentUser.getCity());
            addressTF.setText(currentUser.getAddress());
            zipTF.setText(currentUser.getZip());
            emailTF.setText(currentUser.getEmail());
            phoneTF.setText(currentUser.getPhone());
        }
        
        setSize(485, 320);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add")) {
            if (!validate.matchesUserNamePolicy(userNameTF.getText())) {
                JOptionPane.showMessageDialog(null, "user name is invalid", "Invalid User Name", JOptionPane.ERROR_MESSAGE);
            } else if (!validate.matchesPwdPolicy(new String(passwordPF.getPassword()))) {
                JOptionPane.showMessageDialog(null, "password is invalid", "Invalid Password", JOptionPane.ERROR_MESSAGE);
            } else if (!new String(passwordPF.getPassword()).equals(new String(confirmPasswordPF.getPassword()))) {
                JOptionPane.showMessageDialog(null, "confirm password is not correct", "Cofirm Password Error", JOptionPane.ERROR_MESSAGE);
            } else if (!validate.matchesZipPolicy(zipTF.getText())) {
                System.out.println(zipTF.getText());
                JOptionPane.showMessageDialog(null, "zip code is invalid", "Invalid Zip Code", JOptionPane.ERROR_MESSAGE);
            } else if (!validate.matchesEmailPolicy(emailTF.getText())) {
                JOptionPane.showMessageDialog(null, "email is invalid", "Invalid Email", JOptionPane.ERROR_MESSAGE);
            } else if (!validate.matchesMobileNumberPolicy(phoneTF.getText())) {
                JOptionPane.showMessageDialog(null, "mobile number is invalid", "Invalid Mobile Number", JOptionPane.ERROR_MESSAGE);
            } else {
                OracleConnect.doAddUser(userNameTF.getText(), lastNameTF.getText(), firstNameTF.getText(),
                    new String(passwordPF.getPassword()), countryTF.getText(), provinceTF.getText(), cityTF.getText(),
                    addressTF.getText(), zipTF.getText(), emailTF.getText(), phoneTF.getText(), roleTypeStr);
                setVisible(false);
            }
        }
        if (e.getSource().equals(roleTypeCB)) {
            roleTypeStr = roleTypeCB.getSelectedItem().toString();
        }
        if (e.getActionCommand().equals("Update")) {
            if (!myUser.getUserName().equals(userNameTF.getText())) {
                JOptionPane.showMessageDialog(null, "user name can't modify", "Invalid User Name", JOptionPane.ERROR_MESSAGE);
            } else if (!validate.matchesPwdPolicy(new String(passwordPF.getPassword()))) {
                JOptionPane.showMessageDialog(null, "password is invalid", "Invalid Password", JOptionPane.ERROR_MESSAGE);
            } else if (!new String(passwordPF.getPassword()).equals(new String(confirmPasswordPF.getPassword()))) {
                JOptionPane.showMessageDialog(null, "confirm password is not correct", "Cofirm Password Error", JOptionPane.ERROR_MESSAGE);
            } else if (!validate.matchesZipPolicy(zipTF.getText())) {
                System.out.println(zipTF.getText());
                JOptionPane.showMessageDialog(null, "zip code is invalid", "Invalid Zip Code", JOptionPane.ERROR_MESSAGE);
            } else if (!validate.matchesEmailPolicy(emailTF.getText())) {
                JOptionPane.showMessageDialog(null, "email is invalid", "Invalid Email", JOptionPane.ERROR_MESSAGE);
            } else if (!validate.matchesMobileNumberPolicy(phoneTF.getText())) {
                JOptionPane.showMessageDialog(null, "mobile number is invalid", "Invalid Mobile Number", JOptionPane.ERROR_MESSAGE);
            } else {
                OracleConnect.doUpdateUser(userNameTF.getText(), lastNameTF.getText(), firstNameTF.getText(),
                    new String(passwordPF.getPassword()), countryTF.getText(), provinceTF.getText(), cityTF.getText(),
                    addressTF.getText(), zipTF.getText(), emailTF.getText(), phoneTF.getText(), roleTypeStr);
                setVisible(false);
            }
        }
        if (e.getActionCommand().equals("Exit")) {
            this.setVisible(false);
        }
        if (e.getActionCommand().equals("Reset")) {
            userNameTF.setText("");
            passwordPF.setText("");
            confirmPasswordPF.setText("");
            firstNameTF.setText("");
            lastNameTF.setText("");
            roleTypeCB.setSelectedIndex(0);
            countryTF.setText("");
            provinceTF.setText("");
            cityTF.setText("");
            addressTF.setText("");
            zipTF.setText("");
            emailTF.setText("");
            phoneTF.setText("");
        }
    }
    
}
