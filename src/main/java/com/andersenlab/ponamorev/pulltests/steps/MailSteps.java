package com.andersenlab.ponamorev.pulltests.steps;

import com.andersenlab.ponamorev.pulltests.pages.MailPage;
import net.thucydides.core.annotations.Step;

import static org.junit.Assert.assertTrue;

public class MailSteps extends BaseSteps {

    private final MailPage mailPage = new MailPage();



    /**
     * Check that user name is correct
     */
    @Step("Иия вошедшего пользователя верно")
    public void userNameShouldBeCorrect() {
        assertTrue("Имя вошедшего пользователя не верно",
                mailPage.isUserNameCorrect());
    }

    /**
     * Log out from account
     */
    @Step("Выход из аккаунта")
    public void logout() {
        mailPage.clickLogoutButton();
    }
}