package com.elavon.tasks.genericTasks;

import com.elavon.constants.reports.Report;
import com.elavon.constants.reports.ReportGroup;
import com.elavon.tasks.operateCustomer.AddReports;
import net.serenitybdd.core.steps.Instrumented;

public class UpdateUserReports {

    public static AddReports byAddingTheReportsOf(ReportGroup group) {
        return Instrumented.instanceOf(AddReports.class).withProperties(group);
    }

    public static AddReports byAddingTheReportsOf(Report report) {
        return Instrumented.instanceOf(AddReports.class).withProperties(report);
    }

//    public static RemoveReports byRemovingTheReportsOf(ReportGroup group);
}
