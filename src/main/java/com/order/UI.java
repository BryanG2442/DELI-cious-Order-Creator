package com.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UI {
    private static Scanner scanner = new Scanner(System.in);


    public void greetingScreen(){
        System.out.println("Welcome to the DELI-cious application.\n" +
                "Please input the number of your selection: " +
                "\n1) Make a new order");
    }

    public void orderTaker(){
        System.out.println("Welcome to the order creator. We will now take your order.");

        String choice = " ";
        while (!choice.equalsIgnoreCase("Y")){
            ArrayList<Sandwich> sandwiches = new ArrayList<>();
            sandwiches.add(makeSandwich());
            System.out.println("Would you like to make another sandwich?" +
                    "\nPlease input \"Y\" for yes, or any other key for no.");
        }


    }


    public Sandwich makeSandwich(){
        Sandwich.BreadSize breadSize = getBreadSize();
        Sandwich.BreadType breadType = getBreadType();



    }


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
        System.out.println("What size of bread would you like?" +
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



    }














    public ArrayList<String> getChoices(){
        System.out.println("Please input all of your choices, divided by a comma" +
                "\n(1, 3, 4)");
        String baseInput = scanner.nextLine();
        String[] splitInput = baseInput.split(",");
        return Arrays.stream(splitInput).distinct().map(String::trim).collect(Collectors.toCollection(ArrayList::new));
    }
























}
