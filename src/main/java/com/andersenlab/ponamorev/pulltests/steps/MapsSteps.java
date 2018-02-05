package com.andersenlab.ponamorev.pulltests.steps;

import com.andersenlab.ponamorev.pulltests.pages.MapsPage;
import net.thucydides.core.annotations.Step;

public class MapsSteps extends BaseSteps {

    private final MapsPage mapsPage = new MapsPage();

    /**
     * Return to start page
     */
    @Override
    @Step("Нажимается лого и перемещение на начальную страницу")
    public void moveToStartPage() {
        mapsPage.returnToStartPage();
    }
}