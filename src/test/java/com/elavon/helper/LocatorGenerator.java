package com.elavon.helper;

public class LocatorGenerator {

    public static final String delimeter = "@COUNTER";
    private String xpath;

    public LocatorGenerator(String xpath) {
        this.xpath = xpath;
    }

    public String generate(int count) {
        return xpath.replaceAll(delimeter, Integer.toString(count));
    }
}
