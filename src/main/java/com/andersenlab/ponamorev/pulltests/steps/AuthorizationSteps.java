package com.andersenlab.ponamorev.pulltests.steps;

import com.andersenlab.ponamorev.pulltests.pages.AuthorizationPage;
import net.thucydides.core.annotations.Step;

import static org.junit.Assert.assertTrue;

public class AuthorizationSteps extends BaseSteps {

    private final AuthorizationPage authorizationPage = new AuthorizationPage();



    /**
     * Check that message about error of authorization is displayed
     */
    @Step("Сообщение об ошибке авторизации должно отображаться")
    public void errorMessageShouldBeDisplayed() {
        assertTrue("Сообщение об ошибке не отображается",
                authorizationPage.isErrorMessageDisplayed());
    }

    /**
     * Check that message about invalid password is displayed
     */
    @Step("Сообщение о неверном пароле отображается")
    public void messageAboutInvalidPasswordShouldBeDisplayed() {
        assertTrue("Сообщение о неверном пароле не отображается",
                authorizationPage.isMessageAboutInvalidPasswordDisplayed());
    }

    /**
     * Check that message about invalid login is displayed
     */
    @Step("Сообщение о несуществующем аккаунте отображается")
    public void messageAboutInvalidLoginShouldBeDisplayed() {
        assertTrue("Сообщение о несуществующем аккаунте не отображается",
                authorizationPage.isMessageAboutInvalidLoginDisplayed());
    }
}