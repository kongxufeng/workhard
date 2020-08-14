package ragz;


import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.AppDemo;

public class WorkHard extends AppDemo {

    @Test(description = "测试")
    public void sign() throws Exception{
        driver.findElement(By.xpath("//android.widget.TextView[@text='工作台']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='签到']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.view.View[@resource-id='index-container']/android.view.View[3]/android.view.View[2]")).getText();

        Thread.sleep(1000);


    }

}
