/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryproject;

import java.util.regex.*;

/**
 *
 * @author majin_000
 */
public class validate {
    
    public static Boolean validateUserNameAndPwd(String userName, String passWord) {
        Boolean validation = true;
        
        if (userName.isEmpty() || passWord.isEmpty()) {
            validation = false;
        } else if (!matchesUserNamePolicy(userName) || !matchesPwdPolicy(passWord)) {
            validation = false;
        }
        return validation;
    }
    public static Boolean matchesUserNamePolicy(String usr) {
        String patternUser = "^[A-Za-z][A-Za-z0-9_-]{7,}$";
        Pattern pattern = Pattern.compile(patternUser);
        return pattern.matcher(usr).matches();
    }
    public static Boolean matchesPwdPolicy(String pwd) {
        String patternPwd = "^[A-Za-z][A-Za-z0-9@#\\$%\\^&+=]{7,}$";
        Pattern pattern = Pattern.compile(patternPwd);
        return pattern.matcher(pwd).matches();
    }
    public static Boolean matchesZipPolicy(String zip) {
        String patternZip = "^(?!.*[DFIOQU])[A-VXY][0-9][A-Z]\\s?[0-9][A-Z][0-9]$";
        Pattern pattern = Pattern.compile(patternZip);
        return pattern.matcher(zip).matches();
    }
    public static Boolean matchesEmailPolicy(String email) {
        String patternEmail = 
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(patternEmail);
        return pattern.matcher(email).matches();
    }
    public static Boolean matchesMobileNumberPolicy(String mobileNum) {
        String patternMobileNum = "^[+]?[01]?[- .]?(\\([2-9]\\d\\)|[2-9]\\d{2})[- .]?\\d{3}[- .]?\\d{4}$";
        Pattern pattern = Pattern.compile(patternMobileNum);
        return pattern.matcher(mobileNum).matches();
    }
    public static User validUserAndPwd(String name, String pwd) {
        return OracleConnect.isExistedUser(name, pwd);
    }
}
