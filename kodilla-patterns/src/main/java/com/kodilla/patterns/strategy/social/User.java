package com.kodilla.patterns.strategy.social;

public sealed class User
        permits Millenials, YGeneration, ZGeneration {

    private String username;
    private SocialPublisher socialPublisher;

    public User(String username, SocialPublisher socialPublisher) {
        this.username = username;
        this.socialPublisher = socialPublisher;
    }

    public String sharePost() {
        return socialPublisher.share();
    }

    public void setSocialPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }

    public String getUsername() {
        return username;
    }
}