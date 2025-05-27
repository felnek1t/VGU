package ordertest;

import dish.Dish;
import menu.Menu;
import order.Order;
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

    @Test
    void testCalculateTotalWithZeroPrice() {
        when(menu.isDishAvailable(anyString())).thenReturn(true);
        order.addDish(new Dish("Free Item", 0.0));
        order.addDish(new Dish("Salad", 5.0));
        assertEquals(5.0, order.calculateTotal());
    }

    @Test
    void testRemoveNonExistentDish() {
        when(menu.isDishAvailable("Pasta")).thenReturn(true);
        order.addDish(dish);
        assertFalse(order.removeDish("Pizza"));
        assertEquals(1, order.getDishes().size());
    }

    @Test
    void testAddMultipleDishes() {
        when(menu.isDishAvailable(anyString())).thenReturn(true);
        Dish dish2 = new Dish("Pizza", 12.0);
        assertTrue(order.addDish(dish));
        assertTrue(order.addDish(dish2));
        assertEquals(2, order.getDishes().size());
    }
}