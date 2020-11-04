package kvinz.springframework.petclinic.bootstrap;

import kvinz.springframework.petclinic.model.Owner;
import kvinz.springframework.petclinic.model.PetType;
import kvinz.springframework.petclinic.model.Vet;
import kvinz.springframework.petclinic.services.OwnerService;
import kvinz.springframework.petclinic.services.PetTypeService;
import kvinz.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService  vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Ivan");
        owner1.setLastName("Korovin");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Marianna");
        owner2.setLastName("Kiss");

        ownerService.save(owner2);

        System.out.println("-------Loaded owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Maksym");
        vet1.setLastName("Maksymov");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Alex");
        vet2.setLastName("Panin");

        vetService.save(vet2);

        System.out.println("-------Loaded vets");

    }
}
