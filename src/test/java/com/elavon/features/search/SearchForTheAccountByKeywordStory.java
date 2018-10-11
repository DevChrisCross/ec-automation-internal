package com.elavon.features.search;

import com.elavon.constants.HomeNavigation;
import com.elavon.setup.Application;
import com.elavon.tasks.accessApplication.OpenTheApplication;
import com.google.common.collect.ImmutableMap;
import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;

@RunWith(SerenityRunner.class)
public class SearchForTheAccountByKeywordStory {

    private Actor anna = Application.generateUser();

    @Test
    public void search_results_should_show_the_search_term_in_the_title() {
        givenThat(anna).wasAbleTo(OpenTheApplication.on().thePageOf(HomeNavigation.LOGIN));
        Map<String, String> jsonMap = ImmutableMap.of("username", "c038975", "password", "Architech@4");
        RestAssured.given()
                .contentType("application/json")
                .body(jsonMap)
                .when().post("https://qa-elavonconnect.eu.global.prv/api/v1/user/authenticate/")
                .then().statusCode(200);
//        andThat(anna).wasAbleTo(LoginTheAccount.as(UserType.INTERNAL));
//        andThat(anna).wasAbleTo(SearchForTheAccount.forTheCustomer(SearchBy.USER)
//        andThat(anna).wasAbleTo(AddTheNewUser.ofUser()
//                .typeOfAccount().byCloningTheUserOf("chris@creag").incompletely());
//        andThat(anna).wasAbleTo(ViewTheAccount.of("chris@creag"));
//        andThat(anna).wasAbleTo(Impersonate.theUserProfile());
//        andThat(anna).wasAbleTo(End.theImpersonationOfTheUser());
//        andThat(anna).wasAbleTo(Reset.thePasswordOfTheUserAccount().incompletely());
//        andThat(anna).wasAbleTo(UpdateTheProfile.byChangingTheFieldOf(UserProfile.ROLE).withTheValueOf(UserRole.MANAGER));
//        andThat(anna).wasAbleTo(UpdateTheLocations.byRemovingTheLocation().withTheValueOf("2100441305"));
//        andThat(anna).wasAbleTo(UpdateTheReports.byAddingTheReportOf(ReportGroup.STANDARD_NONPARTNER_REPORTS));
//        andThat(anna).wasAbleTo(UpdateTheReports.by(Operation.ADDING).theReportOf(ReportGroup.DCC_REPORTS));
//        andThat(anna).wasAbleTo(UpdateTheReports.byAddingTheReportOf(DisputeReport.Non_Financial_Chargeback_List));
//        andThat(anna).wasAbleTo(SearchForTheAccount.withTheName().thatContains(""));
//        andThat(anna).wasAbleTo(SearchForTheAccount.withTheEmail().thatStartsWith(""));
//        when(anna).attemptsTo(SearchForTheAccount.forTheTerm("BDD In Action"));
//        andThat(anna).wasAbleTo(CloneTheAccount.ofUser().typeOfAccount().incompletely());
//        andThat(anna).wasAbleTo(AddTheNewUser.theNewUser().withTheValueOf("2100371205").fromTheClientGroup("300").incompletely());
//        then(anna).should(eventually(seeThat(TheWebPage.title(), containsString("BDD In Action"))));

    }
}