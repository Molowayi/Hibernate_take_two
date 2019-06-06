package be.intecbrussel.dakplusplus.model;

import be.intecbrussel.dakplusplus.model.project.Project;
import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Adress {

    @Id
    @GeneratedValue
    private long id;
    @NotNull
    private String street;
    @NotNull
    private String number;  // TODO is numbr a key word in mysql?
    @NotNull
    private String zipCode;
    @NotNull
    private String city;
    @NotNull
    private String country;
    @ManyToMany(cascade = {CascadeType.ALL})
    private Set<ContactData> data = new HashSet<>();
    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "adresses")
    private Set<Project> projects = new HashSet<>();

    public Adress() {
    }

    public Adress(String street, String number, String zipCode, String city, String country) {
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<ContactData> getData() {
        return data;
    }

    public void setData(Set<ContactData> data) {
        this.data = data;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public void addContactData(ContactData contactData) {
        data.add(contactData);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Adress adress = (Adress) o;

        if (id != adress.id) return false;
        if (street != null ? !street.equals(adress.street) : adress.street != null) return false;
        if (number != null ? !number.equals(adress.number) : adress.number != null) return false;
        if (zipCode != null ? !zipCode.equals(adress.zipCode) : adress.zipCode != null) return false;
        if (city != null ? !city.equals(adress.city) : adress.city != null) return false;
        if (country != null ? !country.equals(adress.country) : adress.country != null) return false;
        if (data != null ? !data.equals(adress.data) : adress.data != null) return false;
        return projects != null ? projects.equals(adress.projects) : adress.projects == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (projects != null ? projects.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

