package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class MyUserList {
    public static final List<MyUser> users = new ArrayList<>();

    static {
        // {noop} をつけると平文パスワードをそのまま使えます
        users.add(new MyUser("alice", "{noop}pass1"));
        users.add(new MyUser("bob",   "{noop}pass2"));
        users.add(new MyUser("carol", "{noop}pass3"));
        users.add(new MyUser("dave",  "{noop}pass4"));
        users.add(new MyUser("eve",   "{noop}pass5"));
    }
}
