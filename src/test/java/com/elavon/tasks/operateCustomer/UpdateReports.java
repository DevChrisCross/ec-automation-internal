package com.elavon.tasks.operateCustomer;

import com.elavon.constants.Operation;
import com.elavon.constants.reports.Report;
import com.elavon.interactions.ClickOn;
import com.elavon.tasks.Cancellable;
import com.elavon.tasks.ModifyAssignedReports;
import com.elavon.ui.pages.CustomerAccount.EditReportsPage;
import com.elavon.ui.pages.CustomerAccount.ViewCustomerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class UpdateReports extends Cancellable implements Task {

    private Report report;
    private Operation operation;

    public UpdateReports(Report report, Operation operation) {
        this.report = report;
        this.operation = operation;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                ClickOn.the(ViewCustomerPage.EDIT_REPORTS_BUTTON),
                new ModifyAssignedReports(report, operation),
                ClickOn.the(SuccessOrFail(
                        EditReportsPage.UPDATE_BUTTON,
                        EditReportsPage.CANCEL_BUTTON))
        );
    }
}
