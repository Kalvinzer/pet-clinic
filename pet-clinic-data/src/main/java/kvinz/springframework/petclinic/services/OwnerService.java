package kvinz.springframework.petclinic.services;

import kvinz.springframework.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);

}
