package application.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ClothingDataStore {
    private static final ObservableList<clothes> clothingList = FXCollections.observableArrayList();

    public static ObservableList<clothes> getClothingList() {
        return clothingList;
    }

    public static void addClothing(clothes c) {
        clothingList.add(c);
    }
}
