package be.intecbrussel.dakplusplus.App;

import be.intecbrussel.dakplusplus.datalayer.EmployeeRepository;
import be.intecbrussel.dakplusplus.model.company.Employee;

import java.util.List;

public class ListEmployees {

    public static void main(String[] args) {

        EmployeeRepository employeeRepository = new EmployeeRepository();
        List<Employee> employees = employeeRepository.getListEmployee();
        employees.stream().forEach(System.out::println);
    }
}
