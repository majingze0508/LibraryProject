/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryproject;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author majin_000
 */
public class OracleConnect {
    static Connection c;
    static String query = "";
    static Statement s;
    static ResultSet result = null;
    static String url;
    static String oracleUser;
    static String oraclePwd;
    
    public static void doInsertCategory(Category myCategory) {
        c = null;
        query = "";
        s = null;
        try {
            System.out.println("* Loading the driver *");
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
            s = c.createStatement();
            System.out.println(" ******** init userRoles table ********");
            query = "INSERT INTO category"
		+ "(categoryId, description) VALUES"
		+ "('" + myCategory.getId() + "', '" + myCategory.getDesc() + "')";
            s.executeUpdate(query);
            c.commit();
            c.close();
            
        } catch (Exception e) {
            try
            {
                c.rollback();
            }
            catch(Exception ee) {
                System.out.println("Error !");
            }
            System.out.println("Error - User table has error : " + e);
        }
    }
    
    public static User isExistedUser(String name, String pwd) {
        c = null;
        query = "";
        s = null;
        result = null;
        User loginUser = new User();
        Boolean done = false;
        try {
            System.out.println("* Loading the driver *");
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
            s = c.createStatement();
     
            System.out.println(" ******** selsect user ********");
            query = "SELECT username, lname, fname, password, role " +
                    " FROM users WHERE username = '" + name + "' AND password = '" + pwd + "'";
            result = s.executeQuery(query);
            
            while(result.next()) {
                loginUser.setUserName(result.getString("username"));
                loginUser.setPassword(result.getString("password"));
                loginUser.setLname(result.getString("lname"));
                loginUser.setFname(result.getString("fname"));
                loginUser.setMyRole(result.getString("role"));
                done = true;
            }
            query = "SELECT country, province, city, address, zip, email, mobilenumber " +
                    " FROM userdetail WHERE username = '" + name + "'";
            result = s.executeQuery(query);
            while(result.next()) {
                loginUser.setCountry(result.getString("country"));
                loginUser.setProvince(result.getString("province"));
                loginUser.setCity(result.getString("city"));
                loginUser.setAddress(result.getString("address"));
                loginUser.setZip(result.getString("zip"));
                loginUser.setEmail(result.getString("email"));
                loginUser.setPhone(result.getString("mobilenumber"));
                done = true;
            }
            c.commit();
            c.close();
            if (!done) {
                return null;
            }
            return loginUser;
        } catch (Exception e) {
            try
            {
                c.rollback();
            }
            catch(Exception ee) {
                System.out.println("Error !");
            }
            System.out.println("Error - User table has error : " + e);
            return null;
        }
    }
    public static User doSelectUser(String name) {
        c = null;
        query = "";
        s = null;
        result = null;
        User loginUser = new User();
        Boolean done = false;
        try {
            System.out.println("* Loading the driver *");
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
            s = c.createStatement();
     
            System.out.println(" ******** selsect user ********");
            query = "SELECT username, lname, fname, password, role " +
                    " FROM users WHERE username = '" + name + "'";
            result = s.executeQuery(query);
            
            while(result.next()) {
                loginUser.setUserName(result.getString("username"));
                loginUser.setPassword(result.getString("password"));
                loginUser.setLname(result.getString("lname"));
                loginUser.setFname(result.getString("fname"));
                loginUser.setMyRole(result.getString("role"));
                done = true;
            }
            query = "SELECT country, province, city, address, zip, email, mobilenumber " +
                    " FROM userdetail WHERE username = '" + name + "'";
            result = s.executeQuery(query);
            while(result.next()) {
                loginUser.setCountry(result.getString("country"));
                loginUser.setProvince(result.getString("province"));
                loginUser.setCity(result.getString("city"));
                loginUser.setAddress(result.getString("address"));
                loginUser.setZip(result.getString("zip"));
                loginUser.setEmail(result.getString("email"));
                loginUser.setPhone(result.getString("mobilenumber"));
                done = true;
            }
            c.commit();
            c.close();
            if (!done) {
                return null;
            }
            return loginUser;
        } catch (Exception e) {
            try
            {
                c.rollback();
            }
            catch(Exception ee) {
                System.out.println("Error !");
            }
            System.out.println("Error - User table has error : " + e);
            return null;
        }
    }

