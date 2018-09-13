package com.elavon.features.search;

import com.elavon.setup.Application;
import com.elavon.setup.UserType;
import com.elavon.tasks.View;
import com.elavon.tasks.login.Login;
import com.elavon.tasks.open.Open;
import com.elavon.tasks.search.Search;
import com.elavon.tasks.search.SearchBy;
import com.elavon.tasks.search.SearchFilter;
import com.elavon.tasks.search.SearchMatch;
import com.elavon.ui.Page;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import org.junit.Test;
import org.junit.runner.RunWith;

import static net.serenitybdd.screenplay.GivenWhenThen.and;
import static net.serenitybdd.screenplay.GivenWhenThen.andThat;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;

@RunWith(SerenityRunner.class)
public class SearchByKeywordStory {

    private Actor anna = Application.USER;

    @Test
    public void search_results_should_show_the_search_term_in_the_title() {

        givenThat(anna).wasAbleTo(Open.theApplication().onThe(Page.LOGIN));
        andThat(anna).wasAbleTo(Login.as(UserType.INTERNAL));
//        andThat(anna).wasAbleTo(Search.forCustomer(SearchBy.USER)
//                .withThe(SearchFilter.USER_ID).that(SearchMatch.EXACTS).theWord("chris@creag"));
        andThat(anna).wasAbleTo(View.theProfileOf("chris@creag"));
//        andThat(anna).wasAbleTo(Search.withTheName().thatContains(""));
//        andThat(anna).wasAbleTo(Search.withTheEmail().thatStartsWith(""));
//        when(anna).attemptsTo(Search.forTheTerm("BDD In Action"));

//        then(anna).should(eventually(seeThat(TheWebPage.title(), containsString("BDD In Action"))));

    }
}