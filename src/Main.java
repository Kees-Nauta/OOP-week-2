import java.util.ArrayList;
import java.util.Scanner;

class Cupcake {
    public double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void type() {
        System.out.println("A basic, generic cupcake, with vanilla frosting");
    }
}

class RedVelvet extends Cupcake {
    @Override
    public void type() {
        System.out.println("A red velvet based cupcake, with cream cheese frosting.");
    }
}

class Chocolate extends Cupcake {
    @Override
    public void type() {
        System.out.println("A chocolate based cupcake, with chocolate frosting.");
    }
}

class Drink {
    public double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void type() {
        System.out.println("A generic drink.");
    }
}

class Soda extends Drink {
    @Override
    public void type() {
        System.out.println("A bottle of soda.");
    }
}

class Milk extends Drink {
    @Override
    public void type() {
        System.out.println("A bottle of milk.");
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Cupcake> cupcakeMenu = new ArrayList<>();

        Cupcake cupcake = new Cupcake();
        RedVelvet redVelvet = new RedVelvet();
        Chocolate chocolate = new Chocolate();


        Scanner input = new Scanner(System.in);

        System.out.println("We are in the middle of creating the cupcake menu. We currently have three cupcakes on the menu but we need to decide on pricing.");

        System.out.println("We are deciding on the price for our standard cupcake. Here is the description:");
        cupcake.type();

        System.out.println("How much would you like to charge for the normal cupcake? (Input a numerical number taken to 2 decimal places)");
        String priceText = input.nextLine();
        double price = Double.parseDouble(priceText);
        cupcake.setPrice(price);

        System.out.println("We are deciding on the price for our Red Velvet cupcake. Here is the description:");
        redVelvet.type();

        System.out.println("How much would you like to charge for the Red Velvet cupcake? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        redVelvet.setPrice(price);

        System.out.println("We are deciding on the price for our Chocolate cupcake. Here is the description:");
        chocolate.type();

        System.out.println("How much would you like to charge for the Chocolate cupcake? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        chocolate.setPrice(price);

        cupcakeMenu.add(cupcake);
        cupcakeMenu.add(redVelvet);
        cupcakeMenu.add(chocolate);

        ArrayList<Drink> drinkMenu = new ArrayList<>();

        Drink water = new Drink();
        Soda soda = new Soda();
        Milk milk = new Milk();

        System.out.println("We are in the middle of creating the drink menu. We currently have three drinks on the menu but we need to decide on pricing.");

        setPriceForDrink(input, water);
        setPriceForDrink(input, soda);
        setPriceForDrink(input, milk);

        drinkMenu.add(water);
        drinkMenu.add(soda);
        drinkMenu.add(milk);

        input.close();

        System.out.println("Menu:");
        System.out.println("Cupcakes:");
        for (Cupcake c : cupcakeMenu) {
            c.type();
            System.out.println("Price: $" + c.getPrice());
            System.out.println();
        }
        System.out.println("Drinks:");
        for (Drink d : drinkMenu) {
            d.type();
            System.out.println("Price: $" + d.getPrice());
            System.out.println();
        }
        new Order(cupcakeMenu, drinkMenu);
    }

    private static void setPriceForDrink(Scanner input, Drink drink) {
        System.out.println("We are deciding on the price for our drink. Here is the description:");
        drink.type();
        System.out.println("How much would you like to charge for the drink? (Input a numerical number taken to 2 decimal places)");
        String priceText = input.nextLine();
        double price = Double.parseDouble(priceText);
        drink.setPrice(price);
    }
}
