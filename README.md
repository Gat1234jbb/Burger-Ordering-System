# Burger Ordering System

## Project Description

The Burger Ordering System is a Java application developed using Object-Oriented Programming (OOP) concepts. The system allows customers to select a burger type, customize ingredients, manage orders, calculate prices and calories, and generate an order summary.

This project includes both a console-based version and a JavaFX graphical user interface (GUI).

---

## Features

- Select a burger type:
  - Beef Burger
  - Chicken Burger
  - Fish Burger

- Add optional ingredients:
  - Cheese
  - Lettuce
  - Tomato
  - Onion
  - Egg
  - Bacon

- Remove optional ingredients

- Prevent duplicate ingredients

- Protect required ingredients (Bun and Patty)

- Set quantity from 1 to 5

- Calculate total price

- Calculate total calories

- Clear current order

- Display order summary

---

## Classes

### Ingredient
Stores ingredient information:
- Name
- Price
- Calories
- Category
- Required Status

### Burger
Handles:
- Ingredient management
- Quantity management
- Price calculation
- Calorie calculation

### BurgerFactory
Creates burger objects with their default ingredients.

### IngredientRepository
Stores all available optional ingredients.

### Main
Provides the console-based menu system.

### BurgerOrderingApp
Provides the JavaFX graphical user interface.

---

## Object-Oriented Programming Concepts

### Encapsulation
Class attributes are declared as private and accessed using public getter methods.

### Composition
A Burger object contains multiple Ingredient objects.

### Object Passing
Ingredient objects are passed as parameters to methods such as addIngredient().

### Object Returning
BurgerFactory returns Burger objects through the createBurger() method.

---

## Requirements

- Java JDK 8 or above
- JavaFX SDK

---

## How to Run

### Console Version

Run:

```java
Main.java
```

### JavaFX GUI Version

Run:

```java
BurgerOrderingApp.java
```

---

## Sample Functions

- Select Burger
- Add Ingredient
- Remove Ingredient
- Clear Order
- Checkout
- View Order Summary

---

## Author

Soh Heng Yi

---

## Course

Software Development Assignment
