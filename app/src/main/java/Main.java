package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import dish.Dish;
import order.Order;
import cafe.Cafe;
//test
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        logger.info("Starting Cafe Order System");
        Cafe cafe = new Cafe();

        // Создаем блюда
        Dish dish1 = new Dish("Pasta Carbonara", 12.50);
        Dish dish2 = new Dish("Caesar Salad", 8.75);
        Dish dish3 = new Dish("Tiramisu", 6.25);
        Dish dish4 = new Dish("Pasta Carbonara", 12.50); // Дубликат

        // Создаем заказ для стола 1
        Order order1 = new Order(1);
        order1.addDish(dish1);
        order1.addDish(dish3);
        order1.addDish(dish4); // Проверка дубликата
        cafe.createOrder(order1);

        // Создаем заказ для стола 2
        Order order2 = new Order(2);
        order2.addDish(dish2);
        order2.addDish(dish3);
        cafe.createOrder(order2);

        // Выводим информацию о заказах
        logger.info("Details for table 1:");
        cafe.displayOrderDetails(1);

        // Удаляем блюдо из заказа
        logger.info("Removing 'Tiramisu' from table 1:");
        order1.removeDish("Tiramisu");

        // Выводим обновленную информацию
        logger.info("Updated details for table 1:");
        cafe.displayOrderDetails(1);

        logger.info("Details for table 2:");
        cafe.displayOrderDetails(2);

        logger.info("Cafe Order System finished");
    }
}