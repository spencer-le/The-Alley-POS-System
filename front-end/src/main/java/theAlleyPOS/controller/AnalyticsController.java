package theAlleyPOS.controller;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import theAlleyPOS.model.Item;
import theAlleyPOS.DatabaseHelper;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
Lines 25 through 56 create the table buttons, columns, and tabs which will show the analytics
 */
public class AnalyticsController {
    public TextField minimumAmountField;
    public TableColumn columnItemId;
    public TableColumn columnItemName;
    public TableColumn columnItemAmount;
    public Button btnLoadItems;
    @FXML
    private Button homeButton1;
    @FXML
    private Button homeButton2;
    @FXML
    private Button homeButton3;
    @FXML
    private Button homeButton4;
    @FXML
    private TableView tableViewSalesReport;
    @FXML
    private DatePicker beginDateSalesReport;
    @FXML
    private DatePicker endDateSalesReport;
    @FXML
    private TableView tableViewExcess;
    @FXML
    private DatePicker startDatePickerExcess;

    @FXML
    private TableView tableViewSalesTogether;
    @FXML
    private TableView tableViewRestockReport;

    /*
    This initialize function creates the columns for the table and names them
     */
    @FXML
    public void initialize() {
        columnItemId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnItemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        columnItemAmount.setCellValueFactory(new PropertyValueFactory<>("inventoryCount"));
    }

    /*
    The loadRestockItems function takes in a minimum number from the user, and returns all items whose inventory is
    less than this number, using a DatabaseHelper.
     */
    public void loadRestockItems() {
        int minAmount;
        try {
            String userInput = minimumAmountField.getText().trim();
            if (userInput.isEmpty()) {
                throw new NumberFormatException("Error: Input field is empty");
            }
            minAmount = Integer.parseInt(userInput);

            if (minAmount < 0) {
                throw new NumberFormatException("Error: Number cannot be negative");
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error: Invalid Input. Please try again.");
            alert.showAndWait();
            return;
        }
        DatabaseHelper dbHelper = new DatabaseHelper();
        List<Item> filteredItems = dbHelper.fetchItemsBelowInventoryCount(minAmount);
        ObservableList<Item> observableList = FXCollections.observableArrayList(filteredItems);
        tableViewRestockReport.setItems(observableList);
    }

    /*
    The loadManagerTimeClockScreen function changes scenes to the home screen for the current manager.
     */
    private void loadManagerTimeClockScreen(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/theAlleyPOS/ManagerTimeClock.fxml"));
            Scene anotherScene = new Scene(fxmlLoader.load());

            // Getting the current stage from any component (assuming all are on the same stage)
            Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();

            // Switching scene
            currentStage.setScene(anotherScene);
        } catch (IOException e) {
            System.out.println("Failed to load manager time clock screen.");
            e.printStackTrace();
        }
    }

    /*
    The handleHomeButton function uses FXML to send the user back to the home screen when the button is pressed
     */
    @FXML
    public void handleHomeButton(ActionEvent actionEvent) {
        loadManagerTimeClockScreen(actionEvent);
    }

    /*
    The handleLoadItemsClick function also uses FXML to load the items which need to be restocked.
     */
    @FXML
    public void handleLoadItemsClick(ActionEvent actionEvent) {
        loadRestockItems();
    }
}