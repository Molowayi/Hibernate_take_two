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

        Calendar jeb_birthdate = Calendar.getInstance();
        jeb_birthdate.set(1967, 9, 9);
        Employee jeb = new Employee("Jeb", "Bush", "0477777776", "jeb@email.adress", "15", "Hogestraat", "1000", "Bruxelles", "Belgium", Role.ADMINISTRATIVE, jeb_birthdate);
        Calendar james_birthade = Calendar.getInstance();
        james_birthade.set(1968, 9, 1);
        ;
        Employee james = new Employee("James", "Monroe", "0477777775", "jeb@email.adress", "18", "Philippe de Champagne", "1000", "Bruxelles", "Belgium", Role.TEAM_LEADER, james_birthade);
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
}
