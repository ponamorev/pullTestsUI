package com.andersenlab.ponamorev.pulltests.data;

public enum LanguagesData {
    ENGLISH("English"),
    RUSSIAN("Русский");

    private String language;

    LanguagesData(String lang) {
        language = lang;
    }

    public String getLanguage() {
        return language;
    }
}
