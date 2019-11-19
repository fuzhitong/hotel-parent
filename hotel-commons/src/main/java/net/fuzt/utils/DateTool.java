/**
 * Project Name:hotel-admin
 * File Name:DateTool.java
 * Package Name:com.java.utils
 * Date:下午1:49:22
 * Copyright (c) 2019, bluemobi All Rights Reserved.
 *
*/

package net.fuzt.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 * Description: Date: 下午1:49:22 <br/>
 * 
 * @author 丁鹏
 * @version
 * @see
 */
public class DateTool {
    public static long diffDays(String inTime, String outTime) throws Exception {
        if (inTime == null || outTime == null) {
            throw new Exception("时间参数不能为null");
        }
        String regex = "\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}";
        if (!inTime.matches(regex) || !inTime.matches(regex)) {
            throw new Exception("时间格式不正确");
        }
        // 入住时间与退房时间 2018-01-12 12:30:30
        String[] ruTimeArr = inTime.split("\\ ")[0].split("\\-");// {"2018","01","12"}
        String[] TuiTimeArr = outTime.split("\\ ")[0].split("\\-");
        LocalDate of = LocalDate.of(Integer.parseInt(ruTimeArr[0]), Integer.parseInt(ruTimeArr[1]),
                Integer.parseInt(ruTimeArr[2]));
        LocalDate end = LocalDate.of(Integer.parseInt(TuiTimeArr[0]), Integer.parseInt(TuiTimeArr[1]),
                Integer.parseInt(TuiTimeArr[2]));
        long days = end.toEpochDay() - of.toEpochDay();
        // 2、计算退房时间戳是否小于12:00:00的时间戳
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
        long time1 = sdf2.parse(outTime.split("\\ ")[1]).getTime();
        long time2 = sdf2.parse("12:00:00").getTime();
        long timeCha = time1 - time2;
        if (timeCha > 0) {
            days++;
        }
        return days;
    }

}
