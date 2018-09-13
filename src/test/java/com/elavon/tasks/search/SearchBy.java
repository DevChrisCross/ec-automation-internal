package com.elavon.tasks.search;

import com.elavon.ui.pages.CustomerSearchPage;
import net.serenitybdd.screenplay.targets.Target;

public enum SearchBy {
    LOCATION(CustomerSearchPage.LOCATION_TAB_BUTTON),
    USER(CustomerSearchPage.USER_TAB_BUTTON);

    private Target target;

    SearchBy(Target target) {
        this.target = target;
    }

    public Target getTarget() {
        return target;
    }
}
