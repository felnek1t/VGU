package orderinterface;

import java.util.List;
import dish.Dish;

public interface OrderInterface {
    boolean addDish(Dish dish);
    boolean removeDish(String dishName);
    double calculateTotal();
    int getTableNumber();
    List<Dish> getDishes();
}
