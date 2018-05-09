package com.testAutomation.testcases;

import com.testAutomation.base.TestBase;
import com.testAutomation.utilities.TestUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OpenAccountTest extends TestBase {

    @Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
    public void openAccountTest(String customer, String currency, String alertText) throws InterruptedException {

        click("openaccountBtn_XPATH");
        select("customer_XPATH", customer);
        select("currency_XPATH", currency);
        click("processBtn_XPATH");

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alert.getText().contains(alertText));
        alert.accept();

    }



}
