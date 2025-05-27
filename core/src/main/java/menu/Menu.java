package menu;

import dish.Dish;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private static final Logger logger = LogManager.getLogger(Menu.class);
    private List<Dish> dishes;

    public Menu() {
        this.dishes = new ArrayList<>();
    }

    public boolean addDish(Dish dish) {
        if (dishes.stream().anyMatch(d -> d.getName().equalsIgnoreCase(dish.getName()))) {
            logger.warn("Dish '{}' already exists in the menu.", dish.getName());
            return false;
        }
        dishes.add(dish);
        logger.info("Added dish to menu: {}", dish);
        return true;
    }

    public boolean removeDish(String dishName) {
        Dish dish = dishes.stream()
                .filter(d -> d.getName().equalsIgnoreCase(dishName))
                .findFirst()
                .orElse(null);
        if (dish == null) {
            logger.warn("Dish '{}' not found in the menu.", dishName);
            return false;
        }
        dishes.remove(dish);
        logger.info("Removed dish from menu: {}", dish);
        return true;
    }

    public List<Dish> getDishes() {
        return new ArrayList<>(dishes);
    }

    public boolean isDishAvailable(String dishName) {
        return dishes.stream().anyMatch(d -> d.getName().equalsIgnoreCase(dishName));
    }
}