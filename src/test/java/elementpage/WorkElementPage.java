package elementpage;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class WorkElementPage{
    AndroidDriver driver;
    /**
     * 构造方法
     * */
    public WorkElementPage(AndroidDriver driver) {
        this.driver =driver;
        PageFactory.initElements(driver, this);
    }
    /**
     * 获取跳过按钮元素
     * */

    @FindBy(xpath = "//android.widget.TextView[@text='跳过']")
    public WebElement skip_button;
    public List<WebElement> skip_buttons;

    /**
     * 获取返回登录页按钮元素
     * */
    @FindBy(xpath = "//android.widget.TextView[@text='返回登录页']")
    public WebElement 返回登录页按钮;
    public List<WebElement> 返回登录页按钮s;

    /**
     * 获取登陆按钮元素
     * */

    @FindBy(xpath = "//*[starts-with(@text,'登录')]")
    public WebElement 登录按钮;

    /**
     * 获取工作台按钮元素
     * */

    @FindBy(xpath = "//android.widget.TextView[@text='工作台']")
    public WebElement 工作台按钮;



    /**
     * 获取签到按钮元素
     * */

    @FindBy(xpath = "//android.view.View[@text='签到']")
    public WebElement 签到按钮;


    /**
     * 获取定位信息元素
     * */

    @FindBy(xpath = "//android.view.View[@resource-id='map-now-address']")
    public WebElement 定位信息;

    /**
     * 获取位置list元素
     * */

    @FindBy(xpath = "//android.widget.ListView/android.view.View")
    public List<WebElement> 位置列表s;
    public WebElement 位置列表;
    public List<WebElement> get位置列表内容元素(){
        return 位置列表.findElements(By.xpath("//android.view.View[1]"));
    }

    /**
     * 获取企业列表切换按钮元素
     * */

    @FindBy(xpath = "//android.view.View[@text='企业']")
    public WebElement 企业按钮;

    /**
     * 获取打卡按钮元素
     * */

    @FindBy(xpath = "//android.view.View[@resource-id='item-button-clocking']/android.view.View[1]")
    public WebElement 打卡按钮;

    /**
     * 获取签到后的文本元素
     * */

    @FindBy(xpath = "//android.view.View[@resource-id='clock-elementpage']/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[2]")
    public WebElement 签到文本;

    /**
     * 获取签退后的文本元素
     * */

    @FindBy(xpath = "//android.view.View[@resource-id='clock-elementpage']/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[5]")
    public WebElement 签退文本;



}
