package com.elavon.helper;

public class LocatorCounter {

    public static final String delimeter = "@COUNTER";
    private final String xpath;

    public LocatorCounter(String xpath) {
        this.xpath = xpath;
    }

    public String valueOf(int count) {
        return xpath.replaceAll(delimeter, Integer.toString(count));
    }

    public String getXpath() {
        return xpath;
    }
}
