package de.jenkins.advantageshop.pageobjects;

import de.jenkins.advantageshop.common.BasePO;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePO extends BasePO {

    // === Web Elements ===
    @FindBy(id = "speakersImg")
    protected WebElement divSpeakers;

    @FindBy(id = "tabletsImg")
    protected WebElement divTablets;

    // === Constructor ===
    public HomePO() {
        super();
    }

    // === Methods ===
    public void goToSpeakers() {
        divSpeakers.click();
    }

    public void goToTablets() {
        divTablets.click();
    }
}