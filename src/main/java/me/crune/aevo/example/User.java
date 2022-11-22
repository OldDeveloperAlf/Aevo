package me.crune.aevo.example;

import me.crune.aevo.Aevo;
import me.crune.aevo.annotation.Column;
import me.crune.aevo.annotation.ColumnKey;

import java.util.UUID;

public class User implements Aevo<UUID> {

    @ColumnKey
    @Column("uniqueId")
    private final UUID uniqueId;

    @Column("balance")
    private int balance;

    public User(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public UUID getKey() {
        return this.uniqueId;
    }
}
