package be.intecbrussel.dakplusplus.model.project;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private long id;
    private String designation;
    @Temporal(TemporalType.DATE)
    private Calendar begin;
    @Temporal(TemporalType.DATE)
    private Calendar end;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "task")
    private List<Equipment> equipment = new ArrayList<>();
    @ManyToOne(cascade = {CascadeType.ALL})
    private  Planning planning;

    public Task(String designation, Calendar begin, Calendar end) {
        this.designation = designation;
        this.begin = begin;
        this.end = end;
    }

    public Task() {
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

    public Calendar getBegin() {
        return begin;
    }

    public void setBegin(Calendar begin) {
        this.begin = begin;
    }

    public Calendar getEnd() {
        return end;
    }

    public void setEnd(Calendar end) {
        this.end = end;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    public Planning getPlanning() {
        return planning;
    }

    public void setPlanning(Planning planning) {
        this.planning = planning;
    }
}
