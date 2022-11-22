package me.crune.aevo.example;

import me.crune.aevo.AevoSet;
import me.crune.aevo.Loader;
import me.crune.aevo.MySQL;
import me.crune.aevo.impl.SimpleAevoSet;
import me.crune.aevo.impl.SimpleLoader;

import java.util.UUID;

public class Example {

    public static void main(String[] args) {
        MySQL mySQL = new MySQL("jdbc:mysql://localhost:3306/example", "username", "password");
        Loader<UUID, User> loader = new SimpleLoader<>(mySQL, User.class, new UUIDAdapter());
        AevoSet<UUID, User> users = new SimpleAevoSet<>(loader, "users");

        users.fetchAsync(); // fetch users from user table

        for (User user : users) {
            String msg = "Found user with uuid %s and balance %s.";
            System.out.println(String.format(msg, user.getKey().toString(), user.getBalance()));
        }

        UUID uuid = UUID.randomUUID();
        User user = users.get(uuid).orElse(new User(uuid));
        user.setBalance(1337);
        users.add(user);
        users.updateAsync(); // inserts user if not present into users table

        user.setBalance(69);
        users.updateAsync(); // updates user into users table

        users.delete(user.getKey());
        users.updateAsync(); // deletes user from users table
    }
}
