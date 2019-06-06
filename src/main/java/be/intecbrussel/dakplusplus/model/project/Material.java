package be.intecbrussel.dakplusplus.model.project;

import be.intecbrussel.dakplusplus.model.invoice.Invoice;

import javax.persistence.*;

@Entity
public class Material {

    @Id
    @GeneratedValue
    private long id;
    private static float stock;
    private String designation;
    private float cost;
    private float quantity;   // TODO : together with equipment?
    @ManyToOne(cascade = {CascadeType.ALL})
    private Invoice invoice;

    public Material() {
    }

    public Material(String designation, float cost, float quantity) {
        this.designation = designation;
        this.cost = cost;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static float getStock() {
        return stock;
    }

    public static void setStock(float stock) {
        Material.stock = stock;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
