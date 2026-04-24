package application.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class FoodDataStore {
    private static final ObservableList<food> foodList = FXCollections.observableArrayList();
    public static ObservableList<food> getFoodList() {
        return foodList;
  }
    public static void addFood(food f) {
        foodList.add(f);
    }
}