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

public class EditReportsPageBinder implements Bindable {

    @Override
    public DataBind<String, Target> retrieveData() {
        return new DataBind<>(
                DEFAULT_KEY,
                EditReportsPage.class,
                ImmutableMap.of(ReportGroup.class, new LinkedList<>(Arrays.asList(
                        defaultMap(EditReportsPage.SELECT_ALL_CHECKBOX),
                        defaultMap(EditReportsPage.AUTHORIZATIONS_REPORTS_CHECKBOX),
                        defaultMap(EditReportsPage.DCC_REPORTS_CHECKBOX),
                        defaultMap(EditReportsPage.DISPUTE_REPORTS_CHECKBOX),
                        defaultMap(EditReportsPage.INTERCHANGE_REPORTS_CHECKBOX),
                        defaultMap(EditReportsPage.OPTIONAL_REPORTS_CHECKBOX),
                        defaultMap(EditReportsPage.STANDARD_NONPARTNER_REPORTS_CHECKBOX),
                        defaultMap(EditReportsPage.STANDARD_PARTNER_REPORTS_CHECKBOX)
                )))
        );
    }
}
