package com.elavon.tasks.genericTasks;

import com.elavon.tasks.searchCustomer.DownloadResult;
import net.serenitybdd.core.steps.Instrumented;

public class Download {

    public static DownloadResult theCustomerSearchResults() {
        return Instrumented.instanceOf(DownloadResult.class).withProperties();
    }
}
