package me.crune.aevo;

public interface IdAdapter<T> {

    T get(Object o);

    Object create(T t);

}
