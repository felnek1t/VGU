package order; 

import dish.Dish;
import java.util.List;

public interface OrderInterface {
    boolean addDish(Dish dish);
    boolean removeDish(String dishName);
    double calculateTotal();
    int getTableNumber();
    List<Dish> getDishes();
}