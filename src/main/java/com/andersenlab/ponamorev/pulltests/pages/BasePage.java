package com.andersenlab.ponamorev.pulltests.pages;

import com.andersenlab.ponamorev.pulltests.Driver;
import com.andersenlab.ponamorev.pulltests.data.LoginPasswordData;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    @FindBy(css = "input[name='login']")
    private WebElement loginField;
    @FindBy(css = "input[name='passwd']")
    private WebElement passwordField;
    @FindBy(css = ".button.auth__button")
    private WebElement enterButton;
    @FindBy(css = "*[data-id='video']")
    private WebElement toVideoPage;
    @FindBy(css = "*[data-id='images'")
    private WebElement toImagesPage;
    @FindBy(css = "*[data-id='news'")
    private WebElement toNewsPage;
    @FindBy(css = "*[data-id='maps'")
    private WebElement toMapsPage;
    @FindBy(css = "*[data-id='market'")
    private WebElement toMarketPage;
    @FindBy(css = "*[data-id='translate'")
    private WebElement toTranslatePage;
    @FindBy(css = "*[data-id='music'")
    private WebElement toMusicPage;
    @FindBy(css = "*[title='Выбрать язык']")
    private WebElement choiceLanguageButton;
    @FindBy(className = "b-langs__text")
    private List<WebElement> availiableLanguages;
    @FindBy(css = "*[data-statlog='head.lang.more']")
    private WebElement moreLanguageButton;
    @FindBy(css = ".username.desk-notif-card__user-name")
    private WebElement userNameTitle;
    @FindBy(css = ".logo.logo_type_link")
    private WebElement logoButton;
    @FindBy(className = "geolink__reg")
    private WebElement geoLink;
    @FindBy(css = "*[title='Выбрать язык'] .link__inner")
    private WebElement actualLanguage;

    private String correctGeoLocation = "Минск";
    private String neededLanguage = "Eng";



    /**
     * Check that page is loaded
     */
    public void wailUntilPageLoaded() {
        ExpectedCondition<Boolean> pageReadyStateInCompleted = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            new WebDriverWait(Driver.getDriver(), 5).until(pageReadyStateInCompleted);
        } catch (Exception e) {
            System.err.println(String.format("Страница \"%s\" не загружена", Driver.getDriver().getTitle()));
        }
        init(Driver.getDriver());
    }

    /**
     * Initialisation of all elements from this page
     * @param driver
     */
    private void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /**
     * Check that login field is enabled
     * @return
     */
    public boolean isLoginFieldEnabled() {
        return loginField.isEnabled();
    }

    /**
     * Check that password field is enabled
     * @return
     */
    public boolean isPasswordFieldEnabled() {
        return passwordField.isEnabled();
    }

    /**
     * Enter login and password
     * @param values
     */
    public void enterLoginAndPassword(LoginPasswordData values) {
        loginField.sendKeys(values.getLogin());
        passwordField.sendKeys(values.getPassword());
    }

    /**
     * Check that enter button is enabled
     * @return
     */
    public boolean isEnterButtonEnabled() {
        return enterButton.isEnabled();
    }

    /**
     * Click enter button
     */
    public void clickEnterButton() {
        enterButton.click();
    }

    /**
     * Move to video page
     */
    public void clickToVideoPage() {
        toVideoPage.click();
    }

    /**
     * Move to images page
     */
    public void clickToImagesPage() {
        toImagesPage.click();
    }

    /**
     * Move to news page
     */
    public void clickToNewsPage() {
        toNewsPage.click();
    }

    /**
     * Move to maps page
     */
    public void clickToMapsPage() {
        toMapsPage.click();
    }

    /**
     * Move to video page
     */
    public void clickToMarketPage() {
        toMarketPage.click();
    }

    /**
     * Move to video page
     */
    public void clickToTranslatePage() {
        toTranslatePage.click();
    }

    /**
     * Move to video page
     */
    public void clickToMusicPage() {
        toMusicPage.click();
    }

    /**
     * Check that user is authorized
     * @return
     */
    public boolean isUserAuthorized() {
        try {
            userNameTitle.isDisplayed();
            return true;
        } catch (Exception e) {
            System.err.println("User is not authorized");
            return false;
        }
    }

    /**
     * Return to start page
     */
    public void returnToStartPage() {
        logoButton.click();
    }

    /**
     * Check that geolocation is corrected
     * @return
     */
    public boolean isGeoLocationCorrected() {
        return correctGeoLocation.equals(geoLink.getText());
    }

    /**
     * Click button to choose language
     */
    public void clickChoiceLanguageButton() {
        choiceLanguageButton.click();
    }

    /**
     * Check that needed language is enabled in the list
     * @return
     */
    public boolean isNeededLanguageEnabled() {
        for (WebElement item : availiableLanguages)
            if (neededLanguage.equals(item.getText()))
                return true;
        return false;
    }

    /**
     * Click more language button
     */
    public void clickMoreLanguageButton() {
        moreLanguageButton.click();
    }

    /**
     * Check that actual language is not corrected
     * @return
     */
    public boolean isChosenLanguageNotCorrected() {
        return !neededLanguage.equals(actualLanguage.getText());
    }
}