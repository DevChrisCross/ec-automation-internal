package com.elavon.tasks.searchCustomer;

import com.elavon.constants.SearchBy;
import com.elavon.constants.SearchFilter;
import com.elavon.constants.SearchMatch;
import com.elavon.interactions.ClickOn;
import com.elavon.tasks.genericTasks.Search;
import com.elavon.ui.pages.CustomerSearchPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class ViewCustomerAccount implements Task {

    private final String input;

    public ViewCustomerAccount(String input) {
        this.input = input;
    }

    @Override
    @Step("{0} views the user's account of #input")
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
