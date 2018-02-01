package com.andersenlab.ponamorev.pulltests;

import com.andersenlab.ponamorev.pulltests.data.LoginPasswordData;
import com.andersenlab.ponamorev.pulltests.steps.*;
import net.thucydides.core.annotations.Steps;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PullTest {
    @Steps
    private static BaseSteps baseSteps = new BaseSteps();
    @Steps
    private static GeoLocationSteps geoLocationSteps = new GeoLocationSteps();
    @Steps
    private MailSteps mailSteps = new MailSteps();
    @Steps
    private AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    @Steps
    private LanguageChoiceSteps languageChoiceSteps = new LanguageChoiceSteps();
    @Steps
    private VideoSteps videoSteps = new VideoSteps();
    @Steps
    private ImagesSteps imagesSteps = new ImagesSteps();
    @Steps
    private NewsSteps newsSteps = new NewsSteps();
    @Steps
    private MapsSteps mapsSteps = new MapsSteps();
    @Steps
    private MarketSteps marketSteps = new MarketSteps();
    @Steps
    private TranslateSteps translateSteps = new TranslateSteps();
    @Steps
    private MusicSteps musicSteps = new MusicSteps();

    @BeforeClass
    public static void beforeClass() {
        Driver.getDriver().get("https://yandex.by");
        baseSteps.waitUntilPageLoaded();
        baseSteps.geoLocationShouldBeEnabled();
        baseSteps.clickGeoLink();
        geoLocationSteps.cityFieldShouldBeEnabled();
        geoLocationSteps.saveButtonShouldBeDisabled();
        geoLocationSteps.clearCityField();
        geoLocationSteps.enterNameCity("Минск");
        geoLocationSteps.clickTopElementFromCitiesropDownList();
    }

    @Before
    public void before() {
        Driver.getDriver().get("https://yandex.by");
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
        mailSteps.userNameShouldBeCorrect();
    }

    @Test
    public void second_test() {
        // Check that page is loaded
        baseSteps.waitUntilPageLoaded();

        // Check availability of fields and fill them
        baseSteps.loginFieldShouldBeEnabled();
        baseSteps.passwordFieldShouldBeEnabled();
        baseSteps.enterLoginAndPassword(LoginPasswordData.VALID_VALUES);

        // Check button to enter and click it
        baseSteps.enterButtonShouldBeEnabled();
        baseSteps.clickEnterButton();
        mailSteps.waitUntilPageLoaded();

        // Click button to logout and check that it was done right
        mailSteps.logout();
        baseSteps.waitUntilPageLoaded();
        baseSteps.userShouldBeNotAuthorized();
    }

    @Test
    public void third_test() {
        baseSteps.waitUntilPageLoaded();
        baseSteps.loginFieldShouldBeEnabled();
        baseSteps.passwordFieldShouldBeEnabled();
        baseSteps.enterLoginAndPassword(LoginPasswordData.INVALIDPASSWORD);

        baseSteps.enterButtonShouldBeEnabled();
        baseSteps.clickEnterButton();
        authorizationSteps.waitUntilPageLoaded();

        authorizationSteps.errorMessageShouldBeDisplayed();
        authorizationSteps.messageAboutInvalidPasswordShouldBeDisplayed();
    }

    @Test
    public void fourth_test() {
        baseSteps.waitUntilPageLoaded();
        baseSteps.loginFieldShouldBeEnabled();
        baseSteps.passwordFieldShouldBeEnabled();
        baseSteps.enterLoginAndPassword(LoginPasswordData.INVALIDPASSWORD);

        baseSteps.enterButtonShouldBeEnabled();
        baseSteps.clickEnterButton();
        authorizationSteps.waitUntilPageLoaded();

        authorizationSteps.errorMessageShouldBeDisplayed();
        authorizationSteps.messageAboutInvalidLoginShouldBeDisplayed();
    }

    @Test
    public void fifth_test() {
        baseSteps.waitUntilPageLoaded();
        baseSteps.moveToVideo();
        videoSteps.waitUntilPageLoaded();
        videoSteps.moveToStartPage();

        baseSteps.waitUntilPageLoaded();
        baseSteps.moveToImages();
        imagesSteps.waitUntilPageLoaded();
        imagesSteps.moveToStartPage();

        baseSteps.waitUntilPageLoaded();
        baseSteps.moveToNews();
        newsSteps.waitUntilPageLoaded();
        newsSteps.moveToStartPage();

        baseSteps.waitUntilPageLoaded();
        baseSteps.moveToMaps();
        mapsSteps.waitUntilPageLoaded();
        mapsSteps.moveToStartPage();

        baseSteps.waitUntilPageLoaded();
        baseSteps.moveToMarket();
        marketSteps.waitUntilPageLoaded();
        marketSteps.moveToStartPage();

        baseSteps.waitUntilPageLoaded();
        baseSteps.moveToTranslate();
        translateSteps.waitUntilPageLoaded();
        translateSteps.moveToStartPage();

        baseSteps.waitUntilPageLoaded();
        baseSteps.moveToMusic();
        musicSteps.waitUntilPageLoaded();
        musicSteps.moveToStartPage();
    }

    /*@Test
    public void sixth_test() {
        baseSteps.waitUntilPageLoaded();
    }*/

    @AfterClass
    public static void afterClass() {
        Driver.closeDriver();
    }
}