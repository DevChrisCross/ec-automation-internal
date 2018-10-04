package com.elavon.ui.binders.CustomerAccount;

import com.elavon.binder.Bindable;
import com.elavon.binder.DataBind;
import com.elavon.constants.reports.ReportGroup;
import com.elavon.ui.pages.CustomerAccount.EditReportsPage;
import com.google.common.collect.ImmutableMap;
import net.serenitybdd.screenplay.targets.Target;

import java.util.Arrays;
import java.util.LinkedList;

import static com.elavon.binder.PageBind.DEFAULT_KEY;
import static com.elavon.binder.PageBind.defaultMap;
import static com.elavon.ui.pages.CustomerAccount.EditReportsPage.Available;

public class EditReportsPageBinder implements Bindable {

    @Override
    public DataBind<String, Target> retrieveData() {
        return new DataBind<>(
                DEFAULT_KEY,
                EditReportsPage.class,
                ImmutableMap.of(ReportGroup.class, new LinkedList<>(Arrays.asList(
                        defaultMap(Available.SELECT_ALL_CHECKBOX),
                        defaultMap(Available.AUTHORIZATIONS_REPORTS_CHECKBOX),
                        defaultMap(Available.DCC_REPORTS_CHECKBOX),
                        defaultMap(Available.DISPUTE_REPORTS_CHECKBOX),
                        defaultMap(Available.INTERCHANGE_REPORTS_CHECKBOX),
                        defaultMap(Available.OPTIONAL_REPORTS_CHECKBOX),
                        defaultMap(Available.STANDARD_NONPARTNER_REPORTS_CHECKBOX),
                        defaultMap(Available.STANDARD_PARTNER_REPORTS_CHECKBOX)
                )))
        );
    }
}
