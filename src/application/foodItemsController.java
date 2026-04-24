package application;

import java.io.IOException;

import application.model.FoodDataStore;
import application.model.food;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class foodItemsController {
	@FXML
	private void backToAllProducts(ActionEvent event) {
		try {
		Parent saleRoot = FXMLLoader.load(getClass().getResource("allProducts.fxml"));
	    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    stage.setScene(new Scene(saleRoot));
	    stage.setTitle("All Products");
	    stage.show();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	}
	 @FXML private TableView<food> foodTable;
	    @FXML private TableColumn<food, String> idColumn;
	    @FXML private TableColumn<food, String> nameColumn;
	    @FXML private TableColumn<food, String> onSaleColumn;
	    @FXML private TableColumn<food, Double> quantityColumn;
	    @FXML private TableColumn<food, Double> priceColumn;
	    @FXML private TableColumn<food, String> expiryColumn;
	    @FXML private TableColumn<food, String> manufacturingColumn;
	    @FXML
	    public void initialize() {
	        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
	        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
	        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
	        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
	        onSaleColumn.setCellValueFactory(new PropertyValueFactory<>("onSale"));
	        expiryColumn.setCellValueFactory(new PropertyValueFactory<>("expiryDate"));
	        manufacturingColumn.setCellValueFactory(new PropertyValueFactory<>("manufacturingDate"));
	        foodTable.setItems(FoodDataStore.getFoodList());
	    }
}
