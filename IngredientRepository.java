import java.util.ArrayList;

public class IngredientRepository {

    public static ArrayList<Ingredient> getAvailableIngredients() {

        ArrayList<Ingredient> ingredients = new ArrayList<>();

        ingredients.add(new Ingredient("Cheese", 1.50, 80, "Extra", false));
        ingredients.add(new Ingredient("Lettuce", 0.50, 10, "Vegetable", false));
        ingredients.add(new Ingredient("Tomato", 0.70, 15, "Vegetable", false));
        ingredients.add(new Ingredient("Onion", 0.40, 10, "Vegetable", false));
        ingredients.add(new Ingredient("Egg", 1.20, 90, "Extra", false));
        ingredients.add(new Ingredient("Bacon", 2.00, 150, "Extra", false));

        return ingredients;
    }
}