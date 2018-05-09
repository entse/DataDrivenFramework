package com.testAutomation.listeners;

import com.relevantcodes.extentreports.LogStatus;
import com.testAutomation.base.TestBase;
import com.testAutomation.utilities.TestUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.IOException;

public class CustomListeners extends TestBase implements ITestListener {

    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {

        test.log(LogStatus.PASS, result.getName().toUpperCase()+" PASS");
        rep.endTest(test);
        rep.flush();
    }

    public void onTestFailure(ITestResult result) {

        System.setProperty("org.uncommons.reportng.escape-output", "false");
        try {
            TestUtil.captureScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.log(LogStatus.FAIL, result.getName().toUpperCase()+" Failed with exception: " + result.getThrowable());
        test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

        Reporter.log("Click to see Screenshot");
        Reporter.log("<a target =\"_blank\" href="+TestUtil.screenshotName+">Screenshot</a>");
        Reporter.log("<br>");
        Reporter.log("<br>");
        Reporter.log("<a target =\"_blank\" href="+TestUtil.screenshotName+"><img src="+TestUtil.screenshotName+" height=200 weight=200></img></a>");
        rep.endTest(test);
        rep.flush();
    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

        test = rep.startTest(context.getName().toUpperCase());
    }

    public void onFinish(ITestContext context) {

    }
}
