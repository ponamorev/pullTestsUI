package com.andersenlab.ponamorev.pulltests;

import com.andersenlab.ponamorev.pulltests.data.LanguagesData;
import com.andersenlab.ponamorev.pulltests.data.LoginPasswordData;
import com.andersenlab.ponamorev.pulltests.steps.*;
import net.thucydides.core.annotations.Steps;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PullTest {
    @Steps
    static BaseSteps baseSteps = new BaseSteps();
    @Steps
    static GeoLocationSteps geoLocationSteps = new GeoLocationSteps();
    @Steps
    MailSteps mailSteps = new MailSteps();
    @Steps
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    @Steps
    LanguageChoiceSteps languageChoiceSteps = new LanguageChoiceSteps();
    @Steps
    VideoSteps videoSteps = new VideoSteps();
    @Steps
    ImagesSteps imagesSteps = new ImagesSteps();
    @Steps
    NewsSteps newsSteps = new NewsSteps();
    @Steps
    MapsSteps mapsSteps = new MapsSteps();
    @Steps
    MarketSteps marketSteps = new MarketSteps();
    @Steps
    TranslateSteps translateSteps = new TranslateSteps();
    @Steps
    MusicSteps musicSteps = new MusicSteps();

    @BeforeClass
    public static void beforeClass() {
        // Start initialisation
        Driver.getDriver().get("https://yandex.by");
        baseSteps.waitUntilPageLoaded();
        baseSteps.init();
        baseSteps.geoLocationShouldBeEnabled();
        try {

            // Check the city is correct
            baseSteps.cityShouldBeCorrect();
        } catch (Exception e) {

            // Set correct city
            baseSteps.clickGeoLink();
            geoLocationSteps.waitUntilPageLoaded();
            geoLocationSteps.init();
            geoLocationSteps.cityFieldShouldBeEnabled();
            geoLocationSteps.saveButtonShouldBeDisabled();
            geoLocationSteps.clearCityField();
            geoLocationSteps.enterNameCity("Минск");
            geoLocationSteps.clickTopElementFromCitiesropDownList();
        }
    }

    @Before
    public void before() {
        // Open start page every test
        Driver.getDriver().get("https://yandex.by");

        // Check that language is Russian
        baseSteps.waitUntilPageLoaded();
        baseSteps.clickChoiceLanguageButton();
        baseSteps.clickMoreLanguagesButton();
        languageChoiceSteps.waitUntilPageLoaded();
        try {
            languageChoiceSteps.currentLanguageShouldBeSameAs(LanguagesData.RUSSIAN);
            languageChoiceSteps.moveToStartPage();
        } catch (Exception e) {
            languageChoiceSteps.clickChoiceLanguageButton();
            languageChoiceSteps.nativeLanguageShouldBeEnabled();
            languageChoiceSteps.clickRussian();
            languageChoiceSteps.saveButtonShouldBeClickable();
            languageChoiceSteps.clickSaveButton();
        }
    }

    @Test
    public void first_test() {
        // Check that page is loaded
        baseSteps.waitUntilPageLoaded();

        // Check availability of fields and fill them
        baseSteps.loginFieldShouldBeEnabled();
        baseSteps.passwordFieldShouldBeEnabled();
        baseSteps.enterLoginAndPassword(LoginPasswordData.VALID_VALUES);

        // Check button to enter and click it
        baseSteps.enterButtonShouldBeEnabled();
        baseSteps.clickEnterButton();

        // Check that mail page is loaded and check that user name is correct
        mailSteps.waitUntilPageLoaded();
        mailSteps.init();
        mailSteps.userNameShouldBeCorrect();
    }

    @Test
    public void second_test() {
        // Check that page is loaded
        baseSteps.waitUntilPageLoaded();
        baseSteps.init();

        try {
            // Check that user no authorized
            baseSteps.userShouldBeAuthorized();
        } catch (Exception e) {
            // Logout
            baseSteps.clickMailButton();
            mailSteps.waitUntilPageLoaded();
            mailSteps.logout();
            baseSteps.waitUntilPageLoaded();
            baseSteps.userShouldBeNotAuthorized();
        }

        // Check availability of fields and fill them
        baseSteps.loginFieldShouldBeEnabled();
        baseSteps.passwordFieldShouldBeEnabled();
        baseSteps.enterLoginAndPassword(LoginPasswordData.VALID_VALUES);

        // Check button to enter and click it
        baseSteps.enterButtonShouldBeEnabled();
        baseSteps.clickEnterButton();
        mailSteps.waitUntilPageLoaded();
        mailSteps.init();

        // Click button to logout and check that it was done right
        mailSteps.logout();
        baseSteps.waitUntilPageLoaded();
        baseSteps.init();
        baseSteps.userShouldBeNotAuthorized();
    }

    @Test
    public void third_test() {
        // Check that page is loaded and fields for authorization is enabled
        baseSteps.waitUntilPageLoaded();
        baseSteps.loginFieldShouldBeEnabled();
        baseSteps.passwordFieldShouldBeEnabled();

        // Enter login and password and click submit
        baseSteps.enterLoginAndPassword(LoginPasswordData.INVALIDPASSWORD);
        baseSteps.enterButtonShouldBeEnabled();
        baseSteps.clickEnterButton();
        authorizationSteps.waitUntilPageLoaded();

        // Check that error message is displayed
        authorizationSteps.errorMessageShouldBeDisplayed();
        authorizationSteps.messageAboutInvalidPasswordShouldBeDisplayed();
    }

    @Test
    public void fourth_test() {
        // Check that page is loaded and fields for authorization is enabled
        baseSteps.waitUntilPageLoaded();
        baseSteps.loginFieldShouldBeEnabled();
        baseSteps.passwordFieldShouldBeEnabled();

        // Enter login and password and click submit
        baseSteps.enterLoginAndPassword(LoginPasswordData.INVALIDLOGIN);
        baseSteps.enterButtonShouldBeEnabled();
        baseSteps.clickEnterButton();
        authorizationSteps.waitUntilPageLoaded();

        // Check that error message is displayed
        authorizationSteps.errorMessageShouldBeDisplayed();
        authorizationSteps.messageAboutInvalidLoginShouldBeDisplayed();
    }

    @Test
    public void fifth_test() {
        // Check video page
        baseSteps.waitUntilPageLoaded();
        baseSteps.moveToVideo();
        videoSteps.waitUntilPageLoaded();
        videoSteps.moveToStartPage();

        // Check images page
        baseSteps.waitUntilPageLoaded();
        baseSteps.moveToImages();
        imagesSteps.waitUntilPageLoaded();
        imagesSteps.moveToStartPage();

        // Check news page
        baseSteps.waitUntilPageLoaded();
        baseSteps.moveToNews();
        newsSteps.waitUntilPageLoaded();
        newsSteps.moveToStartPage();

        // Check maps page
        baseSteps.waitUntilPageLoaded();
        baseSteps.moveToMaps();
        mapsSteps.waitUntilPageLoaded();
        mapsSteps.moveToStartPage();

        // Check market page
        baseSteps.waitUntilPageLoaded();
        baseSteps.moveToMarket();
        marketSteps.waitUntilPageLoaded();
        marketSteps.moveToStartPage();

        // Check translate page
        baseSteps.waitUntilPageLoaded();
        baseSteps.moveToTranslate();
        translateSteps.waitUntilPageLoaded();
        translateSteps.moveToStartPage();

        // Check music page
        baseSteps.waitUntilPageLoaded();
        baseSteps.moveToMusic();
        musicSteps.waitUntilPageLoaded();
        musicSteps.moveToStartPage();
    }

    @Test
    public void sixth_test() {
        // Check that start page is loaded and set geolocation anyways
        baseSteps.waitUntilPageLoaded();
        baseSteps.geoLocationShouldBeEnabled();
        baseSteps.clickGeoLink();
        geoLocationSteps.waitUntilPageLoaded();
        geoLocationSteps.init();
        geoLocationSteps.cityFieldShouldBeEnabled();
        geoLocationSteps.saveButtonShouldBeDisabled();
        geoLocationSteps.clearCityField();
        geoLocationSteps.enterNameCity("Минск");
        geoLocationSteps.clickTopElementFromCitiesropDownList();

        // Check that needed language is absentee
        baseSteps.waitUntilPageLoaded();
        baseSteps.clickChoiceLanguageButton();
        baseSteps.neededLanguageShouldBeNotEnabled();
        baseSteps.clickMoreLanguagesButton();

        // Choose needed language and save it
        languageChoiceSteps.waitUntilPageLoaded();
        languageChoiceSteps.clickChoiceLanguageButton();
        languageChoiceSteps.neededLanguageShouldBeEnabled();
        languageChoiceSteps.clickEnglish();
        languageChoiceSteps.saveButtonShouldBeClickable();
        languageChoiceSteps.clickSaveButton();

        // Check that language is not changed
        // BUG!!!
        baseSteps.waitUntilPageLoaded();
        baseSteps.chosenLanguageShouldBeNotCorrect();
    }

    @AfterClass
    public static void afterClass() {
        Driver.closeDriver();
    }
}