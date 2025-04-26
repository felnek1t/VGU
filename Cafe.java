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
                for (Dish dish : order.getDishes()) {
                    System.out.println("- " + dish);
                }
                System.out.println("Total: " + order.calculateTotal()+".руб");
                return;
            }
        }
        System.out.println("No order found for table " + tableNumber);
    }
}