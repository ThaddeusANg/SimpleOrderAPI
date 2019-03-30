package thaddeusng.ReceiptReader.DataAccessLayer.interfaces;

public interface Identifiable extends org.springframework.hateoas.Identifiable<Long> {

    public void setId(Long id);

}