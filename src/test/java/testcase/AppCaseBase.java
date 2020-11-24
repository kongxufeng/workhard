package testcase;

import base.BasePage;
import base.DriverBase;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class AppCaseBase {
    public AndroidDriver driver;
    public Logger logger = LogManager.getLogger();
    private static String deviceName ="G6DAJZLJU8NVVWFA";//vivo
    private static String deviceName1 ="4ed8a95f";//xiaomi8
    @BeforeTest
    public void setup() throws Exception {
            this.driver = DriverBase.getDriver(deviceName);
            int h = driver.manage().window().getSize().height;
            int w = driver.manage().window().getSize().width;
            logger.info("获取尺寸:" + "height=" + h + ",width" + w);
            boolean flag = BasePage.swipe_up(w, h, driver);
            logger.info("是否进行解锁：" + flag);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
