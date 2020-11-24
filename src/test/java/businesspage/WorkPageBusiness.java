package businesspage;

import handlepage.WorkPageHandle;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;

public class WorkPageBusiness {
    //WorkPageHandle pageHandle;
    AndroidDriver driver;
    WorkPageHandle workPageHandle;


    public WorkPageBusiness(AndroidDriver driver){
        this.driver =driver;
        workPageHandle = new WorkPageHandle(driver);
    }

    public void run() throws Exception {
        Thread.sleep(3000);
        //判断是否出现跳过、返回登录页按钮，并点击
        if(!workPageHandle.跳过按钮元素为空()){
            workPageHandle.跳过按钮_点击();
        }
        if (!workPageHandle.返回登录按钮元素为空()){
            workPageHandle.返回登陆页按钮_点击();
            workPageHandle.登录按钮_点击();
        }
        //进入工作台签到页面
        Thread.sleep(3000);
        workPageHandle.工作台按钮_点击();
       // pageHandle.等待签到按钮可用();
        Thread.sleep(3000);
        workPageHandle.签到按钮_点击();
        //校验位置信息
        Thread.sleep(3000);
        workPageHandle.校验位置("航天云网大厦");
        //打卡并断言
        boolean flag = workPageHandle.打卡();
        Assert.assertTrue(flag);
    }


}
