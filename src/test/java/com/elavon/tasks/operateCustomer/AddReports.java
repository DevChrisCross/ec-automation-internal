package com.elavon.tasks.operateCustomer;

import com.elavon.constants.reports.Report;
import com.elavon.constants.reports.ReportGroup;
import com.elavon.interactions.ClickOn;
import com.elavon.tasks.Cancellable;
import com.elavon.ui.pages.CustomerAccount.EditReportsPage;
import com.elavon.ui.pages.CustomerAccount.ViewCustomerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.apache.commons.lang.WordUtils;
import org.openqa.selenium.By;

public class AddReports extends Cancellable implements Task {

    private Target reportTarget;

    public AddReports(ReportGroup reportGroup) {
        reportTarget = EditReportsPage.bind.getDefaultItem(reportGroup);
    }

    public AddReports(Report report) {
        String enumName = String.join(" ", report.toString().split("_"));
        String reportName = WordUtils.capitalizeFully(enumName);
        reportTarget = Target.the(reportName)
                .located(By.xpath("//reports-tree-node/div/div/md-checkbox[@aria-label=\"" + reportName + "\"]"));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOn.the(ViewCustomerPage.EDIT_REPORTS_BUTTON),
                Click.on(reportTarget),
                ClickOn.the(SuccessOrFail(
                        EditReportsPage.UPDATE_BUTTON,
                        EditReportsPage.CANCEL_BUTTON))
        );
    }
}
