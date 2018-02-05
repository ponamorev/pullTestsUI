package com.andersenlab.ponamorev.pulltests.pages;

import com.andersenlab.ponamorev.pulltests.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MapsPage extends BasePage {
    @FindBy(className = "logo-view__logo")
    WebElement logoButton;

    /**
     * Click logo button
     */
    @Override
    public void returnToStartPage() {
        init(Driver.getDriver());
        logoButton.click();
    }
}