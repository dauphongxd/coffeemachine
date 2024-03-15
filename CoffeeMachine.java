package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static Scanner sc = new Scanner(System.in);

    int waterInput = 400;
    int milkInput = 540;
    int coffeeBeansInput = 120;
    int cupAvailable = 9;
    int money = 550;


    public void processInput(String input) {
        switch (input) {
            case "buy" -> chooseCoffee();
            case "fill" -> filling();
            case "take" -> takeMoney();
            case "remaining" -> printStatus();
            default -> System.out.println("Invalid action!");
        }
    }

    public void chooseCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String input = sc.nextLine();
        switch (input) {
            case "1" -> espresso();
            case "2" -> latte();
            case "3" -> cappuccino();
            case "back" -> {
                return;
            }
        }
    }

    public void espresso() {
        int waterNeeded = 250;
        int coffeeNeeded = 16;
        int price = 4;
        int milkNeeded = 0;
        checkInventory(waterNeeded, milkNeeded, coffeeNeeded, price);

    }

    public void latte() {
        int waterNeeded = 350;
        int milkNeeded = 75;
        int coffeeNeeded = 20;
        int price = 7;
        checkInventory(waterNeeded, milkNeeded, coffeeNeeded, price);
    }

    public void cappuccino() {
        int waterNeeded = 200;
        int milkNeeded = 100;
        int coffeeNeeded = 12;
        int price = 6;
        checkInventory(waterNeeded, milkNeeded, coffeeNeeded, price);
    }

    public void checkInventory(int waterNeeded, int milkNeeded, int coffeeNeeded, int price) {
        if (waterInput >= waterNeeded && (milkNeeded == 0 || milkInput >= milkNeeded) && coffeeBeansInput >= coffeeNeeded) {
            System.out.println("I have enough resources, making you a coffee");
            waterInput -= waterNeeded;
            if (milkNeeded > 0 ) {
               milkInput -= milkNeeded;
            }
            coffeeBeansInput -= coffeeNeeded;
            cupAvailable--;
            money += price;
        } else {
            if (waterInput < waterNeeded) System.out.println("Sorry, not enough water!");
            if (milkNeeded > 0 && milkInput < milkNeeded) System.out.println("Sorry, not enough milk!");
            if (coffeeBeansInput < coffeeNeeded) System.out.println("Sorry, not enough coffee!");
            if (cupAvailable <= 0) System.out.println("Sorry, not enough disposable cups!");
        }
    }

    public void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;

    }

    public void printStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(waterInput + " ml of water");
        System.out.println(milkInput + " ml of milk");
        System.out.println(coffeeBeansInput + " g of coffee beans");
        System.out.println(cupAvailable + " disposable cups");
        System.out.println("$" + money + " of money");

    }

    public void filling() {
        System.out.println("Write how many ml of water you want to add: ");
        waterInput += Integer.parseInt(sc.nextLine());
        System.out.println("Write how many ml of milk you want to add: ");
        milkInput += Integer.parseInt(sc.nextLine());
        System.out.println("Write how many grams of coffee beans you want to add: ");
        coffeeBeansInput += Integer.parseInt(sc.nextLine());
        System.out.println("Write how many disposable cups you want to add: ");
        cupAvailable += Integer.parseInt(sc.nextLine());

    }

    public static void main(String[] args) {

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = sc.nextLine();
            if(action.equals("exit")){
                break;
            }
            coffeeMachine.processInput(action);
        }

    }


}
