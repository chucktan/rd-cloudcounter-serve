package com.rd.cloudcounter.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileEmailUtils {

    public static boolean checkMobileIsOk(String mobile) {
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(mobile);
        boolean isMatch = m.matches();
        return isMatch;
    }

    public static boolean checkEmailIsOk(String email) {
        boolean isMatch = true;
        if (!email.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+")) {
            isMatch = false;
        }
        return isMatch;
    }

    public  static  boolean checkCertIdIsOk(String certId){
        String regex = "(^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}$)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(certId);
        boolean isMacth = m.matches();
        return  isMacth;
    }

}

