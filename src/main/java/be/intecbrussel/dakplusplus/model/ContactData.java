package be.intecbrussel.dakplusplus.model;

import be.intecbrussel.dakplusplus.model.company.Company;
import be.intecbrussel.dakplusplus.model.company.Employee;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ContactData implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String email;
    private String mobile;
    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "data")
    private Set<Adress> adresses = new HashSet<>();
    @ManyToOne(cascade = {CascadeType.ALL})
    private Company company;
    @OneToOne(cascade = {CascadeType.ALL})
    private Employee employee;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Set<Adress> getAdresses() {
        return adresses;
    }

    public void setAdresses(Set<Adress> adresses) {
        this.adresses = adresses;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void addAdress(Adress adress) {
        adresses.add(adress);
        adress.addContactData(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        return adresses != null ? adresses.equals(that.adresses) : that.adresses == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (adresses != null ? adresses.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", adresses=" + adresses +
                '}';
    }
}
