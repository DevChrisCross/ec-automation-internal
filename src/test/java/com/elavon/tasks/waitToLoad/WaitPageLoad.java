package com.elavon.tasks.waitToLoad;

import com.elavon.setup.Application;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class WaitPageLoad implements Task {

    private static final String JAVASCRIPT_STATUS = "return document.readyState === \"complete\"";

    private static final String JQUERY_DEFINED = "return window.jQuery !== undefined";
    private static final String ANGULAR_DEFINED = "return window.angular !== undefined";
    private static final String ANGULAR_INJECTOR_DEFINED = "return angular.element(document).injector() !== undefined";

    private static final String JQUERY_STATUS = "return jQuery.active === 0 ";
    private static final String ANGULAR_STATUS =
            "return angular.element(document).injector().get('$http').pendingRequests.length === 0";

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriverWait wait = new WebDriverWait(Application.browser, Application.MAXIMUM_TIMEOUT);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();

        ExpectedCondition<Boolean> angularIsDefined = (webDriver) ->
                ((Boolean) jsExecutor.executeScript(ANGULAR_DEFINED) &&
                        (Boolean) jsExecutor.executeScript(ANGULAR_INJECTOR_DEFINED));

        ExpectedCondition<Boolean> angularIsReady = (webDriver) ->
                ((Boolean) jsExecutor.executeScript(ANGULAR_STATUS) &&
                        (Boolean) jsExecutor.executeScript(JAVASCRIPT_STATUS));

        wait.until(angularIsDefined);
        wait.until(angularIsReady);
    }
}
