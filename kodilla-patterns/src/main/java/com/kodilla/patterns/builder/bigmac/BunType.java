package com.kodilla.patterns.builder.bigmac;

public enum BunType {
    NO_SESAME("Bun"),
    SESAME("Bun with sesame");

    private final String description;

    private BunType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
