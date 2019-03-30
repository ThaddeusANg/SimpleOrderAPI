package thaddeusng.ReceiptReader.PresentationLayer;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;
import thaddeusng.ReceiptReader.DataAccessLayer.data.Order;

import java.util.Date;

public class OrderResource extends ResourceSupport {
    // Order Resource extends ResourceSupport
    // Allows us to add the api endpoints to the object itself
    // Operates like the Order class
    // With this level of indirection, we don't have to mix domain (DAL) logic with the presentation logic
    private final long id;
    private final String description;
    private final long costInUsdCents;
    private final boolean isComplete;
    private final Date orderDate;

    public OrderResource(Order order){
        id = order.getId();
        description = order.getDescription();
        costInUsdCents = order.getCostInUsdCents();
        isComplete = order.isComplete();
        orderDate = order.getDate();
    }

    @JsonProperty("id")
    public Long getResourceId() {

        return id;

    }

    public String getDescription() {

        return description;

    }

    public long getCostInUsdCents() {

        return costInUsdCents;

    }

    public boolean isComplete() {

        return isComplete;

    }

    public Date getDate(){
        return orderDate;
    }
}
