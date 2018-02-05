package com.andersenlab.ponamorev.pulltests.steps;

import com.andersenlab.ponamorev.pulltests.Driver;
import com.andersenlab.ponamorev.pulltests.data.LanguagesData;
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
     * Page initialisation
     */
    @Override
    @Step
    public void init() {
        languageChoicePage.init(Driver.getDriver());
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
     * Check that English language is enabled
     */
    @Step("Проверяется, что <Русский> присутствует в списке")
    public void nativeLanguageShouldBeEnabled() {
        assertTrue("<Русский> не присутствует в списке",
                languageChoicePage.isNativeLanguageEnabled());
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

    /**
     * Click Russian language
     */
    @Step("Нажимается <Русский>")
    public void clickRussian() {
        languageChoicePage.clickNativeLanguage();
    }

    /**
     * Check that save button is clickable
     */
    @Step("Проверяется, что кнопка <Сохранить> доступна для нажатия")
    public void saveButtonShouldBeClickable() {
        assertTrue("Кнопка <Сохранить> не доступна для нажатия",
                languageChoicePage.isSaveButtonClickable());
    }

    /**
     * Check that current language is {0}
     * @param expectedLanguage
     * @throws Exception
     */
    @Step("Проверяется, что текущий язык <{0}>")
    public void currentLanguageShouldBeSameAs(LanguagesData expectedLanguage) throws Exception {
        if (!languageChoicePage.getCurrentLanguage().equals(expectedLanguage.getLanguage()))
            throw new Exception();
    }

    /**
     * Return to start page
     */
    @Override
    @Step("Нажимается лого для возврата на начальную страницу")
    public void moveToStartPage() {
        languageChoicePage.returnToStartPage();
    }
}