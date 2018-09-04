package com.cetiti.cache;

public interface ValueOptions<T> {

    void setValue(String key, T val);

    T getValue(String key);
}
