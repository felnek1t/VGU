package core.src.test.java.order;

import core.src.main.java.dish.Dish;
import core.src.main.java.menu.Menu;
import core.src.main.java.order.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderTest {
    private Order order;
    private Menu menu;
    private Dish dish;

    @BeforeEach
    void setUp() {
        menu = Mockito.mock(Menu.class);
        order = new Order(1, menu);
        dish = new Dish("Pasta", 10.0);
    }

    @Test
    void testAddDish_Available() {
        when(menu.isDishAvailable("Pasta")).thenReturn(true);
        assertTrue(order.addDish(dish));
        assertEquals(1, order.getDishes().size());
        assertEquals(dish, order.getDishes().get(0));
    }

    @Test
    void testAddDish_NotAvailable() {
        when(menu.isDishAvailable("Pasta")).thenReturn(false);
        assertFalse(order.addDish(dish));
        assertEquals(0, order.getDishes().size());
    }

    @Test
    void testAddDuplicateDish() {
        when(menu.isDishAvailable("Pasta")).thenReturn(true);
        order.addDish(dish);
        assertFalse(order.addDish(new Dish("Pasta", 10.0)));
        assertEquals(1, order.getDishes().size());
    }

    @Test
    void testRemoveDish() {
        when(menu.isDishAvailable("Pasta")).thenReturn(true);
        order.addDish(dish);
        assertTrue(order.removeDish("Pasta"));
        assertEquals(0, order.getDishes().size());
    }

    @Test
    void testCalculateTotal() {
        when(menu.isDishAvailable(anyString())).thenReturn(true);
        order.addDish(new Dish("Pasta", 10.0));
        order.addDish(new Dish("Salad", 5.0));
        assertEquals(15.0, order.calculateTotal());
    }
}