package com.elavon.tasks.genericTasks;

import com.elavon.constants.Operation;

public class UpdateTheReportsOfTheUser {

    public static UpdateReportsBuilder by(Operation operation) {
        return new UpdateReportsBuilder(operation);
    }

    public static class UpdateReportsBuilder {

        private final Operation operation;

        public UpdateReportsBuilder(Operation operation) {
            this.operation = operation;
        }

        public 
    }
}
