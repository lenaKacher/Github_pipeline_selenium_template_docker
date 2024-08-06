package de.jenkins.advantageshop.common;

import de.jenkins.advantageshop.reporting.ExtentTestManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static de.jenkins.advantageshop.common.Global_VARS.aDriverType;
import static de.jenkins.advantageshop.common.Global_VARS.url;

public abstract class TestBase {

    @BeforeClass
    protected void setUp() {
        // Get system properties
//        String aDriverType = System.getProperty("driverType", "CHROME");
//        String aEnvironment = System.getProperty("environment", "http://advantage.proficom.de:8080/#/");

        // Create the specific driver
        CreateWebDriver.getInstance().setWebDriver(aDriverType);
        WebDriver aDriver = CreateWebDriver.getInstance().getWebDriver();

        // Open the AUT
        aDriver.get(url);
        System.out.println();
        System.out.println("Test Properties - driver:" + aDriverType + " | env:" + url);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        CreateWebDriver.getInstance().closeWebDriver();
    }
}