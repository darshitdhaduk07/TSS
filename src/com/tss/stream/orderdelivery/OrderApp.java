package com.tss.stream.orderdelivery;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderApp {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Jayesh", "Electronics", Status.PLACED, 45000.00, 1),
                new Order("Sonia", "Electronics", Status.SHIPPED, 1500.00, 2),
                new Order("Rahul", "Grocery", Status.DELIVERED, 250.00, 10),
                new Order("Ravi", "Clothing", Status.PLACED, 1200.00, 3),
                new Order("Jayesh", "Electronics", Status.CANCELLED, 30000.00, 1),
                new Order("Neha", "Clothing", Status.SHIPPED, 2200.00, 2),
                new Order("Pooja", "Grocery", Status.DELIVERED, 150.00, 20),
                new Order("Ravi", "Furniture", Status.PLACED, 18000.00, 1),
                new Order("Jayesh", "Furniture", Status.DELIVERED, 25000.00, 1),
                new Order("Sonia", "Grocery", Status.CANCELLED, 300.00, 5),
                new Order("Ravi", "Furniture", Status.PLACED, 18000.00, 1)
                );

        System.out.println("All order form Jayesh: ");
        orders.stream()
                .filter(order -> order.getCustomerName().equals("Jayesh"))
                .forEach(System.out::println);

        System.out.println("\n\n");

        System.out.println("Only Delivered Orders: ");
        orders.stream()
                .filter(order -> order.getStatus() == Status.DELIVERED)
                .forEach(System.out::println);

        System.out.println("\n\n");


        System.out.println("All category without duplicate: ");

        orders.stream()
                .map(Order::getProductCategory)
                .distinct()
                .forEach(System.out::println);

        System.out.println("\n\n");

        double pricePerUnit = orders.stream()
                .filter(order -> order.getStatus() == Status.SHIPPED)
                .map(order -> order.getPricePerUint())
                .reduce(0.0, Double::sum);

        double quantity = orders.stream()
                .filter(order -> order.getStatus() == Status.SHIPPED)
                .map(order -> order.getQuantity())
                .reduce(0, Integer::sum);

        System.out.println("total Rev: " + pricePerUnit * quantity);

        System.out.println("\n\n");



        float avg = (float) orders.stream()
                .filter(order -> order.getProductCategory().equals("Electronics"))
                .mapToInt(Order::getQuantity)
                .average()
                .orElse(0.0);
        System.out.println("Avg of Electronic items: "+avg);


        System.out.println("\n\n");


        System.out.println("Order with Highest value: ");
        orders.stream()
                .filter(order -> order.getStatus() != Status.CANCELLED)
                .max(Comparator.comparing(
                        o -> o.getQuantity() * o.getPricePerUint()
                ))
                .ifPresent(System.out::println);


        System.out.println("\n\n");


        System.out.println("Grouping order by status");

        orders.stream()
                .collect(
                        Collectors.groupingBy(
                                Order::getStatus,
                                Collectors.counting())
                )
                .forEach((s,c) -> System.out.println(s + " : " + c));



        System.out.println("\n\n");

        System.out.println("Customer with more than two order: ");

        Map<String, List<Order>> listoforderbybuyer = orders.stream()
                .filter(order -> order.getStatus() == Status.PLACED)
                .collect(Collectors.groupingBy(Order::getCustomerName));

        listoforderbybuyer.forEach((name, orderList) -> {
            if(orderList.size() > 2)
                System.out.println(name);
        });

        System.out.println("\n\n");


        System.out.println("Product sort in DESC with total value(top 3): ");
        orders.stream()
                .sorted(Comparator.comparing(Order::getTotalValue).reversed())
                .limit(3)
                .forEach(System.out::println);

        System.out.println("\n\n");


        System.out.println("All order with Clothing category");
        orders.stream()
                .filter(order -> order.getProductCategory().equals("Clothing")&& order.getQuantity() < 10)
                .forEach(System.out::println);







    }
}
