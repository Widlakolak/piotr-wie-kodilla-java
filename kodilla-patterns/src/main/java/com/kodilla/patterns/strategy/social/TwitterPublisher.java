package com.kodilla.patterns.strategy.social;

public class TwitterPublisher implements SocialPublisher {

    @Override
    public String share() {
        System.out.println("Twitter publisher");
        return "Twitter";
    }
}
