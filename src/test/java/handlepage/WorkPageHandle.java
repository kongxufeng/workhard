package handlepage;

import base.BasePage;
import elementpage.WorkElementPage;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.support.PageFactory;
import java.util.Date;


public class WorkPageHandle {
    AndroidDriver driver;
    WorkElementPage workpage;
    BasePage basePage;
    public Logger logger = LogManager.getLogger();
    /**
     * 构造方法
     * */
    public WorkPageHandle(AndroidDriver driver) {
        this.driver =driver;
        workpage = new WorkElementPage(driver);
        basePage = new BasePage(driver);
        PageFactory.initElements(driver,this);
    }

    //判断跳过按钮元素是否为空
    public boolean 跳过按钮元素为空(){
        return workpage.skip_buttons.isEmpty();
    }

    public void 跳过按钮_点击(){
        workpage.skip_button.click();
    }



    //判断返回登录按钮元素是否为空
    public boolean 返回登录按钮元素为空(){
        return workpage.返回登录页按钮s.isEmpty();
    }

    public void 返回登陆页按钮_点击(){
        workpage.返回登录页按钮.click();
    }

    //等待登录按钮
    public void 等待登录按钮可用(){
        basePage.等待元素(workpage.登录按钮);
    }

    public void 登录按钮_点击(){
        等待登录按钮可用();
        workpage.登录按钮.click();
    }

    //等待工作台按钮
    public void 等待工作台按钮可用(){
        basePage.等待元素(workpage.工作台按钮);
    }

    public void 工作台按钮_点击(){
        等待工作台按钮可用();
        workpage.工作台按钮.click();
    }



    //等待签到按钮
    public void 等待签到按钮可用(){
        basePage.等待元素(workpage.签到按钮);
    }

    public void 签到按钮_点击(){
        等待签到按钮可用();
        workpage.签到按钮.click();
    }

    //等待定位信息按钮
    public void 等待定位信息按钮可用(){
        basePage.等待元素(workpage.定位信息);
    }

    //点击定位信息进入定位列表
    public void 定位信息按钮_点击(){
        等待定位信息按钮可用();
        workpage.定位信息.click();
    }

    //点击企业按钮
    public void 企业按钮_点击(){
        basePage.等待元素(workpage.企业按钮);
        workpage.企业按钮.click();
    }

    //获取位置信息内容
    public String 获取位置信息(){
       return workpage.定位信息.getAttribute("name");
    }

    //等待位置列表元素出现
    public void 等待位置列表出现(){
        basePage.等待元素(workpage.位置列表);
    }

    //位置列表识别验证
    public void 查询正确位置(){
        等待位置列表出现();
            if (workpage.定位.isDisplayed()){
                workpage.定位.click();
            }else{
                driver.navigate().back();
            }
    }
    //验证位置
    public void 校验位置(String location) throws Exception{
        等待定位信息按钮可用();
        for (int i=0;i<5;i++){
            if (获取位置信息().isEmpty()){
                Thread.sleep(2000);
            }else if (!获取位置信息().contains(location)){
                定位信息按钮_点击();
                Thread.sleep(2000);
                企业按钮_点击();
                Thread.sleep(5000);
                查询正确位置();
            }else {
                break;
            }
        }
    }


    //当前时间
    public Date 当前时间(){
        return basePage.GetDate("HH:mm");
    }

    //签到时间
    public Date 签到时间(){
        return basePage.GetDate("HH:mm","08:30");
    }

    //签退时间
    public Date 签退时间(){
        return basePage.GetDate("HH:mm","17:30");
    }

    //进行打卡
    public boolean 打卡()throws Exception{
        Date now =当前时间();
        Date start=签到时间();
        Date end=签退时间();
        boolean flag =false;
        if (now.before(start) || now.after(end) ){
            Thread.sleep(3000);
            for (int i = 0; i <4 ; i++) {
                打卡按钮_点击();
                Thread.sleep(3000);
                int n = workpage.校验文本s.size();
                int m = workpage.校验文本s1.size();
                int num = n+m;
                if (now.before(start) && num==1){
                    flag = true;
                    break;
                }else if (now.after(end) && num==2){
                    flag = true;
                    break;
                }else {
                    continue;
                }
            }

        }else {
            //时间没到不点击，返回失败
            logger.error("当前时间 = **********" + now + "没到时间");
            flag =false;
        }

        return flag;
    }


    //点击打卡按钮
    public void 打卡按钮_点击(){
        basePage.等待元素(workpage.打卡按钮);
        workpage.打卡按钮.click();
    }





}
