package core.src.main.java.order;

import java.util.List;
import core.src.main.java.dish.Dish;

public interface OrderInterface {
    boolean addDish(Dish dish);
    boolean removeDish(String dishName);
    double calculateTotal();
    int getTableNumber();
    List<Dish> getDishes();
}
