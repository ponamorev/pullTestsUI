package com.andersenlab.ponamorev.pulltests.data;

public enum LoginPasswordData {
    BOTHVALIDVALUE("AutotestUser", "AutotestUser123"),
    INVALIDLOGIN("NoAutotestUser", "AutotestUser123"),
    INVALIDPASSWORD("AutotestUser", "NoAutotestUser123");

    private String login, password;

    LoginPasswordData(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}