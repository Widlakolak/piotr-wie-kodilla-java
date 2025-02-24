package com.kodilla.patterns.builder.bigmac;

public enum Ingredient {
    LETTUCE("Lettuce"),
    ONION("Onion"),
    BACON("Bacon"),
    PICKLE("Pickle"),
    CHILLI("Chilli"),
    MUSHROOMS("Mushrooms"),
    SHRIMP("Shrimp"),
    CHEESE("Cheese"),;

    private final String name;

    Ingredient(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}