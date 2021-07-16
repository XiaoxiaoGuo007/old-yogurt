package com.example.yogurtlearn.util.dateutil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @description:
 * @author: old_yogurt
 * @date 2021/7/16 13:53
 */
public class TimeStampUtil {

    /*
     * @Author: old_yogurt
     * @Description: 获取精确到秒的时间戳
     * @Param: [date]
     * @return: int
     */
    public static int getSecondTimestamp(Date date) {
        if (null == date) {
            return 0;
        }
        String timestamp = String.valueOf(date.getTime());
        int length = timestamp.length();
        if (length > 3) {
            //这里，获取的timestamp本来是毫秒的，去掉后后三位转为秒
            return Integer.valueOf(timestamp.substring(0, length - 3));
        } else {
            return 0;
        }
    }

    /**
     * @Author: old_yogurt
     * @Description: 将时间戳转换为时间
     * @Param: [s]
     * @return: java.lang.String
     */
    public static String timeStampToDate(String str){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long l = new Long(str);
        Date date = new Date(l);
        return simpleDateFormat.format(date);
    }

    /**
     * @Author: old_yogurt
     * @Description: 将时间转换为时间戳
     * @Param: [s]
     * @return: java.lang.String
     */
    public static String dateTimeToStamp(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        Long l = 0L;
        try {
            date = simpleDateFormat.parse(str);
            l = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return String.valueOf(l);
    }


    public static void main(String[] args) {
        //方法 一
        long method1 = System.currentTimeMillis();
        //方法 二
        long method2 = Calendar.getInstance().getTimeInMillis();
        //方法 三
        long method3 = new Date().getTime();

        System.out.println(method1);
        System.out.println(method2);
        System.out.println(method3);

        System.out.println("将时间戳转换为时间:"+timeStampToDate("15012445555"));
        System.out.println("将时间戳转换为时间:"+dateTimeToStamp("1970-06-24 02:07:25"));
    }

}
