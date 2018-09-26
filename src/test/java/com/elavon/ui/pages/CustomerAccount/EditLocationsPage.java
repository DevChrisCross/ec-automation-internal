package com.elavon.ui.pages.CustomerAccount;

import com.elavon.binder.BindMap;
import com.elavon.helper.LocatorGenerator;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class EditLocationsPage extends PageObject {

    public static BindMap<String, Target> bind;
    private static LocatorGenerator button = new LocatorGenerator("/html/body/div[1]/span/md-content/" +
            "md-content/div/div/button[@COUNTER]");
    public static final Target CANCEL_BUTTON = Target
            .the("cancel button")
            .located(By.xpath(button.generate(1)));
    public static final Target UPDATE_BUTTON = Target
            .the("update button")
            .located(By.xpath(button.generate(2)));

    public static class Location {

        private static String s = "/html/body/div[1]/span/md-content/md-content/div/" +
                "md-card[2]/md-card-content/accesscriteriaselector/div[1]/md-list-item[@COUNTER]/md-autocomplete/" +
                "md-autocomplete-wrap/";
        public static final Target RULE_CLOSE_BUTTON = Target
                .the("rule field close button")
                .located(By.xpath(s.replace("@COUNTER", "1") + "button"));
        private static LocatorGenerator location = new LocatorGenerator(s + "input");
        public static final Target RULE_FIELD = Target
                .the("location rule field")
                .located(By.xpath(location.generate(1)));
        public static final Target CLG_GROUP_FIELD = Target
                .the("location clg group")
                .located(By.xpath(location.generate(2)));
        public static final Target VALUE_FIELD = Target
                .the("location value field")
                .located(By.xpath(location.generate(3)));
        private static LocatorGenerator rule = new LocatorGenerator("/html/body/md-virtual-repeat-container[1]/" +
                "div/div[2]/ul/li[@COUNTER]");
        public static final Target RULE_MID_OPTION = Target
                .the("rule mid option")
                .located(By.xpath(rule.generate(1)));
        public static final Target RULE_CHAIN_OPTION = Target
                .the("rule chain option")
                .located(By.xpath(rule.generate(2)));
        public static final Target RULE_ENTITY_OPTION = Target
                .the("rule entity option")
                .located(By.xpath(rule.generate(3)));
        private static LocatorGenerator firstOption = new LocatorGenerator("/html/body/" +
                "md-virtual-repeat-container[@COUNTER]/div/div[2]/ul/li");
        public static final Target CLG_FIRST_OPTION = Target
                .the("clg first option")
                .located(By.xpath(firstOption.generate(2)));
        public static final Target VALUE_FIRST_OPTION = Target
                .the("value first option")
                .located(By.xpath(firstOption.generate(3)));
    }
}
