package be.intecbrussel.dakplusplus.App;

import be.intecbrussel.dakplusplus.datalayer.EmployeeRepository;
import be.intecbrussel.dakplusplus.model.company.Employee;
import be.intecbrussel.dakplusplus.model.company.Role;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
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
    private TableView<Employee> tableView;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private HBox container;

    @FXML
    private void openAboutDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Hibernate Take Two");
        alert.setHeaderText("About this software");
        alert.setContentText("Version 1.0\nPublished on 08-31-2019");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            ButtonType buttonType = result.get();
        }
    }

    @FXML
    private void save() {

        LocalDate localDate = birthdate.getValue();
        Calendar bd = Calendar.getInstance();
        bd.clear();
        //assuming start of day
        bd.set(localDate.getYear(), localDate.getMonthValue() - 1, localDate.getDayOfMonth());

        Role _role = Employee.makeEmployeeRoleFromString((String) role.getSelectionModel().getSelectedItem());

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

        EmployeeRepository employeeRepository = new EmployeeRepository();
        Employee employee2 = employeeRepository.createEmployee(employee);
        id.setText(new Long(employee2.getId()).toString());

        ObservableList<Employee> data = tableView.getItems();
        data.add(employee2);

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
    }

    @FXML
    private void changeContainerContent() throws IOException {
//         https://stackoverflow.com/questions/11563298/how-to-change-sub-fxml-gui-parts-at-runtime-with-button-click
        container.getChildren().clear();
        container.getChildren().add(FXMLLoader.load(getClass().getResource("/DraftFXML.fxml")));
        container.getChildren().addAll(new Button("Cut"), new Button("Copy"), new Button("Paste"));
    }
}
