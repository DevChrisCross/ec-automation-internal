package com.elavon.tasks.genericTasks;

import com.elavon.tasks.searchUserProfile.DownloadSearchCustomerResult;
import net.serenitybdd.core.steps.Instrumented;

public class Download {

    public static DownloadSearchCustomerResult theCustomerSearchResults() {
        return Instrumented.instanceOf(DownloadSearchCustomerResult.class).withProperties();
    }
}