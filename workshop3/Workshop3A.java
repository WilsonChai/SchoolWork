/**********************************************
   Workshop 3
   Course:JAC444 - Semester 4
   Last Name: Chai
   First Name: Wilson
   ID: 030-918-114
   Section: DD
   This assignment represents my own work in accordance with Seneca Academic Policy.
   Signed by Wilson Chai
   Date: March 21, 2018
**********************************************/
import java.util.ArrayList;
import java.util.regex.*;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Workshop3A extends Application {
    ArrayList<Person> person = new ArrayList<Person>();
    String errorCode = ""; //used for field validation
    int currentIndex = -1; //keeps track of person arraylist

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

        retrieve(); // Gets person arraylist from file

        /***********************************************************************
                                START of Button behaviours
        ***********************************************************************/
        // This method adds a new person to file
        // Validate all fields before saving
        add_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(isNameWrong(name_field.getText())) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", errorCode);
                    return;
                } else if(isStreetWrong(street_field.getText())) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", errorCode);
                    return;
                } else if(isCityWrong(city_field.getText())) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", errorCode);
                    return;
                } else if(isStateWrong(state_field.getText())) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", errorCode);
                    return;
                } else if(isZipWrong(zip_field.getText())) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", errorCode);
                    return;
                } else{
                    //adds person to the end of the arraylist
                    person.add(new Person(name_field.getText(),
                                          street_field.getText(),
                                          city_field.getText(),
                                          state_field.getText(),
                                          zip_field.getText()));
                    save(person); //saves person to file
                }
            }
        });

        // Show information for the first person
        first_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentIndex=0;
                name_field.setText(person.get(currentIndex).get_name());
                street_field.setText(person.get(currentIndex).get_street());
                city_field.setText(person.get(currentIndex).get_city());
                state_field.setText(person.get(currentIndex).get_state());
                zip_field.setText(person.get(currentIndex).get_zip());
            }
        });

        // Show information for the next person
        next_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentIndex++;
                if(currentIndex>=person.size()){
                    currentIndex=0;
                }
                name_field.setText(person.get(currentIndex).get_name());
                street_field.setText(person.get(currentIndex).get_street());
                city_field.setText(person.get(currentIndex).get_city());
                state_field.setText(person.get(currentIndex).get_state());
                zip_field.setText(person.get(currentIndex).get_zip());
            }
        });

        // Show information for the previous person
        previous_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentIndex--;
                if(currentIndex >= person.size()){ //resets to beginning if end of list
                    currentIndex = 0;
                } else if(currentIndex < 0){ //resets to end if negative index
                    currentIndex = person.size()-1;
                }
                name_field.setText(person.get(currentIndex).get_name());
                street_field.setText(person.get(currentIndex).get_street());
                city_field.setText(person.get(currentIndex).get_city());
                state_field.setText(person.get(currentIndex).get_state());
                zip_field.setText(person.get(currentIndex).get_zip());
            }
        });

        // Show information for the last person
        last_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentIndex=person.size()-1;
                name_field.setText(person.get(currentIndex).get_name());
                street_field.setText(person.get(currentIndex).get_street());
                city_field.setText(person.get(currentIndex).get_city());
                state_field.setText(person.get(currentIndex).get_state());
                zip_field.setText(person.get(currentIndex).get_zip());
            }
        });

        // This method updates the current person showing
        // Validate all fields before updating
        update_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(currentIndex<0){
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Update Error!", "Cannot update a non-existing person.");
                    return;
                }else if(isNameWrong(name_field.getText())) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", errorCode);
                    return;
                } else if(isStreetWrong(street_field.getText())) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", errorCode);
                    return;
                } else if(isCityWrong(city_field.getText())) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", errorCode);
                    return;
                } else if(isStateWrong(state_field.getText())) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", errorCode);
                    return;
                } else if(isZipWrong(zip_field.getText())) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", errorCode);
                    return;
                } else{
                    person.set(currentIndex, new Person(name_field.getText(),
                                                        street_field.getText(),
                                                        city_field.getText(),
                                                        state_field.getText(),
                                                        zip_field.getText()));
                    save(person);
                }
            }
        });
        /***********************************************************************
                               END of button behaviours
        ***********************************************************************/

        Scene scene = new Scene(gridPane); //Creating a scene object
        stage.setTitle("Address Book"); //Setting title to the Stage
        stage.setScene(scene); //Adding scene to the stage
        stage.show(); //Displaying the contents of the stage
    }

    //pop-up alert message
    private void showAlert(AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    //saves person arraylist to file
    public void save(ArrayList<Person> person){
        try {
            FileOutputStream fos = new FileOutputStream("Address.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(person);
            System.out.println("Saving Done");

            oos.close();
            fos.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    //gets person arraylist from file
    public void retrieve(){
        try {
            FileInputStream fis = new FileInputStream("Address.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            @SuppressWarnings("unchecked")
            ArrayList<Person> retrievedPerson = (ArrayList<Person>) (ois.readObject());
            person = retrievedPerson;

            ois.close();
            fis.close();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException c){
            person = new ArrayList<Person>();
            c.printStackTrace();
        }
    }

    /***********************************************************************
                        START of Validation Methods
    ***********************************************************************/
    public boolean isNameWrong(String name_field){
        if(name_field.length() > 32){
            errorCode = "Name field is too long. (32 character limit)";
            return true;
        } else if(name_field.isEmpty()){
            errorCode = "Name field is empty.";
            return true;
        } else if(!Pattern.matches("[a-zA-Z ]*", name_field)){
            errorCode = "Name field must be letters only.";
            return true;
        }
        return false;
    }

    public boolean isStreetWrong(String street_field){
        if(street_field.length() > 32){
            errorCode = "Street field is too long. (32 character limit)";
            return true;
        } else if(street_field.isEmpty()){
            errorCode = "Street field is empty.";
            return true;
        } else if(!Pattern.matches("\\d+[\\s]([a-zA-Z]+|[a-zA-Z]+[\\s][a-zA-Z]+)", street_field)){
            errorCode = "Street field must be in correct format.\n(For example: 10 Pond Rd)";
            return true;
        }
        return false;
    }

    public boolean isCityWrong(String city_field){
        if(city_field.length() > 20){
            errorCode = "City field is too long. (20 character limit)";
            return true;
        } else if(city_field.isEmpty()){
            errorCode = "City field is empty.";
            return true;
        } else if(!Pattern.matches("[a-zA-Z ]*", city_field)){
            errorCode = "City field must be letters only.";
            return true;
        }
        return false;
    }

    public boolean isStateWrong(String state_field){
        if(state_field.length() != 2){
            errorCode = "State field must be 2 characters long.";
            return true;
        } else if(!Pattern.matches("[A-Z]{2}", state_field)){
            errorCode = "State field must be capital letters only.";
            return true;
        }
        return false;
    }

    public boolean isZipWrong(String zip_field){
        if(zip_field.length() != 5){
            errorCode = "Zip field must be 5 digits long.";
            return true;
        } else if(!Pattern.matches("[0-9]{5}", zip_field)){
            errorCode = "Zip field must be numbers only.";
            return true;
        }
        return false;
    }
    /***********************************************************************
                           END of Validation Methods
    ***********************************************************************/

    public static void main(String args[]){
        launch(args);
    }
}
