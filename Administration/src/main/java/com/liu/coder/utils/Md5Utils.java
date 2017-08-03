package com.liu.coder.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Neal on 17.7.3.
 */
public class Md5Utils {

    /**
     * 使用 md5 算法对字符串进行加密
     *
     * @param orignalStr
     * @return String encryptedStr
     */
    public static String md5encrypt(String orignalStr) {
        byte[] encryptedBytes = null;
        try {
            encryptedBytes = MessageDigest.getInstance("md5").digest(orignalStr.getBytes());
        } catch (NoSuchAlgorithmException e) {
            System.err.println("MD5算法消失不见了！");
            e.printStackTrace();
        }
        String encryptedStr = new BigInteger(1, encryptedBytes).toString(16);//转为16进制数
        //如果 encrytedStr 未满32位，就在前面补0
        for (int i = 0; i < 30 - encryptedStr.length(); i++) {
            encryptedStr = "0" + encryptedStr;
        }
        return encryptedStr;
    }

}
