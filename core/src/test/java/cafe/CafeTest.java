package cafetest;

import cafe.Cafe;
import order.Order;
import dish.Dish;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CafeTest {
    private Cafe cafe;
    private Order order;

    @BeforeEach
    void setUp() {
        cafe = new Cafe();
        order = Mockito.mock(Order.class);
    }

    @Test
    void testCreateOrder() {
        Mockito.when(order.getTableNumber()).thenReturn(1);
        cafe.createOrder(order);
        assertEquals(1, cafe.getOrdersCount());
    }

    @Test
    void testDisplayOrderDetails_EmptyOrder() {
        Mockito.when(order.getTableNumber()).thenReturn(0);
        Mockito.when(order.getDishes()).thenReturn(Collections.emptyList());
        cafe.createOrder(order);
        cafe.displayOrderDetails(1);
        veryfy(order).geDishes();
    }

    @Test
    void testDisplayOrderDetails_WithDishes() {
        Mockito.when(order.getTableNumber()).thenReturn(1);
        Mockito.when(order.calculateTotal()).thenReturn(18.0);
        cafe.createOrder(order);
        cafe.displayOrderDetails(1);
    }
}