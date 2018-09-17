package com.elavon.tasks.general;

import com.elavon.tasks.customerSearch.constants.SearchBy;
import com.elavon.tasks.customerSearch.SearchCustomer;
import com.elavon.tasks.customerSearch.constants.SearchFilter;
import com.elavon.tasks.customerSearch.constants.SearchMatch;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;

public class Search {

    private SearchBy by;
    private SearchMatch match;
    private SearchFilter filter;

    public Search(SearchBy by) {
        this.by = by;
    }

    public static Performable forTheUserProfileOf(String userId) { return View.theUserProfileOf(userId); }

    public static Search forTheCustomer(SearchBy by) { return new Search(by); }

    public Search withThe(SearchFilter filter) {
        this.filter = filter;
        return this;
    }

    public Search that(SearchMatch match) {
        this.match = match;
        return this;
    }

    public Performable theWord(String input) {
        return Instrumented.instanceOf(SearchCustomer.class)
                .withProperties(by, filter, match, input);
    }
}
