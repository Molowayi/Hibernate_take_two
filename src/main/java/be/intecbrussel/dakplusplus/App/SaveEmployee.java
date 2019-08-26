package be.intecbrussel.dakplusplus.App;

import be.intecbrussel.dakplusplus.datalayer.EmployeeRepository;
import be.intecbrussel.dakplusplus.model.Adress;
import be.intecbrussel.dakplusplus.model.ContactData;
import be.intecbrussel.dakplusplus.model.company.Employee;
import be.intecbrussel.dakplusplus.model.company.Role;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Calendar;

public class SaveEmployee extends Application {

    public static void main(String[] args) {

        Employee jeb = hireEmployee("Jeb", "Bush", "0477777776", "15, Hogestraat, 1000, Bruxelles, Belgium", Role.ADMINISTRATIVE);
        jeb.setBirthdate(Calendar.getInstance());
        Employee james = hireEmployee("James", "Monroe", "0477777775", "18, Philippe de Champagne, 1000, Bruxelles, Belgium", Role.TEAM_LEADER);
        james.setBirthdate(Calendar.getInstance());
        EmployeeRepository employeeRepository = new EmployeeRepository();
        employeeRepository.createEmployee(jeb);
        employeeRepository.createEmployee(james);

        System.out.println("Employee " + jeb + " was created in the database");
        System.out.println("Employee " + james + " was created in the database");

        // GUI
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Employees.fxml"));
        Scene scene = new Scene(root/*, 600, 400*/);
        primaryStage.setTitle("Employee");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private static Employee hireEmployee(String firstname, String lastname, String gsm, String contact, Role role) {
        Employee employee = new Employee();
        employee.setFirstName(firstname);
        employee.setLastName(lastname);
        employee.setRole(role);
        String[] kontact = contact.split(",");
        Adress adress = new Adress(kontact[1], kontact[0], kontact[2], kontact[3], kontact[4]);
        ContactData contactData = new ContactData();
        contactData.setMobile(gsm);
        contactData.setEmail(firstname + "." + lastname + "@dakplusplus.be");
        contactData.addAdress(adress);
        employee.addContactData(contactData);
        return employee;
    }
}
