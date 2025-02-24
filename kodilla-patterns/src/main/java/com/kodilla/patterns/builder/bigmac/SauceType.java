package com.kodilla.patterns.builder.bigmac;

public enum SauceType {
    STANDARD("Standard"),
    ISLANDS_1000("1000 islands"),
    BARBECUE("Barbecue");

    private final String description;

    SauceType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}