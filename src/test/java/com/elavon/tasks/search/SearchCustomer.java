package com.elavon.tasks.search;

import com.elavon.tasks.WaitUntilThe;
import com.elavon.ui.pages.CustomerSearchPage;
import com.elavon.ui.pages.InternalHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class SearchCustomer implements Task {

    private String input;
    private SearchBy by;
    private SearchFilter filter;
    private static final String WILDCARD = "%";

    public SearchCustomer(SearchBy by, SearchFilter filter, SearchMatch match, String input) {
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
//                WaitUntilThe.targetIsLoaded(InternalHomePage.CUSTOMER_SEARCH_TAB),
                Click.on(InternalHomePage.CUSTOMER_SEARCH_TAB),
                Click.on(CustomerSearchPage.SEARCH_FILTER_DROPDOWN),
                Click.on(filter.getOptionValue()),
                Enter.theValue(input).into(filter.getOptionField()),
                Click.on(CustomerSearchPage.APPLY_FILTER_BUTTON),
                Click.on(by.getTarget()),
                WaitUntilThe.pageIsFullyLoaded()
        );
    }
}
