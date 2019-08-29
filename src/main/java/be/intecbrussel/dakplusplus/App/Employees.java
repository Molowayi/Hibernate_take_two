package be.intecbrussel.dakplusplus.App;

import be.intecbrussel.dakplusplus.datalayer.EmployeeRepository;
import be.intecbrussel.dakplusplus.model.company.Employee;
import be.intecbrussel.dakplusplus.model.company.Role;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

public class Employees {
    @FXML
    private Label id;
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

        LocalDate localDate = birthdate.getValue();
        Calendar bd = Calendar.getInstance();
        bd.clear();
        //assuming start of day
        bd.set(localDate.getYear(), localDate.getMonthValue() - 1, localDate.getDayOfMonth());

        Role _role = Employee.makeEmployeeRoleFromString((String) role.getText());
/*        System.out.println(_role);
        System.out.println(firstname.getText());
        System.out.println(lastname.getText());
        System.out.println(mobile.getText());
        System.out.println(emailadress.getText());
        System.out.println(city.getText());
        System.out.println(birthdate);
        System.out.println(bd.toInstant());*/

        Employee employee = new Employee(
                (String)    firstname.getText(),
                (String)    lastname.getText(),
                (String)    mobile.getText(),
                (String)    emailadress.getText(),
                (String)    street.getText(),
                (String)    streetNumber.getText(),
                (String)    zipcode.getText(),
                (String)    city.getText(),
                (String)    country.getText(),
                _role,
                bd

        );

/*        if(employee.getFirstName() != null){
            System.out.println("First name : " + employee.getFirstName());
        }
        if(employee.getLastName() != null){
            System.out.println("Last name : " + employee.getLastName());
        }
        if(employee.getBirthdate() != null){
            System.out.println("Birthdate : " + employee.getBirthdate());
        }
        if(employee.getRole() != null){
            System.out.println("Role : " + employee.getRole());
        }
        if(employee.getContactData() != null){
            System.out.println("Contact : " + employee.getContactData());
        }*/

        System.out.println(employee);

        EmployeeRepository employeeRepository = new EmployeeRepository();
        Employee employee2 = employeeRepository.createEmployee(employee);
        id.setText(new Long(employee2.getId()).toString());
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
