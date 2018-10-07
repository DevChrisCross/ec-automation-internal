package com.elavon.model;

import com.elavon.constants.user.UserLocationRule;

public class Location {

    private UserLocationRule rule;
    private String clg;
    private String value;

    public Location(UserLocationRule rule, String clg, String value) {
        this.rule = rule;
        this.clg = clg;
        this.value = value;
    }

    public UserLocationRule getRule() {
        return rule;
    }

    public String getClg() {
        return clg;
    }

    public String getValue() {
        return value;
    }
}
