package be.intecbrussel.dakplusplus.App;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Employees {
    @FXML
    private TextField name;
    @FXML
    private TextField email;
    @FXML
    private TextField numberPizza;
    @FXML
    private DatePicker deliveryDate;
    @FXML
    private MultiSelectListView ingredients;
    @FXML
    private ToggleGroup myToggleGroup;
    @FXML
    private CheckBox spicy;
    @FXML
    private ComboBox size;


    @FXML
    private void takeOrder() {
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

    }
}