    public static ArrayList<User> doSelectAllUser() {
        c = null;
        query = "";
        s = null;
        result = null;
        ArrayList<User> userList = new ArrayList<User>();
        try {
            System.out.println("* Loading the driver *");
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
            s = c.createStatement();
     
            System.out.println(" ******** selsect user list ********");
            query = "SELECT * FROM users";
            result = s.executeQuery(query);
            
            while(result.next()) {
                User tempUser = new User();
                tempUser.setUserName(result.getString("username"));
                tempUser.setLname(result.getString("lname"));
                tempUser.setFname(result.getString("fname"));
                tempUser.setPassword(result.getString("password"));
                tempUser.setMyRole(result.getString("role"));
                userList.add(tempUser);
            }
            c.commit();
            c.close();
            return userList;
        } catch (Exception e) {
            try
            {
                c.rollback();
            }
            catch(Exception ee) {
                System.out.println("Error !");
            }
            System.out.println("Error - User table has error : " + e);
            return null;
        }
    }
    public static ArrayList<Category> doSelectAllCategory() {
        c = null;
        query = "";
        s = null;
        result = null;
        ArrayList<Category> categoryList = new ArrayList<>();
        try {
            System.out.println("* Loading the driver *");
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
            s = c.createStatement();
     
            System.out.println(" ******** selsect category list ********");
            query = "SELECT * FROM category";
            result = s.executeQuery(query);
            
            while(result.next()) {
                Category tempCategory = new Category();
                tempCategory.setId(result.getString("categoryId"));
                tempCategory.setDesc(result.getString("description"));
                categoryList.add(tempCategory);
            }
            c.commit();
            c.close();
            return categoryList;
        } catch (Exception e) {
            try
            {
                c.rollback();
            }
            catch(Exception ee) {
                System.out.println("Error !");
            }
            System.out.println("Error - User table has error : " + e);
            return null;
        }
    }
    public static ArrayList<Book> doSelectAllBook() {
        c = null;
        query = "";
        s = null;
        result = null;
        ArrayList<Book> bookList = new ArrayList<Book>();
        try {
            System.out.println("* Loading the driver *");
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
            s = c.createStatement();
     
            System.out.println(" ******** selsect book list ********");
            query = "SELECT * FROM book";
            result = s.executeQuery(query);
            
            while(result.next()) {
                Book tempBook = new Book();
                Publisher tempPubliser = new Publisher();
                tempBook.setId(result.getInt("bId"));
                tempBook.setIsbn(result.getString("ISBN"));
                tempBook.setTitle(result.getString("title"));
                tempBook.setAuthor(result.getString("author"));
                tempPubliser.setPid(result.getInt("pid"));
                tempBook.setPublisher(tempPubliser);
                tempBook.setCid(result.getString("cid"));
                tempBook.setPrice(result.getDouble("price"));
                tempBook.setQuantity(result.getInt("quantity"));
                tempBook.setHistory(result.getString("history"));
                bookList.add(tempBook);
            }
            c.commit();
            c.close();
            return bookList;
        } catch (Exception e) {
            try
            {
                c.rollback();
            }
            catch(Exception ee) {
                System.out.println("Error !");
            }
            System.out.println("Error - User table has error : " + e);
            return null;
        }
    }
    public static ArrayList<Publisher> doSelectAllPublisher() {
        c = null;
        query = "";
        s = null;
        result = null;
        ArrayList<Publisher> publisherList = new ArrayList<Publisher>();
        try {
            System.out.println("* Loading the driver *");
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
            s = c.createStatement();
     
            System.out.println(" ******** selsect publisher list ********");
            query = "SELECT * FROM publisher";
            result = s.executeQuery(query);
            
            while(result.next()) {
                Publisher tempPubliser = new Publisher();
                tempPubliser.setPid(result.getInt("pid"));
                tempPubliser.setName(result.getString("name"));
                tempPubliser.setAddress(result.getString("address"));
                publisherList.add(tempPubliser);
            }
            c.commit();
            c.close();
            return publisherList;
        } catch (Exception e) {
            try
            {
                c.rollback();
            }
            catch(Exception ee) {
                System.out.println("Error !");
            }
            System.out.println("Error - User table has error : " + e);
            return null;
        }
    }
    public static Record doSelectRecords(String username) {
        c = null;
        query = "";
        s = null;
        result = null;
        Record myRecord = new Record();
        Boolean done = false;
        try {
            System.out.println("* Loading the driver *");
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
            s = c.createStatement();
     
            System.out.println(" ******** select records ********");
            query = "SELECT recordId, username, borrowTime, dueTime, bid, penalty" +
                    " FROM records WHERE username = '" + username + "'";
            result = s.executeQuery(query);
            if (result.next()) {
                myRecord.setRecordId(result.getString("recordId"));
                myRecord.setBid(result.getInt("bid"));
                myRecord.setBorrowTime(result.getDate("borrowTime"));
                myRecord.setDueTime(result.getDate("dueTime"));
                myRecord.setPenalty(result.getDouble("penalty"));
                myRecord.setUsername(result.getString("username"));
            }
            c.commit();
            c.close();
            return myRecord;
        } catch (Exception e) {
            try
            {
                c.rollback();
            }
            catch(Exception ee) {
                System.out.println("Error !");
            }
            System.out.println("Error - User table has error : " + e);
            return null;
        }
    }
    public static Category doSelectCategory(String cid) {
        c = null;
        query = "";
        s = null;
        result = null;
        Category myCategory = new Category();
        try {
            System.out.println("* Loading the driver *");
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
            s = c.createStatement();
     
            System.out.println(" ******** select category ********");
            query = "SELECT categoryId, description" +
                    " FROM category WHERE categoryId = '" + cid + "'";
            result = s.executeQuery(query);
            if (result.next()) {
                myCategory.setId(result.getString("categoryId"));
                myCategory.setDesc(result.getString("description"));
            }
            c.commit();
            c.close();
            return myCategory;
        } catch (Exception e) {
            try
            {
                c.rollback();
            }
            catch(Exception ee) {
                System.out.println("Error !");
            }
            System.out.println("Error - User table has error : " + e);
            return null;
        }
    }
    
