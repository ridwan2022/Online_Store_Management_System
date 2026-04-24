package application;

import application.model.clothes;
import application.model.ClothingDataStore;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node;

public class clothingItemsController {

    @FXML private TableView<clothes> clothingTable;

    @FXML private TableColumn<clothes, String> idColumn;
    @FXML private TableColumn<clothes, String> nameColumn;
    @FXML private TableColumn<clothes, Double> priceColumn;
    @FXML private TableColumn<clothes, Double> quantityColumn;
    @FXML private TableColumn<clothes, String> brandColumn;
    @FXML private TableColumn<clothes, String> sizeColumn;
    @FXML private TableColumn<clothes, String> subcategoryColumn;
    @FXML private TableColumn<clothes, String> onSaleColumn;

    @FXML
    public void initialize() {
        // Set up cell value factories
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        subcategoryColumn.setCellValueFactory(new PropertyValueFactory<>("subcategory"));
        onSaleColumn.setCellValueFactory(new PropertyValueFactory<>("onSale"));

        // Load data into table
        ObservableList<clothes> clothingList = ClothingDataStore.getClothingList();
        clothingTable.setItems(clothingList);
    }

    @FXML
    private void backToAllProducts(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("allProducts.fxml")); // Replace with correct FXML if needed
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("All Products");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
