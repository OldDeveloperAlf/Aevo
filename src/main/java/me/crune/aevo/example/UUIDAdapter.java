package me.crune.aevo.example;

import me.crune.aevo.IdAdapter;

import java.util.UUID;

public class UUIDAdapter implements IdAdapter<UUID> {

    @Override
    public UUID get(Object o) {
        return UUID.fromString((String) o);
    }

    @Override
    public Object create(UUID uuid) {
        return uuid.toString();
    }
}
