public class BurgerFactory {

    public static Burger createBurger(String type) {

        Burger burger = new Burger(type + " Burger");

        burger.addIngredient(
            new Ingredient("Bun", 2.00, 120, "Bread", true)
        );

        switch (type.toLowerCase()) {

            case "beef":
                burger.addIngredient(
                    new Ingredient("Beef Patty", 6.00, 250, "Patty", true)
                );
                break;

            case "chicken":
                burger.addIngredient(
                    new Ingredient("Chicken Patty", 5.50, 220, "Patty", true)
                );
                break;

            case "fish":
                burger.addIngredient(
                    new Ingredient("Fish Patty", 5.00, 200, "Patty", true)
                );
                break;

            default:
                return null;
        }

        return burger;
    }
}