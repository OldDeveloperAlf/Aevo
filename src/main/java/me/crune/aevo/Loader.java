package me.crune.aevo;

import java.util.Map;

public interface Loader<I, T extends Aevo<I>> {

    Map<I, T> fetch(String table);

    void update(String table, Map<I, T> cache);

}
