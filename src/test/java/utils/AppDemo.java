package utils;


import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class AppDemo {
	public AndroidDriver driver;
	Logger logger = LogManager.getLogger();


	@BeforeClass
	public void setup() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME, "");
		cap.setCapability("platformName", "Android"); //指定测试平台
		cap.setCapability("deviceName", "G6DAJZLJU8NVVWFA"); //指定测试机的ID,通过adb命令`adb devices`获取
		//cap.setCapability("platformVersion", "5.1.1");

		//将上面获取到的包名和Activity名设置为值
		cap.setCapability("appPackage", "com.seeyon.cmp");
		cap.setCapability("appActivity", "com.seeyon.cmp.ui.LoadActivity");

//        //A new session could not be created的解决方法
        cap.setCapability("appWaitActivity", "com.seeyon.cmp.ui.main.MainActivity");
//        //每次启动时覆盖session，否则第二次后运行会报错不能新建session
        //cap.setCapability("sessionOverride", true);
		cap.setCapability("noReset", true);
        //解锁
		//cap.setCapability("unlockType", "pattern");
		//cap.setCapability("unlockKey","666888");
		cap.setCapability("unicodeKeyboard", "true");
		cap.setCapability("resetKeyboard", "true");

		driver = new WrappedRemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	}

	@Test
	public void plus()  throws Exception {

		boolean flag = true;
		int random = new Random().nextInt(40000)+5000;
		//int random = 5000;
		logger.info("等待时间"+random);
		Thread.sleep(random);
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='工作台']")).click();
        new WebDriverWait(driver, 30).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@text='签到']")));
		driver.findElement(By.xpath("//android.view.View[@text='签到']")).click();
        logger.info("********** 等待获取定位信息 **********");
		for(int i=0;i<5;i++){
			//等待获取定位信息
			new WebDriverWait(driver, 30).until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@resource-id='map-now-address']")));
			String text =driver.findElement(
					By.xpath("//android.view.View[@resource-id='map-now-address']")).getAttribute("name");
			logger.info("当前定位是："+text);
			//判断定位信息是否正确
			if (!text.isEmpty() && !text.contains("航天云网大厦")){
				driver.findElement(By.xpath("//android.view.View[@resource-id='map-now-address']")).click();
				new WebDriverWait(driver, 30).until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ListView")));
				int num = driver.findElements(By.xpath("//android.widget.ListView/android.view.View")).size();
                //列表循环查找定位
				for (int j=2 ;j<num ;j++){
					String m = String.valueOf(j);
					String location = driver.findElement(By.xpath("//android.widget.ListView/android.view.View["+m+"]/android.view.View[1]")).getAttribute("name");
					if (location.contains("航天云网大厦")){
						driver.findElement(By.xpath("//android.widget.ListView/android.view.View["+m+"]/android.view.View[1]")).click();
						break;
					}else if (j==num-1){
                        logger.info("********** 全部列表未找到,查询企业列表 **********");
                        driver.findElement(By.xpath("//android.view.View[@text='企业']")).click();
                        new WebDriverWait(driver, 30).until(
                                ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ListView")));
                        int num2 = driver.findElements(By.xpath("//android.widget.ListView/android.view.View")).size();
                        for (int k=2;k<num2;k++){
                            String n = String.valueOf(k);
                            location = driver.findElement(By.xpath("//android.widget.ListView/android.view.View["+n+"]/android.view.View[1]")).getAttribute("name");
                            if (location.contains("航天云网大厦")){
                                driver.findElement(By.xpath("//android.widget.ListView/android.view.View["+n+"]/android.view.View[1]")).click();
                                break;
                            }else if (k == num2-1){
                                driver.navigate().back();
                                break;
                            }else {
                                continue;
                            }
                        }
						break;
					}else {
						continue;
					}
				}
				break;
			}else if (text.isEmpty()){
			    Thread.sleep(5000);
				continue;
			}else {
				break;
			}
		}

		//获取当前系统时间
		Thread.sleep(3000);
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");// 设置日期格式
		Date now =df.parse(df.format(new Date()));
		Date start = df.parse("08:30");
		Date end = df.parse("17:30");
		logger.info("当前时间 = **********" + now);
		//判断是否到打卡时间
		if( now.before(start) || now.after(end) ){
				//点击签到
				driver.findElement(By.xpath("//android.view.View[@resource-id='item-button-clocking']/android.view.View[1]")).click();
				Thread.sleep(3000);
				String text = driver.findElement(By.xpath("//android.view.View[@resource-id='item-button-clocking']/preceding-sibling::android.view.View[3]")).getAttribute("name");
				if (text.contains("正常")){
					logger.info("********** 成功 **********");
					flag = true;
				}else{
					logger.info("**********"+text);
					flag = false;
				}
		}else {
				//时间没到不点击，返回失败
				logger.info("当前时间 = **********" + now + "没到时间");
				flag = false;
		}
		Assert.assertTrue(flag);
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
}