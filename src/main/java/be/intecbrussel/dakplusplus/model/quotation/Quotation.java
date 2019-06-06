package be.intecbrussel.dakplusplus.model.quotation;

import be.intecbrussel.dakplusplus.model.client.Client;
import be.intecbrussel.dakplusplus.model.project.Material;
import be.intecbrussel.dakplusplus.model.project.Project;

import javax.persistence.*;
import java.util.*;
import java.util.List;

@Entity
public class Quotation {

    @Id
    private long id;
    private float amount;
    @OneToOne(cascade = {CascadeType.ALL})
    private Project project;
    @ElementCollection
    @Column(name = "PARAMETER")
    @MapKeyColumn(name = "VALUE")
    @CollectionTable(name = "Yard_details")
    private Map<String, String> yardDetails;
    @OneToMany()
    private List<Material> materials = new ArrayList<>();

    @OneToOne(cascade = {CascadeType.ALL})
    private Client client;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
