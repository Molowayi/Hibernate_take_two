package be.intecbrussel.dakplusplus.App;

import be.intecbrussel.dakplusplus.datalayer.EmployeeRepository;
import be.intecbrussel.dakplusplus.model.company.Employee;
import be.intecbrussel.dakplusplus.model.company.Role;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

public class Employees implements Initializable {
    @FXML
    private Label id;
    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField emailadress;
    @FXML
    private ChoiceBox<String> role;
    //    private TextField role;
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
    private TableView<Employee> tableView;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;


    @FXML
    private void save() {

        LocalDate localDate = birthdate.getValue();
        Calendar bd = Calendar.getInstance();
        bd.clear();
        //assuming start of day
        bd.set(localDate.getYear(), localDate.getMonthValue() - 1, localDate.getDayOfMonth());

        Role _role = Employee.makeEmployeeRoleFromString((String) role.getSelectionModel().getSelectedItem());
/*        System.out.println(_role);
        System.out.println(firstname.getText());
        System.out.println(lastname.getText());
        System.out.println(mobile.getText());
        System.out.println(emailadress.getText());
        System.out.println(city.getText());
        System.out.println(birthdate);
        System.out.println(bd.toInstant());*/

        Employee employee = new Employee(
                (String) firstname.getText(),
                (String) lastname.getText(),
                (String) mobile.getText(),
                (String) emailadress.getText(),
                (String) street.getText(),
                (String) streetNumber.getText(),
                (String) zipcode.getText(),
                (String) city.getText(),
                (String) country.getText(),
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

        EmployeeRepository employeeRepository = new EmployeeRepository();
        Employee employee2 = employeeRepository.createEmployee(employee);
        id.setText(new Long(employee2.getId()).toString());

        updateListEmployees();
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

    @FXML
    protected void addPerson(ActionEvent event) {

        ObservableList<Employee> data = tableView.getItems();
        data.add(new Employee(firstNameField.getText(),
                lastNameField.getText()
        ));

        firstNameField.setText("");
        lastNameField.setText("");



    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        updateListEmployees();
    }

    private void updateListEmployees() {
        ObservableList<Employee> data = tableView.getItems();
        EmployeeRepository employeeRepository = new EmployeeRepository();
        List<Employee> employees = employeeRepository.getListEmployee();
        data.addAll(employees);
        /*if (employees.size() != 0) {
            for (Employee e :
                    employees) {
                data.add(e);
            }
        }*/
    }
}
