package be.intecbrussel.dakplusplus.App;

import be.intecbrussel.dakplusplus.datalayer.EmployeeRepository;
import be.intecbrussel.dakplusplus.datalayer.GenericEntityRepository;
import be.intecbrussel.dakplusplus.model.company.Employee;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class ListEmployees extends Application {

    public static void main(String[] args) {

//        Thread thread = new Thread(new MakeCompany());
//        thread.start();
//
//        EmployeeRepository employeeRepository = new EmployeeRepository();
//        List<Employee> employees = employeeRepository.getListEmployee();
//        employees.stream().forEach(System.out::println);

        List<Employee> employees = (new GenericEntityRepository<Employee>()).getListEntity();
        employees.stream().forEach(System.out::println);



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
