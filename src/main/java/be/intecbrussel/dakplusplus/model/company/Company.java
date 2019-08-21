package be.intecbrussel.dakplusplus.model.company;

import be.intecbrussel.dakplusplus.model.ContactData;
import be.intecbrussel.dakplusplus.model.client.Client;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Company {
    @Id
    @GeneratedValue
    private long id;
    @NotNull
    private String name;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "company")
    private List<Client> clients = new ArrayList<>();
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "company")
    private Set<Employee> employees = new HashSet<>();
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "company")
    private Set<ContactData> contactData = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<ContactData> getContactData() {
        return contactData;
    }

    public void setContactData(Set<ContactData> contactData) {
        this.contactData = contactData;
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
        employee.setCompany(this);
    }

    public void addClient(Client client){
        clients.add(client);
        client.setCompany(this);
    }

    public void addContactData(ContactData contactData){
        this.contactData.add(contactData);
        contactData.setCompany(this);
    }
}
