/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.intecbrussel.dakplusplus.App;

import be.intecbrussel.dakplusplus.datalayer.EmployeeRepository;
import be.intecbrussel.dakplusplus.model.company.Employee;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author JLVH
 */
public class MakeCompany extends Application {
    public static void main(String[] args) {

//        EmployeeRepository employeeRepository = new EmployeeRepository();
//        List<Employee> employees = employeeRepository.getListEmployee();
//        employees.stream().forEach(System.out::println);


        // GUI
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/company.fxml"));
        Scene scene = new Scene(root/*, 600, 400*/);
        primaryStage.setTitle("Company");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
