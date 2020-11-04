package kvinz.springframework.petclinic.bootstrap;

import kvinz.springframework.petclinic.model.*;
import kvinz.springframework.petclinic.services.OwnerService;
import kvinz.springframework.petclinic.services.PetTypeService;
import kvinz.springframework.petclinic.services.SpecialtyService;
import kvinz.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService  vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }


    @Override
    public void run(String... args) throws Exception {

        int counter = petTypeService.findAll().size();

        if(counter ==0) loadData();

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty saveddentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Ivan");
        owner1.setLastName("Korovin");
        owner1.setAddress("Engelas str 1");
        owner1.setCity("Sumy");
        owner1.setTelephone("123123123");

        Pet ivanPet = new Pet();
        ivanPet.setPetType(saveDogPetType);
        ivanPet.setOwner(owner1);
        ivanPet.setBirthDate(LocalDate.now());
        ivanPet.setName("Pepega");
        owner1.getPets().add(ivanPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Marianna");
        owner2.setLastName("Kiss");
        owner2.setAddress("Pepega str 1");
        owner2.setCity("Kiev");
        owner2.setTelephone("123442123");
        ownerService.save(owner2);

        Pet mariannaPet = new Pet();
        ivanPet.setPetType(saveCatPetType);
        ivanPet.setOwner(owner2);
        ivanPet.setBirthDate(LocalDate.now());
        ivanPet.setName("Jpega");
        owner2.getPets().add(ivanPet);

        System.out.println("-------Loaded owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Maksym");
        vet1.setLastName("Maksymov");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Alex");
        vet2.setLastName("Panin");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("-------Loaded vets");
    }
}
