package businesspage;

import base.BasePage;
import handlepage.WorkPageHandle;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.asserts.Assertion;

public class WorkPageBusiness {
    AndroidDriver driver;
    WorkPageHandle pageHandle;

    public WorkPageBusiness(AndroidDriver driver){
        this.driver =driver;
        pageHandle=new WorkPageHandle(driver);
    }

    public void run() throws Exception {
        Thread.sleep(10000);
        //判断是否出现跳过、返回登录页按钮，并点击
        pageHandle.跳过按钮_点击();
        if (!pageHandle.返回登录按钮元素为空()){
            pageHandle.返回登陆页按钮_点击();
            pageHandle.登录按钮_点击();
        }
        //进入工作台签到页面
        pageHandle.工作台按钮_点击();
        pageHandle.等待签到按钮可用();
        pageHandle.签到按钮_点击();
        //校验位置信息
        pageHandle.校验位置("航天云网");
        //打卡并断言
        boolean flag = pageHandle.打卡();
        Assert.assertTrue(flag);
    }


}
