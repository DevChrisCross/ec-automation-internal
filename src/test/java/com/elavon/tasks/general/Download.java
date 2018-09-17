package com.elavon.tasks.general;

import com.elavon.tasks.customerSearch.DownloadSearchCustomerResult;
import net.serenitybdd.core.steps.Instrumented;

public class Download {

    public static DownloadSearchCustomerResult theCustomerSearchResults() {
        return Instrumented.instanceOf(DownloadSearchCustomerResult.class).withProperties();
    }
}
