package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {

    @Test
    void testBigmacBuilder() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun(BunType.SESAME)
                .burgers(2)
                .sauce(SauceType.BARBECUE)
                .ingredient(Ingredient.BACON)
                .ingredient(Ingredient.CHEESE)
                .ingredient(Ingredient.CHILLI)
                .build();
        System.out.println(bigmac);

        //When Then
        assertEquals(2, bigmac.getBurgers());
        assertEquals(SauceType.BARBECUE, bigmac.getSauce());
        int howManyIngredients = bigmac.getIngredients().size();
        assertEquals(3, howManyIngredients);

    }
}
