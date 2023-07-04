package manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {


    Logger logger = LoggerFactory.getLogger(TestNGListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        logger.info("Test " + result.getHost() + " started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        logger.info("Test " + result.getHost() + " successfull");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        logger.info("Test " + result.getHost() + " failed: " + result.getThrowable().fillInStackTrace());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
        logger.info("Test " + result.getHost() + " failed: " + result + result.getThrowable().fillInStackTrace());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
