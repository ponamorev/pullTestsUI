package com.andersenlab.ponamorev.pulltests.pages;

import com.andersenlab.ponamorev.pulltests.Driver;
import com.andersenlab.ponamorev.pulltests.data.LoginPasswordData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailPage extends BasePage {
    @FindBy(css = ".mail-User-Name")
    private WebElement userName;
    @FindBy(css = "*[data-metric='Выход']")
    private WebElement logoutButton;

    private String correctLogin = LoginPasswordData.VALID_VALUES.getLogin();



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
        init(Driver.getDriver());
        userName.click();
        logoutButton.click();
    }
}