package com.andersenlab.ponamorev.pulltests.steps;

import com.andersenlab.ponamorev.pulltests.pages.LanguageChoicePage;
import net.thucydides.core.annotations.Step;

import static org.junit.Assert.assertTrue;

public class LanguageChoiceSteps extends BaseSteps {

    private final LanguageChoicePage languageChoicePage = new LanguageChoicePage();



    /**
     * Click button to choose language
     */
    @Step("Нажимается меню выбора языка")
    public void clickChoiceLanguageButton() {
        languageChoicePage.clickChoiceLanguageButton();
    }

    /**
     * Check that English language is enabled
     */
    @Step("Проверяется, что <English> присутствует в списке")
    public void neededLanguageShouldBeEnabled() {
        assertTrue("<English> не присутствует в списке",
                languageChoicePage.isNeededLanguageEnabled());
    }

    /**
     * Click English language
     */
    @Step("Нажимается <English>")
    public void clickEnglish() {
        languageChoicePage.clickNeededLanguage();
    }

    /**
     * Click save button
     */
    @Step("Нажимается кнопка <Сохранить>")
    public void clickSaveButton() {
        languageChoicePage.clickSaveButton();
    }
}