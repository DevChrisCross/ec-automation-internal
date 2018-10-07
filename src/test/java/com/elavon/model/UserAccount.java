package com.elavon.model;

import com.elavon.constants.user.UserLanguage;
import com.elavon.constants.user.UserRole;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.util.ArrayList;

public class UserAccount {

    private String firstName;
    private String lastName;
    private String email;
    private UserLanguage language;
    private UserRole role;
    private ArrayList<Location> locations;
    private static PropertiesConfiguration generate;

    public UserAccount(String firstName,
                       String lastName,
                       String email,
                       UserLanguage language,
                       UserRole role,
                       ArrayList<Location> locations) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.language = language;
        this.role = role;
        this.locations = locations;
    }

    public UserAccount() {
        generate = null;
        try {
            generate = new PropertiesConfiguration("generate.properties");
            firstName = generate.getString("user.base.first") + generate.getString("user.count");
            lastName = generate.getString("user.base.last");
            email = generate.getString("user.email");
            language = UserLanguage.ENGLISH;
            role = UserRole.MANAGER;
            locations = new ArrayList<>();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static void increaseUserCount() {
        generate = null;
        try {
            generate = new PropertiesConfiguration("generate.properties");
            int count = generate.getInt("user.count");
            generate.setProperty("user.count", ++count);
            generate.save();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public UserLanguage getLanguage() {
        return language;
    }

    public UserRole getRole() {
        return role;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLanguage(UserLanguage language) {
        this.language = language;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }
}
