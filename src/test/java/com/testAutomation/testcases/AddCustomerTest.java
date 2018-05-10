package com.testAutomation.testcases;

import com.testAutomation.base.TestBase;
import com.testAutomation.utilities.TestUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class AddCustomerTest extends TestBase {

    @Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
    public void addCustomerTest(Hashtable<String, String> data) throws InterruptedException{

        if(!data.get("runmode").equals("Y")){
            throw new SkipException("Skipping the testcase cause RunMode is set to NO");
        }

        click("addCustBtn_XPATH");
        type("firstname_XPATH", data.get("firstname"));
        type("lastname_XPATH", data.get("lastname"));
        type("postcode_XPATH", data.get("postcode"));
        click("addbtn_XPATH");

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        Assert.assertTrue(alert.getText().contains(data.get("alerttext")));
        alert.accept();
    }



}
