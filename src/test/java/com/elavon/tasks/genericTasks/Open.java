package com.elavon.tasks.genericTasks;

import com.elavon.constants.EnvironmentLocale;
import com.elavon.constants.EnvironmentType;
import com.elavon.constants.HomeNavigation;
import com.elavon.tasks.accessApplication.OpenApplication;
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

    public Performable onThe(HomeNavigation homeNavigation) {
        return Instrumented.instanceOf(OpenApplication.class)
                .withProperties(homeNavigation, envType, localeType);
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
