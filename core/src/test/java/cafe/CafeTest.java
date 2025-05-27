package cafetest;

import cafe.Cafe;
import order.OrderInterface;
import dish.Dish;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CafeTest {
    private Cafe cafe;
    private OrderInterface order;

    @BeforeEach
    void setUp() {
        cafe = new Cafe();
        order = Mockito.mock(OrderInterface.class);
    }

    @Test
    void testCreateOrder() throws NoSuchFieldException, IllegalAccessException {
        Mockito.when(order.getTableNumber()).thenReturn(1);
        cafe.createOrder(order);

        Field ordersField = Cafe.class.getDeclaredField("orders");
        ordersField.setAccessible(true);
        List<OrderInterface> orders = (List<OrderInterface>) ordersField.get(cafe);
        assertEquals(1, orders.size());
    }

    @Test
    void testDisplayOrderDetails_EmptyOrder() {
        Mockito.when(order.getTableNumber()).thenReturn(1);
        Mockito.when(order.getDishes()).thenReturn(Collections.emptyList());
        cafe.createOrder(order);
        cafe.displayOrderDetails(1);
    }

    @Test
    void testDisplayOrderDetails_NonExistentTable() {
        cafe.displayOrderDetails(999);
    }
    @Test
    void testDisplayOrderDetails_WithDishes() {
        Mockito.when(order.getTableNumber()).thenReturn(1);
        Mockito.when(order.getDishes()).thenReturn(
                List.of(new Dish("Pizza", 10.0), new Dish("Pasta", 8.0))
        );
        Mockito.when(order.calculateTotal()).thenReturn(18.0);
        cafe.createOrder(order);
        cafe.displayOrderDetails(1);
    }
}