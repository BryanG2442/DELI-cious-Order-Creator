package com.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UI {
    private static final Scanner scanner = new Scanner(System.in);


    public void greetingScreen(){
        String choice = " ";
        System.out.println("Welcome to the DELI-cious application.");
        while (!choice.equalsIgnoreCase("0")){
        System.out.println(
                "Please input the number of your selection: " +
                "\n1) Make a new order" +
                "\n0) Exit");
        choice = scanner.nextLine();
        switch (choice){
            case "1":
                orderTaker();
                break;
            case "0":
                System.out.println("Thank you for using this application.");
                break;
            default:
                System.out.println("Invalid input. Please make a valid selection.");
        }



        }

    }

    public void orderTaker(){
        System.out.println("Welcome to the order creator. We will now take your order.");
        Order order = makeOrder();
        System.out.println("Your order consists of: ");
        for (Sandwich sandwich : order.getSandwiches()){
            showSandwich(sandwich);
        }
        System.out.println("Drink Size ----- " + order.getDrinkSize().readable);
        System.out.println("Drink Flavor ----- " + order.getDrinkFlavors().readable);
        System.out.println("Chips ----- " + order.getChipFlavors().readable);
        System.out.printf("Your total comes out to $%.2f. Would you like to confirm your purchase?" +
                "\n(Y to confirm your purchase, any other key to cancel)", order.getOrderPrice());
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Y")){
            System.out.println("Thank you for your purchase!");
            ReceiptWriter receiptWriter = new ReceiptWriter();
            receiptWriter.writeReceipt(order);
        }
        else{
            System.out.println("Order canceled. We hope to see you again.");
        }





    }

    public Order makeOrder(){
        String choice = "Y";
        ArrayList<Sandwich> sandwiches = new ArrayList<>();

        while (choice.equalsIgnoreCase("Y")){
            sandwiches.add(makeSandwich());
            System.out.println("Would you like to make another sandwich?" +
                    "\nPlease input Y for yes, or any other key for no.");
            choice = scanner.nextLine();
        }

        System.out.println("Would you like a drink? (Y for yes, any other key for no)");
        choice = scanner.nextLine();
        Order.DrinkSize drinkSize;
        Order.DrinkFlavors drinkFlavor;
        if (choice.equalsIgnoreCase("Y")){
            drinkSize = getDrinkSize();
            drinkFlavor = getDrinkFlavor();
        }
        else {
            drinkSize = Order.DrinkSize.NO_DRINK;
            drinkFlavor = Order.DrinkFlavors.NO_DRINK;
        }
        Order.ChipFlavors chipFlavor;
        System.out.println("Would you like chips? (Y for yes, any other key for no)");
        choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Y")){
            chipFlavor = getChipFlavor();
        }
        else {
            chipFlavor = Order.ChipFlavors.NO_CHIPS;
        }
        Order order = new Order(drinkSize, drinkFlavor, chipFlavor, sandwiches);
        return order;
    }
    //functions that get the remaining variables neccessary for an order
    public Order.DrinkSize getDrinkSize(){
        System.out.println("What drink size would you like?" +
                "\n1) Small" +
                "\n2) Medium" +
                "\n3) Large");

        String input = "0";
        Order.DrinkSize drinkSize = null;

        while (!input.equals("1")&&!input.equals("2")&&!input.equals("3"))
            input = scanner.nextLine();
        switch (input) {
            case "1":drinkSize = Order.DrinkSize.SMALL;
                break;

            case "2":drinkSize = Order.DrinkSize.MEDIUM;
                break;
            case "3":
                drinkSize = Order.DrinkSize.LARGE;
                break;
            default:
                System.out.println("Invalid input. Please input a valid value");

        }
        return drinkSize;
    }
    public Order.DrinkFlavors getDrinkFlavor(){
        System.out.println("What drink flavor would you like?" +
                "\n1) Cola" +
                "\n2) Lemon-Lime" +
                "\n3) Grape" +
                "\n4) Strawberry" +
                "\n5) Orange");

        String input = "0";
        Order.DrinkFlavors drinkFlavor = null;

        while (!input.equals("1")&&!input.equals("2")&&!input.equals("3")
        &&!input.equals("4")&&!input.equals("5"))
            input = scanner.nextLine();
        switch (input) {
            case "1":
                drinkFlavor = Order.DrinkFlavors.COLA;
                break;
            case "2":
                drinkFlavor = Order.DrinkFlavors.LEMON_LIME;
                break;
            case "3":
                drinkFlavor = Order.DrinkFlavors.GRAPE;
                break;
            case "4":
                drinkFlavor = Order.DrinkFlavors.STRAWBERRY;
                break;
            case "5":
                drinkFlavor = Order.DrinkFlavors.ORANGE;
                break;
            default:
                System.out.println("Invalid input. Please input a valid value");

        }
        return drinkFlavor;
    }
    public Order.ChipFlavors getChipFlavor(){
        System.out.println("What chip flavor would you like?" +
                "\n1) Standard" +
                "\n2) Spicy" +
                "\n3) Nacho Cheese" +
                "\n4) Lime" +
                "\n5) BBQ");

        String input = "0";
        Order.ChipFlavors chipFlavor = null;

        while (!input.equals("1")&&!input.equals("2")&&!input.equals("3")
                &&!input.equals("4")&&!input.equals("5"))
            input = scanner.nextLine();
        switch (input) {
            case "1":
                chipFlavor = Order.ChipFlavors.STANDARD;
                break;
            case "2":
                chipFlavor = Order.ChipFlavors.SPICY;
                break;
            case "3":
                chipFlavor = Order.ChipFlavors.NACHO_CHEESE;
                break;
            case "4":
                chipFlavor = Order.ChipFlavors.LIME;
                break;
            case "5":
                chipFlavor = Order.ChipFlavors.BBQ;
                break;
            default:
                System.out.println("Invalid input. Please input a valid value");

        }
        return chipFlavor;
    }



    public Sandwich makeSandwich(){
        Sandwich.BreadSize breadSize = getBreadSize();
        Sandwich.BreadType breadType = getBreadType();
        ArrayList<Sandwich.PremiumMeats> meats = getPremiumMeats();
        ArrayList<Sandwich.PremiumMeats> extraMeats = getExtraMeats(meats);
        ArrayList<Sandwich.PremiumCheese> cheeses = getPremiumCheeses();
        ArrayList<Sandwich.PremiumCheese> extraCheeses = getExtraCheeses(cheeses);
        ArrayList<Sandwich.RegularToppings> toppings = getToppings();
        ArrayList<Sandwich.RegularToppings> extraToppings = getExtraToppings(toppings);
        ArrayList<Sandwich.Condiments> condiments = getCondiments();
        ArrayList<Sandwich.Sides> sides = getSides();
        boolean toasted = askToast();
        Sandwich sandwich = new Sandwich(toasted, breadSize, breadType, meats,
                extraMeats, cheeses, extraCheeses, toppings, extraToppings, condiments, sides);
        sandwich = editSandwich(sandwich);
        return sandwich;
    }

    //Functions that get the given variables listed for creating a sandwich
    public Sandwich.BreadSize getBreadSize(){
        System.out.println("What size of bread would you like?" +
                "\n1) Four Inch" +
                "\n2) Eight Inch" +
                "\n3) Twelve Inch");

        String input = "0";
        Sandwich.BreadSize breadSize = null;
        
        while (!input.equals("1")&&!input.equals("2")&&!input.equals("3"))
            input = scanner.nextLine();
        switch (input) {
            case "1":breadSize = Sandwich.BreadSize.FOUR_INCH;
                break;

            case "2":breadSize = Sandwich.BreadSize.EIGHT_INCH;
                break;

            case "3":
                breadSize = Sandwich.BreadSize.TWELVE_INCH;
                break;
            default:
                System.out.println("Invalid input. Please input a valid value");

        }
        return breadSize;
    }
    public Sandwich.BreadType getBreadType(){
        System.out.println("What type of bread would you like?" +
                "\n1) White" +
                "\n2) Wheat" +
                "\n3) Rye" +
                "\n4) Wrap");

        String input = "0";
        Sandwich.BreadType breadType = null;

        while (!input.equals("1")&&!input.equals("2")&&!input.equals("3")&&!input.equals("4"))
            input = scanner.nextLine();
            switch (input) {
            case "1":breadType = Sandwich.BreadType.WHITE;
                break;

            case "2":breadType = Sandwich.BreadType.WHEAT;
                break;

            case "3":
                breadType = Sandwich.BreadType.RYE;
                break;
            case "4":
                breadType = Sandwich.BreadType.WRAP;
                break;
            default:
                System.out.println("Invalid input. Please input a valid value");

        }
        return breadType;
    }
    public ArrayList<Sandwich.PremiumMeats> getPremiumMeats(){
        ArrayList<Sandwich.PremiumMeats> meats = new ArrayList<>();
        System.out.println("What meats would you like?" +
                "\n1) Steak" +
                "\n2) Ham" +
                "\n3) Salami" +
                "\n4) Roast Beef" +
                "\n5) Chicken" +
                "\n6) Bacon" +
                "\n0) No Meats");
        ArrayList<String> choices = getChoices();
        for (String choice: choices){
            switch (choice){
                case "1": meats.add(Sandwich.PremiumMeats.STEAK);
                    break;
                case "2": meats.add(Sandwich.PremiumMeats.HAM);
                    break;
                case "3": meats.add(Sandwich.PremiumMeats.SALAMI);
                    break;
                case "4": meats.add(Sandwich.PremiumMeats.ROAST_BEEF);
                    break;
                case "5": meats.add(Sandwich.PremiumMeats.CHICKEN);
                    break;
                case "6": meats.add(Sandwich.PremiumMeats.BACON);
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Invalid input - ignored");;



            }
        }
        return meats;
    }
    public ArrayList<Sandwich.PremiumMeats> getExtraMeats(ArrayList<Sandwich.PremiumMeats> meats){
        ArrayList<Sandwich.PremiumMeats> extraMeats = new ArrayList<>();
        String input;
        System.out.println("Would you like any extra meat? (Y for yes, anything else for no)");
        input = scanner.nextLine();
        if (input.equalsIgnoreCase("Y")){
            for (Sandwich.PremiumMeats meat : meats){
                System.out.println("Would you like extra " + meat.readable + "? (Y for yes, anything else for no)");
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("Y")){
                    extraMeats.add(meat);
                }
            }
        }
        return extraMeats;
    }
    public ArrayList<Sandwich.PremiumCheese> getPremiumCheeses(){
        ArrayList<Sandwich.PremiumCheese> cheeses = new ArrayList<>();
        System.out.println("What cheeses would you like?" +
                "\n1) American" +
                "\n2) Provolone" +
                "\n3) Cheddar" +
                "\n4) Swiss" +
                "\n0) No Cheeses");
        ArrayList<String> choices = getChoices();
        for (String choice: choices){
            switch (choice){
                case "1": cheeses.add(Sandwich.PremiumCheese.AMERICAN);
                    break;
                case "2": cheeses.add(Sandwich.PremiumCheese.PROVOLONE);
                    break;
                case "3": cheeses.add(Sandwich.PremiumCheese.CHEDDAR);
                    break;
                case "4": cheeses.add(Sandwich.PremiumCheese.SWISS);
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Invalid input - ignored");;



            }
        }
        return cheeses;
    }
    public ArrayList<Sandwich.PremiumCheese> getExtraCheeses(ArrayList<Sandwich.PremiumCheese> cheeses){
        ArrayList<Sandwich.PremiumCheese> extraCheese = new ArrayList<>();
        String input;
        System.out.println("Would you like any extra cheese? (Y for yes, anything else for no)");
        input = scanner.nextLine();
        if (input.equalsIgnoreCase("Y")){
            for (Sandwich.PremiumCheese cheese : cheeses){
                System.out.println("Would you like extra " + cheese.readable + "? (Y for yes, anything else for no)");
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("Y")){
                    extraCheese.add(cheese);
                }
            }
        }
        return extraCheese;
    }
    public ArrayList<Sandwich.RegularToppings> getToppings() {
        ArrayList<Sandwich.RegularToppings> toppings = new ArrayList<>();
        System.out.println("What toppings would you like?" +
                "\n1) Lettuce" +
                "\n2) Peppers" +
                "\n3) Onions" +
                "\n4) Tomatoes" +
                "\n5) Jalepenos" +
                "\n6) Cucumbers" +
                "\n7) Pickles" +
                "\n8) Guacamole" +
                "\n9) Mushrooms" +
                "\n0) No Toppings");
        ArrayList<String> choices = getChoices();
        for (String choice: choices){
            switch (choice){
                case "1": toppings.add(Sandwich.RegularToppings.LETTUCE);
                    break;
                case "2": toppings.add(Sandwich.RegularToppings.PEPPERS);
                    break;
                case "3": toppings.add(Sandwich.RegularToppings.ONIONS);
                    break;
                case "4": toppings.add(Sandwich.RegularToppings.TOMATOES);
                    break;
                case "5": toppings.add(Sandwich.RegularToppings.JALAPENOS);
                    break;
                case "6": toppings.add(Sandwich.RegularToppings.CUCUMBERS);
                    break;
                case "7": toppings.add(Sandwich.RegularToppings.PICKLES);
                    break;
                case "8": toppings.add(Sandwich.RegularToppings.GUACAMOLE);
                    break;
                case "9": toppings.add(Sandwich.RegularToppings.MUSHROOMS);
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Invalid input - ignored");;



            }
        }
        return toppings;

    }
    public ArrayList<Sandwich.RegularToppings> getExtraToppings(ArrayList<Sandwich.RegularToppings> toppings){
        ArrayList<Sandwich.RegularToppings> extraToppings = new ArrayList<>();
        String input;
        System.out.println("Would you like any extra toppings? (Y for yes, anything else for no)");
        input = scanner.nextLine();
        if (input.equalsIgnoreCase("Y")){
            for (Sandwich.RegularToppings topping : toppings){
                System.out.println("Would you like extra " + topping.readable + "? (Y for yes, anything else for no)");
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("Y")){
                    extraToppings.add(topping);
                }
            }
        }
        return extraToppings;
    }

    public ArrayList<Sandwich.Condiments> getCondiments(){
        ArrayList<Sandwich.Condiments> condiments = new ArrayList<>();
        System.out.println("What condiments would you like?" +
                "\n1) Mayo" +
                "\n2) Mustard" +
                "\n3) Ketchup" +
                "\n4) Ranch" +
                "\n5) Thousand Islands" +
                "\n6) Vinaigrette" +
                "\n0) No Cheeses");
        ArrayList<String> choices = getChoices();
        for (String choice: choices){
            switch (choice){
                case "1": condiments.add(Sandwich.Condiments.MAYO);
                    break;
                case "2": condiments.add(Sandwich.Condiments.MUSTARD);
                    break;
                case "3": condiments.add(Sandwich.Condiments.KETCHUP);
                    break;
                case "4": condiments.add(Sandwich.Condiments.RANCH);
                    break;
                case "5": condiments.add(Sandwich.Condiments.THOUSAND_ISLANDS);
                    break;
                case "6": condiments.add(Sandwich.Condiments.VINAIGRETTE);
                case "0":
                    break;
                default:
                    System.out.println("Invalid input - ignored");;



            }
        }
        return condiments;
    }
    public ArrayList<Sandwich.Sides> getSides(){
        ArrayList<Sandwich.Sides> sides = new ArrayList<>();
        System.out.println("What sides would you like?" +
                "\n1) Au Jus" +
                "\n2) Sauce" +
                "\n0) No sides");
        ArrayList<String> choices = getChoices();
        for (String choice: choices){
            switch (choice){
                case "1": sides.add(Sandwich.Sides.AU_JUS);
                    break;
                case "2": sides.add(Sandwich.Sides.SAUCE);
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Invalid input - ignored");;



            }
        }
        return sides;
    }

    public boolean askToast(){
        System.out.println("Would you like your sandwich toasted?");
        return getBool();
    }
    //Utilities used on a completed sandwich
    public void showSandwich(Sandwich sandwich){
        System.out.println("---------------------------------------------");
        System.out.println("Bread ---- " + sandwich.getBreadType().readable);
        System.out.println("Size ---- " + sandwich.getBreadSize().readable);
        System.out.println("Meats ----------");
        for (Sandwich.PremiumMeats meat : sandwich.getMeatToppings()){
            System.out.println(meat.readable);
        }
        System.out.println("Extra Meats ----------");
        for (Sandwich.PremiumMeats meat : sandwich.getExtraMeatToppings()){
            System.out.println(meat.readable);
        }
        System.out.println("Cheeses ----------");
        for (Sandwich.PremiumCheese cheese : sandwich.getCheeseToppings()){
            System.out.println(cheese.readable);
        }
        System.out.println("Extra Cheeses ----------");
        for (Sandwich.PremiumCheese cheese : sandwich.getExtraCheeseToppings()){
            System.out.println(cheese.readable);
        }
        System.out.println("Toppings ---------- ");
        for (Sandwich.RegularToppings topping : sandwich.getRegularToppings()){
            System.out.println(topping.readable);
        }
        System.out.println("Extra toppings ----------");
        sandwich.getExtraRegularToppings().stream().map(topping -> topping.readable).forEach(System.out::println);
        System.out.println("Condiments ---------- ");
        sandwich.getCondiments().stream().map(condiment -> condiment.readable).forEach((System.out::println));
        System.out.println("Sides ---------- ");
        sandwich.getSides().stream().map(side -> side.readable).forEach(System.out::println);
        System.out.println("---------------------------------------------");
    }
    public Sandwich editSandwich(Sandwich sandwich){
        String input = "Y";
        String choice;
        while (input.equalsIgnoreCase("Y")) {
            showSandwich(sandwich);
            System.out.println("Would you like to edit your sandwich?" +
                    "\n(Y for yes and anything else for no)");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("Y")){
                System.out.println("Please choose what you would like to edit:" +
                        "\n1) Bread Size" +
                        "\n2) Bread Type" +
                        "\n3) Meat Choice" +
                        "\n4) Extra Meat Choice" +
                        "\n5) Cheese Choice" +
                        "\n6) Extra Cheese Choice" +
                        "\n7) Topping Choice" +
                        "\n8) Extra Topping Choice" +
                        "\n9) Sauce Choice" +
                        "\n10) Side Choice" +
                        "\n11) Toast Preference" +
                        "\n0) Nothing needs to be changed");
                choice = scanner.nextLine();
                switch (choice){
                    case "1":sandwich.setBreadSize(getBreadSize());
                    break;
                    case "2":sandwich.setBreadType(getBreadType());
                    break;
                    case "3":sandwich.setMeatToppings(getPremiumMeats());
                            sandwich.setExtraMeatToppings(fixMeats(sandwich.getMeatToppings(), sandwich.getExtraMeatToppings()));
                            break;
                    case "4":
                        sandwich.setExtraMeatToppings(getExtraMeats(sandwich.getMeatToppings()));
                        break;
                    case "5":sandwich.setCheeseToppings(getPremiumCheeses());
                        sandwich.setExtraCheeseToppings(fixCheese(sandwich.getCheeseToppings(), sandwich.getExtraCheeseToppings()));
                        break;
                    case "6":
                        sandwich.setExtraCheeseToppings(getExtraCheeses(sandwich.getCheeseToppings()));
                        break;
                    case "7":sandwich.setRegularToppings(getToppings());
                        sandwich.setExtraRegularToppings(fixToppings(sandwich.getRegularToppings(), sandwich.getExtraRegularToppings()));
                        break;
                    case "8":
                        sandwich.setExtraRegularToppings(getExtraToppings(sandwich.getRegularToppings()));
                        break;
                    case "9":
                        sandwich.setCondiments(getCondiments());
                        break;
                    case "10":
                        sandwich.setSides(getSides());
                        break;
                    case "11":
                        sandwich.setToasted(askToast());
                    case "0":
                        break;
                    default:
                        System.out.println("Invalid input, please try a valid option");

                }

            }


        }
        return sandwich;
    }





    //functions that remove a topping from the associated extra topping list if they decide they no longer want
    //that topping
    public ArrayList<Sandwich.PremiumMeats> fixMeats(ArrayList<Sandwich.PremiumMeats> meats,
                                                    ArrayList<Sandwich.PremiumMeats> extraMeats) {
        for (int i = 0; i < extraMeats.size(); i++){
            int y = 0;
            for (Sandwich.PremiumMeats meat: meats){
                if (extraMeats.get(i) == meat){
                    y++;
                }
            }
            if (y == 0){
                extraMeats.remove(i);
            }

        }
    return extraMeats;
    }
    public ArrayList<Sandwich.PremiumCheese> fixCheese(ArrayList<Sandwich.PremiumCheese> cheeses,
                                                     ArrayList<Sandwich.PremiumCheese> extraCheeses) {
        for (int i = 0; i < extraCheeses.size(); i++){
            int y = 0;
            for (Sandwich.PremiumCheese cheese : cheeses){
                if (extraCheeses.get(i) == cheese){
                    y++;
                }
            }
            if (y == 0){
                extraCheeses.remove(i);
            }

        }
        return extraCheeses;
    }
    public ArrayList<Sandwich.RegularToppings> fixToppings(ArrayList<Sandwich.RegularToppings> toppings,
                                                       ArrayList<Sandwich.RegularToppings> extraToppings) {
        for (int i = 0; i < extraToppings.size(); i++){
            int y = 0;
            for (Sandwich.RegularToppings topping : toppings){
                if (extraToppings.get(i) == topping){
                    y++;
                }
            }
            if (y == 0){
                extraToppings.remove(i);
            }

        }
        return extraToppings;
    }













    public boolean getBool(){
        boolean choice = false;
        System.out.println("Please input Y for yes and any other key for no.");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("Y")){
            choice = true;
        }
        return choice;
    }


    public ArrayList<String> getChoices(){
        System.out.println("Please input all of your choices, divided by a comma" +
                "\n(1, 3, 4)");
        String baseInput = scanner.nextLine();
        String[] splitInput = baseInput.split(",");
        return Arrays.stream(splitInput).distinct().map(String::trim).collect(Collectors.toCollection(ArrayList::new));
    }
























}
