package base;

import io.appium.java_client.android.AndroidDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasePage {
    AndroidDriver driver;

    /**
     * 构造方法
     * */
    public BasePage(AndroidDriver driver){
        this.driver = driver;

    }



    //获取指定日期格式当前系统时间
    public Date GetDate(String pattern){
        SimpleDateFormat df = new SimpleDateFormat(pattern);// 设置日期格式
        String time = df.format(new Date());
        Date date= null;
        try {
            date = df.parse(time);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }
    }
    //获取指定日期格式时间
    public Date GetDate(String pattern,String time){
        SimpleDateFormat df = new SimpleDateFormat(pattern);// 设置日期格式
        //String time = df.format(new Date());
        Date date= null;
        try {
             date = df.parse(time);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }

    }

}
