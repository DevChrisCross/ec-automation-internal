package com.elavon.ui.pages.CustomerAccount;

import com.elavon.binder.BindMap;
import com.elavon.helper.LocatorCounter;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CloneCustomerPage extends EditCustomerProfilePage {

    public static BindMap<String, Target> bind;

    public static final Target NEXT_BUTTON = Target
            .the("next button")
            .located(By.xpath("/html/body/div[1]/span/md-content/md-content/div/form/md-card[2]/md-card-content/" +
                    "md-card-actions/button[2]"));

    public static class Language {

        private static LocatorCounter languageOption = new LocatorCounter("/html/body/div[4]/md-select-menu" +
                "/md-content/md-option[@COUNTER]");
        public static final Target DEUTSCH_OPTION = Target
                .the("deutsch option")
                .located(By.xpath(languageOption.valueOf(1)));
        public static final Target ENGLISH_OPTION = Target
                .the("english option")
                .located(By.xpath(languageOption.valueOf(2)));
        public static final Target ESPANOL_OPTION = Target
                .the("espanol option")
                .located(By.xpath(languageOption.valueOf(3)));
        public static final Target FRANCAIS_OPTION = Target
                .the("francais option")
                .located(By.xpath(languageOption.valueOf(4)));
        public static final Target ITALIANO_OPTION = Target
                .the("italiano option")
                .located(By.xpath(languageOption.valueOf(5)));
        public static final Target NEDERLANDS_OPTION = Target
                .the("nederlands option")
                .located(By.xpath(languageOption.valueOf(6)));
        public static final Target NORSK_OPTION = Target
                .the("norsk option")
                .located(By.xpath(languageOption.valueOf(7)));
        public static final Target POLSKI_OPTION = Target
                .the("polski option")
                .located(By.xpath(languageOption.valueOf(8)));
    }

    public static class Role {

        private static LocatorCounter roleOption = new LocatorCounter("/html/body/div[1]/span/md-content/" +
                "md-content/div/form/md-card[2]/md-card-content/div[2]/div/md-radio-group/div[1]/md-radio-button/" +
                "div[1]/div[@COUNTER]");
        public static final Target EMPLOYEE_RADIO_BUTTON = Target
                .the("employee radio button")
                .located(By.xpath(roleOption.valueOf(2)));
        public static final Target MANAGER_RADIO_BUTTON = Target
                .the("manager radio button")
                .located(By.xpath(roleOption.valueOf(1)));
    }

}
