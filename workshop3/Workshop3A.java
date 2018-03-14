/**********************************************
   Workshop 3 - Task A
   Course:JAC444 - Semester 4
   Last Name: Chai
   First Name: Wilson
   ID: 030-918-114
   Section: DD
   This assignment represents my own work in accordance with Seneca Academic Policy.
   Signed by Wilson Chai
   Date: March 20, 2018
**********************************************/
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Window;

public class Workshop3A extends Application {
    @Override
    public void start(Stage stage) {
        //create labels
        Label name_label = new Label("Name");
        Label street_label = new Label("Street");
        Label city_label = new Label("City");
        Label state_label = new Label("State");
        Label zip_label = new Label("Zip");

        //create textfields
        TextField name_field = new TextField();
        TextField street_field = new TextField();
        TextField city_field = new TextField();
        TextField state_field = new TextField();
        TextField zip_field = new TextField();

        //Set column width for fields
        name_field.setPrefColumnCount(32);
        street_field.setPrefColumnCount(32);
        city_field.setPrefColumnCount(20);
        state_field.setPrefColumnCount(2);
        zip_field.setPrefColumnCount(5);

        //Creating Buttons
        Button add_button = new Button("Add");
        Button first_button = new Button("First");
        Button next_button = new Button("Next");
        Button previous_button = new Button("Previous");
        Button last_button = new Button("Last");
        Button update_button = new Button("Update");

        //Create buttons with flowPane
        FlowPane flowPane = new FlowPane();
        flowPane.setHgap(5);
        flowPane.setAlignment(Pos.CENTER);
        flowPane.getChildren().addAll(add_button, first_button, next_button,
                                      previous_button, last_button, update_button);

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 130); //Setting size for the gridPane
        gridPane.setPadding(new Insets(10, 10, 10, 10)); //Setting the padding

        //Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER); //Setting the Grid alignment

        //Add nodes to the grid
        gridPane.add(name_label, 0, 0);
        gridPane.add(name_field, 1, 0, 5, 1);
        gridPane.add(street_label, 0, 1);
        gridPane.add(street_field, 1, 1, 5, 1);
        gridPane.add(city_label, 0, 2);
        gridPane.add(city_field, 1, 2);
        gridPane.add(state_label, 2, 2);
        gridPane.add(state_field, 3, 2);
        gridPane.add(zip_label, 4, 2);
        gridPane.add(zip_field, 5, 2);

        //Add flowPane to gridPane
        gridPane.add(flowPane, 0, 3, 9, 1);

        //Detect button presses and does empty field checks
        add_button.setOnAction(new EventHandler<ActionEvent>() {
            System.out.println(checkIfFieldEmpty(name_field, gridPane));
        });

        Scene scene = new Scene(gridPane); //Creating a scene object
        stage.setTitle("Address Book"); //Setting title to the Stage
        stage.setScene(scene); //Adding scene to the stage
        stage.show(); //Displaying the contents of the stage

        public boolean checkIfFieldEmpty(TextField name_field, GridPane gridPane){
            @Override
            public void handle(ActionEvent event) {
                if(name_field.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your name");
                    return true;
                } else{
                    return false;
                }
            }
        }
    }

    private void showAlert(AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public static void main(String args[]){
        launch(args);
    }
}
