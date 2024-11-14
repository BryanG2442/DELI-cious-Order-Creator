package com.order;

import java.util.ArrayList;

public class Sandwich {

    public enum BreadSize {
        FOUR_INCH(5.50, 1, .50, .75, .30),

        EIGHT_INCH(7, 2, 1, 1.50, .60),

        TWELVE_INCH(8.50, 3, 1.50, 2.25, .90);


        private final double basePrice;
        private final double meatPrice;
        private final double extraMeatPrice;
        private final double cheesePrice;
        private final double extraCheesePrice;

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
    public enum BreadType{
        WHITE, WHEAT, RYE, WRAP
    }

    public enum RegularToppings{
        LETTUCE, PEPPERS, ONIONS, TOMATOES, JALAPENOS, CUCUMBERS, PICKLES, GUACAMOLE, MUSHROOMS
    }
    public enum PremiumMeats{
        STEAK, HAM, SALAMI, ROAST_BEEF, CHICKEN, BACON
    }
    public enum PremiumCheese{
        AMERICAN, PROVOLONE, CHEDDAR, SWISS
    }
    public enum Sauces {
     MAYO, MUSTARD, KETCHUP, RANCH, THOUSAND_ISLANDS, VINAIGRETTE
    }

    private boolean isToasted;
    private BreadType breadType;
    private BreadSize breadSize;
    private ArrayList<PremiumMeats> meatToppings;
    private ArrayList<PremiumMeats> extraMeatToppings;
    private ArrayList<PremiumCheese> cheeseToppings;
    private ArrayList<PremiumCheese> extraCheeseToppings;
    private ArrayList<RegularToppings> regularToppings;
    private ArrayList<RegularToppings> extraRegularToppings;
    private ArrayList<Sauces> sauces;


    public Sandwich(boolean isToasted, BreadSize breadSize, BreadType breadType,
                    ArrayList<PremiumMeats> meatToppings, ArrayList<PremiumMeats> extraMeatToppings,
                    ArrayList<PremiumCheese> cheeseToppings, ArrayList<PremiumCheese> extraCheeseToppings,
                    ArrayList<RegularToppings> regularToppings, ArrayList<RegularToppings> extraRegularToppings,
                    ArrayList<Sauces> sauces){
        this.isToasted = isToasted;
        this.breadSize = breadSize;
        this.breadType = breadType;
        this.meatToppings = meatToppings;
        this.extraMeatToppings = extraMeatToppings;
        this.cheeseToppings = cheeseToppings;
        this.extraCheeseToppings = extraCheeseToppings;
        this.regularToppings = regularToppings;
        this.extraRegularToppings = extraRegularToppings;
        this.sauces = sauces;



    }

    public ArrayList<PremiumMeats> getMeatToppings() {
        return meatToppings;
    }

    public ArrayList<PremiumMeats> getExtraMeatToppings() {
        return extraMeatToppings;
    }

    public ArrayList<PremiumCheese> getCheeseToppings() {
        return cheeseToppings;
    }

    public ArrayList<PremiumCheese> getExtraCheeseToppings() {
        return extraCheeseToppings;
    }

    public ArrayList<RegularToppings> getRegularToppings() {
        return regularToppings;
    }

    public ArrayList<RegularToppings> getExtraRegularToppings() {
        return extraRegularToppings;
    }

    public ArrayList<Sauces> getSauces() {
        return sauces;
    }

    public BreadSize getBreadSize() {
        return breadSize;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public double getSandwichPrice(){
        return (extraCheeseToppings.size() * breadSize.extraCheesePrice)
                + (cheeseToppings.size() * breadSize.cheesePrice)
                +(extraMeatToppings.size() * breadSize.extraMeatPrice)
                + (meatToppings.size() * breadSize.meatPrice)
                + breadSize.getBasePrice();




    }


    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    public void setBreadSize(BreadSize breadSize) {
        this.breadSize = breadSize;
    }

    public void setMeatToppings(ArrayList<PremiumMeats> meatToppings) {
        this.meatToppings = meatToppings;
    }

    public void setExtraMeatToppings(ArrayList<PremiumMeats> extraMeatToppings) {
        this.extraMeatToppings = extraMeatToppings;
    }

    public void setCheeseToppings(ArrayList<PremiumCheese> cheeseToppings) {
        this.cheeseToppings = cheeseToppings;
    }

    public void setExtraCheeseToppings(ArrayList<PremiumCheese> extraCheeseToppings) {
        this.extraCheeseToppings = extraCheeseToppings;
    }

    public void setRegularToppings(ArrayList<RegularToppings> regularToppings) {
        this.regularToppings = regularToppings;
    }

    public void setExtraRegularToppings(ArrayList<RegularToppings> extraRegularToppings) {
        this.extraRegularToppings = extraRegularToppings;
    }

    public void setSauces(ArrayList<Sauces> sauces) {
        this.sauces = sauces;
    }
}
