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

public class ViewAccount implements Task {

    private static String name;

    public ViewAccount(String name) {
        ViewAccount.name = name;
    }

    @Override
    @Step("{0} views the user account #name")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Search.forTheCustomer(SearchBy.USER)
                        .withThe(SearchFilter.USER_ID)
                        .that(SearchMatch.EXACTS)
                        .theWord(name),
                ClickOn.the(CustomerSearchPage.FIRST_ROW_SEARCH_RESULT)
        );
    }

    public static String getName() {
        if (name == null) { return "Unknown User"; }
        return name;
    }
}
