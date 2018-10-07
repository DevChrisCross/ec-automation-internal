package com.elavon.tasks.cancellableTasks.updateReports;

import com.elavon.constants.Operation;
import com.elavon.constants.reports.Report;
import net.serenitybdd.core.steps.Instrumented;

public class UpdateTheReports {

    public static UpdateReportsBuilder by(Operation operation) {
        return new UpdateReportsBuilder(operation);
    }

    public static class UpdateReportsBuilder {

        private final Operation operation;

        public UpdateReportsBuilder(Operation operation) {
            this.operation = operation;
        }

        public UpdateReports theReportOf(Report report) {
            return Instrumented.instanceOf(UpdateReports.class).withProperties(report, operation);
        }
    }
}
