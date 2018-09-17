package com.elavon.tasks.customerSearch;

import com.elavon.interactions.ClickOn;
import com.elavon.tasks.general.Search;
import com.elavon.tasks.customerSearch.constants.SearchBy;
import com.elavon.tasks.customerSearch.constants.SearchFilter;
import com.elavon.tasks.customerSearch.constants.SearchMatch;
import com.elavon.tasks.wait.WaitUntilThe;
import com.elavon.ui.pages.CustomerSearchPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class ViewProfile implements Task {

    private String input;

    public ViewProfile(String input) { this.input = input; }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Search.forTheCustomer(SearchBy.USER)
                        .withThe(SearchFilter.USER_ID)
                        .that(SearchMatch.EXACTS)
                        .theWord(input),
                ClickOn.the(CustomerSearchPage.FIRST_ROW_SEARCH_RESULT)
        );
    }
}
