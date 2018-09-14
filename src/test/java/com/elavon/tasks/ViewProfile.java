package com.elavon.tasks;

import com.elavon.setup.Application;
import com.elavon.tasks.search.Search;
import com.elavon.tasks.search.SearchBy;
import com.elavon.tasks.search.SearchFilter;
import com.elavon.tasks.search.SearchMatch;
import com.elavon.ui.pages.CustomerProfilePage;
import com.elavon.ui.pages.CustomerSearchPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotCurrentlyVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

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
                Click.on(CustomerSearchPage.FIRST_ROW_SEARCH_RESULT),
                WaitUntil.the(CustomerProfilePage.ACCOUNT_DETAILS_CARD, isVisible())
                        .forNoMoreThan(Application.MAXIMUM_TIMEOUT).seconds()
        );
    }
}
