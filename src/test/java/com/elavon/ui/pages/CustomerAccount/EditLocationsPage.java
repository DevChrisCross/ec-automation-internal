package com.elavon.ui.pages.CustomerAccount;

import com.elavon.binder.DataBind;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class EditLocationsPage extends PageObject {

    public static DataBind<String, Target> bind;

    public static final Target ACTION_BUTTON = Target
            .the("action button")
            .locatedBy("//md-content/div/div/button[{0}]");

    public static class Location {

        public static final Target REMOVE_LOCATION_BUTTON = Target
                .the("remove location button")
                .locatedBy("//md-list/md-list-item[contains(.,\"{0}\")]/div[5]");

        public static final Target LOCATION_INPUT = Target
                .the("location input")
                .locatedBy("//accesscriteriaselector/div[1]/md-list-item[{0}]" +
                        "/md-autocomplete/md-autocomplete-wrap/{1}");

        public static final Target RULE_CLOSE_BUTTON = LOCATION_INPUT.of("1", "button").called("rule field close button");
        public static final Target CLG_CLOSE_BUTTON = LOCATION_INPUT.of("2", "button").called("clg field close button");
        public static final Target VALUE_CLOSE_BUTTON = LOCATION_INPUT.of("3", "button").called("value field close button");

        public static final Target RULE_FIELD = LOCATION_INPUT.of("1", "input").called("location rule field");
        public static final Target CLG_GROUP_FIELD = LOCATION_INPUT.of("2", "input").called("location clg group");
        public static final Target VALUE_FIELD = LOCATION_INPUT.of("3", "input").called("location value field");

        public static final Target RULE_OPTION = Target
                .the("rule option")
                .locatedBy("//md-virtual-repeat-container[1]/div/div[2]/ul/li[{0}]");
        public static final Target RULE_MID_OPTION = RULE_OPTION.of("1").called("rule mid option");
        public static final Target RULE_CHAIN_OPTION =RULE_OPTION.of("2").called("rule chain option");
        public static final Target RULE_ENTITY_OPTION = RULE_OPTION.of("3").called("rule entity option");

        public static final Target FIRST_OPTION = Target
                .the("first option")
                .locatedBy("//md-virtual-repeat-container[{0}]/div/div[2]/ul/li[1]");
        public static final Target CLG_FIRST_OPTION = FIRST_OPTION.of("2").called("first option of clg");
        public static final Target VALUE_FIRST_OPTION = FIRST_OPTION.of("3").called("first option of value");
    }
}
