import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class BurgerOrderingApp extends Application {

    private Burger currentBurger;

    private ComboBox<String> burgerBox;
    private ListView<String> availableList;
    private ListView<String> currentList;
    private Spinner<Integer> quantitySpinner;

    private Label priceLabel;
    private Label calorieLabel;

    @Override
    public void start(Stage stage) {

        currentBurger = BurgerFactory.createBurger("Beef");

        Label titleLabel = new Label("Burger Ordering System");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        burgerBox = new ComboBox<>();
        burgerBox.getItems().addAll("Beef", "Chicken", "Fish");
        burgerBox.setValue("Beef");

        availableList = new ListView<>();
        currentList = new ListView<>();

        quantitySpinner = new Spinner<>(1, 5, 1);

        Button addButton = new Button("Add Ingredient");
        Button removeButton = new Button("Remove Ingredient");
        Button clearButton = new Button("Clear Order");
        Button checkoutButton = new Button("Checkout");

        priceLabel = new Label("Total Price: RM 0.00");
        calorieLabel = new Label("Total Calories: 0");

        loadAvailableIngredients();
        refreshCurrentIngredients();

        burgerBox.setOnAction(e -> {
            currentBurger = BurgerFactory.createBurger(burgerBox.getValue());
            quantitySpinner.getValueFactory().setValue(1);
            refreshCurrentIngredients();
            resetSummary();
        });

        addButton.setOnAction(e -> {

            String selected =
                    availableList.getSelectionModel().getSelectedItem();

            if (selected == null) {
                return;
            }

            for (Ingredient ingredient :
                    IngredientRepository.getAvailableIngredients()) {

                if (ingredient.getName().equals(selected)) {

                    boolean added =
                            currentBurger.addIngredient(ingredient);

                    if (!added) {

                        showAlert(
                                "Ingredient already exists."
                        );
                    }

                    refreshCurrentIngredients();
                    break;
                }
            }
        });

        removeButton.setOnAction(e -> {

            String selected =
                    currentList.getSelectionModel().getSelectedItem();

            if (selected == null) {
                return;
            }

            boolean removed =
                    currentBurger.removeIngredient(selected);

            if (!removed) {

                showAlert(
                        "Ingredient cannot be removed."
                );
            }

            refreshCurrentIngredients();
        });

        clearButton.setOnAction(e -> {

            burgerBox.setValue("Beef");

            currentBurger =
                    BurgerFactory.createBurger("Beef");

            quantitySpinner
                    .getValueFactory()
                    .setValue(1);

            refreshCurrentIngredients();
            resetSummary();
        });

        checkoutButton.setOnAction(e -> {

            currentBurger.setQuantity(
                    quantitySpinner.getValue()
            );

            priceLabel.setText(
                    String.format(
                            "Total Price: RM %.2f",
                            currentBurger.getTotalPrice()
                    )
            );

            calorieLabel.setText(
                    "Total Calories: "
                            + currentBurger.getTotalCalories()
            );
        });

        VBox leftBox = new VBox(
                10,
                new Label("Available Ingredients"),
                availableList,
                addButton
        );

        VBox rightBox = new VBox(
                10,
                new Label("Current Ingredients"),
                currentList,
                removeButton
        );

        HBox ingredientBox = new HBox(
                20,
                leftBox,
                rightBox
        );

        VBox root = new VBox(
                15,
                titleLabel,
                new Label("Burger Type"),
                burgerBox,
                ingredientBox,
                new Label("Quantity"),
                quantitySpinner,
                priceLabel,
                calorieLabel,
                clearButton,
                checkoutButton
        );

        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 700, 600);

        stage.setTitle("Burger Ordering System");
        stage.setScene(scene);
        stage.show();
    }

    private void loadAvailableIngredients() {

    availableList.getItems().clear();

    for (Ingredient ingredient :
            IngredientRepository.getAvailableIngredients()) {

        availableList.getItems().add(
                ingredient.getName());
    }
}

    private void refreshCurrentIngredients() {

        currentList.getItems().clear();

        for (Ingredient ingredient :
                currentBurger.getOptionalIngredients()) {

            currentList.getItems().add(
                    ingredient.getName()
            );
        }
    }

    private void resetSummary() {

        priceLabel.setText(
                "Total Price: RM 0.00"
        );

        calorieLabel.setText(
                "Total Calories: 0"
        );
    }

    private void showAlert(String message) {

        Alert alert = new Alert(
                Alert.AlertType.INFORMATION
        );

        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}