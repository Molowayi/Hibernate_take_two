package be.intecbrussel.dakplusplus.App;

import be.intecbrussel.dakplusplus.datalayer.EmployeeRepository;
import be.intecbrussel.dakplusplus.model.Adress;
import be.intecbrussel.dakplusplus.model.ContactData;
import be.intecbrussel.dakplusplus.model.company.Employee;
import be.intecbrussel.dakplusplus.model.company.Role;

public class SaveEmployee {

    public static void main(String[] args) {

        Employee jeb = hireEmployee("Jeb", "Bush", "0477777776", "15, Hogestraat, 1000, Bruxelles, Belgium", Role.ADMINISTRATIVE);
        Employee james = hireEmployee("James", "Monroe", "0477777775", "18, Philippe de Champagne, 1000, Bruxelles, Belgium", Role.TEAM_LEADER);
        EmployeeRepository employeeRepository = new EmployeeRepository();
        employeeRepository.createEmployee(jeb);
        employeeRepository.createEmployee(james);

        System.out.println("Employee " + jeb + " was created in the database");
        System.out.println("Employee " + james + " was created in the database");
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
