package com.empresa.proyecto.functional.util.designpatterns;

import java.util.function.Function;

public class DecoratorPattern {
    public static void main(String[] args) {
        Burger myOrder = new BurgerShop(burger -> burger.addCheese())
                .use(
                        new BurgerShop(burger -> burger.addVegies())
                                .use(
                                        new Burger()
                                )
                );
        System.out.println(myOrder);
    }
}

class BurgerShop {
    Function<Burger, Burger> decoration;

    public BurgerShop(Function<Burger, Burger> decoration) {
        this.decoration = decoration;
    }

    public Burger use(Burger baseBurger) {
        System.out.println("Base burger: " + baseBurger);
        return decoration.apply(baseBurger);
    }
}

class Burger {
    private String burgerType;

    public Burger() {
        this.burgerType = "";
    }

    public Burger(String type) {
        this.burgerType = type;
    }

    public Burger addVegies() {
        System.out.println("Adding vegies to the burger");
        return new Burger(this.burgerType += "Vegie ");
    }

    public Burger addCheese() {
        System.out.println("Adding cheese to the burger");
        return new Burger(this.burgerType += "Cheese ");
    }

    public String toString() {
        return String.format("%s", burgerType + "burger");
    }
}
