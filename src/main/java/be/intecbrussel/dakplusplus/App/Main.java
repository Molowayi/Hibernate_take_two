package be.intecbrussel.dakplusplus.App;

import be.intecbrussel.dakplusplus.datalayer.EmployeeRepository;
import be.intecbrussel.dakplusplus.datalayer.EntityManagerCreator;
import be.intecbrussel.dakplusplus.model.Adress;
import be.intecbrussel.dakplusplus.model.ContactData;
import be.intecbrussel.dakplusplus.model.client.Client;
import be.intecbrussel.dakplusplus.model.company.Company;
import be.intecbrussel.dakplusplus.model.company.Employee;
import be.intecbrussel.dakplusplus.model.company.Role;
import be.intecbrussel.dakplusplus.model.company.WorkedHours;
import be.intecbrussel.dakplusplus.model.invoice.Invoice;
import be.intecbrussel.dakplusplus.model.invoice.Invoice_Type;
import be.intecbrussel.dakplusplus.model.invoice.SmallInvoice;
import be.intecbrussel.dakplusplus.model.project.*;
import be.intecbrussel.dakplusplus.model.quotation.Quotation;

import javax.persistence.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

//        EntityManagerFactory emf = EntityManagerCreator.g;
//        EntityManager em = emf.createEntityManager();
        EntityManager em = EntityManagerCreator.getEntityManager();
        em.getTransaction().begin();

        Adress adress1 = new Adress("Aanspach", "12", "1000", "Bruxelles", "Belgique");
        Adress adress2 = new Adress("Aanspach", "12", "1000", "Bruxelles", "Belgique");
        Adress adress3 = new Adress("Aanspach", "12", "1000", "Bruxelles", "Belgique");
        Adress adress4 = new Adress("Aanspach", "12", "1000", "Bruxelles", "Belgique");

        ContactData contactData1 = new ContactData();
        contactData1.setEmail("email@gmail.com");
        contactData1.setMobile("0477777777");
        ContactData contactData2 = new ContactData();
        ContactData contactData3 = new ContactData();
        ContactData contactData4 = new ContactData();
        Set<ContactData> contactDataDpp = new HashSet<>();
        contactDataDpp.add(contactData4);

        Set<Adress> adresses = new HashSet<>();
        Set<Adress> adresses2 = new HashSet<>();
        Set<Adress> adresses3 = new HashSet<>();

        adresses.add(adress1);
        contactData1.setAdresses(adresses);
        adresses2.add(adress2);
        contactData2.setAdresses(adresses2);
        adresses3.add(adress3);
        contactData3.setAdresses(adresses3);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 2, 21);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2018, 3, 21);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(2018, 4, 21);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2018, 5, 21);

        Task task = new Task("Cleaning", calendar, calendar1);
        Task task1 = new Task("Glueing", calendar1, calendar2);
        Task task2 = new Task("Painitng", calendar3, calendar1);
        Task task3 = new Task();

        List<Task> tasks = new ArrayList<>();
        tasks.add(task);
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);

        Planning planning = new Planning();
        planning.setTasks(tasks);

        Material material1 = new Material("Wood", 10, 5);
        Material material2 = new Material("Glass", 100, 5);
        Material material3 = new Material("Glue", 10, 5);
        Material material4 = new Material("Steel", 150, 5);
        List<Material> materials = new ArrayList<>();
        materials.add(material1);
        materials.add(material3);
        materials.add(material2);
        materials.add(material4);

        Equipment hammer = new Equipment("hammer", 10, 1);
        Equipment knife = new Equipment("knife", 2, 1);
        Equipment cisors = new Equipment("scisors", 2, 11);

        List<Equipment> equipment = new ArrayList<>();
        equipment.add(cisors);
        equipment.add(knife);
        equipment.add(hammer);

        Invoice invoice = new SmallInvoice();
        invoice.setType(Invoice_Type.ALL_ONCE);
        invoice.setMaterials(materials);

        WorkedHours workedHours1 = new WorkedHours();
        WorkedHours workedHours2 = new WorkedHours();
        WorkedHours workedHours3 = new WorkedHours();
        Set<WorkedHours> workedHoursSet = new HashSet<>();
        workedHoursSet.add(workedHours1);
        workedHoursSet.add(workedHours2);
        workedHoursSet.add(workedHours2);

        Employee tom = new Employee();
        tom.setContactData(contactData1);

        Calendar birthdate = Calendar.getInstance();
        birthdate.set(1990, 6, 26);
        tom.setFirstName("Tom");
        tom.setLastName("Sawyer");
        tom.setHours(workedHoursSet);
        tom.setBirthdate(birthdate);
        tom.setRole(Role.WORKER);

        Employee jan = new Employee();
        jan.setContactData(contactData1);

        Calendar birthdate2 = Calendar.getInstance();
        birthdate2.set(1992, 7, 26);
        jan.setFirstName("Jan");
        jan.setLastName("Sammers");
        jan.setBirthdate(birthdate2);
        jan.setRole(Role.TEAM_LEADER);


        Client client = new Client();
        client.setName("Michel");
        client.setContactData(contactData1);

        List<Client> clients = new ArrayList<>();
        clients.add(client);

        Quotation quotation = new Quotation();
        quotation.setAmount(1000f);
        quotation.setClient(client);


        Project project = new Project();
        project.setDescription("First project for our company");
        project.setClient(client);
        project.setAdresses(adresses);
        project.setInvoice(invoice);
        project.setPlanning(planning);
        project.setQuotation(quotation);

        quotation.setProject(project);

        Company dakplusplus = new Company();
        dakplusplus.setContactData(contactDataDpp);
        dakplusplus.setName("Dak plus plus");
        Set<Employee> employees = new HashSet<>();
        employees.add(tom);
        employees.add(jan);
        dakplusplus.setEmployees(employees);

        dakplusplus.setClients(clients);
        client.setCompany(dakplusplus);
        Set<Employee> employees1 = new HashSet<>();
        employees1.add(jan);
        employees1.add(tom);
        project.setEmployees(employees1);


        em.persist(dakplusplus);
        em.getTransaction().commit();


        // DISPLAYING ALL THE EMPLOYEES
        System.out.println("List of employees");
        EmployeeRepository employeeRepository = new EmployeeRepository();
        List<Employee> employeesS = employeeRepository.getListEmployee();
        employeesS.stream().forEach(System.out::println);

        em.close();
  //      emf.close();

    }
}
