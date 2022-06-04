package com.susu.oss.common.utils;

import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.ChineseCaptcha;
import com.wf.captcha.GifCaptcha;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import java.awt.*;

public class EasyCaptchaUtils {

    /**
     * @return  png格式验证码
     */
    public static SpecCaptcha getSpecCaptcha(){

        SpecCaptcha captcha = new SpecCaptcha(130, 45);
        // 字符串长度
        captcha.setLen(5);
        // 字母数字混合
        captcha.setCharType(Captcha.TYPE_DEFAULT);
        // 设置内置字体
       /* try {
            captcha.setFont(Captcha.FONT_6);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }*/
        // 设置系统字体
        //captcha.setFont(new Font("楷体", Font.PLAIN, 28));
        return captcha;
    }

    /**
     * @return 算术类型
     */
    public static ArithmeticCaptcha getArithmeticCaptcha(){
        ArithmeticCaptcha captcha = new ArithmeticCaptcha  (130, 48);
        captcha.setLen(3);  // 几位数运算，默认是两位
        captcha.getArithmeticString();  // 获取运算的公式：4-9+1=?
        String text = captcha.text();// 获取运算的结果：-4
        return captcha;
    }

    /**
     * @return  Gif验证码类
     */
    public static GifCaptcha getGifCaptcha(){
        GifCaptcha captcha = new GifCaptcha(130, 48);
        captcha.setLen(5); // 字符串长度
        captcha.setCharType(Captcha.TYPE_DEFAULT); // 字母数字混合
        // 设置内置字体
        // captcha.setFont(Captcha.FONT_1);
        // 设置系统字体
        captcha.setFont(new Font("楷体", Font.PLAIN, 28));
        return captcha;
    }

    /**
     * @return 中文类型
     */
    public static ChineseCaptcha getChineseCaptcha(){
        ChineseCaptcha  captcha = new ChineseCaptcha (130, 48);
        captcha.setLen(5); // 字符串长度
        return captcha;
    }





}
