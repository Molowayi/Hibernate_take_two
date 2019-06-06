package be.intecbrussel.dakplusplus.model.project;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Planning {

    @Id
    @GeneratedValue
    private long id;
    @OneToOne(cascade = {CascadeType.ALL})
    private  Project project;
    @OneToMany(cascade = {CascadeType.ALL},  mappedBy = "planning")
    private List<Task> tasks = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
