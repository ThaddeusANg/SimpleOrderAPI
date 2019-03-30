package thaddeusng.ReceiptReader.PresentationLayer;

import java.util.Collection;
import java.util.stream.Collectors;

public abstract class ResourceAssembler<DomainType, ResourceType> {
    public abstract ResourceType ToResource(DomainType domainObject);

    public Collection<ResourceType> ToResourceCollection(Collection<DomainType> domainObjects) {

        return domainObjects.stream().map(o -> ToResource(o)).collect(Collectors.toList());

    }

}