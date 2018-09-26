package com.elavon.tasks.searchCustomer;

import com.elavon.ui.pages.CustomerSearchPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

@Deprecated
public class DownloadSearchCustomerResult implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CustomerSearchPage.SEARCH_OPTIONS),
                Click.on(CustomerSearchPage.DOWNLOAD_RESULTS_OPTION)
        );
    }
}
