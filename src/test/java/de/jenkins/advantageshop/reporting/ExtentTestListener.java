package de.jenkins.advantageshop.reporting;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.SkipException;

public class ExtentTestListener implements ITestListener {

    @Override
    public synchronized void onStart(ITestContext pContext) {
    }

    @Override
    public synchronized void onFinish(ITestContext pContext) {
        ExtentTestManager.endTest();
        ExtentReportsManager.getInstance().flush();
    }

    @Override
    public synchronized void onTestStart(ITestResult pResult) {
        // Создание узла отчета
        ExtentTestManager.createReportNode(pResult.getMethod().getDescription(), pResult.getMethod().getMethodName());
    }

    @Override
    public synchronized void onTestSuccess(ITestResult pResult) {
        System.out.println("Test finished: " + pResult.getMethod().getDescription() + ", pInternerTestName: " + pResult.getMethod().getMethodName());
        ExtentTest test = ExtentTestManager.getTest();
        if (test != null) {
            test.log(Status.PASS, "Test passed");
        }
    }

    @Override
    public synchronized void onTestFailure(ITestResult pResult) {
        if (!pResult.getThrowable().getClass().equals(SkipException.class)) {
            System.out.println("onTestFailure called for method: " + pResult.getMethod().getMethodName());
            ExtentTest test = ExtentTestManager.getTest();
            if (test != null) {
                test.log(Status.FAIL, ExceptionUtils.getStackTrace(pResult.getThrowable()));
                String aScreenshot = CaptureScreen.getSeleniumScreenshotAsBase64();
                ReportHelper.addScreenshot("Fehler", aScreenshot);
            }
        }
    }

    @Override
    public synchronized void onTestSkipped(ITestResult pResult) {
        System.out.println("onTestSkipped called for method: " + pResult.getMethod().getMethodName());
        ExtentTestManager.createReportNode(pResult.getMethod().getDescription(), pResult.getMethod().getMethodName());
        ExtentTest test = ExtentTestManager.getTest();
        if (test != null) {
            test.log(Status.SKIP, "Test skipped");
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult pResult) {
    }
}
