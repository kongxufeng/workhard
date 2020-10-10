package utils;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.URL;

public class AppTest {
    public AndroidDriver driver;
    public Logger logger = LogManager.getLogger();
    @BeforeClass
    public void setup() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.BROWSER_NAME, "");
        cap.setCapability("platformName", "Android"); //指定测试平台
        cap.setCapability("deviceName", "G6DAJZLJU8NVVWFA"); //1859c24b指定测试机的ID,通过adb命令`adb devices`获取G6DAJZLJU8NVVWFA
        //cap.setCapability("platformVersion", "5.1.1");

        //将上面获取到的包名和Activity名设置为值
        //cap.setCapability("appPackage", "com.seeyon.cmp");
        //cap.setCapability("appActivity", "com.seeyon.cmp.ui.LoadActivity");
        //云信
        cap.setCapability("appPackage", "com.tencent.weworklocal");
        cap.setCapability("appActivity", "com.tencent.wework.launch.WwMainActivity");

        //A new session could not be created的解决方法
        //cap.setCapability("appWaitActivity", "com.seeyon.cmp.ui.main.MainActivity");
        //每次启动时覆盖session，否则第二次后运行会报错不能新建session
        //cap.setCapability("sessionOverride", true);
        cap.setCapability("noReset", true);
        //解锁

        //cap.setCapability("unlockType", "pattern");
        //cap.setCapability("unlockKey","666888");
        cap.setCapability("unicodeKeyboard", "true");
        cap.setCapability("resetKeyboard", "true");

        driver = new WrappedRemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }
}
