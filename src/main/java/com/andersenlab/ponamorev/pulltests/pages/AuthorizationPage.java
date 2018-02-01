package com.andersenlab.ponamorev.pulltests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationPage extends BasePage {
    @FindBy(className = "passport-Domik-Form-Error")
    private WebElement messageAboutInvalidPasswordOrAccount;

    private String loginError = "Такого аккаунта нет";
    private String passwordError = "Неверный пароль";



    /**
     * Check that message about error is displayed
     * @return
     */
    public boolean isErrorMessageDisplayed() {
        return messageAboutInvalidPasswordOrAccount.isDisplayed();
    }

    /**
     * Check that message error contains login error
     */
    public boolean isMessageAboutInvalidLoginDisplayed() {
        return loginError.equals(messageAboutInvalidPasswordOrAccount.getText());
    }

    /**
     * Check that message error contains password error
     */
    public boolean isMessageAboutInvalidPasswordDisplayed() {
        return passwordError.equals(messageAboutInvalidPasswordOrAccount.getText());
    }
}