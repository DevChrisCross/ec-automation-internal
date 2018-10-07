package com.elavon.tasks.accessApplication;

import com.elavon.constants.EnvironmentLocale;
import com.elavon.constants.EnvironmentType;
import com.elavon.constants.HomeNavigation;
import net.serenitybdd.core.steps.Instrumented;

import static com.elavon.setup.Application.CONFIG;

public class OpenTheApplication {

    public static OpenApplicationBuilder on() {
        return new OpenApplicationBuilder();
    }

    public static class OpenApplicationBuilder {

        private EnvironmentType envType;
        private EnvironmentLocale localeType;

        public OpenApplicationBuilder() {
            String env = CONFIG.getString("environment.type");
            envType = EnvironmentType.valueOf(env.toUpperCase());

            String locale = CONFIG.getString("environment.locale");
            localeType = EnvironmentLocale.valueOf(locale);
        }

        public OpenApplicationBuilder theEnvironmentOf(EnvironmentType envType) {
            this.envType = envType;
            return this;
        }

        public OpenApplicationBuilder theLocaleOf(EnvironmentLocale locale) {
            this.localeType = locale;
            return this;
        }

        public OpenApplication thePageOf(HomeNavigation homeNavigation) {
            return Instrumented.instanceOf(OpenApplication.class).withProperties(homeNavigation, envType, localeType);
        }

    }
}
