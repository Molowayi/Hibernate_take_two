package be.intecbrussel.dakplusplus.model.company;

import be.intecbrussel.dakplusplus.model.Adress;
import be.intecbrussel.dakplusplus.model.ContactData;
import be.intecbrussel.dakplusplus.model.project.Project;
import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private long id;
    @NotNull
    private String firstName;
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
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                ", contactData=" + contactData +
                '}';
    }

}
