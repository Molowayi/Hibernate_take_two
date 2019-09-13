package be.intecbrussel.dakplusplus.App;

import be.intecbrussel.dakplusplus.datalayer.EmployeeRepository;
import be.intecbrussel.dakplusplus.datalayer.GenericEntityRepository;
import be.intecbrussel.dakplusplus.model.company.Employee;
import com.sun.tools.internal.xjc.model.CArrayInfo;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ListEmployees extends Application {

    public static void main(String[] args) {

/*
        Thread thread = new Thread(new MakeCompany());
        thread.start();
*/

        EmployeeRepository employeeRepository = new EmployeeRepository();
        List<Employee> employees = employeeRepository.getListEmployee();
        employees.stream().forEach(System.out::println);

//        List<Employee> employees = (new GenericEntityRepository<Employee>()).getListEntity();
//        employees.stream().forEach(System.out::println);

//        MakeCompany.main(new String[] {});

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


/*
    @Override
    public void start(Stage primaryStage) {
//    super.start();
        try {
            // Because we need to init the JavaFX toolkit - which usually Application.launch does
            // I'm not sure if this way of launching has any effect on anything
            new JFXPanel();

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    // Your class that extends Application
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("/Employees.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene scene = new Scene(root*/
/*, 600, 400*//*
);
                    primaryStage.setTitle("Employee");
                    primaryStage.setScene(scene);
                    primaryStage.show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/

}
