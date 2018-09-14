package com.elavon.tasks;

import com.elavon.setup.Application;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Optional;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class WaitPageLoad implements Task {

    private WebDriverWait wait;
    private ExpectedCondition<Boolean> isFinishedLoading;

    public WaitPageLoad() {
        wait = new WebDriverWait(Application.BROWSER, Application.MAXIMUM_TIMEOUT);

        isFinishedLoading = (webDriver) -> {
            final JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
            boolean isJavascriptLoaded;
            boolean isAjaxLoaded;

            isJavascriptLoaded = jsExecutor.executeScript("return document.readyState").equals("complete");
            try {
                isAjaxLoaded = ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
            } catch (Exception e) {
                isAjaxLoaded = true;
            }

            return isJavascriptLoaded && isAjaxLoaded;
        };
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        wait.until(isFinishedLoading);
    }
}
