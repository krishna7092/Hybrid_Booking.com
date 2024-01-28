package Booking.Listeners;

import Booking.BaseTest.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;


public class TestListener extends BaseClass implements ITestListener {


   public ExtentReports extentReports  = ReportConfiguration.ExtendReprtGenerator(); ;
    ExtentTest test;




    @Override
    public void onTestStart(ITestResult result) {

        test= extentReports.createTest(result.getMethod().getMethodName());
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        test.pass(" Test method passed" + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver1;
        try {
           driver1 = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ITestListener.super.onTestFailure(result);
        test.log(Status.FAIL,result.getThrowable());
        test.fail("Test is failed on " + result.getMethod().getDate() + " Method name" + result.getMethod().getMethodName());
        try {

            screenshot(result.getMethod().getMethodName(),driver1,"Failed");
            ExtentTest failedSc = test.addScreenCaptureFromPath(System.getProperty("user.dir") + "/Reports/Screenshots/Failed" + "/" + result.getMethod().getMethodName() + ".png", "Failed sc");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        extentReports.flush();
    }
}
