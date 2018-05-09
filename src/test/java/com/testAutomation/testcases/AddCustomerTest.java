package com.testAutomation.testcases;

import com.testAutomation.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCustomerTest extends TestBase {

    @Test(dataProvider = "getData")
    public void addCustomer(String firstName, String lastName, String postCode, String alertText){

        click("addCustBtn_XPATH");
        type("firstname_XPATH", firstName);
        type("lastname_XPATH", lastName);
        type("postcode_XPATH", postCode);
        click("addbtn_XPATH");

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        Assert.assertTrue(alert.getText().contains(alertText));
        alert.accept();
    }


    @DataProvider
    public Object[][] getData(){

        String sheetName = "AddCustomerTest";
        int rows = excel.getRowCount(sheetName);
        int cols = excel.getColumnCount(sheetName);

        Object[][] data = new Object[rows - 1][cols];

        for (int rowNum = 2; rowNum <= rows; rowNum++){ //2
            for(int colNum = 0; colNum < cols; colNum++){
                data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum); //-2
            }
        }return data;
    }
}
