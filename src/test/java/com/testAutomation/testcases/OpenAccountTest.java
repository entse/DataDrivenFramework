package com.testAutomation.testcases;

import com.testAutomation.base.TestBase;
import com.testAutomation.utilities.TestUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class OpenAccountTest extends TestBase {

    @Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
    public void openAccountTest(Hashtable<String, String> data) throws InterruptedException {

        if(!(TestUtil.isTestRunnable("openAccountTest", excel))){
            throw new SkipException("Skipping the test "+"openAccountTest".toUpperCase()+ "cause Run mode is set to NO");
        }

        click("openaccountBtn_XPATH");
        select("customer_XPATH", data.get("customer"));
        select("currency_XPATH", data.get("currency"));
        click("processBtn_XPATH");

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alert.getText().contains(data.get("alerttext")));
        alert.accept();

    }



}