    public static void doDeleteCategory(Category currentCategory) {
        c = null;
        s = null;
        try
        {
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
                
            Statement s = c.createStatement();           
            System.out.println(" ******** delete category TABLE ********");
            query =         "DELETE FROM category";
            query = query + " WHERE categoryId = '" + currentCategory.getId() + "'";
            s.executeUpdate(query);
            c.commit();
            c.close();
            JOptionPane.showMessageDialog(null, "category is deleted", "Category Delete", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e)
        {
            try
            {
                c.rollback();
            }
            catch(Exception ee)
            {System.out.println("Error !");}
            System.out.println("Error - Database Management for insert tables() : " + e);
        }
    }
    public static Publisher doSelectPublisher(int pid) {
        c = null;
        query = "";
        s = null;
        result = null;
        Publisher myPublisher = new Publisher();
        Boolean done = false;
        try {
            System.out.println("* Loading the driver *");
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
            s = c.createStatement();
     
            System.out.println(" ******** select publisher ********");
            query = "SELECT pid, name, address" +
                    " FROM publisher WHERE pid = " + pid;
            result = s.executeQuery(query);
            if (result.next()) {
                myPublisher.setPid(result.getInt("pid"));
                myPublisher.setName(result.getString("name"));
                myPublisher.setAddress(result.getString("address"));
            }
            c.commit();
            c.close();
            return myPublisher;
        } catch (Exception e) {
            try
            {
                c.rollback();
            }
            catch(Exception ee) {
                System.out.println("Error !");
            }
            System.out.println("Error - User table has error : " + e);
            return null;
        }
    }
    public static Publisher doSelectPublisherByName(String name) {
        c = null;
        query = "";
        s = null;
        result = null;
        Publisher myPublisher = new Publisher();
        Boolean done = false;
        try {
            System.out.println("* Loading the driver *");
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
            s = c.createStatement();
     
            System.out.println(" ******** select records ********");
            query = "SELECT pid, name, address" +
                    " FROM publisher WHERE name = '" + name + "'";
            result = s.executeQuery(query);
            if (result.next()) {
                myPublisher.setPid(result.getInt("pid"));
                myPublisher.setName(result.getString("name"));
                myPublisher.setAddress(result.getString("address"));
            }
            c.commit();
            c.close();
            return myPublisher;
        } catch (Exception e) {
            try
            {
                c.rollback();
            }
            catch(Exception ee) {
                System.out.println("Error !");
            }
            System.out.println("Error - User table has error : " + e);
            return null;
        }
    }
    public static Loginlog doSelectLogRecord(String username) {
        c = null;
        query = "";
        s = null;
        result = null;
        Loginlog myLogRecord = new Loginlog();
        try {
            System.out.println("* Loading the driver *");
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
            s = c.createStatement();
     
            System.out.println(" ******** select log records ********");
            query = "SELECT logId, username, description" +
                    " FROM logrecords WHERE username = '" + username + "'";
            result = s.executeQuery(query);
            if (result.next()) {
                myLogRecord.setLogId(result.getInt("logId"));
                myLogRecord.setUsername(result.getString("username"));
                myLogRecord.setDesc(result.getString("description"));
            }
            //c.commit();
            //c.close();
            return myLogRecord;
        } catch (Exception e) {
            try
            {
                c.rollback();
            }
            catch(Exception ee) {
                System.out.println("Error !");
            }
            System.out.println("Error - User table has error : " + e);
            return null;
        }
    }
    public static void doAddUser(String userName, String lname, String fname, String password,
                                    String country, String pronvince, String city, String address,
                                    String zip, String email, String phone, String roleType) {
        c = null;
        s = null;
        try
        {
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
                
            s = c.createStatement();
            System.out.println(" ******** INSERTING INTO Users TABLE ********");
            System.out.println(roleType);
            query =         "INSERT INTO users ";
            query = query + "(username, lname, fname, password, role)";
            query = query + "values";
            query = query + "('" + userName + 
                    "', '" + lname + "', '" + fname
                    + "', '" + password + "', '"
                    + roleType + "')";
            //query = query + "(select roleId from userRoles where roletype = '" + roleType + "'))";
            System.out.println("query: "+query);
            s.executeUpdate(query);
            System.out.println("query: "+query);
            System.out.println(" ******** INSERTING INTO userdetail TABLE ********");
            
            query =         "INSERT INTO userdetail ";
            query = query + "(username, country, province, city, address, zip, email, mobilenumber)";
            query = query + "values";
            query = query + "('" + userName + 
                    "', '" + country + "', '" + pronvince
                    + "', '" + city + "', '" + address + "', '"
                    + zip + "', '" + email + "', '" + phone + "')";
            s.executeUpdate(query);
            c.commit();
            c.close();
            JOptionPane.showMessageDialog(null, "add user successed", "User Edit", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e)
        {
            try
            {
                c.rollback();
            }
            catch(Exception ee)
            {System.out.println("Error !");}
            System.out.println("Error - Database Management for insert tables() : " + e);
            JOptionPane.showMessageDialog(null, "add user failed", "User Edit", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void doUpdateUser(String userName, String lname, String fname, String password,
                                    String country, String pronvince, String city, String address,
                                    String zip, String email, String phone, String roleType) {
        c = null;
        s = null;
        try
        {
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
                
            Statement s = c.createStatement();           
            System.out.println(" ******** Update Users TABLE ********");
            
            query =         "UPDATE users SET";
            query = query + " lname = '" + lname + "', fname = '"
                    + fname + "', password = '" + password + "', role = " + 
                    "'" + roleType + "'";
            query = query + " WHERE username = '" + userName + "'";
            s.executeUpdate(query);
            System.out.println(" ******** Update userdetail TABLE ********");
            
            query =         "UPDATE userdetail SET";
            query = query + " country = '" + country + "', province = '"
                    + pronvince + "', city = '" + city + "', address = '"
                    + address + "', zip = '" + zip + "', email = '"
                    + email + "', mobilenumber = '" + phone + "'";
            query = query + " WHERE username = '" + userName + "'";
            s.executeUpdate(query);
            c.commit();
            c.close();
            JOptionPane.showMessageDialog(null, "update user successed", "User Edit", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e)
        {
            try
            {
                c.rollback();
            }
            catch(Exception ee)
            {System.out.println("Error !");}
            System.out.println("Error - Database Management for insert tables() : " + e);
            JOptionPane.showMessageDialog(null, "update user failed", "User Edit", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public static void doDeleteUser(User currentuser) {
        c = null;
        s = null;
        try
        {
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
                
            Statement s = c.createStatement();           
            System.out.println(" ******** delete records ********");
            ArrayList<Record> tempList = currentuser.getMyRecords();
            if (!tempList.isEmpty()) {
                tempList.stream().map((r) -> {
                    query =         "DELETE FROM records";
                    return r;
                }).forEachOrdered((r) -> {
                    query = query + " WHERE recordId = '"
                            + r.getRecordId() + "'";
                });
                s.executeUpdate(query);
            }
            System.out.println(" ******** delete log records ********");
            if (doSelectLogRecord(currentuser.getUserName()) != null) {
                query = "DELETE FROM logrecords";
                query = query + " WHERE username = '" + currentuser.getUserName() + "'";
                s.executeUpdate(query);
            }
            System.out.println(" ******** delete userdetail TABLE ********");
            query =         "DELETE FROM userdetail";
            query = query + " WHERE username = '" + currentuser.getUserName() + "'";
            s.executeUpdate(query);
            System.out.println(" ******** delete users TABLE ********");
            query =         "DELETE FROM users";
            query = query + " WHERE username = '" + currentuser.getUserName() + "'";
            s.executeUpdate(query);
            c.commit();
            c.close();
            JOptionPane.showMessageDialog(null, "user is deleted", "User Edit", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e)
        {
            try
            {
                c.rollback();
            }
            catch(Exception ee)
            {System.out.println("Error !");}
            System.out.println("Error - Database Management for insert tables() : " + e);
        }
    }
    
    public static void doAddLog(String userName) {
        c = null;
        s = null;
        try
        {
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
                
            Statement s = c.createStatement();          
            System.out.println(" ******** INSERTING INTO logrecords TABLE ********");
            java.util.Date time = new java.util.Date();
            String log = userName + " logged in the system on " + time.toString();
            query =         "INSERT INTO logrecords ";
            query = query + "(logId, username, description)";
            query = query + " values ";
            query = query + "(login_log_seq.nextval" + 
                    ", '" + userName + "', '" + log + "')";
            System.out.println(query);
            s.executeUpdate(query);
            c.commit();
            c.close();
        }
        catch(Exception e)
        {
            try
            {
                c.rollback();
            }
            catch(Exception ee)
            {System.out.println("Error !");}
            System.out.println("Error - Database Management for insert tables() : " + e);
        }
    }
    
    public static ArrayList<Loginlog> doSelectAllLoginRecords() {
        c = null;
        query = "";
        s = null;
        result = null;
        ArrayList<Loginlog> logList = new ArrayList<Loginlog>();
        try {
            System.out.println("* Loading the driver *");
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
            s = c.createStatement();
     
            System.out.println(" ******** selsect login log list ********");
            query = "SELECT * FROM logrecords";
            result = s.executeQuery(query);
            
            while(result.next()) {
                Loginlog tempLog = new Loginlog();
                tempLog.setLogId(result.getInt("logId"));
                tempLog.setUsername(result.getString("username"));
                tempLog.setDesc(result.getString("description"));
                logList.add(tempLog);
            }
            c.commit();
            c.close();
            return logList;
        } catch (Exception e) {
            try
            {
                c.rollback();
            }
            catch(Exception ee) {
                System.out.println("Error !");
            }
            System.out.println("Error - Log table has error : " + e);
            return null;
        }
    }
    
    public static Boolean doAddBook(Book book) {
        c = null;
        s = null;
        try
        {
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
                
            Statement s = c.createStatement();          
            System.out.println(" ******** INSERTING INTO book TABLE ********");
            query =         "INSERT INTO book ";
            query = query + "(bId, ISBN, title, author, pid, cid, price, quantity, history)";
            query = query + " values ";
            query = query + "(" + book.getId() +
                    ", '" + book.getIsbn() + "', '" + book.getTitle() +
                    "', '" +  book.getAuthor() + "', " + book.getPublisher().getPid()
                    + ", '" + book.getCid() + "', " + book.getPrice() + ", "
                    + book.getQuantity() + ", '" + book.getHistory() + "')";
            System.out.println(query);
            s.executeUpdate(query);
            c.commit();
            c.close();
            return true;
        }
        catch(Exception e)
        {
            try
            {
                c.rollback();
            }
            catch(Exception ee)
            {System.out.println("Error !");}
            System.out.println("Error - Database Management for insert tables() : " + e);
            return false;
        }
    }
    
    public static Boolean doAddCategory(Category category) {
        c = null;
        s = null;
        try
        {
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
                
            Statement s = c.createStatement();          
            System.out.println(" ******** INSERTING INTO category TABLE ********");
            query =         "INSERT INTO category ";
            query = query + "(categoryId, description)";
            query = query + " values ";
            query = query + "('" + category.getId() +
                    "', '" + category.getDesc() + "')";
            System.out.println(query);
            s.executeUpdate(query);
            c.commit();
            c.close();
            return true;
        }
        catch(Exception e)
        {
            try
            {
                c.rollback();
            }
            catch(Exception ee)
            {System.out.println("Error !");}
            System.out.println("Error - Database Management for insert tables() : " + e);
            return false;
        }
    }
    
    public static void doUpdateCategory(Category category) {
        c = null;
        s = null;
        try
        {
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
                
            Statement s = c.createStatement();           
            System.out.println(" ******** Update category TABLE ********");
            
            query =         "UPDATE category SET";
            query = query + " description = '" + category.getDesc() + "'";
            query = query + " WHERE categoryId = '" + category.getId() + "'";
            s.executeUpdate(query);
            c.commit();
            c.close();
            JOptionPane.showMessageDialog(null, "update category successed", "Category Edit", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e)
        {
            try
            {
                c.rollback();
            }
            catch(Exception ee)
            {System.out.println("Error !");}
            System.out.println("Error - Database Management for insert tables() : " + e);
            JOptionPane.showMessageDialog(null, "update category failed", "Category Edit", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public static void doDeletePublisher(Publisher currentPublisher) {
        c = null;
        s = null;
        try
        {
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
                
            Statement s = c.createStatement();           
            System.out.println(" ******** delete publisher TABLE ********");
            query =         "DELETE FROM publisher";
            query = query + " WHERE pid = " + currentPublisher.getPid();
            s.executeUpdate(query);
            c.commit();
            c.close();
            JOptionPane.showMessageDialog(null, "publisher is deleted", "Publisher Delete", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e)
        {
            try
            {
                c.rollback();
            }
            catch(Exception ee)
            {System.out.println("Error !");}
            System.out.println("Error - Database Management for insert tables() : " + e);
        }
    }
    
    public static Boolean doAddPublisher(Publisher publisher) {
        c = null;
        s = null;
        try
        {
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
                
            Statement s = c.createStatement();          
            System.out.println(" ******** INSERTING INTO publisher TABLE ********");
            query =         "INSERT INTO publisher ";
            query = query + "(pid, name, address)";
            query = query + " values ";
            query = query + "(" + publisher.getPid() +
                    ", '" + publisher.getName() + "', '"
                    + publisher.getAddress() + "')";
            System.out.println(query);
            s.executeUpdate(query);
            c.commit();
            c.close();
            return true;
        }
        catch(Exception e)
        {
            try
            {
                c.rollback();
            }
            catch(Exception ee)
            {System.out.println("Error !");}
            System.out.println("Error - Database Management for insert tables() : " + e);
            return false;
        }
    }
    
    public static void doUpdatePublisher(Publisher publisher) {
        c = null;
        s = null;
        try
        {
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
                
            Statement s = c.createStatement();           
            System.out.println(" ******** Update publisher TABLE ********");
            
            query =         "UPDATE publisher SET";
            query = query + " name = '" + publisher.getName() + "', address = '" + publisher.getAddress() + "'";
            query = query + " WHERE pid = " + publisher.getPid();
            s.executeUpdate(query);
            c.commit();
            c.close();
            JOptionPane.showMessageDialog(null, "update publisher successed", "Publisher Edit", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e)
        {
            try
            {
                c.rollback();
            }
            catch(Exception ee)
            {System.out.println("Error !");}
            System.out.println("Error - Database Management for insert tables() : " + e);
            JOptionPane.showMessageDialog(null, "update publisher failed", "Publisher Edit", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public static Book doSelectBook(Book book) {
        c = null;
        query = "";
        s = null;
        result = null;
        Book searchedBook = new Book();
        Publisher publisher = new Publisher();
        Boolean done = false;
        try {
            System.out.println("* Loading the driver *");
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
            s = c.createStatement();
            System.out.println(" ******** selsect book ********");
            query = "SELECT bId, ISBN, title, author, pid, cid, price, quantity, history" +
                    " FROM book WHERE bId = " + book.getId();
            result = s.executeQuery(query);
            
            while(result.next()) {
                searchedBook.setId(result.getInt("bId"));
                searchedBook.setIsbn(result.getString("ISBN"));
                searchedBook.setTitle(result.getString("title"));
                searchedBook.setAuthor(result.getString("author"));
                searchedBook.setCid(result.getString("cid"));
                searchedBook.setPrice(result.getDouble("price"));
                searchedBook.setQuantity(result.getInt("quantity"));
                searchedBook.setHistory(result.getString("history"));
                System.out.println(" ******** select publisher ********");
                query = "SELECT pid, name, address" +
                    " FROM publisher WHERE pid = " + result.getInt("pid");
                result = s.executeQuery(query);
                if (result.next()) {
                    publisher.setPid(result.getInt("pid"));
                    publisher.setName(result.getString("name"));
                    publisher.setAddress(result.getString("address"));                   
                }
                searchedBook.setPublisher(publisher);
                done = true;
            }
            c.commit();
            c.close();
            if (!done) {
                return null;
            }
            return searchedBook;
        } catch (Exception e) {
            try
            {
                c.rollback();
            }
            catch(Exception ee) {
                System.out.println("Error !");
            }
            System.out.println("Error - book table has error : " + e);
            return null;
        }
    }
    
    
    public static ArrayList<Record> doSelectAllRecordsForSpeicalUser(String username) {
        c = null;
        query = "";
        s = null;
        result = null;
        ArrayList<Record> recordList = new ArrayList<Record>();
        try {
            System.out.println("* Loading the driver *");
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
            s = c.createStatement();
     
            System.out.println(" ******** selsect record list ********");
            query = "SELECT * FROM records where username='" + username + "'";
            result = s.executeQuery(query);
            
            while(result.next()) {
                Record tempRecord = new Record();
                tempRecord.setRecordId(result.getString("recordId"));
                tempRecord.setUsername(username);
                tempRecord.setBorrowTime(result.getDate("borrowTime"));
                tempRecord.setDueTime(result.getDate("dueTime"));
                tempRecord.setBid(result.getInt("bid"));
                tempRecord.setPenalty(result.getDouble("penalty"));
                tempRecord.setIsReturn(result.getInt("isReturn"));
                recordList.add(tempRecord);
            }
            c.commit();
            c.close();
            return recordList;
        } catch (Exception e) {
            try
            {
                c.rollback();
            }
            catch(Exception ee) {
                System.out.println("Error !");
            }
            System.out.println("Error - Log table has error : " + e);
            return null;
        }
    }
    
    public static ArrayList<Record> doSelectAllRecords() {
        c = null;
        query = "";
        s = null;
        result = null;
        ArrayList<Record> recordList = new ArrayList<Record>();
        try {
            System.out.println("* Loading the driver *");
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
            s = c.createStatement();
     
            System.out.println(" ******** selsect record list ********");
            query = "SELECT * FROM records";
            result = s.executeQuery(query);
            
            while(result.next()) {
                Record tempRecord = new Record();
                tempRecord.setRecordId(result.getString("recordId"));
                tempRecord.setUsername(result.getString("username"));
                tempRecord.setBorrowTime(result.getDate("borrowTime"));
                tempRecord.setDueTime(result.getDate("dueTime"));
                tempRecord.setBid(result.getInt("bid"));
                tempRecord.setPenalty(result.getDouble("penalty"));
                tempRecord.setIsReturn(result.getInt("isReturn"));
                recordList.add(tempRecord);
            }
            c.commit();
            c.close();
            return recordList;
        } catch (Exception e) {
            try
            {
                c.rollback();
            }
            catch(Exception ee) {
                System.out.println("Error !");
            }
            System.out.println("Error - record table has error : " + e);
            return null;
        }
    }
    
    public static Boolean doAddRecord(Record record) {
        c = null;
        s = null;
        Boolean done = true;
        try
        {
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);  
            s = c.createStatement();
            System.out.println(" ******** INSERTING INTO records TABLE ********");
            query =         "INSERT INTO records ";
            query = query + "(recordId, username, borrowTime, dueTime, bid, penalty, isReturn)";
            query = query + "values";
            query = query + "('" + record.getRecordId() + 
                    "', '" + record.getUsername() + "', to_date('" + convertToSqlDate(record.getBorrowTime()).toString()
                    + "', 'YYYY/MM/DD'), to_date('" + convertToSqlDate(record.getDueTime()).toString() + "', 'YYYY/MM/DD'), "
                    + record.getBid() + ", " + record.getPenalty() + ", " + record.getIsReturn() + ")";
            /*query = query + "('" + record.getRecordId() + 
                    "', '" + record.getUsername() + "', " + convertToSqlDate(record.getBorrowTime())
                    + ", " + convertToSqlDate(record.getDueTime()) + ", "
                    + record.getBid() + ", " + record.getPenalty() + ", " + record.getIsReturn() + ")";*/
            System.out.println("query: "+query);
            s.executeUpdate(query);
            c.commit();
            c.close();
            JOptionPane.showMessageDialog(null, "Borrow book is success", "Borrow Book", JOptionPane.INFORMATION_MESSAGE);
            return done;
        }
        catch(Exception e)
        {
            try
            {
                c.rollback();
            }
            catch(Exception ee)
            {System.out.println("Error !");}
            System.out.println("Error - Database Management for insert tables() : " + e);
            JOptionPane.showMessageDialog(null, "Borrow book failed", "Borrow Book", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
    
    public static void doUpdateBook(Book book) {
        c = null;
        s = null;
        try
        {
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
                
            Statement s = c.createStatement();           
            System.out.println(" ******** Update book TABLE ********");
            
            query =         "UPDATE book SET";
            query = query + " ISBN = '" + book.getIsbn() + "', title = '" + book.getTitle() + "', author = '"
                    + book.getAuthor() + "', pid = " + book.getPublisher().getPid() + ", cid = '" + book.getCid()
                    + "', price = " + book.getPrice() + ", quantity = " + book.getQuantity() + ", history = '"
                    + book.getHistory() + "'";
            query = query + " WHERE bId = " + book.getId();
            s.executeUpdate(query);
            c.commit();
            c.close();
            JOptionPane.showMessageDialog(null, "update book successed", "Book Edit", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e)
        {
            try
            {
                c.rollback();
            }
            catch(Exception ee)
            {System.out.println("Error !");}
            System.out.println("Error - Database Management for insert tables() : " + e);
            JOptionPane.showMessageDialog(null, "update book failed", "Book Edit", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public static void doDeleteBook(Book currentBook) {
        c = null;
        s = null;
        try
        {
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
                
            Statement s = c.createStatement();           
            System.out.println(" ******** delete book TABLE ********");
            query =         "DELETE FROM book";
            query = query + " WHERE bId = " + currentBook.getId();
            s.executeUpdate(query);
            c.commit();
            c.close();
            JOptionPane.showMessageDialog(null, "book is deleted", "Book Delete", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e)
        {
            try
            {
                c.rollback();
            }
            catch(Exception ee)
            {System.out.println("Error !");}
            System.out.println("Error - Database Management for insert tables() : " + e);
        }
    }
    
    public static java.sql.Date convertToSqlDate(java.util.Date today) {
        java.sql.Date sqlDate = null;
        if (today != null) {
            sqlDate = new java.sql.Date(today.getTime());
        }
        return sqlDate;
    }
    
    public static void doDeleteRecord(Record currentRecord) {
        c = null;
        s = null;
        try
        {
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
                
            Statement s = c.createStatement();           
            System.out.println(" ******** delete book TABLE ********");
            query =         "DELETE FROM records";
            query = query + " WHERE recordId = '" + currentRecord.getRecordId() + "'";
            s.executeUpdate(query);
            c.commit();
            c.close();
            JOptionPane.showMessageDialog(null, "record is deleted", "Record Delete", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e)
        {
            try
            {
                c.rollback();
            }
            catch(Exception ee)
            {System.out.println("Error !");}
            System.out.println("Error - Database Management for insert tables() : " + e);
        }
    }
    
    public static Boolean doUpdateRecord(Record record) {
        c = null;
        s = null;
        try
        {
            c = DriverManager.getConnection(url, oracleUser, oraclePwd);
                
            Statement s = c.createStatement();
            
            System.out.println(" ******** Update publisher TABLE ********");
            
            query =         "UPDATE records SET ";
            query = query + "username = '" + record.getUsername() + "', borrowTime = "
                    + "to_date('" + convertToSqlDate(record.getBorrowTime()).toString() + "', 'YYYY/MM/DD'), dueTime = "
                    + "to_date('" + convertToSqlDate(record.getDueTime()).toString() + "', 'YYYY/MM/DD'), bid = "
                    + record.getBid() + ", penalty = " + record.getPenalty() + ", isReturn = " + record.getIsReturn();
            query = query + " WHERE recordId = '" + record.getRecordId() + "'";
            s.executeUpdate(query);
            c.commit();
            c.close();
            return true;
        }
        catch(Exception e)
        {
            try
            {
                c.rollback();
            }
            catch(Exception ee)
            {System.out.println("Error !");}
            System.out.println("Error - Database Management for insert tables() : " + e);
            JOptionPane.showMessageDialog(null, "update record failed", "Record Edit", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
}
