package libraryproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.regex.*;
import java.io.*;

/**
 *
 * @author Jingze Ma
 */
public class LibraryProject extends JFrame implements ActionListener{
    Scanner inFile = null;
    JTextField userNameTF;
    JPasswordField passwordPF;
    User loginUser;
    mainMenuUI mainUI;
    userEditUI loginUserEditUI;
    String host, port, databaseName, oracleName, oraclePwd;
    String url;
    public LibraryProject()
    {
        loginUser = new User();
        setTitle("Library System - Log in");
        JLabel userNameL = new JLabel("username: ", SwingConstants.RIGHT);
        JLabel passwordL = new JLabel("password: ", SwingConstants.RIGHT);
        
        userNameTF = new JTextField(8);
        passwordPF = new JPasswordField(8);
        
        JButton loginB = new JButton("Login");
        loginB.addActionListener(this);
        JButton resetB = new JButton("Reset");
        resetB.addActionListener(this);
        JButton registerB = new JButton("Register");
        registerB.addActionListener(this);
        JButton exitB = new JButton("Exit");
        exitB.addActionListener(this);
        
        Container pane = getContentPane();
        pane.setLayout(null);
        
        userNameL.setLocation(20, 80);
        userNameL.setSize(140, 20);
        userNameTF.setLocation(160, 80);
        userNameTF.setSize(200, 20);
        passwordL.setLocation(20, 125);
        passwordL.setSize(140, 20);
        passwordPF.setLocation(160, 125);
        passwordPF.setSize(200, 20);
        
        loginB.setLocation(20, 240);
        loginB.setSize(100, 30);
        resetB.setLocation(130, 240);
        resetB.setSize(100, 30);
        registerB.setLocation(240, 240);
        registerB.setSize(100, 30);
        exitB.setLocation(350, 240);
        exitB.setSize(100, 30);
        
        pane.add(userNameL);
        pane.add(userNameTF);
        pane.add(passwordL);
        pane.add(passwordPF);
        pane.add(loginB);
        pane.add(resetB);
        pane.add(registerB);
        pane.add(exitB);
        
        setSize(485, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        readConfigFile("config.ini");
    }
    
    public static void main(String[] args) {
        LibraryProject myLibrary = new LibraryProject();
    }
    
    public void readConfigFile(String path){
        Scanner in;
        host = "";
        port = "";
        databaseName = "";
        oracleName = "";
        oraclePwd = "";
        
        try {
            in = new Scanner(new FileReader("config.ini"));
            String regexp = ":";
            while (in.hasNext()) {
                host = in.next().split(regexp)[1];
                port = in.next().split(regexp)[1];
                databaseName = in.next().split(regexp)[1];
                oracleName = in.next().split(regexp)[1];
                oraclePwd = in.next().split(regexp)[1];
            }
            OracleConnect.url = "jdbc:oracle:thin:@" + host + ":" + port + ":" + databaseName;
            OracleConnect.oracleUser = oracleName;
            OracleConnect.oraclePwd = oraclePwd;
            in.close();
            //selinitRoles();
        } catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "the file doesn't exist", "File Not Found", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Login")) {
            Boolean done = true;
            done = validate.validateUserNameAndPwd(userNameTF.getText(), new String(passwordPF.getPassword()));
            if (done) {
                loginUser = validate.validUserAndPwd(userNameTF.getText(), new String(passwordPF.getPassword()));
                if (loginUser != null) {
                    this.setVisible(false);
                    OracleConnect.doAddLog(userNameTF.getText());
                    mainUI = new mainMenuUI(loginUser);
                } else {
                    JOptionPane.showMessageDialog(null, "user name / password is invalid.", "Invalid username/password", JOptionPane.ERROR_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid username or password", "Invalid username/password", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }
        if (e.getActionCommand().equals("Reset")) {
            userNameTF.setText("");
            passwordPF.setText("");
        }
        if (e.getActionCommand().equals("Register")) {
            loginUserEditUI = new userEditUI(loginUser, "Register");
        }
    }
}
