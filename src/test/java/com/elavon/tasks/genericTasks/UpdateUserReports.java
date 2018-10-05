package com.elavon.tasks.genericTasks;

import com.elavon.constants.Operation;
import com.elavon.constants.reports.Report;
import com.elavon.tasks.operateCustomer.UpdateReports;
import net.serenitybdd.core.steps.Instrumented;

public class UpdateUserReports {

    public static UpdateReports byAddingTheReportOf(Report report) {
        return Instrumented.instanceOf(UpdateReports.class).withProperties(report, Operation.ADD);
    }

    public static UpdateReports byRemovingTheReportOf(Report report) {
        return Instrumented.instanceOf(UpdateReports.class).withProperties(report, Operation.REMOVE);
    }
}
