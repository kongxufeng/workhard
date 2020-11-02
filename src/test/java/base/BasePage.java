package base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasePage {
    public AndroidDriver driver;

    /**
     * 构造方法
     * */
    public BasePage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void 等待元素(WebElement element){
        new WebDriverWait(driver, 20).until(
                ExpectedConditions.visibilityOf(element));
    }

    public static boolean swipe_up(int w, int h, AndroidDriver driver){
        boolean flag= false;
        if (driver.isLocked()){
            driver.swipe(new Double(w*0.5).intValue(),new Double(h*0.75).intValue(),new Double(w*0.5).intValue(),new Double(h*0.25).intValue() ,1000);
            flag = true;
        }
        return flag;
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
