package com.elavon.tasks.operateCustomer;

import com.elavon.interactions.ClickOn;
import com.elavon.ui.pages.CustomerAccount.EditLocationsPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.util.List;

public class RemoveCustomerLocations implements Task {

    private String value;

    public RemoveCustomerLocations(String value) {
        this.value = value;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<String> items = Text.of(EditLocationsPage.Location.ITEMS).viewedBy(actor).asList();
        int indexToRemove = items.indexOf(value);
        Target removeButton = Target
                .the("remove location button")
                .located(By.xpath(EditLocationsPage.Location.itemXPath + "[" + ++indexToRemove + "]/div[5]"));

        actor.attemptsTo(
                ClickOn.the(removeButton)
        );
    }

    public static RemoveCustomerLocations withTheValueOf(String value) {
        return Instrumented.instanceOf(RemoveCustomerLocations.class).withProperties(value);
    }
}
