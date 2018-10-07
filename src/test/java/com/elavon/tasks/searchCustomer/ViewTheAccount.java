package com.elavon.tasks.searchCustomer;

import com.elavon.constants.search.SearchBy;
import com.elavon.constants.search.SearchFilter;
import com.elavon.constants.search.SearchMatch;
import com.elavon.interactions.ClickOn;
import com.elavon.ui.pages.CustomerSearchPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class ViewTheAccount implements Task {

    private static String name;

    public static ViewTheAccount of(String userId) {
        return Instrumented.instanceOf(ViewTheAccount.class).withProperties(userId);
    }

    public ViewTheAccount(String name) {
        ViewTheAccount.name = name;
    }

    @Override
    @Step("{0} views the user account #name")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SearchForTheAccount.by(SearchBy.USER)
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
