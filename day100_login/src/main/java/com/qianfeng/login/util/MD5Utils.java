package com.qianfeng.login.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密
 */
public class MD5Utils {

    public static String md5(String str,String salt){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String password= str+salt;
            //获取MD5加密的对象
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            //将需要加密的字符串放入Digest中,返回值是加密之后的密文
            byte[] bytes = messageDigest.digest(password.getBytes());

            for (int i = 0; i < bytes.length; i++) {
                String strs = Integer.toHexString(bytes[i] & 0xFF);
                if (strs.length() == 1) {
                    strs="0"+strs;
                }
                stringBuilder.append(strs);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
