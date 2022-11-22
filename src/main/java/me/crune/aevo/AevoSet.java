package me.crune.aevo;

import java.util.Optional;

public interface AevoSet<I, T extends Aevo<I>> extends Iterable<T> {

    Optional<T> get(I id);

    void add(T t);

    void delete(I i);

    void updateAsync();

    void fetchAsync();

}
