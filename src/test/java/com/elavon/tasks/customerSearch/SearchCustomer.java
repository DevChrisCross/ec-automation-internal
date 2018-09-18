package com.elavon.tasks.customerSearch;

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
import net.serenitybdd.screenplay.targets.Target;

import java.util.Map;

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
        Map<String, Target> searchFilter = SearchFilter.bindMap.get(CustomerSearchPage.class).get(filter);
        Map<String, Target> searchBy = SearchBy.bindMap.get(CustomerSearchPage.class).get(by);

        actor.attemptsTo(
                ClickOn.the(InternalHomePage.CUSTOMER_SEARCH_TAB),
                Click.on(CustomerSearchPage.SEARCH_FILTER_DROPDOWN),
                Click.on(searchFilter.get("option")),
                Enter.theValue(input).into(searchFilter.get("field")),
                Click.on(CustomerSearchPage.APPLY_FILTER_BUTTON),
                ClickOn.the(searchBy.get("target"))
        );
    }
}
