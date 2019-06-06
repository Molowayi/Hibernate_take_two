package be.intecbrussel.dakplusplus.model.project;

import be.intecbrussel.dakplusplus.model.Adress;
import be.intecbrussel.dakplusplus.model.client.Client;
import be.intecbrussel.dakplusplus.model.company.Employee;
import be.intecbrussel.dakplusplus.model.invoice.Invoice;
import be.intecbrussel.dakplusplus.model.quotation.Quotation;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Project {
    @Id
    @GeneratedValue
    private long id;
    private String description;
    @ManyToOne(cascade = {CascadeType.ALL})
    private Client client;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "project", fetch = FetchType.LAZY, orphanRemoval = false)
    private Set<Employee> employees = new HashSet<>();
    @OneToOne(cascade = {CascadeType.ALL})
    private Invoice invoice;
    @OneToOne(cascade = {CascadeType.ALL})
    private Planning planning;
    @ManyToMany(cascade = {CascadeType.ALL})
    private Set<Adress> adresses = new HashSet<>();
    @OneToOne(cascade = {CascadeType.ALL})
    private Quotation quotation;

     public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Planning getPlanning() {
        return planning;
    }

    public void setPlanning(Planning planning) {
        this.planning = planning;
    }

    public Set<Adress> getAdresses() {
        return adresses;
    }

    public void setAdresses(Set<Adress> adresses) {
        this.adresses = adresses;
    }

    public Quotation getQuotation() {
        return quotation;
    }

    public void setQuotation(Quotation quotation) {
        this.quotation = quotation;
    }
}
