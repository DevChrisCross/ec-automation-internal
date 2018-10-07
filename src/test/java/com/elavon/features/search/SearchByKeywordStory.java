package com.elavon.features.search;

import com.elavon.constants.HomeNavigation;
import com.elavon.constants.reports.ReportGroup;
import com.elavon.constants.user.UserType;
import com.elavon.setup.Application;
import com.elavon.tasks.genericTasks.Login;
import com.elavon.tasks.genericTasks.Open;
import com.elavon.tasks.genericTasks.Search;
import com.elavon.tasks.genericTasks.UpdateUserReports;
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
//        andThat(anna).wasAbleTo(Impersonate.theUserProfile());
//        andThat(anna).wasAbleTo(End.theImpersonationOfTheUser());
//        andThat(anna).wasAbleTo(Reset.thePasswordOfTheUserAccount().incompletely());
//        andThat(anna).wasAbleTo(UpdateUserProfile.byChangingTheFieldOf(UserProfile.ROLE).withTheValueOf(UserRole.MANAGER));
//        andThat(anna).wasAbleTo(UpdateUserLocations.byRemovingTheLocation().withTheValueOf("2100441305"));
//        andThat(anna).wasAbleTo(UpdateUserReports.byAddingTheReportOf(ReportGroup.STANDARD_NONPARTNER_REPORTS));
        andThat(anna).wasAbleTo(UpdateUserReports.byRemovingTheReportOf(ReportGroup.DISPUTE_REPORTS));
//        andThat(anna).wasAbleTo(UpdateUserReports.byAddingTheReportOf(DisputeReport.Non_Financial_Chargeback_List));
//        andThat(anna).wasAbleTo(Search.withTheName().thatContains(""));
//        andThat(anna).wasAbleTo(Search.withTheEmail().thatStartsWith(""));
//        when(anna).attemptsTo(Search.forTheTerm("BDD In Action"));
//        andThat(anna).wasAbleTo(Clone.theUser().incompletely());
//        andThat(anna).wasAbleTo(Add.theNewUser().withTheValueOf("2100371205").fromTheClientGroup("300").incompletely());
//        then(anna).should(eventually(seeThat(TheWebPage.title(), containsString("BDD In Action"))));

    }
}