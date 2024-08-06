package de.jenkins.advantageshop.pageobjects;

import de.jenkins.advantageshop.common.BasePO;
import de.jenkins.advantageshop.common.SynchronizationUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPO extends BasePO {

    // === WebElements ===
    @FindBy(name = "username")
    protected WebElement inputUser;

    @FindBy(name = "password")
    protected WebElement inputPassword;

    @FindBy(id = "sign_in_btn")
    protected WebElement buttonSignIn;

    // === Constructor ===
    public SignInPO() {
        super();
    }

    // === Methods ===
    public void sendInputUser(String pUserName) {
        inputUser.sendKeys(pUserName);
    }

    public void sendInputPassword(String pPassword) {
        inputPassword.sendKeys(pPassword);
    }

    public void clickButtonToSignIn() {
        SynchronizationUtils.waitForClickable(buttonSignIn);
        buttonSignIn.click();
        SynchronizationUtils.waitForInvisibility(buttonSignIn);
    }
}