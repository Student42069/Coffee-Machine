package machine;

import java.util.Scanner;

import static java.lang.System.exit;

public class Machine {

    private int cups = 9;
    private int water = 400;
    private int milk = 540;
    private int coffee = 120;
    private int money = 550;

    private final Scanner sc = new Scanner(System.in);

    private void addWater() {
        System.out.println("Write how many ml of water you want to add: ");
        this.water += this.sc.nextInt();
    }

    private void addMilk() {
        System.out.println("Write how many ml of milk you want to add: ");
        this.milk += this.sc.nextInt();
    }

    private void addCoffee() {
        System.out.println("Write how many grams of coffee beans you want to add:");
        this.coffee += this.sc.nextInt();
    }

    private void addCups() {
        System.out.println("Write how many disposable cups of coffee you want to add:");
        this.cups += this.sc.nextInt();
    }

    public void run() {
        while(true) {
            String action = chooseAction();
            switch (action) {
                case "buy":
                    chooseCoffee();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    print();
                    break;
                case "exit":
                    exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    private void take() {
        System.out.println("I gave you $" + this.money);
        this.money = 0;
    }

    private void fill() {
        addWater();
        addMilk();
        addCoffee();
        addCups();
    }

    private void chooseCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String coffeeChoice = sc.nextLine();
        switch (coffeeChoice){
            case "1":
                choiceEspresso();
                break;
            case "2":
                choiceLatte();
                break;
            case "3":
                choiceCappuccino();
                break;
            case "back":
                break;
        }
    }

    private void choiceCappuccino() {
        this.cups--;
        this.water -= 200;
        this.milk -= 100;
        this.coffee -= 12;
        this.money += 6;
        String isEnought = verifyQuantities();
        if (isEnought.equals("good")){
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            System.out.println("Sorry, not enough "+isEnought+"!");
            this.cups++;
            this.water += 200;
            this.milk += 100;
            this.coffee += 12;
            this.money -= 6;
        }
    }

    private String verifyQuantities() {
        if(this.cups < 0){
            return "cups";
        } else if(this.water < 0){
            return "water";
        }else if(this.milk < 0){
            return "milk";
        }else if(this.coffee < 0){
            return "coffee";
        } else {
            return "good";
        }
    }

    private void choiceLatte() {
        this.cups--;
        this.water -= 350;
        this.milk -= 75;
        this.coffee -= 20;
        this.money += 7;
        String isEnought = verifyQuantities();
        if (isEnought.equals("good")){
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            System.out.println("Sorry, not enough "+isEnought+"!");
            this.cups++;
            this.water += 350;
            this.milk += 75;
            this.coffee += 20;
            this.money -= 7;
        }
    }

    private void choiceEspresso() {
        this.cups--;
        this.water -= 250;
        this.coffee -= 16;
        this.money += 4;
        String isEnought = verifyQuantities();
        if (isEnought.equals("good")){
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            System.out.println("Sorry, not enough "+isEnought+"!");
            this.cups++;
            this.water += 250;
            this.coffee += 16;
            this.money -= 4;
        }
    }

    private String chooseAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        return this.sc.nextLine();
    }

    private void print(){
        System.out.println("The coffee machine has:\n" +
                this.water + " ml of water\n" +
                this.milk + " ml of milk\n" +
                this.coffee + " g of coffee beans\n" +
                this.cups + " disposable cups\n" +
                "$"+this.money+" of money");
    }
}
