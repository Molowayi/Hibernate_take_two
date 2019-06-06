package be.intecbrussel.dakplusplus.model.invoice;

import javax.persistence.DiscriminatorValue;
import java.util.Calendar;
import java.util.Map;

@DiscriminatorValue("TWO_TIMES")
public class BigInvoice {

    private Map<Calendar, Float> payment;

    public Map<Calendar, Float> getPayment() {
        return payment;
    }

    public void setPayment(Map<Calendar, Float> payment) {
        this.payment = payment;
    }

}
