package me.crune.aevo.impl;

import me.crune.aevo.Aevo;
import me.crune.aevo.AevoSet;
import me.crune.aevo.Loader;

import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class SimpleAevoSet<I, T extends Aevo<I>> implements AevoSet<I, T> {

    private Map<I, T> cache;
    private final Loader<I, T> loader;
    private final String table;

    public SimpleAevoSet(Loader<I, T> loader, String table) {
        this.loader = loader;
        this.cache = loader.fetch(table);
        this.table = table;
    }

    public Optional<T> get(I id) {
        return Optional.ofNullable(cache.get(id));
    }

    public void add(T t) {
        cache.put(t.getKey(), t);
    }

    public void delete(I i) {
        cache.remove(i);
    }

    @Override
    public void updateAsync() {
        CompletableFuture.runAsync(() -> loader.update(table, cache));
    }

    @Override
    public void fetchAsync() {
        CompletableFuture.runAsync(() -> this.cache = loader.fetch(table));
    }

    public Iterator<T> iterator() {
        return cache.values().iterator();
    }
}
