package com.elavon.tasks.cancellableTasks.updateLocations;

import com.elavon.constants.Operation;
import com.elavon.constants.user.UserLocationRule;
import com.elavon.model.Location;
import net.serenitybdd.core.steps.Instrumented;

public class UpdateTheLocations {

    public static LocationsBuilder by(Operation operation) {
        return new LocationsBuilder(operation);
    }

    public static class LocationsBuilder {

        private Operation operation;
        private UserLocationRule rule;
        private String clg;

        public LocationsBuilder(Operation operation) {
            this.operation = operation;
            this.rule = UserLocationRule.MID;
        }

        public LocationsBuilder withTheRuleOf(UserLocationRule rule) {
            this.rule = rule;
            return this;
        }

        public LocationsBuilder fromTheClientGroupOf(String clg) {
            this.clg = clg;
            return this;
        }


        public UpdateLocations withTheValueOf(String value) {
            return Instrumented.instanceOf(UpdateLocations.class)
                    .withProperties(operation, new Location(rule, clg, value));
        }
    }
}
