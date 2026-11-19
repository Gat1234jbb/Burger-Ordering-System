import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Burger selectBurger(Scanner sc) {

        while (true) {

            System.out.println("\n===== BURGER SELECTION =====");
            System.out.println("1. Beef Burger");
            System.out.println("2. Chicken Burger");
            System.out.println("3. Fish Burger");
            System.out.print("Select Burger: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    return BurgerFactory.createBurger("Beef");

                case 2:
                    return BurgerFactory.createBurger("Chicken");

                case 3:
                    return BurgerFactory.createBurger("Fish");

                default:
                    System.out.println("Invalid Selection.");
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Burger burger = selectBurger(sc);

        while (true) {

            System.out.println("\n===== CURRENT ORDER =====");
            System.out.println("Burger: " + burger.getBurgerName());

            System.out.println("\nCurrent Extra Ingredients:");

            ArrayList<Ingredient> extras =
                    burger.getOptionalIngredients();

            if (extras.isEmpty()) {
                System.out.println("None");
            } else {

                for (int i = 0; i < extras.size(); i++) {
                    System.out.println((i + 1) + ". " + extras.get(i).getName());
                }
            }

            System.out.println("\n1. Add Ingredient");
            System.out.println("2. Remove Ingredient");
            System.out.println("3. Clear Order");
            System.out.println("4. Checkout");

            System.out.print("Choose Option: ");

            int option = sc.nextInt();

            switch (option) {

                case 1:

                    ArrayList<Ingredient> available =
                            IngredientRepository.getAvailableIngredients();

                    System.out.println("\nAvailable Ingredients:");

                    for (int i = 0; i < available.size(); i++) {
                        System.out.println((i + 1) + ". " + available.get(i).getName());
                    }

                    System.out.print("Select Ingredient: ");

                    int addChoice = sc.nextInt();

                    if (addChoice >= 1 && addChoice <= available.size()) {

                        boolean added =
                                burger.addIngredient(
                                        available.get(addChoice - 1));

                        if (added) {
                            System.out.println("Ingredient Added.");
                        } else {
                            System.out.println("Ingredient Already Exists.");
                        }
                    }

                    break;

                case 2:

                    if (extras.isEmpty()) {

                        System.out.println("No Removable Ingredients.");
                        break;
                    }

                    System.out.println("\nRemovable Ingredients:");

                    for (int i = 0; i < extras.size(); i++) {
                        System.out.println((i + 1) + ". " + extras.get(i).getName());
                    }

                    System.out.println("0. Return");

                    System.out.print("Select Ingredient: ");

                    int removeChoice = sc.nextInt();

                    if (removeChoice == 0) {
                        break;
                    }

                    if (removeChoice >= 1 && removeChoice <= extras.size()) {

                        burger.removeIngredient(
                                extras.get(removeChoice - 1).getName());

                        System.out.println("Ingredient Removed.");
                    }

                    break;

                case 3:

                    System.out.println("Order Cleared.");

                    burger = selectBurger(sc);

                    break;

                case 4:

                    System.out.print("\nEnter Quantity (1-5): ");

                    int quantity = sc.nextInt();

                    while (quantity < 1 || quantity > 5) {

                        System.out.print("Invalid Quantity. Enter Again (1-5): ");
                        quantity = sc.nextInt();
                    }

                    burger.setQuantity(quantity);

                    System.out.println("\n===== ORDER SUMMARY =====");

                    System.out.println("Burger: " + burger.getBurgerName());

                    System.out.println("\nIngredients:");

                    for (Ingredient ingredient : burger.getIngredients()) {
                        System.out.println("- " + ingredient.getName());
                    }

                    System.out.println("\nQuantity: " + burger.getQuantity());

                    System.out.printf("Total Price: RM %.2f\n",
                            burger.getTotalPrice());

                    System.out.println("Total Calories: "
                            + burger.getTotalCalories());

                    System.out.println("\nThank You!");

                    return;

                default:
                    System.out.println("Invalid Option.");
            }
        }
    }
}