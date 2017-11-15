/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryproject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author majin_000
 */
public class mainMenuUI extends JFrame implements 
        ActionListener{
    JMenuBar menuBR;
    JMenuItem bookI, userI, recordI, recordListI, userListI, bookListI, logListI;
    BorderLayout borderLayoutMgr;
    userManagementUI userManageUI;
    BookManagementUI bookManageUI;
    UserProfile userProfileUI;
    bookBorrowUI borrowUI;
    RecordManageUI recordManageUI;
    MyRecordManageUI myRecordsUI;
    User myUser = new User();
    int logIndex = 1;
    int userIndex = 1;
    int recordIndex = 1;
    ArrayList<Book> books = new ArrayList<Book>();
    public mainMenuUI(User currentUser) {
        myUser = currentUser;
        setTitle("Library System - Welcome");
        if (myUser.getMyRole().equals("sysadmin") ||
           myUser.getMyRole().equals("bookadmin")) {
            menuBR = new JMenuBar();
            setJMenuBar(menuBR);
        
            JMenu manageM = new JMenu("Management");
            JMenu outputM = new JMenu("Output");
        
            menuBR.add(manageM);
            menuBR.add(outputM);
            
            userI = new JMenuItem("User Management");
            userI.addActionListener(this);
            userListI = new JMenuItem("User List");
            userListI.addActionListener(this);
            logListI = new JMenuItem("Login Log List");
            logListI.addActionListener(this);            
            if (myUser.getMyRole().equals("sysadmin")) {
                manageM.add(userI);
                outputM.add(userListI);
                outputM.add(logListI);
            }
            bookI = new JMenuItem("Book Management");
            bookI.addActionListener(this);
            manageM.add(bookI);
            recordI = new JMenuItem("Record Management");
            recordI.addActionListener(this);
            manageM.add(recordI);
                    
            bookListI = new JMenuItem("Book List");
            bookListI.addActionListener(this);
            outputM.add(bookListI);
            recordListI = new JMenuItem("Record List");
            recordListI.addActionListener(this);
            outputM.add(recordListI);
            
        }
        
        JLabel welcomeL = new JLabel("Welcome User: " + myUser.getUserName(), SwingConstants.CENTER);
        JButton userB = new JButton("User Profile");
        userB.addActionListener(this);
        JButton borrowB = new JButton("Borrow");
        borrowB.addActionListener(this);
        JButton recordB = new JButton("My Records");
        recordB.addActionListener(this);
        JButton exitB = new JButton("Exit");
        exitB.addActionListener(this);
        
        welcomeL.setLocation(200, 0);
        welcomeL.setSize(200, 30);
        userB.setLocation(130, 100);
        userB.setSize(120, 30);
        borrowB.setLocation(130, 150);
        borrowB.setSize(120, 30);
        recordB.setLocation(130, 200);
        recordB.setSize(120, 30);
        exitB.setLocation(130, 250);
        exitB.setSize(120, 30);
        
        Container pane = getContentPane();
        pane.setLayout(null);
        pane.add(welcomeL);
        pane.add(userB);
        pane.add(borrowB);
        pane.add(recordB);
        pane.add(exitB);
        
        
        
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPenalty();
        GetPenalty();
    }

    private void GetBookList() { 
        books = new ArrayList<Book>();
        books = OracleConnect.doSelectAllBook();
        if (books != null && !books.isEmpty()) {
            for (Book b: books) {
                Publisher tmpPublisher = OracleConnect.doSelectPublisher(b.getPublisher().getPid());
                if (tmpPublisher != null) {
                    b.setPublisher(tmpPublisher);
                }
            }
        }
    }

    public void setPenalty() {
        ArrayList<Record> records = new ArrayList<>();
        
        records = OracleConnect.doSelectAllRecordsForSpeicalUser(myUser.getUserName());
        Date today = new Date();
        if (records != null && !records.isEmpty()) {
            for (Record r: records) {
                if ((r.getDueTime().getTime() - today.getTime()) < 0) {
                    r.setPenalty(r.doCalculatePenalty());
                    OracleConnect.doUpdateRecord(r);
                }
            }
        }
    }
    
    public void GetPenalty() {
        ArrayList<Record> records = new ArrayList<>();
        
        records = OracleConnect.doSelectAllRecordsForSpeicalUser(myUser.getUserName());
        String str = "";
        if (records != null && !records.isEmpty()) {
            for (Record r: records) {
                if (r.getPenalty() > 0 && r.getIsReturn() == 0) {
                    str += "Record: " + r.getRecordId() + "\n\tBook Id: " + r.getBid()
                            + "\n\tBorrow Time: " + r.getBorrowTime() + "\n\tDue Time: "
                            + r.getDueTime() + "\n\tPenalty: " + r.getPenalty() + "\n";
                }
            }
        }
        if (!str.equals("")) {
            JOptionPane.showMessageDialog(null, "You should return these book as soon as possible" + "\n" + str, "Penalty List", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("User Profile")) {
            userProfileUI = new UserProfile(myUser);
        }
        if (e.getActionCommand().equals("Borrow")) {
            borrowUI = new bookBorrowUI(myUser);
        }
        if (e.getActionCommand().equals("User Management")) {
            userManageUI = new userManagementUI();
        }
        if (e.getActionCommand().equals("Book List")) {
            GetBookList();
            if (books == null || books.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No any book record", "Book List", JOptionPane.INFORMATION_MESSAGE);
            } else {
                String bookStr = "";
                int index = 1;
                for (Book b: books) {
                    bookStr += "record" + index + ":\nISBN: " + b.getIsbn()
                        + "\ntitle: " + b.getTitle()
                        + "\nauthor: " + b.getAuthor() + "\nprice: " + b.getPrice()
                        + "\nquantity: "+ b.getQuantity() + "\nborrow history:"
                        + b.getHistory() + "\n\n";
                    index++;
                }
                JOptionPane.showMessageDialog(null, bookStr, "Book List", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (e.getActionCommand().equals("User List")) {
            ArrayList<User> users = OracleConnect.doSelectAllUser();
            if (users == null || users.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No any user record", "User List", JOptionPane.INFORMATION_MESSAGE);
            } else {
                String userStr = "";
                for (User u: users) {
                    userStr += "record" + userIndex + ":\nusername: " + u.getUserName()
                        + "\nfull name: " + u.getFname()
                        + " " + u.getLname() + "\nrole: " + u.getMyRole()
                        + "\n\n";
                    userIndex++;
                }
                JOptionPane.showMessageDialog(null, userStr, "User List", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (e.getActionCommand().equals("Record List")) {
            ArrayList<Record> records = OracleConnect.doSelectAllRecords();
            if (records == null || records.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No any borrow record", "Borrow Records List", JOptionPane.INFORMATION_MESSAGE);
            } else {
                String recordStr = "";
                for (Record r: records) {
                    recordStr += "record" + recordIndex + ":\nrecordId: " + r.getRecordId()
                        + "\nusername: " + r.getUsername()
                        + "\nborrowTime: " + r.getBorrowTime().toString()
                        + "\ndueTime: " + r.getDueTime()
                        + "\nbid: " + r.getBid()
                        + "\npenalty: " + r.getPenalty()
                        + "\nisReturn: " + r.getIsReturn()
                        + "\n\n";
                    recordIndex++;
                }
                JOptionPane.showMessageDialog(null, recordStr, "Borrow Records List", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        if (e.getActionCommand().equals("My Records")) {
            myRecordsUI = new MyRecordManageUI(myUser);
        }
        if (e.getActionCommand().equals("Login Log List")) {
            ArrayList<Loginlog> logs = OracleConnect.doSelectAllLoginRecords();
            if (logs == null || logs.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No any login log record", "Login Log List", JOptionPane.INFORMATION_MESSAGE);
            } else {
                String logStr = "";
                for (Loginlog l: logs) {
                    logStr += "record" + logIndex + ":\nlogId: " + l.getLogId()
                        + "\nuser: " + l.getUsername()
                        + "\ndescription: " + l.getDesc()
                        + "\n\n";
                    logIndex++;
                }
                JOptionPane.showMessageDialog(null, logStr, "Login Log List", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }
        if (e.getActionCommand().equals("Book Management")) {
            bookManageUI = new BookManagementUI();
        }
        if (e.getActionCommand().equals("Record Management")) {
            recordManageUI = new RecordManageUI();
        }
    }
}
