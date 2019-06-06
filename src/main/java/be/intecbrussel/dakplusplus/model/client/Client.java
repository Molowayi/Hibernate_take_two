package be.intecbrussel.dakplusplus.model.client;

import be.intecbrussel.dakplusplus.model.ContactData;
import be.intecbrussel.dakplusplus.model.company.Company;
import be.intecbrussel.dakplusplus.model.invoice.Invoice;
import be.intecbrussel.dakplusplus.model.project.Project;
import be.intecbrussel.dakplusplus.model.quotation.Quotation;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToOne(cascade = {CascadeType.ALL})
    private ContactData contactData;
    @ManyToOne(cascade = {CascadeType.ALL})
    private Company company;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Set<Invoice> invoices = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Set<Project> projects = new HashSet<>();
    @OneToOne(cascade = {CascadeType.ALL})
    private Quotation quotation;

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

    public ContactData getContactData() {
        return contactData;
    }

    public void setContactData(ContactData contactData) {
        this.contactData = contactData;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Quotation getQuotation() {
        return quotation;
    }

    public void setQuotation(Quotation quotation) {
        this.quotation = quotation;
    }
}
