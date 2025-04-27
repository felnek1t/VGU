import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private static final Logger logger = LoggerFactory.getLogger(Cafe.class);
    private List<Order> orders;

    public Cafe() {
        this.orders = new ArrayList<>();
    }

    public void createOrder(Order order) {
        orders.add(order);
        logger.info("Order created for table {}", order.getTableNumber());
    }

    public void displayOrderDetails(int tableNumber) {
        for (Order order : orders) {
            if (order.getTableNumber() == tableNumber) {
                logger.info("Order for table {}:", tableNumber);
                if (order.getDishes().isEmpty()) {
                    logger.info("No dishes in this order.");
                } else {
                    for (Dish dish : order.getDishes()) {
                        logger.info("- {}", dish);
                    }
                    logger.info("Total: {}.руб", order.calculateTotal());
                    // Вывод статистики
                    logger.info("Total dishes: {}", order.getDishes().size());
                    double averagePrice = order.getDishes().isEmpty() ? 0 : order.calculateTotal() / order.getDishes().size();
                    logger.info("Average dish price: {}.руб", String.format("%.2f", averagePrice));
                }
                return;
            }
        }
        logger.warn("No order found for table {}", tableNumber);
    }
}