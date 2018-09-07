package com.elavon.features.search;

import com.elavon.setup.EnvironmentLocale;
import com.elavon.setup.User;
import com.elavon.tasks.LoginAs;
import com.elavon.tasks.OpenTheApplication;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static net.serenitybdd.screenplay.GivenWhenThen.andThat;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;

@RunWith(SerenityRunner.class)
public class SearchByKeywordStory {

    Actor anna;

    @Before
    public void annaCanBrowseTheWeb() {
        anna = User.named("Anna");
    }

    @Test
    public void search_results_should_show_the_search_term_in_the_title() {

        givenThat(anna).wasAbleTo(OpenTheApplication.onTheTermsOfUsePage().fromTheHomePage());
//        when(anna).attemptsTo(Search.forTheTerm("BDD In Action"));

//        then(anna).should(eventually(seeThat(TheWebPage.title(), containsString("BDD In Action"))));

    }
}