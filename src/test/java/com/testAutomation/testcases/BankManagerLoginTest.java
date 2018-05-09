package com.testAutomation.testcases;

import com.testAutomation.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankManagerLoginTest extends TestBase{

    @Test
    public void loginAsBankManager() throws InterruptedException {
        log.debug("Inside Login Test");
        click("bmlBtn_XPATH");
        Thread.sleep(3000);

        Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("addCustBtn_XPATH"))), "Login is not successful");

        log.debug("Login succesfully executed");
    }
}
