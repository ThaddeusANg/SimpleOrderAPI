package thaddeusng.ReceiptReader.DataAccessLayer.Repositories;

import org.springframework.stereotype.Repository;
import thaddeusng.ReceiptReader.DataAccessLayer.Repositories.base.InMemoryRepository;
import thaddeusng.ReceiptReader.DataAccessLayer.data.Order;

@Repository

public class OrderRepository extends InMemoryRepository<Order> {

    protected void updateIfExists(Order original, Order updated) {
        original.setDescription(updated.getDescription());
        original.setCostInUsdCents(updated.getCostInUsdCents());
        original.setComplete(updated.isComplete());
        original.setDate(updated.getDate());
    }

}