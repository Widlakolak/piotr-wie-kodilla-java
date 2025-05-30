package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class Country {

    private final String name;
    private final BigDecimal peopleQuantity;

    public Country(String name, BigDecimal peopleQuantity) {
        this.name = name;
        this.peopleQuantity = peopleQuantity;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPeopleQuantity(){
        return peopleQuantity;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name= '" + name + '\'' +
                ", people quantity= " + peopleQuantity +
                '}';
    }
}
