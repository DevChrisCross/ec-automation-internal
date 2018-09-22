package com.elavon.constants;

public enum PageUrl {
    HOME("welcome"),
    LOGIN("login"),
    CONTACT_US("contactus"),
    TERMS_OF_USE("termsOfUseEu"),
    COOKIES_POLICY("cookiesPolicyEu");

    private final String url;

    PageUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
