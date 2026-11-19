public class Ingredient {

    private String name;
    private double price;
    private int calories;
    private String category;
    private boolean required;

    public Ingredient(String name, double price, int calories, String category, boolean required) {
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.category = category;
        this.required = required;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getCalories() {
        return calories;
    }

    public String getCategory() {
        return category;
    }

    public boolean isRequired() {
        return required;
    }
}