package com.andersenlab.ponamorev.pulltests.pages;

import com.andersenlab.ponamorev.pulltests.data.MessagesErrorData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationPage extends BasePage {
    @FindBy(className = "passport-Domik-Form-Error")
    private WebElement messageAboutInvalidPasswordOrAccount;

    private String loginError = MessagesErrorData.LOGIN_ERROR.getMessage();
    private String passwordError = MessagesErrorData.PASSWORD_ERROR.getMessage();



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