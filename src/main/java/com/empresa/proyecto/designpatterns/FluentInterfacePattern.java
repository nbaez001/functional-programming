package com.empresa.proyecto.designpatterns;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FluentInterfacePattern {
    public static void main(String[] args) {
        Order.place(order -> order
                .add("Shoes")
                .add("Headphones")
                .deliveryAt("Street no 45, Jodhput")
        );
    }
}

class Order {
    private List<String> cart = new ArrayList<>();
    private String address = "";

    public Order() {
    }

    public Order(List<String> cart, String address) {
        this.cart = cart;
        this.address = address;
    }

    public Order add(String item) {
        cart.add(item);
        System.out.println(item + " added to the cart");
        return new Order(this.cart, this.address);
    }

    public Order deliveryAt(String location) {
        this.address = location;
        System.out.println("The delivery address set by you is '" + location + "'");
        return new Order(this.cart, this.address);
    }

    public static void place(Function<Order, Order> function) {
        Order order = new Order();
        order = function.apply(order);
        System.out.println("Order placed");
        System.out.println(order.cart.size() + " items ordered by you will be delivered at " + order.address + " by tomorrow");
    }
}
