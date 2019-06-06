package be.intecbrussel.dakplusplus.model.invoice;

import be.intecbrussel.dakplusplus.model.client.Client;
import be.intecbrussel.dakplusplus.model.project.Equipment;
import be.intecbrussel.dakplusplus.model.project.Material;
import be.intecbrussel.dakplusplus.model.project.Project;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Invoice {

    @Id
    @GeneratedValue
    private long id;

    private float amount;
    @Enumerated(EnumType.STRING)
    private Invoice_Type type;
    @ManyToOne()
    private Client client;
    @OneToMany()
    private List<Equipment> equipment = new ArrayList<>();
    @OneToMany()
    private List<Material> materials = new ArrayList<>();
    @OneToOne(cascade = {CascadeType.ALL}, mappedBy = "invoice")
    private Project project;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getAmount() {

        float emount = 0;
        for (Material m :
                materials) {
            emount += m.getCost() * m.getQuantity();

        }
        return emount;
    }

    private void setAmount(float amount) {
        this.amount = amount;
    }

    public Invoice_Type getType() {
        return type;
    }

    public void setType(Invoice_Type type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
