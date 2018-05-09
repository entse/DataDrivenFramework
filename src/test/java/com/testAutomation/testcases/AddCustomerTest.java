package com.testAutomation.testcases;

import com.testAutomation.base.TestBase;
import com.testAutomation.utilities.TestUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCustomerTest extends TestBase {

    @Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
    public void addCustomerTest(String firstName, String lastName, String postCode, String alertText){

        click("addCustBtn_XPATH");
        type("firstname_XPATH", firstName);
        type("lastname_XPATH", lastName);
        type("postcode_XPATH", postCode);
        click("addbtn_XPATH");

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        Assert.assertTrue(alert.getText().contains(alertText));
        alert.accept();
    }



}
