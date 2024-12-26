package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> userList = new ArrayList<>();

    public Forum() {

        userList.add(new ForumUser(1, "User name 1", 'M', LocalDate.of(1980, 10, 20), 200));
        userList.add(new ForumUser(2, "User name 2", 'M', LocalDate.of(2005, 8, 10), 0));
        userList.add(new ForumUser(3, "User name 3", 'F', LocalDate.of(1980, 3, 26), 60));
        userList.add(new ForumUser(4, "User name 4", 'F', LocalDate.of(1990, 4, 5), 30));
        userList.add(new ForumUser(5, "User name 5", 'M', LocalDate.of(2000, 6, 7), 400));
        userList.add(new ForumUser(6, "User name 6", 'M', LocalDate.of(1980, 10, 20), 100));
        userList.add(new ForumUser(7, "User name 7", 'M', LocalDate.of(2005, 8, 10), 50));
        userList.add(new ForumUser(8, "User name 8", 'F', LocalDate.of(2010, 3, 26), 200));
        userList.add(new ForumUser(9, "User name 9", 'F', LocalDate.of(1970, 4, 5), 30));
        userList.add(new ForumUser(10, "User name 10", 'M', LocalDate.of(2000, 6, 7), 0));

    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(userList);
    }
}