package MenuTest;

import core.src.main.java.dish.Dish;
import core.src.main.java.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {
    private Menu menu;

    @BeforeEach
    void setUp() {
        menu = new Menu();
    }

    @Test
    void testAddDish() {
        Dish dish = new Dish("Pasta", 10.0);
        assertTrue(menu.addDish(dish));
        assertEquals(1, menu.getDishes().size());
        assertEquals(dish, menu.getDishes().get(0));
    }

    @Test
    void testAddDuplicateDish() {
        Dish dish = new Dish("Pasta", 10.0);
        menu.addDish(dish);
        assertFalse(menu.addDish(new Dish("Pasta", 10.0)));
        assertEquals(1, menu.getDishes().size());
    }

    @Test
    void testRemoveDish() {
        Dish dish = new Dish("Pasta", 10.0);
        menu.addDish(dish);
        assertTrue(menu.removeDish("Pasta"));
        assertEquals(0, menu.getDishes().size());
    }

    @Test
    void testRemoveNonExistentDish() {
        assertFalse(menu.removeDish("Pizza"));
    }

    @Test
    void testIsDishAvailable() {
        Dish dish = new Dish("Pasta", 10.0);
        menu.addDish(dish);
        assertTrue(menu.isDishAvailable("Pasta"));
        assertFalse(menu.isDishAvailable("Pizza"));
    }

    @Test
    void testAddMultipleDishes() {
        Dish dish1 = new Dish("Pasta", 10.0);
        Dish dish2 = new Dish("Pizza", 12.0);
        assertTrue(menu.addDish(dish1));
        assertTrue(menu.addDish(dish2));
        assertEquals(2, menu.getDishes().size());
    }

    @Test
    void testRemoveAllDishes() {
        Dish dish1 = new Dish("Pasta", 10.0);
        Dish dish2 = new Dish("Pizza", 12.0);
        menu.addDish(dish1);
        menu.addDish(dish2);
        assertTrue(menu.removeDish("Pasta"));
        assertTrue(menu.removeDish("Pizza"));
        assertEquals(0, menu.getDishes().size());
    }
}