package com.elavon.binder;

import net.serenitybdd.screenplay.targets.Target;

public interface Bindable {

    DataBind<String, Target> retrieveData();
}
