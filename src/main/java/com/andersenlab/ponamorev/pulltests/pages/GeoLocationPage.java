package com.andersenlab.ponamorev.pulltests.pages;

import com.andersenlab.ponamorev.pulltests.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeoLocationPage extends BasePage {
    @FindBy(id = "city__front-input")
    private WebElement cityField;
    @FindBy(xpath = "//div[text()='Минск']")
    private WebElement cityFromDropDownList;
    @FindBy(css = ".button.form__save")
    private WebElement saveButton;



    /**
     * Check that field for city is enabled
     * @return
     */
    public boolean isCityFieldEnabled() {
        return cityField.isEnabled();
    }

    /**
     * Check that save button is disabled
     * @return
     */
    public boolean isSaveButtonDisabled() {
        return !saveButton.isEnabled();
    }

    /**
     * Clear field for city
     */
    public void clearCityField() {
        cityField.clear();
    }

    /**
     * Enter city in field
     * @param city
     */
    public void enterCity(String city) {
        cityField.sendKeys(city);
        new WebDriverWait(Driver.getDriver(), 5).until(ExpectedConditions.visibilityOf(cityFromDropDownList));
    }

    /**
     * Click top element from drop down list after entering the city
     */
    public void clickTopElementFromCitiesDropDownList() {
        init(Driver.getDriver());
        new WebDriverWait(Driver.getDriver(), 5).until(ExpectedConditions.visibilityOf(cityFromDropDownList));
        cityFromDropDownList.click();
    }
}
