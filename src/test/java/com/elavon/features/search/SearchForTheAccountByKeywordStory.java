package com.elavon.features.search;

import com.elavon.constants.HomeNavigation;
import com.elavon.constants.Operation;
import com.elavon.constants.reports.ReportGroup;
import com.elavon.constants.user.UserType;
import com.elavon.setup.Application;
import com.elavon.tasks.accessApplication.LoginTheAccount;
import com.elavon.tasks.accessApplication.OpenTheApplication;
import com.elavon.tasks.cancellableTasks.createNewCustomer.AddTheNewUser;
import com.elavon.tasks.cancellableTasks.updateReports.UpdateTheReports;
import com.elavon.tasks.searchCustomer.ViewTheAccount;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import org.junit.Test;
import org.junit.runner.RunWith;

import static net.serenitybdd.screenplay.GivenWhenThen.andThat;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;

@RunWith(SerenityRunner.class)
public class SearchForTheAccountByKeywordStory {

    private Actor anna = Application.USER;

    @Test
    public void search_results_should_show_the_search_term_in_the_title() {

        givenThat(anna).wasAbleTo(OpenTheApplication.on().thePageOf(HomeNavigation.LOGIN));
        andThat(anna).wasAbleTo(LoginTheAccount.as(UserType.INTERNAL));
//        andThat(anna).wasAbleTo(SearchForTheAccount.forTheCustomer(SearchBy.USER)
        andThat(anna).wasAbleTo(AddTheNewUser.ofUser().typeOfAccount());
        andThat(anna).wasAbleTo(ViewTheAccount.of("chris@creag"));
//        andThat(anna).wasAbleTo(Impersonate.theUserProfile());
//        andThat(anna).wasAbleTo(End.theImpersonationOfTheUser());
//        andThat(anna).wasAbleTo(Reset.thePasswordOfTheUserAccount().incompletely());
//        andThat(anna).wasAbleTo(UpdateTheProfile.byChangingTheFieldOf(UserProfile.ROLE).withTheValueOf(UserRole.MANAGER));
//        andThat(anna).wasAbleTo(UpdateTheLocations.byRemovingTheLocation().withTheValueOf("2100441305"));
//        andThat(anna).wasAbleTo(UpdateTheReports.byAddingTheReportOf(ReportGroup.STANDARD_NONPARTNER_REPORTS));
        andThat(anna).wasAbleTo(UpdateTheReports.by(Operation.ADDING).theReportOf(ReportGroup.DCC_REPORTS));
//        andThat(anna).wasAbleTo(UpdateTheReports.byAddingTheReportOf(DisputeReport.Non_Financial_Chargeback_List));
//        andThat(anna).wasAbleTo(SearchForTheAccount.withTheName().thatContains(""));
//        andThat(anna).wasAbleTo(SearchForTheAccount.withTheEmail().thatStartsWith(""));
//        when(anna).attemptsTo(SearchForTheAccount.forTheTerm("BDD In Action"));
//        andThat(anna).wasAbleTo(Clone.theUser().incompletely());
//        andThat(anna).wasAbleTo(AddTheNewUser.theNewUser().withTheValueOf("2100371205").fromTheClientGroup("300").incompletely());
//        then(anna).should(eventually(seeThat(TheWebPage.title(), containsString("BDD In Action"))));

    }
}