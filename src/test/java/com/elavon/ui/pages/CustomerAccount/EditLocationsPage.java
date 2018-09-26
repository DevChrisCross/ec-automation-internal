package com.elavon.ui.pages.CustomerAccount;

import com.elavon.binder.BindMap;
import com.elavon.helper.LocatorCounter;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class EditLocationsPage extends PageObject {

    public static BindMap<String, Target> bind;

    private static LocatorCounter button = new LocatorCounter("/html/body/div[1]/span/md-content/" +
            "md-content/div/div/button[@COUNTER]");
    public static final Target CANCEL_BUTTON = Target
            .the("cancel button")
            .located(By.xpath(button.valueOf(1)));
    public static final Target UPDATE_BUTTON = Target
            .the("update button")
            .located(By.xpath(button.valueOf(2)));

    public static class Location {

        private static String s = "/html/body/div[1]/span/md-content/md-content/div/" +
                "md-card[2]/md-card-content/accesscriteriaselector/div[1]/md-list-item[@COUNTER]/md-autocomplete/" +
                "md-autocomplete-wrap/";
        public static final Target RULE_CLOSE_BUTTON = Target
                .the("rule field close button")
                .located(By.xpath(s.replace("@COUNTER", "1") + "button"));

        private static LocatorCounter location = new LocatorCounter(s + "input");
        public static final Target RULE_FIELD = Target
                .the("location rule field")
                .located(By.xpath(location.valueOf(1)));
        public static final Target CLG_GROUP_FIELD = Target
                .the("location clg group")
                .located(By.xpath(location.valueOf(2)));
        public static final Target VALUE_FIELD = Target
                .the("location value field")
                .located(By.xpath(location.valueOf(3)));

        private static LocatorCounter rule = new LocatorCounter("/html/body/md-virtual-repeat-container[1]/" +
                "div/div[2]/ul/li[@COUNTER]");
        public static final Target RULE_MID_OPTION = Target
                .the("rule mid option")
                .located(By.xpath(rule.valueOf(1)));
        public static final Target RULE_CHAIN_OPTION = Target
                .the("rule chain option")
                .located(By.xpath(rule.valueOf(2)));
        public static final Target RULE_ENTITY_OPTION = Target
                .the("rule entity option")
                .located(By.xpath(rule.valueOf(3)));

        private static LocatorCounter firstOption = new LocatorCounter("/html/body/" +
                "md-virtual-repeat-container[@COUNTER]/div/div[2]/ul/li");
        public static final Target CLG_FIRST_OPTION = Target
                .the("clg first option")
                .located(By.xpath(firstOption.valueOf(2)));
        public static final Target VALUE_FIRST_OPTION = Target
                .the("value first option")
                .located(By.xpath(firstOption.valueOf(3)));
    }
}
