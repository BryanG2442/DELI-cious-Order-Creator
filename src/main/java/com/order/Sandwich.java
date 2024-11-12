package com.order;

import java.util.ArrayList;

public class Sandwich {
    private boolean isToasted;
    private BreadType breadType;
    private BreadSize breadSize;
    private ArrayList<PremiumMeats> meatToppings;
    private ArrayList<PremiumCheese> cheeseToppings;
    private ArrayList<RegularToppings> regularToppings;
    private ArrayList<Sauces> sauces;

    enum BreadSize {
        FOUR_INCH(5.50, 1, .50, .75, .30),

        EIGHT_INCH(7, 2, 1, 1.50, .60),

        TWELVE_INCH(8.50, 3, 1.50, 2.25, .90);


        private double basePrice;
        private double meatPrice;
        private double extraMeatPrice;
        private double cheesePrice;
        private double extraCheesePrice;

        BreadSize (double basePrice, double meatPrice, double extraMeatPrice, double cheesePrice, double extraCheesePrice){
            this.basePrice = basePrice;
            this.meatPrice = meatPrice;
            this.extraMeatPrice = extraMeatPrice;
            this. cheesePrice = cheesePrice;
            this.extraCheesePrice = extraCheesePrice;
        }

        public double getBasePrice() {
            return basePrice;
        }

        public double getCheesePrice() {
            return cheesePrice;
        }

        public double getExtraCheesePrice() {
            return extraCheesePrice;
        }

        public double getExtraMeatPrice() {
            return extraMeatPrice;
        }

        public double getMeatPrice() {
            return meatPrice;
        }
    }
    enum BreadType{
        WHITE, WHEAT, RYE, WRAP
    }

    enum RegularToppings{
        LETTUCE, PEPPERS, ONIONS, TOMATOES, JALAPENOS, CUCUMBERS, PICKLES, GUACAMOLE, MUSHROOMS
    }
    enum PremiumMeats{
        STEAK, HAM, SALAMI, ROAST_BEEF, CHICKEN, BACON
    }
    enum PremiumCheese{
        AMERICAN, PROVOLONE, CHEDDAR, SWISS
    }
    enum Sauces {
     MAYO, MUSTARD, KETCHUP, RANCH, THOUSAND_ISLANDS, VINAIGRETTE
    }

    public Sandwich(){

    }

    public










}
