package com.testAutomation.testcases;

import com.testAutomation.base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Test
    public void loginAsBankManager() throws InterruptedException {
        log.debug("Inside Login Test");
        driver.findElement(By.xpath(OR.getProperty("bmlbtn"))).click();
        Thread.sleep(3000);
        log.debug("Login succesfully executed");
    }
}
