package com.elavon.tasks.cancellableTasks.updateProfile;

import com.elavon.constants.user.UserProfile;
import net.serenitybdd.core.steps.Instrumented;

public class UpdateTheProfile {

    public static UpdateProfileBuilder byChangingTheFieldOf(UserProfile userProfile) {
        return new UpdateProfileBuilder(userProfile);
    }

    private static class UpdateProfileBuilder {

        private final UserProfile userProfile;

        public UpdateProfileBuilder(UserProfile userProfile) {
            this.userProfile = userProfile;
        }

        public UpdateProfile withTheValueOf(Enum value) {
            return Instrumented.instanceOf(UpdateProfile.class).withProperties(userProfile, value);
        }
    }
}
