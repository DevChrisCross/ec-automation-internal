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
                BrowseTheWeb.with(Application.generateBrowser()),
                CallAnApi.at(Application.generateApi()));
        OnStage.setTheStage(cast);
    }

    @Given("^that (.*) decided to find a specific customer using the customer search$")
    public void decided_to_search_customer(String name) throws Throwable {
        OnStage.theActorCalled(name).attemptsTo(
                OpenTheApplication.on().thePageOf(HomeNavigation.LOGIN),
                LoginTheAccount.as(UserType.INTERNAL)
        );
    }

    @When("^s?he searches for a criteria that (.*) the term (.*) using the (.*) filter shown by (.*) category$")
    public void search_for_customer(SearchMatch match,
                                    String searchTerm,
                                    SearchFilter filter,
                                    SearchBy by) throws Throwable {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SearchForTheAccount.by(by)
                        .withThe(filter)
                        .that(match)
                        .theWord(searchTerm)
        );
    }

    @Then("^s?he should see that the search results matches the (.*) criteria of the (.*) filter$")
    public void search_result_matches_filter() throws Throwable {
        OnStage.theActorInTheSpotlight().should(
//                seeThat()
//                RestAssured.given().auth().basic()
        );
    }


}
