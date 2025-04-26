/*
Постановка задачи:
Создать программу для управления заказами в кафе. Программа должна:
- Позволять создавать заказы с указанием номера стола и добавлять в них блюда.
- Каждое блюдо имеет название и цену.
- Рассчитывать общую стоимость заказа.
- Выводить информацию о заказе.
- Использовать классы Dish, Order, Cafe и Main для реализации функционала.
*/
public class Main {
    public static void main(String[] args) {
        Cafe cafe = new Cafe();

        // Создаем блюда
        Dish dish1 = new Dish("Pasta Carbonara", 12.50);
        Dish dish2 = new Dish("Caesar Salad", 8.75);
        Dish dish3 = new Dish("Tiramisu", 6.25);

        // Создаем заказ для стола 1
        Order order1 = new Order(1);
        order1.addDish(dish1);
        order1.addDish(dish3);
        cafe.createOrder(order1);

        // Создаем заказ для стола 2
        Order order2 = new Order(2);
        order2.addDish(dish2);
        order2.addDish(dish3);
        cafe.createOrder(order2);

        // Выводим информацию о заказах
        cafe.displayOrderDetails(1);
        cafe.displayOrderDetails(2);
    }
}