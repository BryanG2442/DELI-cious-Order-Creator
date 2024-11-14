package com.order;

import java.util.ArrayList;

public class Order {
    enum DrinkSize {
        SMALL (2),
        MEDIUM (2.5),
        LARGE (3);

        private final double drinkPrice;

        DrinkSize (double drinkPrice){
            this.drinkPrice = drinkPrice;
        }

        public double getDrinkPrice() {
            return drinkPrice;
        }
    }
    enum DrinkFlavors{
        COLA, LEMON_LIME, GRAPE, STRAWBERRY,
    }

    enum ChipFlavors{
        STANDARD, SPICY, NACHO_CHEESE, LIME, BBQ,
    }

    private DrinkSize drinkSize;
    private DrinkFlavors drinkFlavors;
    private ChipFlavors chipFlavors;
    private ArrayList<Sandwich> sandwiches;



    public Order (DrinkSize drinkSize, DrinkFlavors drinkFlavors,
                  ChipFlavors chipFlavors, ArrayList<Sandwich> sandwiches)
    {
        this.drinkSize = drinkSize;
        this.drinkFlavors = drinkFlavors;
        this.chipFlavors = chipFlavors;
        this.sandwiches = sandwiches;
    }







}
