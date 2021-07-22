package com.example.yogurtlearn.util.dateutil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
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

    /**
     * @Author: old_yogurt
     * @Description:
     * @Param: [args]
     * @return: void
     */

    public static void LocalTimeTest(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
    }


}
