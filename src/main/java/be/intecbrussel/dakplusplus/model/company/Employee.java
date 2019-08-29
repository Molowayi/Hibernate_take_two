package be.intecbrussel.dakplusplus.model.company;

import be.intecbrussel.dakplusplus.model.Adress;
import be.intecbrussel.dakplusplus.model.ContactData;
import be.intecbrussel.dakplusplus.model.project.Project;
import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.*;

@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    @NotNull
    private String firstName;
    @NotNull
    private Calendar birthdate;
    @NotNull
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Company company;
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<IllTime> illTimes = new HashSet<>();
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<WorkedHours> hours = new HashSet<>();
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Project project;
    @OneToOne(cascade = {CascadeType.ALL}, mappedBy = "employee", fetch = FetchType.EAGER, orphanRemoval = true)
    private ContactData contactData;

    public Employee() {
    }

    public Employee(String firstName, String lastName, Role role, ContactData contactData) {
        this.firstName = firstName;
        this.lastName = lastName;

        this.role = role;
        this.contactData = contactData;
    }

    public Employee(String firstname, String lastname, String gsm, String email, String street, String nr, String zipcode, String city, String country, Role role, Calendar birthdate) {

        Adress adress = new Adress(street, nr, zipcode, city, country);
        ContactData contactData = new ContactData();
        contactData.setMobile(gsm);
        contactData.setEmail(email);
        contactData.addAdress(adress);
        this.addContactData(contactData);
        this.firstName = firstname;
        this.lastName = lastname;
        this.role = role;
        this.birthdate = birthdate;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<IllTime> getIllTimes() {
        return illTimes;
    }

    public void setIllTimes(Set<IllTime> illTimes) {
        this.illTimes = illTimes;
    }

    public Set<WorkedHours> getHours() {
        return hours;
    }

    public void setHours(Set<WorkedHours> hours) {
        this.hours = hours;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public ContactData getContactData() {
        return contactData;
    }

    public void setContactData(ContactData contactData) {
        this.contactData = contactData;
    }

    public void addContactData(ContactData contactData) {
        this.contactData = contactData;
        contactData.setEmployee(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        if (role != employee.role) return false;
        return contactData != null ? contactData.equals(employee.contactData) : employee.contactData == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (contactData != null ? contactData.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + role + " born the " + birthdate.toInstant()
/*
                +
                ", contactData=" + contactData +
                '}'
*/
                ;
    }

    public void setBirthdate(Calendar birthdate) {
        this.birthdate = birthdate;
    }

    public Calendar getBirthdate() {
        return birthdate;
    }

    public void makeRoleFromString(String s) {
        Role role = null;
        switch (s) {
            case "ADMINISTRATIVE":
                role = Role.ADMINISTRATIVE;
                break;
            case "TEAM_LEADER":
                role = Role.TEAM_LEADER;
                break;
            case "WORKER":
                role = Role.WORKER;
                break;
            case "MANAGER":
                role = Role.MANAGER;
                break;
        }
        this.role = role;
    }

    public static Role makeEmployeeRoleFromString(String s) {
        Role role = null;
        switch (s) {
            case "ADMINISTRATIVE":
                role = Role.ADMINISTRATIVE;
                break;
            case "TEAM_LEADER":
                role = Role.TEAM_LEADER;
                break;
            case "WORKER":
                role = Role.WORKER;
                break;
            case "MANAGER":
                role = Role.MANAGER;
                break;
        }
        return role;
    }
}
