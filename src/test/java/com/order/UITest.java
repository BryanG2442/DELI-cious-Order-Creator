package com.order;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class UITest {

    @org.junit.jupiter.api.Test
    void fixMeats() {
        //arrange
        UI ui = new UI();
        ArrayList<Sandwich.PremiumMeats> baseMeats = new ArrayList<>();
        baseMeats.add(Sandwich.PremiumMeats.CHICKEN);
        baseMeats.add(Sandwich.PremiumMeats.HAM);
        ArrayList<Sandwich.PremiumMeats> extraMeats = new ArrayList<>();
        extraMeats.add(Sandwich.PremiumMeats.CHICKEN);
        extraMeats.add(Sandwich.PremiumMeats.SALAMI);

        //act
        extraMeats = ui.fixMeats(baseMeats, extraMeats);

        //assert
        assertEquals(1, extraMeats.size());
        System.out.println(extraMeats.size());




    }
}