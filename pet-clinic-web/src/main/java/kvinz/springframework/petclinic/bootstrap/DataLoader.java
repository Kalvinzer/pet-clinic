package kvinz.springframework.petclinic.bootstrap;

import kvinz.springframework.petclinic.model.Owner;
import kvinz.springframework.petclinic.model.Vet;
import kvinz.springframework.petclinic.services.OwnerService;
import kvinz.springframework.petclinic.services.VetService;
import kvinz.springframework.petclinic.services.map.OwnerServiceMap;
import kvinz.springframework.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService  vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Ivan");
        owner1.setLastNamel("Korovin");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Marianna");
        owner2.setLastNamel("Kiss");

        ownerService.save(owner2);

        System.out.println("-------Loaded owners");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Maksym");
        vet1.setLastNamel("Maksymov");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Alex");
        vet2.setLastNamel("Panin");

        vetService.save(vet2);

        System.out.println("-------Loaded vets");

    }
}
