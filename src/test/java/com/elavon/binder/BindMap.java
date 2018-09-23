package com.elavon.binder;

import java.util.HashMap;
import java.util.Map;

public class BindMap<K, V> extends HashMap<Bindable, Map<K, V>> {

    private final K defaultKey;

    public BindMap(K defaultKey) {
        super();
        this.defaultKey = defaultKey;
    }

    public V getDefaultItem(Object o) {
        return super.get(o).get(defaultKey);
    }
}
