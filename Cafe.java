import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private List<Order> orders;

    public Cafe() {
        this.orders = new ArrayList<>();
    }

    public void createOrder(Order order) {
        orders.add(order);
        System.out.println("Order created for table " + order.getTableNumber());
    }

    public void displayOrderDetails(int tableNumber) {
        for (Order order : orders) {
            if (order.getTableNumber() == tableNumber) {
                System.out.println("Order for table " + tableNumber + ":");
                if (order.getDishes().isEmpty()) {
                    System.out.println("No dishes in this order.");
                } else {
                    for (Dish dish : order.getDishes()) {
                        System.out.println("- " + dish);
                    }
                    System.out.println("Total: " + order.calculateTotal() + ".руб");
                    // Вывод статистики
                    System.out.println("Total dishes: " + order.getDishes().size());
                    double averagePrice = order.getDishes().isEmpty() ? 0 : order.calculateTotal() / order.getDishes().size();
                    System.out.println("Average dish price: " + String.format("%.2f", averagePrice) + ".руб");
                }
                return;
            }
        }
        System.out.println("No order found for table " + tableNumber);
    }
}