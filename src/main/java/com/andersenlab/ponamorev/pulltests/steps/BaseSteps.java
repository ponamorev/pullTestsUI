package com.andersenlab.ponamorev.pulltests.steps;

import com.andersenlab.ponamorev.pulltests.data.LoginPasswordData;
import com.andersenlab.ponamorev.pulltests.pages.BasePage;
import net.thucydides.core.annotations.Step;

import static org.junit.Assert.assertTrue;

public class BaseSteps {

    private final BasePage basePage = new BasePage();



    /**
     * Wait until page is loading
     */
    @Step("Ожидается загрузка страницы")
    public void waitUntilPageLoaded() {
        basePage.wailUntilPageLoaded();
    }

    /**
     * Check that login field is enabled
     */
    @Step("Поле ввода логина должно быть доступно")
    public void loginFieldShouldBeEnabled() {
        assertTrue("Поле ввода логина не доступно",
                basePage.isLoginFieldEnabled());
    }

    /**
     * Check that password field is enabled
     */
    @Step("Поле ввода пароля должно быть доступно")
    public void passwordFieldShouldBeEnabled() {
        assertTrue("Поле ввода пароля не доступно",
                basePage.isPasswordFieldEnabled());
    }

    /**
     * Enter login and password
     * @param values
     */
    @Step("Вводятся логин и пароль от почты")
    public void enterLoginAndPassword(LoginPasswordData values) {
        basePage.enterLoginAndPassword(values);
    }

    /**
     * Check that enter button is enabled
     */
    @Step("Кнопка <Войти> должна быть доступна")
    public void enterButtonShouldBeEnabled() {
        assertTrue("Кнопка <Войти> не доступна",
                basePage.isEnterButtonEnabled());
    }

    /**
     * Click enter button
     */
    @Step("Нажимается кнопка <Войти>")
    public void clickEnterButton() {
        basePage.clickEnterButton();
    }

    /**
     * Move to video page
     */
    @Step("Переход на вкладку <Видео>")
    public void moveToVideo() {
        basePage.clickToVideoPage();
    }

    /**
     * Move to images page
     */
    @Step("Переход на вкладку <Картинки>")
    public void moveToImages() {
        basePage.clickToImagesPage();
    }

    /**
     * Move to news page
     */
    @Step("Переход на вкладку <Новости>")
    public void moveToNews() {
        basePage.clickToNewsPage();
    }

    /**
     * Move to maps page
     */
    @Step("Переход на вкладку <Карты>")
    public void moveToMaps() {
        basePage.clickToMapsPage();
    }

    /**
     * Move to market page
     */
    @Step("Переход на вкладку <Маркет>")
    public void moveToMarket() {
        basePage.clickToMarketPage();
    }

    /**
     * Move to translate page
     */
    @Step("Переход на вкладку <Переводчик>")
    public void moveToTranslate() {
        basePage.clickToTranslatePage();
    }

    /**
     * Move to music page
     */
    @Step("Переход на вкладку <Музыка>")
    public void moveToMusic() {
        basePage.clickToMusicPage();
    }

    /**
     * Check that user is not authorized
     */
    @Step("Пользователь не авторизован")
    public void userShouldBeNotAuthorized() {
        assertTrue("Пользователь авторизован",
                basePage.isUserNotAuthorized());
    }

    /**
     * Come back to start page
     */
    @Step("Возврат на начальную страницу")
    public void moveToStartPage() {
        basePage.returnToStartPage();
    }

    /**
     * Check that geolocation is correct
     */
    @Step("Местоположение должно быть в Минске")
    public void geoLocationShouldBeCorrect() {
        assertTrue("Местоположение не в Минске",
                basePage.isGeoLocationCorrected());
    }

    /**
     * Click choice language button
     */
    @Step("Нажимается кнопка выбора языка")
    public void clickChoiceLanguageButton() {
        basePage.clickChoiceLanguageButton();
    }

    /**
     * Check that needed values is not enabled
     */
    @Step("Проверяется, что нужное значение не доступно")
    public void neededLanguageShouldBeNotEnabled() {
        assertTrue("Нужный язык доступен",
                !basePage.isNeededLanguageEnabled());
    }

    /**
     * Click more languages button
     */
    @Step("Нажимается кнопка <ещё> для выбора языка")
    public void clickMoreLanguagesButton() {
        basePage.clickMoreLanguagesButton();
    }

    /**
     * Check that language is not correct
     */
    @Step("Выбранный язык не совпадает с действительным")
    public void chosenLanguageShouldBeNotCorrect() {
        assertTrue("Выбранный язык совпадает с действительным",
                basePage.isChosenLanguageNotCorrected());
    }
}