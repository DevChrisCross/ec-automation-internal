package com.elavon.tasks;

import com.elavon.constants.Operation;
import com.elavon.constants.reports.Report;
import com.elavon.constants.reports.ReportGroup;
import com.elavon.ui.pages.CustomerAccount.EditReportsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.util.List;


public class ModifyAssignedReports implements Task {

    private Report report;
    private Operation operation;

    public ModifyAssignedReports(Report report, Operation operation) {
        this.report = report;
        this.operation = operation;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String reportName = report instanceof ReportGroup ?
                report.toString() :
                String.join(" ", report.toString().split("_"));

        //edge-case for Non-Financial Chargeback, cannot be done with XPath 1.0
        if (reportName.equals("Non Financial Chargeback List")) {
            reportName = "Non-Financial Chargeback List";
        }

        List<String> assignedReports = Text.of(EditReportsPage.ASSIGNED_REPORT_NAMES).viewedBy(actor).asList();
        int indexToRemove = assignedReports.indexOf(reportName) + 1;

        Target reportToOperate = Target.the(reportName)
                .located(By.xpath(
                        operation.equals(Operation.ADD) ?
                                EditReportsPage.REPORT_CHECKBOXES_XPATH + "[@aria-label=\"" + reportName + "\"]" :
                                "//assigned-reports/div[" + indexToRemove + "]/div/div/i"
                ));

        actor.attemptsTo(Click.on(reportToOperate));
    }
}
