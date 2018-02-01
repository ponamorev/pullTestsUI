package com.andersenlab.ponamorev.pulltests.data;

public enum MessagesErrorData {
    LOGIN_ERROR("Такого аккаунта нет"),
    PASSWORD_ERROR("Неверный пароль");

    private String message;

    MessagesErrorData(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
