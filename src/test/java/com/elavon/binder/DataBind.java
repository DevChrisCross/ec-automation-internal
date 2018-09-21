package com.elavon.binder;

import net.thucydides.core.pages.PageObject;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class DataBind<K, V> {

    private Class<? extends PageObject> pageClass;
    private Class<? extends Bindable> bindClass;
    private Queue<Map<K, V>> data;

    public DataBind(Class<? extends PageObject> pageClass, Class<? extends Bindable> bindClass, Queue<Map<K, V>> data) {
        this.pageClass = pageClass;
        this.bindClass = bindClass;
        this.data = data;
    }

    public Class<? extends PageObject> getPageClass() {
        return pageClass;
    }

    public Class<? extends Bindable> getBindClass() {
        return bindClass;
    }

    public Queue<Map<K, V>> getData() {
        return new LinkedList<>(data);
    }
}
