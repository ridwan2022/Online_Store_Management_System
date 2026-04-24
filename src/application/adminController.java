package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class adminController {
@FXML
private void viewProducts(ActionEvent event) {
	try {
	Parent saleRoot = FXMLLoader.load(getClass().getResource("allProducts.fxml"));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(new Scene(saleRoot));
    stage.setTitle("View all products");
    stage.show();
} catch (IOException e) {
    e.printStackTrace();
}
}
@FXML
private void addNewProduct(ActionEvent event) {
	try {
	Parent saleRoot = FXMLLoader.load(getClass().getResource("addNewProducts.fxml"));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(new Scene(saleRoot));
    stage.setTitle("Add new product");
    stage.show();
} catch (IOException e) {
    e.printStackTrace();
}
}
@FXML
private void handleSale(ActionEvent event) {
	try {
	Parent saleRoot = FXMLLoader.load(getClass().getResource("Manage_Sales.fxml"));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(new Scene(saleRoot));
    stage.setTitle("Manage Sales");
    stage.show();
} catch (IOException e) {
    e.printStackTrace();
}
}
@FXML
private void backToWelcome(ActionEvent event) {
	try {
	Parent saleRoot = FXMLLoader.load(getClass().getResource("Online_Store_welcomePage.fxml"));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(new Scene(saleRoot));
    stage.setTitle("Welcome");
    stage.show();
} catch (IOException e) {
    e.printStackTrace();
}
}
}
