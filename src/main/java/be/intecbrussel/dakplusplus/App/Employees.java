package be.intecbrussel.dakplusplus.App;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Employees {
    @FXML
    private Label id ;
    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField emailadress;
    @FXML
    private TextField role;
    @FXML
    private TextField mobile;
    @FXML
    private TextField street;
    @FXML
    private TextField streetNumber;
    @FXML
    private TextField zipcode;
    @FXML
    private TextField city;
    @FXML
    private TextField country;
    @FXML
    private DatePicker birthdate;
    @FXML
    private MultiSelectListView ingredients;
    @FXML
    private ToggleGroup myToggleGroup;
    @FXML
    private CheckBox spicy;
    @FXML
    private ComboBox size;


    @FXML
    private void save() {
/*
        LocalDate value = deliveryDate.getValue();
//        ObservableList selectedIndices = ingredients.getSelectionModel().getSelectedIndices();
        ObservableList selectedIndices = ingredients.getSelectionModel().getSelectedItems();

//        for(Object o : selectedIndices){
//            System.out.println("o = " + o + " (" + o.getClass() + ")");
//        }
        RadioButton selectedBottom = (RadioButton) myToggleGroup.getSelectedToggle();
        boolean isSpicy = spicy.isSelected();
        String pizzaSize = (String) size.getValue();
        int numberOfPieces = Integer.parseInt(numberPizza.getText());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Name : " + name.getText() +
                "\nEmail : " + email.getText() +
                "\nDelivery date : " + formatter.format(value) +
                "\nIngredients : " + selectedIndices +
                "\nSelected bottom : " + selectedBottom.getText() +
                "\nSpicy : " + isSpicy +
                "\nPieces : " + numberOfPieces);
*/

    }
}
