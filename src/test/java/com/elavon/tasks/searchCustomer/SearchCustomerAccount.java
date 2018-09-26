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
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

import java.util.Map;

public class SearchCustomerAccount implements Task {

    private final String input;
    private final SearchBy by;
    private final SearchFilter filter;
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
    @Step("{0} searches for the user account with #filter filter and a value of #input")
    public <T extends Actor> void performAs(T actor) {
        Target selectedSearchBy = CustomerSearchPage.bind.getDefaultItem(by);
        Map<String, Target> selectedFilter = CustomerSearchPage.bind.get(filter);

        actor.attemptsTo(
                ClickOn.the(InternalHomePage.CUSTOMER_SEARCH_TAB),
                Click.on(CustomerSearchPage.Filter.DROPDOWN),
                Click.on(selectedFilter.get("option")),
                Enter.theValue(input).into(selectedFilter.get("field")),
                Click.on(CustomerSearchPage.Filter.APPLY_BUTTON),
                ClickOn.the(selectedSearchBy)
        );
    }
}
