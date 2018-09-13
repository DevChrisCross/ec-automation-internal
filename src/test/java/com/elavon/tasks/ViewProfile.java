package com.elavon.tasks;

import com.elavon.setup.Application;
import com.elavon.tasks.search.Search;
import com.elavon.tasks.search.SearchBy;
import com.elavon.tasks.search.SearchFilter;
import com.elavon.tasks.search.SearchMatch;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.waits.WaitUntilAngularIsReady;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotCurrentlyVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ViewProfile implements Task {

    private String input;

    public ViewProfile(String input) { this.input = input; }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target firstRowResult = Target.the("")
                .located(By.xpath("/html/body/div[1]/span/" +
                        "md-content/md-content/div/div/" +
                        "md-card[2]/md-card-content[2]/md-table-container/table/tbody/tr/td[1]"));
        Target toastMessage = Target.the("toast message")
                .located(By.id("toast"));
        actor.attemptsTo(
                Search.forCustomer(SearchBy.USER)
                        .withThe(SearchFilter.USER_ID)
                        .that(SearchMatch.EXACTS)
                        .theWord(input),
                WaitUntil.the(toastMessage, isNotCurrentlyVisible()).forNoMoreThan(Application.MAXIMUM_TIMEOUT).seconds(),
                Click.on(firstRowResult)
        );
    }
}
