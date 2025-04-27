package core.src.main.java.cafe;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import core.src.main.java.order.Order;
import core.src.main.java.dish.Dish;

public class Cafe {
    private static final Logger logger = LogManager.getLogger(Cafe.class);
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
                    logger.info("Total: {}.rub", order.calculateTotal());
                    // Вывод статистики
                    logger.info("Total dishes: {}", order.getDishes().size());
                    double averagePrice = order.getDishes().isEmpty() ? 0 : order.calculateTotal() / order.getDishes().size();
                    logger.info("Average dish price: {}.rub", String.format("%.2f", averagePrice));
                }
                return;
            }
        }
        logger.warn("No order found for table {}", tableNumber);
    }
}