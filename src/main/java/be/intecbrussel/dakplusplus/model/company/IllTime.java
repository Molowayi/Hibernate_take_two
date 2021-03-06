package be.intecbrussel.dakplusplus.model.company;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class IllTime {

    @Id
    @GeneratedValue
    private long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar begin;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar end;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
