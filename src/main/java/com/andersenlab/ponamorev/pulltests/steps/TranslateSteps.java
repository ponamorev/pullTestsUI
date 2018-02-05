package com.andersenlab.ponamorev.pulltests.steps;

import com.andersenlab.ponamorev.pulltests.pages.TranslatePage;
import net.thucydides.core.annotations.Step;

public class TranslateSteps extends BaseSteps {

    private final TranslatePage translatePage = new TranslatePage();

    @Override
    @Step("Нажимается лого для возрата на начальную страницу")
    public void moveToStartPage() {
        translatePage.returnToStartPage();
    }
}