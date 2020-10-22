package elementpage;

import base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;


public class WorkElementPage{
    AndroidDriver driver;
    BasePage basePage;
    /**
     * 构造方法
     * */
    public WorkElementPage(AndroidDriver driver) {
        this.driver =driver;
        basePage =new BasePage(driver);
        PageFactory.initElements(driver, this);
    }
    /**
     * 获取跳过按钮元素
     * */

    @FindBy(xpath = "//android.widget.TextView[@text='跳过']")
    public WebElement skip_button;

    @FindBy(xpath = "//android.widget.TextView[@text='跳过']")
    public List<WebElement> skip_buttons;



    /**
     * 获取返回登录页按钮元素
     * */
    @FindBy(xpath = "//android.widget.TextView[@text='返回登录页']")
    public WebElement 返回登录页按钮;
    @FindBy(xpath = "//android.widget.TextView[@text='返回登录页']")
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

    @FindBy(xpath = "//android.widget.ListView/android.view.View/android.view.View")
    public List<WebElement> 位置列表s;
    @FindBy(xpath = "//android.widget.ListView/android.view.View")
    public WebElement 位置列表;


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

    @FindBy(xpath = "//android.view.View[@resource-id='clock-page']/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[3]")
    public WebElement 签到文本;

    /**
     * 获取签退后的文本元素
     * */

    @FindBy(xpath = "//android.view.View[@resource-id='clock-page']/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[6]")
    public WebElement 签退文本;





}
