package thaddeusng.ReceiptReader.DataAccessLayer.data;

import thaddeusng.ReceiptReader.DataAccessLayer.interfaces.Identifiable;
import java.util.Date;

public class Order implements Identifiable {

    private Long Id;
    private String Description;
    private long CostInUsdCents;
    private Date Date;
    private boolean isComplete;

    @Override

    public Long getId() {

        return Id;

    }

    @Override

    public void setId(Long id) {

        this.Id = id;

    }

    public String getDescription() {

        return Description;

    }

    public void setDescription(String description) {

        this.Description = description;

    }

    public void setCostInUsdCents(long cost) {

        CostInUsdCents = cost;

    }

    public long getCostInUsdCents() {

        return CostInUsdCents;

    }

    public Date getDate(){

        return Date;

    }

    public void setDate(Date date){

        Date = date;

    }

    public void setComplete(boolean isComplete) {

        this.isComplete = isComplete;

    }

    public void markComplete() {

        setComplete(true);

    }

    public void markIncomplete() {

        setComplete(false);

    }

    public boolean isComplete() {

        return isComplete;

    }

}