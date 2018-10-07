package com.elavon.tasks.cancellableTasks.updateReports;

import com.elavon.constants.Operation;
import com.elavon.constants.reports.DisputeReport;
import com.elavon.constants.reports.Report;
import com.elavon.constants.reports.ReportGroup;
import com.elavon.interactions.ClickOn;
import com.elavon.tasks.cancellableTasks.Cancellable;
import com.elavon.ui.pages.CustomerAccount.EditReportsPage;
import com.elavon.ui.pages.CustomerAccount.ViewCustomerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class UpdateReports extends Cancellable implements Task {

    private Report report;
    private Operation operation;

    public UpdateReports(Report report, Operation operation) {
        this.report = report;
        this.operation = operation;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String reportName = report instanceof ReportGroup ?
                report.toString() :
                String.join(" ", report.toString().split("_"));

        //edge-case for Non-Financial Chargeback, cannot be done with XPath 1.0
        if (report.equals(DisputeReport.Non_Financial_Chargeback_List)) {
            reportName = "Non-Financial Chargeback List";
        }

        //edge-case for Select All Checkbox since ALL is an instanceof ReportGroup
        if (report.equals(ReportGroup.ALL)) {
            reportName = "Select All";
        }

        Target reportToOperate = operation.equals(Operation.ADDING) ?
                EditReportsPage.REPORT_CHECKBOX.of(reportName).called(reportName) :
                EditReportsPage.REPORT_REMOVE_BUTTON.of(reportName).called(reportName);

        actor.attemptsTo(
                ClickOn.the(ViewCustomerPage.EDIT_REPORTS_BUTTON),
                Click.on(reportToOperate),
                ProceedOrCancel()
        );
    }
}
