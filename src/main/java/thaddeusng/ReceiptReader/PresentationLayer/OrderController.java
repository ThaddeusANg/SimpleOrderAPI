package thaddeusng.ReceiptReader.PresentationLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thaddeusng.ReceiptReader.DataAccessLayer.Repositories.OrderRepository;
import thaddeusng.ReceiptReader.DataAccessLayer.data.Order;

import javax.xml.ws.Response;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@ExposesResourceFor(Order.class)
@RequestMapping(value = "/order", produces = "application/json")
public class OrderController {
    // Repository takes the body data from request and converts it into a domain object.
    @Autowired
    private OrderRepository repository;

    // ResourceAssembler takes the domain object and converts it into a Resource Type decorated with links to the associated API endpoints
    @Autowired
    private OrderResourceAssembler resourceAssembler;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<OrderResource>> FindAllOrders(){
        List<Order> orders = repository.findAll();

        return new ResponseEntity(resourceAssembler.ToResourceCollection(orders), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<OrderResource> CreateOrder(@RequestBody Order order){
        Order createdOrder = repository.create(order);
        return new ResponseEntity(resourceAssembler.ToResource(createdOrder), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<OrderResource> FindOrderById(@PathVariable Long id){
        Optional<Order> order = repository.findById(id);

        return order.isPresent()
                ? new ResponseEntity(resourceAssembler.ToResource(order.get()), HttpStatus.FOUND)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
    public ResponseEntity<OrderResource> UpdateOrder(@PathVariable Long id, @RequestBody Order updatedOrder){
        boolean wasUpdateSuccessful = repository.update(id, updatedOrder);

        return wasUpdateSuccessful
                ? FindOrderById(id)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> DeleteOrder(@PathVariable Long id){
        boolean wasDeleted = repository.delete(id);

        HttpStatus status = wasDeleted ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;

        return new ResponseEntity(status);
    }
}
