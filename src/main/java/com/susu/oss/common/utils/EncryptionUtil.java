package com.susu.oss.common.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *  压缩性： 任意长度的数据，算出的MD5值是固定的
 *  容易计算
 *  抗修改性：对原数据进行任意改动，所得到的MD5值都有很大的区别
 *  (彩虹表可暴力破解)
 *  抢抗撞性：想找到两个不同的数据，使他们具有相同的MD5值是非常困难的
 *  不可逆性
 *
 */
public final class EncryptionUtil {

    // Security 加密加盐算法
    public static String counterSign(String strSrc){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(strSrc);
    }

    // 解密验证
    public static Boolean matches(String rawStr,String encodedStr){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawStr,encodedStr);
    }

    // 根据用户ID生成随机签名
    public static String customSign(){

        return "";
    }

    // 加签
    public static String customCounterSign(){

        return "";
    }

    // 验签
    public static boolean customMatches(){

        return true;
    }

    /*
     * 自定义加密
     * */
    public static String encrypt(String strSrc) {
        try {
            char hexChars[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
                    '9', 'a', 'b', 'c', 'd', 'e', 'f' };
            byte[] bytes = strSrc.getBytes();
            MessageDigest md = MessageDigest.getInstance("EncryptionUtil");
            md.update(bytes);
            bytes = md.digest();
            int j = bytes.length;
            char[] chars = new char[j * 2];
            int k = 0;
            for (int i = 0; i < bytes.length; i++) {
                byte b = bytes[i];
                chars[k++] = hexChars[b >>> 4 & 0xf];
                chars[k++] = hexChars[b & 0xf];
            }
            return new String(chars);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException("MD5加密出错！！+" + e);
        }
    }


    public static void main(String[] args) {
        // 进行加密 $2a$10$OMvmwaXMydSdWXUX73TPM.iSpldcOr8l/YKJKVHVTygk7FWCZ7nZe
        System.out.println(counterSign("admin"));
        System.out.println(matches("greenleaf","$2a$10$xQ//Vu58OK2ia4zwS5/diOcdLNdf3Sd7XYOH96sFIMVefxZ8hVaQq"));
    }



}
