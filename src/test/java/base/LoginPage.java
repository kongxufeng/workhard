package base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    AndroidDriver driver;

    /**
     * 构造方法
     * */
    public LoginPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * 获取登陆按钮元素
     * */

    @FindBy(xpath = "//*[starts-with(@text,'登录')]")
    public WebElement 登录按钮;

    /**
     * 获取用户名输入框元素
     * */

    @FindBy(xpath = "//*[starts-with(@text,'用户名')]")
    public WebElement 用户名;

    /**
     * 获取密码输入框元素
     * */

    @FindBy(xpath = "//*[starts-with(@text,'密码')]")
    public WebElement 密码;

    public void login(String username,String password){
        new WebDriverWait(driver, 30).until(
                ExpectedConditions.visibilityOf(用户名));
        用户名.sendKeys(username);
        密码.sendKeys(password);
    }
}
