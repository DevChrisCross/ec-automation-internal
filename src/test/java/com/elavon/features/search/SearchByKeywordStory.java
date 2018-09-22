package com.elavon.features.search;

import com.elavon.constants.HomeNavigation;
import com.elavon.constants.UserProfile;
import com.elavon.constants.UserRole;
import com.elavon.constants.UserType;
import com.elavon.setup.Application;
import com.elavon.tasks.genericTasks.Login;
import com.elavon.tasks.genericTasks.Open;
import com.elavon.tasks.genericTasks.Search;
import com.elavon.tasks.genericTasks.Update;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import org.junit.Test;
import org.junit.runner.RunWith;

import static net.serenitybdd.screenplay.GivenWhenThen.andThat;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;

@RunWith(SerenityRunner.class)
public class SearchByKeywordStory {

    private Actor anna = Application.USER;

    @Test
    public void search_results_should_show_the_search_term_in_the_title() {

        givenThat(anna).wasAbleTo(Open.theApplication().onThe(HomeNavigation.LOGIN));
        andThat(anna).wasAbleTo(Login.as(UserType.INTERNAL));
//        andThat(anna).wasAbleTo(Search.forTheCustomer(SearchBy.USER)
        andThat(anna).wasAbleTo(Search.forTheUserProfileOf("chris@creag"));
//        andThat(anna).wasAbleTo(Impersonate.theUserProfileOf("chris@creag"));
//        andThat(anna).wasAbleTo(End.theImpersonationOfTheUser());
//        andThat(anna).wasAbleTo(Reset.thePasswordOfTheUserAccount().incompletely());
        andThat(anna).wasAbleTo(Update.theCustomerProfile(UserProfile.ROLE).withTheValueOf(UserRole.EMPLOYEE));
//        andThat(anna).wasAbleTo(Click.on());
//        andThat(anna).wasAbleTo(Search.withTheName().thatContains(""));
//        andThat(anna).wasAbleTo(Search.withTheEmail().thatStartsWith(""));
//        when(anna).attemptsTo(Search.forTheTerm("BDD In Action"));

//        then(anna).should(eventually(seeThat(TheWebPage.title(), containsString("BDD In Action"))));

    }
}