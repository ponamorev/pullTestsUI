package com.andersenlab.ponamorev.pulltests.steps;

import com.andersenlab.ponamorev.pulltests.pages.GeoLocationPage;
import net.thucydides.core.annotations.Step;

import static org.junit.Assert.assertTrue;

public class GeoLocationSteps extends BaseSteps {

    private final GeoLocationPage geoLocationPage = new GeoLocationPage();



    /**
     * Check that field for city is enabled
     */
    @Step("Проверяется, что поле для ввода города доступно")
    public void cityFieldShouldBeEnabled() {
        assertTrue("Поле для ввода города не доступно",
                geoLocationPage.isCityFieldEnabled());
    }

    /**
     * Check that save button is disabled
     */
    @Step("Проверяется, что кнопка <Сохранить> не доступна")
    public void saveButtonShouldBeDisabled() {
        assertTrue("Кнопка <Сохранить> доступна",
                geoLocationPage.isSaveButtonDisabled());
    }

    /**
     * Clear field for city
     */
    @Step("Очищается поле для ввода города")
    public void clearCityField() {
        geoLocationPage.clearCityField();
    }

    /**
     * Enter city in field
     * @param city
     */
    @Step("Вводится название города")
    public void enterNameCity(String city) {
        geoLocationPage.enterCity(city);
    }

    /**
     * Click top element from drop down list after entering the city
     */
    @Step("Нажимается первый элемент в выпадающем списке городов")
    public void clickTopElementFromCitiesropDownList() {
        geoLocationPage.clickTopElementFromCitiesDropDownList();
    }
}
