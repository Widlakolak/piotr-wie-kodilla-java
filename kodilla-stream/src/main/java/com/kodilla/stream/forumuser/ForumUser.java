package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {

    private final int userId;
    private final String username;
    private final char gender;
    private final LocalDate birthday;
    private final int postCount;

    public ForumUser(int userId, String username, char gender, LocalDate birthday, int postCount) {
        this.userId = userId;
        this.username = username;
        this.gender = gender;
        this.birthday = birthday;
        this.postCount = postCount;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getPostCount() {
        return postCount;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", postCount=" + postCount +
                '}';
    }
}
