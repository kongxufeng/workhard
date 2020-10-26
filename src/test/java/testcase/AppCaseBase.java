package testcase;

import base.BasePage;
import base.DriverBase;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class AppCaseBase {
    public AndroidDriver driver;
    public Logger logger = LogManager.getLogger();
    private static String deviceName ="G6DAJZLJU8NVVWFA";//vivo
    private static String deviceName1 ="4ed8a95f";//xiaomi8
    @BeforeSuite
    public void setup() throws Exception {
        this.driver = DriverBase.getDriver(deviceName);
        int h = driver.manage().window().getSize().height;
        int w = driver.manage().window().getSize().width;
        logger.info("获取尺寸:"+"height="+h+",width"+w);
        Thread.sleep(5000);
        boolean flag = BasePage.swipe_up(w,h,driver);
        logger.info("是否进行解锁："+flag);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
