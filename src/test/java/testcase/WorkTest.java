package testcase;


import businesspage.WorkPageBusiness;

import org.testng.annotations.Test;


public class WorkTest extends AppCaseBase {
    /*private static String username ="asd123";
    private static String password ="asd123";*/

    /*@Test
    public void WorkTest() throws Exception{
        boolean flag =false;
        new WebDriverWait(driver, 30).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='工作台']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='工作台']")).click();
        new WebDriverWait(driver, 30).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='航天云网OA']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='航天云网OA']")).click();
        new WebDriverWait(driver, 30).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='微协同']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='微协同']")).click();
        new WebDriverWait(driver, 30).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@text='全部应用']")));
        driver.findElement(By.xpath("//android.view.View[@text='全部应用']")).click();
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
            if (!text.isEmpty() && !text.equals("航天云网大厦")){
                driver.findElement(By.xpath("//android.view.View[@resource-id='map-now-address']")).click();
                new WebDriverWait(driver, 30).until(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ListView")));
                List<WebElement> element = driver.findElements(By.xpath("//android.widget.ListView/android.view.View"));
                //列表循环查找定位
                for (int j=2 ;j<element.size() ;j++){
                    String m = String.valueOf(j);
                    WebElement element1= driver.findElement(By.xpath("//android.widget.ListView/android.view.View["+m+"]/android.view.View[1]"));
                    String location = element1.getAttribute("name");
                    if (location.contains("航天云网大厦")){
                        driver.findElement(By.xpath("//android.widget.ListView/android.view.View["+m+"]/android.view.View[1]")).click();
                        break;
                    }else if (j==element.size()-1){
                        logger.info("********** 全部列表未找到,查询企业列表 **********");
                        driver.findElement(By.xpath("//android.view.View[@text='企业']")).click();
                        new WebDriverWait(driver, 30).until(
                                ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ListView")));
                        List<WebElement> element2 = driver.findElements(By.xpath("//android.widget.ListView/android.view.View"));
                        for (int k=2;k<element2.size();k++){
                            String n = String.valueOf(k);
                            WebElement element3 = driver.findElement(By.xpath("//android.widget.ListView/android.view.View["+n+"]/android.view.View[1]"));
                            location = element3.getAttribute("name");
                            if (location.contains("航天云网大厦")){
                                driver.findElement(By.xpath("//android.widget.ListView/android.view.View["+n+"]/android.view.View[1]")).click();
                                break;
                            }else if (k == element2.size()-1){
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
            String text ="";
            if (now.before(start)){
                text = driver.findElement(By.xpath("//android.view.View[@resource-id='clock-elementpage']/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[2]")).getAttribute("name");
            }else {
                text = driver.findElement(By.xpath("//android.view.View[@resource-id='clock-elementpage']/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[5]")).getAttribute("name");
            }

            if (text.contains("正常")){
                logger.info("********** 成功 **********");
                flag = true;
            }else{
                logger.error("未检测到正常**********"+text);
                flag = false;
            }
        }
        else {
            //时间没到不点击，返回失败
            logger.error("当前时间 = **********" + now + "没到时间");
            flag = false;
        }
        Assert.assertTrue(flag);


    }*/


    @Test
    public void Test()throws Exception{
        //LoginPage loginPage =new LoginPage(driver);
        //loginPage.login(username,password);
        WorkPageBusiness business = new WorkPageBusiness(driver);
        business.run();
    }
}
