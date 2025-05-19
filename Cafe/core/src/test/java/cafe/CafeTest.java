package core.src.test.java.cafe;

import core.src.main.java.cafe.Cafe;
import core.src.main.java.order.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

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
    void testCreateOrder() throws NoSuchFieldException, IllegalAccessException {
        Mockito.when(order.getTableNumber()).thenReturn(1); // Корректное использование when
        cafe.createOrder(order);

        // Доступ к приватному полю orders через рефлексию
        Field ordersField = Cafe.class.getDeclaredField("orders");
        ordersField.setAccessible(true);
        List<Order> orders = (List<Order>) ordersField.get(cafe);
        assertEquals(1, orders.size()); // Проверяем размер списка
    }

    @Test
    void testDisplayOrderDetails_EmptyOrder() {
        Mockito.when(order.getTableNumber()).thenReturn(1);
        Mockito.when(order.getDishes()).thenReturn(Collections.emptyList());
        cafe.createOrder(order);
        cafe.displayOrderDetails(1);
        // Проверяем, что метод не выбрасывает исключений (логи можно проверить отдельно)
    }

    @Test
    void testDisplayOrderDetails_NonExistentTable() {
        cafe.displayOrderDetails(999);
        // Проверяем, что метод не выбрасывает исключений
    }
}