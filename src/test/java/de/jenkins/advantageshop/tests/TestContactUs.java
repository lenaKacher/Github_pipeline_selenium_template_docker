package de.jenkins.advantageshop.tests;

import de.jenkins.advantageshop.common.TestBase;
import de.jenkins.advantageshop.pageobjects.ContactUsPO;
import de.jenkins.advantageshop.reporting.CaptureScreen;
import de.jenkins.advantageshop.reporting.ReportHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestContactUs extends TestBase {

    // Test data
    protected String categoryName = "Headphones";
    protected String productName = "Beats Studio 2 Over-Ear Matte Black Headphones";
    protected String eMail = "test@hotmail.com";
    protected String subject ="It does not work in the correct way, it does turn off every single 5 minutes";

    @Test(description = "Kontaktformular absenden")
    protected void testContactUs(){
        // steps to write a formulary
        selectAndSetCategory();
        selectAndSetProduct();
        setEmail();
        setSubjet();
        pressSend();

        // check confirmation message
        Assert.assertEquals(getConfirmation(),"Thank you for contacting Advantage support.", "Form Submitted");

        // Screenshot of confirmation
        String aScreenshot = CaptureScreen.getSeleniumScreenshotAsBase64();
        ReportHelper.addScreenshot("Warenkorb", aScreenshot);
    }

    public void selectAndSetCategory(){
        ContactUsPO aSelectCategory = new ContactUsPO();
        aSelectCategory.enterCategoryList();
        aSelectCategory.setCategory(categoryName);
    }

    public void selectAndSetProduct(){
        ContactUsPO aSelectProduct = new ContactUsPO();
        aSelectProduct.enterProductList();
        aSelectProduct.setSelectProduct(productName);
    }

    public void setEmail(){
        ContactUsPO aEnterEmail = new ContactUsPO();
        aEnterEmail.setEmail(eMail);
    }

    public void setSubjet(){
        ContactUsPO aEnterSubject = new ContactUsPO();
        aEnterSubject.setSubject(subject);
    }

    public void pressSend(){
        ContactUsPO aPressSend = new ContactUsPO();
        aPressSend.pressSend();
    }

    public String getConfirmation(){
        ContactUsPO aGetConfirmation = new ContactUsPO();
        return aGetConfirmation.getStringOfText();
    }
}