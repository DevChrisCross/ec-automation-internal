package com.elavon.ui.pages;

import com.elavon.helper.LocatorGenerator;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CloneUserProfilePage {

    public static class Location {

        private static LocatorGenerator location = new LocatorGenerator("/html/body/div[1]/span/md-content/md-content/div/" +
                "md-card[2]/md-card-content/accesscriteriaselector/div[1]/md-list-item[@COUNTER]/md-autocomplete/" +
                "md-autocomplete-wrap/input");

        public static final Target LOCATION_RULE_FIELD = Target
                .the("location rule field")
                .located(By.xpath(location.generate(1)));
        public static final Target LOCATION_CLG_GROUP_FIELD = Target
                .the("location clg group")
                .located(By.xpath(location.generate(1)));
        public static final Target LOCATION_VALUE_FIELD = Target
                .the("location value field")
                .located(By.xpath(location.generate(1)));
    }
}
