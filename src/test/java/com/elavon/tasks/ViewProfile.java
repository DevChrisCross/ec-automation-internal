package com.elavon.tasks;

import com.elavon.tasks.search.Search;
import com.elavon.tasks.search.SearchBy;
import com.elavon.tasks.search.SearchFilter;
import com.elavon.tasks.search.SearchMatch;
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
//                WaitUntilThe.targetIsLoaded(CustomerSearchPage.FIRST_ROW_SEARCH_RESULT),
                Click.on(CustomerSearchPage.FIRST_ROW_SEARCH_RESULT),
                WaitUntilThe.pageIsFullyLoaded()
        );
    }
}
