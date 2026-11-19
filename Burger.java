import java.util.ArrayList;

public class Burger {

    private String burgerName;
    private ArrayList<Ingredient> ingredients;
    private int quantity;

    public Burger(String burgerName) {
        this.burgerName = burgerName;
        this.ingredients = new ArrayList<>();
        quantity = 1;
    }

    public String getBurgerName() {
        return burgerName;
    }

    public int getQuantity() {
        return quantity;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public ArrayList<Ingredient> getOptionalIngredients() {

        ArrayList<Ingredient> optionalIngredients = new ArrayList<>();

        for (Ingredient ingredient : ingredients) {
            if (!ingredient.isRequired()) {
                optionalIngredients.add(ingredient);
            }
        }

        return optionalIngredients;
    }

    public boolean addIngredient(Ingredient ingredient) {

        for (Ingredient current : ingredients) {

            if (current.getName().equalsIgnoreCase(ingredient.getName())) {
                return false;
            }
        }

        ingredients.add(ingredient);
        return true;
    }

    public boolean removeIngredient(String ingredientName) {

        for (Ingredient ingredient : ingredients) {

            if (ingredient.getName().equalsIgnoreCase(ingredientName)) {

                if (ingredient.isRequired()) {
                    return false;
                }

                ingredients.remove(ingredient);
                return true;
            }
        }

        return false;
    }

    public void setQuantity(int quantity) {

        if (quantity >= 1 && quantity <= 5) {
            this.quantity = quantity;
        }
    }

    public double calculatePrice() {

        double total = 0;

        for (Ingredient ingredient : ingredients) {
            total += ingredient.getPrice();
        }

        return total;
    }

    public int calculateCalories() {

        int total = 0;

        for (Ingredient ingredient : ingredients) {
            total += ingredient.getCalories();
        }

        return total;
    }

    public double getTotalPrice() {
        return calculatePrice() * quantity;
    }

    public int getTotalCalories() {
        return calculateCalories() * quantity;
    }
}