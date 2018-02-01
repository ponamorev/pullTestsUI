package com.andersenlab.ponamorev.pulltests.pages;

import com.andersenlab.ponamorev.pulltests.data.LoginPasswordData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailPage extends BasePage {
    @FindBy(className = "mail-User-Name")
    private WebElement userName;
    @FindBy(css = "*[data-metric='Выход']")
    private WebElement logoutButton;

    private String correctLogin = LoginPasswordData.BOTHVALIDVALUE.getLogin();



    /**
     * Check that actual user name is correct with expected
     * @return
     */
    public boolean isUserNameCorrect() {
        return correctLogin.equals(userName.getText());
    }

    /**
     * Click logout
     */
    public void clickLogoutButton() {
        logoutButton.click();
    }
}