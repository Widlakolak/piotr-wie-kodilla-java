package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {
    @Test
    void testGetPeopleQuantity() {

        //Given
        Country poland = new Country("Poland", new BigDecimal("38000000"));
        Country usa = new Country("USA", new BigDecimal("200000000"));
        Country germany = new Country("Germany", new BigDecimal("60000000"));
        Country france = new Country("France", new BigDecimal("50000000"));
        Country china = new Country("China", new BigDecimal("4000000000"));
        Country uk = new Country("UK", new BigDecimal("45000000"));
        Country japan = new Country("Japan", new BigDecimal("10000000"));
        Country india = new Country("India", new BigDecimal("500000000"));
        Country canada = new Country("Canada", new BigDecimal("100000000"));

        Continent europe = new Continent("Europe");
        Continent america = new Continent("America");
        Continent asia = new Continent("Asia");

        europe.addCountry(poland);
        europe.addCountry(germany);
        europe.addCountry(france);
        europe.addCountry(uk);

        america.addCountry(usa);
        america.addCountry(canada);

        asia.addCountry(china);
        asia.addCountry(japan);
        asia.addCountry(india);

        World world = new World();

        world.addContinent(europe);
        world.addContinent(america);
        world.addContinent(asia);

        //When
        BigDecimal worldPeopleQuantity = world.getPeopleQuantity();

        //Then
        BigDecimal expectedPeopleQuantity = new BigDecimal("5003000000");
        assertEquals(expectedPeopleQuantity, worldPeopleQuantity);


    }
}
