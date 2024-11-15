package com.order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    public void writeReceipt(Order order){
        LocalDateTime timeNow = LocalDateTime.now();
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        DateTimeFormatter timeFormat2 = DateTimeFormatter.ofPattern("yyyy/MM/dd  hh:mm:ss");

        try {
            FileWriter fileWriter = new FileWriter("src/" + timeNow.format(timeFormat) + ".txt" );
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(timeNow.format(timeFormat2) + "\n\n");
            bufferedWriter.write("Sandwiches:");
            for (Sandwich sandwich: order.getSandwiches()){
                bufferedWriter.write(sandwichOutput(sandwich));
            }
            bufferedWriter.write("\nDrink Size: " + order.getDrinkSize().readable
            + "  --------- " + order.getDrinkSize().getDrinkPrice());
            bufferedWriter.write("\nDrink Flavor: " + order.getDrinkFlavors().readable);
            bufferedWriter.write("\nChip Flavor: " + order.getChipFlavors().readable + "  --------- "
            + order.getChipFlavors().getPrice());
            bufferedWriter.write("\n\n\nOrder Total   -------------- " + order.getOrderPrice());


            bufferedWriter.close();

        } catch (Exception e) {
            System.out.println("Some sort of error has occurred.");
        }

    }
    public String sandwichOutput (Sandwich sandwich){
        StringBuilder output = new StringBuilder();
        output.append("--------------------------\n");
        output.append("Bread Size: ").append(sandwich.getBreadSize().readable).append(" --------- $").append(sandwich.getBreadSize().getBasePrice()).append("\n");
        output.append("Bread Type: ").append(sandwich.getBreadType().readable).append("\n");
        output.append("Meats ----------\n");
        for (Sandwich.PremiumMeats meat : sandwich.getMeatToppings()){
            output.append(meat.readable).append("  --------- $").append(sandwich.getBreadSize().getMeatPrice()).append("\n");
        }
        output.append("Extra meats  ---------\n");
        for (Sandwich.PremiumMeats extraMeat : sandwich.getExtraMeatToppings()){
            output.append(extraMeat.readable).append(" --------- $").append(sandwich.getBreadSize().getExtraMeatPrice()).append("\n");
        }
        output.append("Cheeses ----------\n");
        for (Sandwich.PremiumCheese cheese : sandwich.getCheeseToppings()){
            output.append(cheese.readable).append("  --------- $").append(sandwich.getBreadSize().getCheesePrice()).append("\n");
        }
        output.append("Extra cheeses  ---------\n");
        for (Sandwich.PremiumCheese extraCheese : sandwich.getExtraCheeseToppings()){
            output.append(extraCheese.readable).append(" --------- $").append(sandwich.getBreadSize().getExtraCheesePrice()).append("\n");
        }
        output.append("Toppings ----------\n");
        for (Sandwich.RegularToppings topping : sandwich.getRegularToppings()){
            output.append(topping.readable).append("\n");
        }
        output.append("Extra toppings  ---------\n");
        for (Sandwich.RegularToppings extraTopping : sandwich.getExtraRegularToppings()){
            output.append(extraTopping.readable).append("\n");
        }
        output.append("Condiments  ---------\n");
        for (Sandwich.Condiments condiments : sandwich.getCondiments()){
            output.append(condiments.readable).append("\n");
        }
        output.append("Sides  ---------\n");
        for (Sandwich.Sides side : sandwich.getSides()) {
            output.append(side.readable).append("\n");
        }
        output.append("Sandwich total ------------------ $").append(sandwich.getSandwichPrice()).append("\n");






        return output.toString();


    }







}
