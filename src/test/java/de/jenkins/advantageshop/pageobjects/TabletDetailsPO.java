package de.jenkins.advantageshop.pageobjects;

import de.jenkins.advantageshop.common.BasePO;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TabletDetailsPO extends BasePO {

    // === Web Elements ===
    @FindBy(xpath = "//div[@id='Description']/h1")
    protected WebElement nameOfTheTablet;

    @FindBy(xpath = "//div[@id='Description']/h2")
    protected WebElement priceOfTheTablet;

    // === Constructor ===
    public TabletDetailsPO() {
        super();
    }

    // === Methods ===
    public String getNameOfTablet() {
        return nameOfTheTablet.getText();
    }

    public String getPriceOfTablet() {
        return priceOfTheTablet.getText();
    }
}