package com.elavon.tasks;

import com.elavon.ui.pages.CustomerSearchPage;
import net.serenitybdd.screenplay.targets.Target;

public enum SearchFilter {
    GROUP(CustomerSearchPage.GROUP_DROPDOWN_OPTION,         CustomerSearchPage.GROUP_FIELD),
    ENTITY(CustomerSearchPage.ENTITY_DROPDOWN_OPTION,       CustomerSearchPage.ENTITY_FIELD),
    MCC(CustomerSearchPage.MCC_DROPDOWN_OPTION,             CustomerSearchPage.MCC_FIELD),
    MERCHANT_ID(CustomerSearchPage.MERCHANT_DROPDOWN_OPTION, CustomerSearchPage.MERCHANT_ID_FIELD),
    FIRST_NAME(CustomerSearchPage.NAME_DROPDOWN_OPTION,     CustomerSearchPage.FIRST_NAME_FIELD),
    LAST_NAME(CustomerSearchPage.NAME_DROPDOWN_OPTION,      CustomerSearchPage.LAST_NAME_FIELD),
    TAX_ID(CustomerSearchPage.TAX_ID_DROPDOWN_OPTION,       CustomerSearchPage.TAX_ID_FIELD),
    EMAIL(CustomerSearchPage.EMAIL_DROPDOWN_OPTION,         CustomerSearchPage.EMAIL_FIELD),
    USER_ID(CustomerSearchPage.USER_ID_DROPDOWN_OPTION,     CustomerSearchPage.USER_ID_FIELD);

    private Target optionValue;
    private Target optionField;

    SearchFilter(Target optionValue, Target optionField) {
        this.optionValue = optionValue;
        this.optionField = optionField;
    }

    public Target getOptionValue() {
        return optionValue;
    }

    public Target getOptionField() {
        return optionField;
    }
}
