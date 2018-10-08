package com.elavon.serenity;

import com.elavon.constants.HomeNavigation;
import com.elavon.constants.search.SearchBy;
import com.elavon.constants.search.SearchFilter;
import com.elavon.constants.search.SearchMatch;
import com.elavon.constants.user.UserType;
import com.elavon.setup.Application;
import com.elavon.tasks.accessApplication.LoginTheAccount;
import com.elavon.tasks.accessApplication.OpenTheApplication;
import com.elavon.tasks.searchCustomer.SearchForTheAccount;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;

public class SearchExistingCustomerStepDefinition {
    @Before
    public void set_the_stage() {
        Cast cast = Cast.whereEveryoneCan(
                Application.USER.usingAbilityTo(BrowseTheWeb.class),
                Application.USER.usingAbilityTo(CallAnApi.class));
        OnStage.setTheStage(cast);
    }

    @Given("^that (.*) has search by (.*) with the (.*) filter that (.*) the criteria (.*) in the customer search$")
    public void search_for_customer(String name,
                                    SearchBy by,
                                    SearchFilter filter,
                                    SearchMatch match,
                                    String searchTerm) throws Throwable {
        OnStage.theActorCalled(name).attemptsTo(
                OpenTheApplication.on().thePageOf(HomeNavigation.LOGIN),
                LoginTheAccount.as(UserType.INTERNAL),
                SearchForTheAccount.by(by)
                        .withThe(filter)
                        .that(match)
                        .theWord(searchTerm)
        );
    }

    @When("^s?he looks at the search results table$")
    public void heLooksAtTheSearchResultsTable() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^s?he should see that the search results matches the criteria of the filter$")
    public void heShouldSeeThatTheSearchResultsMatchesTheCriteriaOfTheFilter() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
