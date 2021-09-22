package cn.sxt.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * jdk 8中日期时间API的测试
 *
 * @author xiexu
 * @create 2020-9-16 下午 5:17
 */
public class JDK8DateTimeTest {

    @Test
    public void testDate(){
        //偏移量
        Date date1 = new Date(2020,9,16);
        System.out.println(date1);  //Sat Oct 16 00:00:00 CST 3920

        Date date2 = new Date(2020 - 1900,9 - 1,16);
        System.out.println(date2); //Tue Sep 08 00:00:00 CST 2020
    }

    /*
    LocalDate、LocalTime、LocalDateTime 的使用
    说明：
        1.LocalDateTime相较于LocalDate、LocalTime，使用频率要高
        2.类似于Calendar
     */
    @Test
    public void test1(){
        //now():获取当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate); //2020-10-30
        System.out.println(localTime); //15:23:23.752
        System.out.println(localDateTime); //2020-10-30T15:23:23.752

        //of():设置指定的年、月、日、时、分、秒。(是没有偏移量的)
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 30, 15, 24, 43);
        System.out.println(localDateTime1); //2020-10-30T15:24:43

        //getXxx()：获取相关的属性
        System.out.println(localDateTime.getDayOfMonth()); //30
        System.out.println(localDateTime.getDayOfWeek()); //FRIDAY
        System.out.println(localDateTime.getMonth()); //OCTOBER
        System.out.println(localDateTime.getMonthValue()); //10
        System.out.println(localDateTime.getMinute()); //24

        //体现不可变性
        //withXxx():设置相关的属性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);//2020-10-30
        System.out.println(localDate1);//2020-10-22

        LocalDateTime localDateTime2 = localDateTime.withHour(4);
        System.out.println(localDateTime); //2020-10-30T15:24:20.879
        System.out.println(localDateTime2); //2020-10-30T04:24:20.879

        //不可变性
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime); //2020-10-30T15:24:20.879
        System.out.println(localDateTime3); //2021-01-30T15:24:20.879

        LocalDateTime localDateTime4 = localDateTime.minusDays(6);
        System.out.println(localDateTime); //2020-10-30T15:24:20.879
        System.out.println(localDateTime4); //2020-10-24T15:24:20.879
    }

    /*
    Instant的使用
    类似于 java.util.Date类
     */
    @Test
    public void test2(){
        //now():获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);//2020-10-30T07:27:02.667Z

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2020-10-30T15:27:02.667+08:00

        //toEpochMilli():获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数  ---> Date类的getTime()
        long milli = instant.toEpochMilli();
        System.out.println(milli); //1604042822667

        //ofEpochMilli():通过给定的毫秒数，获取Instant实例  -->Date(long millis)
        Instant instant1 = Instant.ofEpochMilli(1604042822667L);
        System.out.println(instant1); //2020-10-30T07:27:02.667Z
    }

    /*
    DateTimeFormatter:格式化或解析日期、时间
    类似于SimpleDateFormat
     */
    @Test
    public void test3(){
//        方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化:日期-->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime); //2020-10-30T15:29:46.953
        System.out.println(str1);//2020-10-30T15:29:46.953

        //解析：字符串 -->日期
        TemporalAccessor parse = formatter.parse("2020-10-30T15:29:46.953");
        System.out.println(parse); //

//        方式二：
//        本地化相关的格式。如：ofLocalizedDateTime()
//        FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDateTime
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        //格式化
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);//2019年2月18日 下午03时47分16秒

//      本地化相关的格式。如：ofLocalizedDate()
//      FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT : 适用于LocalDate
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        //格式化
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);//2019-2-18

//       重点： 方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4);//2019-02-18 03:52:09

        //解析
        TemporalAccessor accessor = formatter3.parse("2019-02-18 03:52:09");
        System.out.println(accessor);

    }

}
