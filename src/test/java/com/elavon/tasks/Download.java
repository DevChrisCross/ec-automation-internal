package com.elavon.tasks;

import net.serenitybdd.core.steps.Instrumented;

public class Download {

    public static DownloadSearchCustomerResult theCustomerSearchResults() {
        return Instrumented.instanceOf(DownloadSearchCustomerResult.class).withProperties();
    }
}
