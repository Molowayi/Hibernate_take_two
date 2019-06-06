package be.intecbrussel.dakplusplus.model.project;

import be.intecbrussel.dakplusplus.model.invoice.Invoice;

import javax.persistence.*;

@Entity
public class Equipment {

    @Id
    @GeneratedValue
    private long id;
    private String designation;
    private float cost;
    private int quantity;
    @ManyToOne(cascade = {CascadeType.ALL})
    private Invoice invoice;
    @ManyToOne(cascade = {CascadeType.ALL})
    private Task task;

    public Equipment() {
    }

    public Equipment(String designation, float cost, int quantity) {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
