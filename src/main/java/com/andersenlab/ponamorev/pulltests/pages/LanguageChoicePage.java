package com.andersenlab.ponamorev.pulltests.pages;

import com.andersenlab.ponamorev.pulltests.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LanguageChoicePage extends BasePage {
    @FindBy(css = ".button.select__button")
    private WebElement languageChoiceButton;
    @FindBy(css = "*[class='select__item'")
    private List<WebElement> availiableLanguages;
    @FindBy(css = ".form__save")
    private WebElement saveButton;

    private String neededLanguage = "English";
    private WebElement neededLanguageButton;



    /**
     * Click button to choose language
     */
    @Override
    public void clickChoiceLanguageButton() {
        languageChoiceButton.click();
    }

    /**
     * Check that English language is enabled
     * @return
     */
    public boolean isNeededLanguageEnabled() {
        for (WebElement item : availiableLanguages)
            if (neededLanguage.equals(item.getText())) {
                neededLanguageButton = Driver.getDriver().findElement(By.xpath(String.format("//contains(text(),%s", neededLanguage)));
                return true;
            }
        return false;
    }

    /**
     * Click English language
     */
    public void clickNeededLanguage() {
        neededLanguageButton.click();
    }

    /**
     * Click save button
     */
    public void clickSaveButton() {
        saveButton.click();
    }
}