package theAlleyPOS.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class EmployeeTimeClockController {

    @FXML
    private Button clockInButton, breakInButton, clockOutButton, breakOutButton;

    @FXML
    public void handleClockInOut(ActionEvent actionEvent) {
        Button clickedButton = (Button) actionEvent.getSource();
        String buttonText = clickedButton.getText();

        switch (buttonText) {
            case "Clock In":
                // Takes user to item selection screen
                System.out.println("Clocking In...");
                loadItemSelectionScreen(actionEvent);
                break;

            case "Clock Out":
                // Takes user back to login screen
                System.out.println("Clocking Out...");
                loadLoginScreen(actionEvent);
                break;
        }
    }

    @FXML
    public void handleBreakInOut(ActionEvent actionEvent) {
        Button clickedButton = (Button) actionEvent.getSource();
        String buttonText = clickedButton.getText();

        switch (buttonText) {
            case "Break In":
                // Takes user to item selection screen
                System.out.println("Breaking In...");
                loadItemSelectionScreen(actionEvent);
                break;

            case "Break Out":
                // Takes user back to login screen
                System.out.println("Breaking Out...");
                loadLoginScreen(actionEvent);
                break;
        }
    }

    private void loadLoginScreen(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/theAlleyPOS/Login.fxml"));
            Scene loginScene = new Scene(fxmlLoader.load());

            // Get the current stage using any of the controls
            Stage currentStage = (Stage) clockInButton.getScene().getWindow();

            // Set the scene to the stage
            currentStage.setScene(loginScene);
        } catch (IOException e) {
            System.out.println("Failed to load login screen.");
            e.printStackTrace();
        }
    }

    private void loadItemSelectionScreen(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/theAlleyPOS/ItemSelection.fxml"));
            Scene loginScene = new Scene(fxmlLoader.load());

            // Get the current stage using any of the controls
            Stage currentStage = (Stage) clockInButton.getScene().getWindow();

            // Set the scene to the stage
            currentStage.setScene(loginScene);
        } catch (IOException e) {
            System.out.println("Failed to load login screen.");
            e.printStackTrace();
        }
    }
}