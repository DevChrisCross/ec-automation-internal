package com.elavon.tasks.general;

import com.elavon.setup.constants.EnvironmentLocale;
import com.elavon.setup.constants.EnvironmentType;
import com.elavon.tasks.home.OpenApplicationPage;
import com.elavon.ui.Page;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;

import static com.elavon.setup.Application.CONFIG;

public class Open {

    private EnvironmentType envType;
    private EnvironmentLocale localeType;

    public Open() {
        String env = CONFIG.getString("environment.type");
        envType = EnvironmentType.valueOf(env.toUpperCase());

        String locale = CONFIG.getString("environment.locale");
        localeType = EnvironmentLocale.valueOf(locale);
    }

    public static Open theApplication() { return new Open(); }

    public Performable byNavigatingUrlTo(Page page) {
        return Instrumented.instanceOf(OpenApplicationPage.class)
                .withProperties(page, envType, localeType, false);
    }

    public Performable onThe(Page page) {
        return Instrumented.instanceOf(OpenApplicationPage.class)
                .withProperties(page, envType, localeType, true);
    }

    public Open withTheEnvironmentOf(EnvironmentType envType) {
        this.envType = envType;
        return this;
    }

    public Open withTheLocaleOf(EnvironmentLocale locale) {
        this.localeType = locale;
        return this;
    }
}
