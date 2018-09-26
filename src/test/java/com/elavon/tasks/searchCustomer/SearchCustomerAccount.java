package com.elavon.tasks.searchCustomer;

import com.elavon.constants.SearchBy;
import com.elavon.constants.SearchFilter;
import com.elavon.constants.SearchMatch;
import com.elavon.interactions.ClickOn;
import com.elavon.ui.pages.CustomerSearchPage;
import com.elavon.ui.pages.InternalHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class SearchCustomerAccount implements Task {

    private String input;
    private SearchBy by;
    private SearchFilter filter;
    private static final String WILDCARD = "%";

    public SearchCustomerAccount(SearchBy by, SearchFilter filter, SearchMatch match, String input) {
        if (match.equals(SearchMatch.STARTS_WITH)) { input += WILDCARD; }
        if (match.equals(SearchMatch.ENDS_WITH)) { input = WILDCARD + input; }
        if (match.equals(SearchMatch.CONTAINS)) { input = WILDCARD + input + WILDCARD; }

        this.input = input;
        this.filter = filter;
        this.by = by;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOn.the(InternalHomePage.CUSTOMER_SEARCH_TAB),
                Click.on(CustomerSearchPage.Filter.DROPDOWN),
                Click.on(CustomerSearchPage.bind.get(filter).get("option")),
                Enter.theValue(input).into(CustomerSearchPage.bind.get(filter).get("field")),
                Click.on(CustomerSearchPage.Filter.APPLY_BUTTON),
                ClickOn.the(CustomerSearchPage.bind.get(by).get("target"))
        );
    }
}
