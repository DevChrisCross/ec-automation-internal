package com.elavon.ui.pages;

import com.elavon.binder.DataBind;
import com.elavon.helper.LocatorCounter;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class CustomerSearchPage extends PageObject {

    public static DataBind<String, Target> bind;

    public static final Target ADD_CUSTOMERS_LINK = Target
            .the("add customer link")
            .located(By.xpath("//a[contains(., 'add customers')]"));

    public static final Target LOCATION_TAB_BUTTON = Target
            .the("location tab button")
            .located(By.id("userButton"));
    public static final Target USER_TAB_BUTTON = Target
            .the("location tab button")
            .located(By.id("locationButton"));

    public static final Target SEARCH_OPTIONS = Target
            .the("search options")
            .located(By.id("editFaqMenu"));
    public static final Target DOWNLOAD_RESULTS_OPTION = Target
            .the("download results option")
            .located(By.xpath("//button[@ng-click=\"intSearch.download()\"]"));

    public static final Target FIRST_ROW_SEARCH_RESULT = Target
            .the("first row search result")
            .located(By.xpath("//md-table-container/table/tbody/tr[1]"));

    public static class Filter {

        public static final Target DROPDOWN = Target
                .the("search filter dropdown")
                .located(By.id("selectedFilter"));
        public static final Target APPLY_BUTTON = Target
                .the("apply filter button")
                .located(By.id("submitFilter"));

        public static final Target GROUP_FIELD = Target
                .the("group field")
                .located(By.id("userChain"));
        public static final Target ENTITY_FIELD = Target
                .the("entity field")
                .located(By.id("userEntity"));
        public static final Target MCC_FIELD = Target
                .the("mcc field")
                .located(By.id("mcc"));
        public static final Target MERCHANT_ID_FIELD = Target
                .the("merchant id field")
                .located(By.id("externalMid"));
        public static final Target FIRST_NAME_FIELD = Target
                .the("first name field")
                .located(By.id("userFirstName"));
        public static final Target LAST_NAME_FIELD = Target
                .the("last name field")
                .located(By.id("userLastName"));
        public static final Target TAX_ID_FIELD = Target
                .the("tax id field")
                .located(By.id("taxId"));
        public static final Target EMAIL_FIELD = Target
                .the("email field")
                .located(By.id("userEmail"));
        public static final Target USER_ID_FIELD = Target
                .the("user id field")
                .located(By.id("searchUserId"));

        private static LocatorCounter dropdownOption = new LocatorCounter("//md-content/div/md-option[@COUNTER]");
        public static final Target GROUP_DROPDOWN_OPTION = Target
                .the("group dropdown option")
                .located(By.xpath(dropdownOption.valueOf(1)));
        public static final Target ENTITY_DROPDOWN_OPTION = Target
                .the("entity dropdown option")
                .located(By.xpath(dropdownOption.valueOf(2)));
        public static final Target MCC_DROPDOWN_OPTION = Target
                .the("mcc dropdown option")
                .located(By.xpath(dropdownOption.valueOf(3)));
        public static final Target MERCHANT_ID_DROPDOWN_OPTION = Target
                .the("merchant id dropdown option")
                .located(By.xpath(dropdownOption.valueOf(4)));
        public static final Target NAME_DROPDOWN_OPTION = Target
                .the("name dropdown option")
                .located(By.xpath(dropdownOption.valueOf(5)));
        public static final Target TAX_ID_DROPDOWN_OPTION = Target
                .the("tax id dropdown option")
                .located(By.xpath(dropdownOption.valueOf(6)));
        public static final Target EMAIL_DROPDOWN_OPTION = Target
                .the("email dropdown option")
                .located(By.xpath(dropdownOption.valueOf(7)));
        public static final Target USER_ID_DROPDOWN_OPTION = Target
                .the("user id dropdown option")
                .located(By.xpath(dropdownOption.valueOf(8)));
    }
}
