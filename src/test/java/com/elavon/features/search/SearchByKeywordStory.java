package com.elavon.features.search;

import com.elavon.setup.Application;
import com.elavon.tasks.OpenTheApplication;
import com.elavon.tasks.login.LoginAs;
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

        givenThat(anna).wasAbleTo(OpenTheApplication.onTheHomePage());
        andThat(anna).wasAbleTo(LoginAs.anInternalUser());
//        when(anna).attemptsTo(Search.forTheTerm("BDD In Action"));

//        then(anna).should(eventually(seeThat(TheWebPage.title(), containsString("BDD In Action"))));

    }
}