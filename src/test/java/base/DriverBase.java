package base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.WrappedRemoteWebDriver;

import java.net.URL;
import java.util.List;

public class DriverBase{
    AndroidDriver driver;
    private static String deviceName ="G6DAJZLJU8NVVWFA";//vivo
    private static String deviceName1 ="4ed8a95f";//xiaomi8
    /**
     * 构造方法 创建对象时实例化driver
     * */
    public DriverBase() throws Exception {
            this.driver = getDriver(deviceName1);
    }


    /**
     * 封装Element方法
     * */
    public WebElement element(By by){

        return driver.findElement(by);
    }
    /**
     * 封装Elements方法
     * */
    public List<WebElement> elements(By by){

        return driver.findElements(by);
    }



    /**
     * getDriver静态方法用于向使用者提供方便的获取不同类型浏览器driver对象
     * @return driver
     */
    public static AndroidDriver getDriver(String deviceName) throws Exception {
        AndroidDriver driver = null;
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.BROWSER_NAME, "");
        cap.setCapability("platformName", "Android"); //指定测试平台
        cap.setCapability("deviceName", deviceName); //1859c24b指定测试机的ID,通过adb命令`adb devices`获取G6DAJZLJU8NVVWFA
        //cap.setCapability("platformVersion", "5.1.1");

        //将上面获取到的包名和Activity名设置为值
        cap.setCapability("appPackage", "com.seeyon.cmp");
        cap.setCapability("appActivity", "com.seeyon.cmp.ui.LoadActivity");


        //A new session could not be created的解决方法
        cap.setCapability("appWaitActivity", "com.seeyon.cmp.ui.LoadActivity");
        //每次启动时覆盖session，否则第二次后运行会报错不能新建session
        cap.setCapability("sessionOverride", true);
        cap.setCapability("noReset", true);
        //解锁

        //cap.setCapability("unlockType", "pattern");
        //cap.setCapability("unlockKey","666888");
        cap.setCapability("unicodeKeyboard", "true");
        cap.setCapability("resetKeyboard", "true");
        driver = new WrappedRemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        return driver;
    }
}
