package com.andersenlab.ponamorev.pulltests.pages;

import com.andersenlab.ponamorev.pulltests.Driver;
import com.andersenlab.ponamorev.pulltests.data.LanguagesData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LanguageChoicePage extends BasePage {
    @FindBy(css = ".button.select__button")
    private WebElement languageChoiceButton;
    @FindBy(css = "*[class='select__item'")
    private List<WebElement> availiableLanguages;
    @FindBy(css = ".form__save")
    private WebElement saveButton;
    @FindBy(xpath = "//*[@class='select__text'][text()='English']")
    private WebElement neededLanguageButton;
    @FindBy(xpath = "//*[@class='select__text'][text()='Русский']")
    private WebElement nativeLanguageButton;
    @FindBy(css = ".button.select__button .button__text")
    private WebElement currentLanguage;
    @FindBy(css = ".logo")
    private WebElement logoButton;

    private String neededLanguage = "English";



    /**
     * Click button to choose language
     */
    @Override
    public void clickChoiceLanguageButton() {
        init(Driver.getDriver());
        languageChoiceButton.click();
    }

    /**
     * Check that English language is enabled
     * @return
     */
    public boolean isNeededLanguageEnabled() {
        return neededLanguageButton.isEnabled();
    }

    /**
     * Check that Russian language is enabled
     * @return
     */
    public boolean isNativeLanguageEnabled() {
        return nativeLanguageButton.isEnabled();
    }

    /**
     * Click English language
     */
    public void clickNeededLanguage() {
        init(Driver.getDriver());
        neededLanguageButton.click();
    }

    /**
     * Click save button
     */
    public void clickSaveButton() {
        saveButton.click();
    }

    /**
     * Check that save button is clickable
     * @return
     */
    public boolean isSaveButtonClickable() {
        try {
            new WebDriverWait(Driver.getDriver(), 5).until(
                    ExpectedConditions.elementToBeClickable(saveButton));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Click Russian language
     */
    public void clickNativeLanguage() {
        nativeLanguageButton.click();
    }

    /**
     * Get current language
     * @return
     */
    public String getCurrentLanguage() {
        init(Driver.getDriver());
        return currentLanguage.getText();
    }

    /**
     * Click logo to return on start page
     */
    @Override
    public void returnToStartPage() {
        logoButton.click();
    }
}