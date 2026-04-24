package application;
import application.model.food;

import java.io.IOException;

import application.model.FoodDataStore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class addFoodController {
    @FXML
    private TextField idField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField priceField;
    @FXML
    private TextField quantityField;
    @FXML
    private TextField onSaleField;
    @FXML
    private TextField expiryField;
    @FXML
    private TextField manufacturingField;
    @FXML
    private void goBackToaddNewProduct(ActionEvent event) {
        try {
            Parent adminRoot = FXMLLoader.load(getClass().getResource("addNewProducts.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(adminRoot));
            stage.setTitle("Admin Dashboard");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleAddFood() {
        String id = idField.getText();
        String name = nameField.getText();
        double price = Double.parseDouble(priceField.getText());
        double quantity = Double.parseDouble(quantityField.getText());
        String onSale = onSaleField.getText();
        String expiryDate = expiryField.getText();
        String manufacturingDate = manufacturingField.getText();

        food newFood = new food(id, name, price, quantity, onSale, expiryDate, manufacturingDate);
        FoodDataStore.addFood(newFood);

        // 👉 Save to file
        String data = id + "," + name + "," + price + "," + quantity + "," +
                      onSale + "," + expiryDate + "," + manufacturingDate;

        application.FileUtill.saveToFile("food.txt", data);

        System.out.println("Food added & saved to file!");
        clearFields();
    }
private void clearFields() {
    idField.clear();
    nameField.clear();
    priceField.clear();
    quantityField.clear();
    onSaleField.clear();
    expiryField.clear();
    manufacturingField.clear();
}
}