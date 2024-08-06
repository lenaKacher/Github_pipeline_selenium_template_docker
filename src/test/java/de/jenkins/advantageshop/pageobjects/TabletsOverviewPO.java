package de.jenkins.advantageshop.pageobjects;

import de.jenkins.advantageshop.common.BasePO;
import de.jenkins.advantageshop.common.SynchronizationUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TabletsOverviewPO extends BasePO {

    // === Web Elements ===
    @FindBy(xpath = "//div[@class='cell categoryRight']//li[1]//img")
    protected WebElement firstTablet;

    // === Constructor ===
    public TabletsOverviewPO() {
        super();
    }

    // === Methods ===
    public void clickFirstTablet() {
        SynchronizationUtils.threadSleeper(1000);
        SynchronizationUtils.waitForClickable(firstTablet);
        firstTablet.click();
    }
}