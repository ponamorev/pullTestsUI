package com.andersenlab.ponamorev.pulltests.pages;

import com.andersenlab.ponamorev.pulltests.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TranslatePage extends BasePage {
    @FindBy(id = "logo")
    private WebElement logoButton;

    /**
     * Click for returning to start page
     */
    @Override
    public void returnToStartPage() {
        init(Driver.getDriver());
        logoButton.click();
    }
}