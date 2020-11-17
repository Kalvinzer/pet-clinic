package kvinz.springframework.petclinic.services.map;

import kvinz.springframework.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    final Long ownerId= 1L;
    final Long owner2Id= 2L;
    final String lastName = "Kaznacheiev";

    @BeforeEach
    void setUp() {
        ownerServiceMap =  new OwnerServiceMap(new PetTypeServiceMap(),new PetServiceMap());

        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findByLastName() {
        Owner ownerFind = ownerServiceMap.findByLastName(lastName);
        assertNotNull(ownerFind);
        assertEquals(lastName,ownerFind.getLastName());
    }

    @Test
    void findByLastNameNotFound() {
        Owner ownerFind = ownerServiceMap.findByLastName("foo");
        assertNull(ownerFind);
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(1,owners.size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);
        assertEquals(ownerId,owner.getId());
    }

    @Test
    void saveExistingId() {
        Owner owner2 = Owner.builder().id(owner2Id).build();
        Owner saveOwner = ownerServiceMap.save(owner2);
        assertEquals(owner2Id, saveOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner =ownerServiceMap.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertEquals(0,ownerServiceMap.findAll().size());
    }
}