package be.intecbrussel.dakplusplus.model.invoice;

import be.intecbrussel.dakplusplus.model.invoice.Invoice;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Calendar;

@DiscriminatorValue("ALL_ONCE")
public class SmallInvoice extends Invoice {

    private boolean paid;
    @Temporal(TemporalType.DATE)
    private Calendar datePayment;

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Calendar getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(Calendar datePayment) {
        this.datePayment = datePayment;
    }
}
