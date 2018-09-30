package com.elavon.binder;

import net.thucydides.core.pages.PageObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class DataBind<K, V> {

    private Class<? extends PageObject> pageClass;
    private final K defaultKey;
    private Map<Enum, Map<K, V>> dataBinds;

    public DataBind(K defaultKey,
                    Class<? extends PageObject> pageClass,
                    Map<Class<? extends Enum>, Queue<Map<K, V>>> dataBinds) {

        Map<Enum, Map<K, V>> map = new HashMap<>();
        dataBinds.forEach((enumClass, queue) -> {
            Enum[] enums = enumClass.getEnumConstants();
            for (Enum e : enums) {
                map.put(e, queue.poll());
            }
        });

        this.defaultKey = defaultKey;
        this.pageClass = pageClass;
        this.dataBinds = map;
    }

    public Class<? extends PageObject> getPageClass() {
        return pageClass;
    }

    public Map<Enum, Map<K, V>> getDataBinds() {
        return dataBinds;
    }

    public Map<K, V> getItem(Enum e) {
        return dataBinds.get(e);
    }

    public V getDefaultItem(Enum e) {
        return dataBinds.get(e).get(defaultKey);
    }
}
