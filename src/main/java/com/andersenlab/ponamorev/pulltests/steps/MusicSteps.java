package com.andersenlab.ponamorev.pulltests.steps;

import com.andersenlab.ponamorev.pulltests.pages.MusicPage;
import net.thucydides.core.annotations.Step;

public class MusicSteps extends BaseSteps {

    private final MusicPage musicPage = new MusicPage();

    /**
     * Return to start page
     */
    @Override
    @Step("Нажимается лого и открывается начальная страница")
    public void moveToStartPage() {
        musicPage.returnToStartPage();
    }
}