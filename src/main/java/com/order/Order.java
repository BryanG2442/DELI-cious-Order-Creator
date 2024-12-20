package com.order;

import java.util.ArrayList;

public class Order {
    public enum DrinkSize {
        NO_DRINK(0, "No drink"),
        SMALL (2, "Small"),
        MEDIUM (2.5, "Medium"),
        LARGE (3, "Large");

        private final double drinkPrice;
        public final String readable;
        DrinkSize (double drinkPrice, String readable){
            this.drinkPrice = drinkPrice;
            this.readable = readable;
        }

        public double getDrinkPrice() {
            return drinkPrice;
        }
    }
    public enum DrinkFlavors{
        COLA("Cola"),
        LEMON_LIME("Lemon-Lime"),
        GRAPE("Grape"),
        STRAWBERRY("Strawberry"),
        ORANGE("Orange"), NO_DRINK(" ");
        public final String readable;
        DrinkFlavors(String readable){
            this.readable = readable;
        }


    }

    public enum ChipFlavors{
        NO_CHIPS("No chips", 0),
        STANDARD("Standard", 1.50), SPICY("Spicy", 1.50),
        NACHO_CHEESE("Nacho Cheese", 1.50),
        LIME("Lime", 1.50), BBQ("BBQ", 1.50);

        public final String readable;
        private final double price;
        ChipFlavors(String readable, double price){
            this.readable = readable;
            this.price = price;

        }

        public double getPrice() {
            return price;
        }
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

    public double getOrderPrice(){
        return drinkSize.getDrinkPrice() + chipFlavors.getPrice() +
                sandwiches.stream().map(sandwich -> sandwich.getSandwichPrice())
                        .reduce(0.0, (sum, price) -> sum += price);
    }








    public DrinkSize getDrinkSize() {
        return drinkSize;
    }

    public void setDrinkSize(DrinkSize drinkSize) {
        this.drinkSize = drinkSize;
    }

    public DrinkFlavors getDrinkFlavors() {
        return drinkFlavors;
    }

    public void setDrinkFlavors(DrinkFlavors drinkFlavors) {
        this.drinkFlavors = drinkFlavors;
    }

    public ChipFlavors getChipFlavors() {
        return chipFlavors;
    }

    public void setChipFlavors(ChipFlavors chipFlavors) {
        this.chipFlavors = chipFlavors;
    }

    public ArrayList<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public void setSandwiches(ArrayList<Sandwich> sandwiches) {
        this.sandwiches = sandwiches;
    }
}
