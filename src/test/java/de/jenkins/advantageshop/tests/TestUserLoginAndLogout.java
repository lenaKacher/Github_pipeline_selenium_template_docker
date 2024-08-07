package de.jenkins.advantageshop.tests;

import de.jenkins.advantageshop.common.Global_VARS;
import de.jenkins.advantageshop.common.TestBase;
import de.jenkins.advantageshop.pageobjects.MenuPO;
import de.jenkins.advantageshop.pageobjects.SignInPO;
import de.jenkins.advantageshop.reporting.CaptureScreen;
import de.jenkins.advantageshop.reporting.ReportHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestUserLoginAndLogout extends TestBase {

    // Test data
    protected String userName = Global_VARS.login;
    protected String password = Global_VARS.password;

    @Test(description = "Einfacher login und logout")
    protected void testUserLoginAndLogout() {
        // Steps for logging in
        goToUserInput();
        enterDataForLogIn();

        // Assert if the user is logged in
        Assert.assertEquals(getNameOfUserLogged(), userName, "User is logged");

        // Steps for logging out
        stepsForLoggingOut();

        // Assert if the user is logged out
        Assert.assertTrue(getNameOfUserLoggedOut().isEmpty());

        // Reporting in table
        String[][] aInfos = {
                {"Username logged", userName},
                {"Username unlogged", "empty"},
        };
        ReportHelper.createTable(aInfos);

        // Screenshot vom Warenkorb
        String aScreenshot = CaptureScreen.getSeleniumScreenshotAsBase64();
        ReportHelper.addScreenshot("User Logged out", aScreenshot);
    }

    // Go to the interface where one can input the information of the user
    public void goToUserInput() {
        MenuPO aMenu = new MenuPO();
        aMenu.goToUser();

    }

    // Input of the name and the password of the user for logging in
    public void enterDataForLogIn() {
        SignInPO aSignIn = new SignInPO();
        aSignIn.sendInputUser(userName);
        aSignIn.sendInputPassword(password);
        aSignIn.clickButtonToSignIn();
    }

    // String of the name of the logged-in user
    public String getNameOfUserLogged() {
        MenuPO aMenuWithUser = new MenuPO();
        return aMenuWithUser.getLoggedUser();
    }

    // Steps for logging out of menu
    public void stepsForLoggingOut() {
        MenuPO aMenuWithUser = new MenuPO();
        aMenuWithUser.clickUserFunctions();
        aMenuWithUser.clickToLogOut();
    }

    // Get empty string of logged-out user
    public String getNameOfUserLoggedOut() {
        MenuPO menu = new MenuPO();
        return menu.readBlankUser();
    }
}