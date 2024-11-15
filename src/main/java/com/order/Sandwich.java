package com.order;

import java.util.ArrayList;

public class Sandwich {
    public enum Sides {
        AU_JUS("Au Jus"), SAUCE("Sauce");
        public final String readable;
        Sides(String readable){
            this.readable = readable;
        }
    }
    public enum BreadSize {
        FOUR_INCH("Four Inches", 5.50, 1, .50, .75, .30),

        EIGHT_INCH("Eight Inches", 7, 2, 1, 1.50, .60),

        TWELVE_INCH("Twelve Inches", 8.50, 3, 1.50, 2.25, .90);

        public final String readable;
        private final double basePrice;
        private final double meatPrice;
        private final double extraMeatPrice;
        private final double cheesePrice;
        private final double extraCheesePrice;

        BreadSize (String readable, double basePrice, double meatPrice, double extraMeatPrice, double cheesePrice, double extraCheesePrice){
            this.readable = readable;
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
        WHITE("White"), WHEAT("Wheat"), RYE("Rye"), WRAP("Wrap");
        public final String readable;
        BreadType(String readable){
            this.readable = readable;
        }
    }

    public enum RegularToppings{
        LETTUCE("Lettuce"), PEPPERS("Peppers"), ONIONS("Onions"), TOMATOES("Tomatoes"),
        JALAPENOS("Jalapenos"), CUCUMBERS("Cucumbers"), PICKLES("Pickles"), GUACAMOLE("Guacamole"),
        MUSHROOMS("Mushrooms");
        public final String readable;
        RegularToppings(String readable){
            this.readable = readable;

        }
    }
    public enum PremiumMeats{
        STEAK ("Steak"), HAM("Ham"), SALAMI("Salami"),
        ROAST_BEEF("Roast Beef"), CHICKEN("Chicken"), BACON("Bacon");
        final String readable;
        PremiumMeats(String readable){
            this.readable = readable;
        }
    }
    public enum PremiumCheese{
        AMERICAN("American"), PROVOLONE("Provolone"),
        CHEDDAR("Cheddar"), SWISS("Swiss");
        final String readable;
        PremiumCheese(String readable){
            this.readable = readable;
        }
    }
    public enum Condiments {
     MAYO("Mayo"), MUSTARD("Mustard"), KETCHUP("Ketchup"),
        RANCH("Ranch"), THOUSAND_ISLANDS("Thousand Islands"),
        VINAIGRETTE("Vinaigrette");
     public final String readable;
     Condiments(String readable){
         this.readable = readable;
     }
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
    private ArrayList<Condiments> condiments;
    private ArrayList<Sides> sides;

    public Sandwich(boolean isToasted, BreadSize breadSize, BreadType breadType,
                    ArrayList<PremiumMeats> meatToppings, ArrayList<PremiumMeats> extraMeatToppings,
                    ArrayList<PremiumCheese> cheeseToppings, ArrayList<PremiumCheese> extraCheeseToppings,
                    ArrayList<RegularToppings> regularToppings, ArrayList<RegularToppings> extraRegularToppings,
                    ArrayList<Condiments> condiments, ArrayList<Sides> sides){
        this.isToasted = isToasted;
        this.breadSize = breadSize;
        this.breadType = breadType;
        this.meatToppings = meatToppings;
        this.extraMeatToppings = extraMeatToppings;
        this.cheeseToppings = cheeseToppings;
        this.extraCheeseToppings = extraCheeseToppings;
        this.regularToppings = regularToppings;
        this.extraRegularToppings = extraRegularToppings;
        this.condiments = condiments;
        this.sides = sides;


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

    public ArrayList<Condiments> getCondiments() {
        return condiments;
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

    public void setCondiments(ArrayList<Condiments> condiments) {
        this.condiments = condiments;
    }

    public ArrayList<Sides> getSides() {
        return sides;
    }

    public void setSides(ArrayList<Sides> sides) {
        this.sides = sides;
    }
}
