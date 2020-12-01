package sandbox.paul.sfgpetclinic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sandbox.paul.sfgpetclinic.model.*;
import sandbox.paul.sfgpetclinic.services.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    @Autowired  //No longer needed with Spring 5
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        if (petTypeService.findAll().size() == 0) loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("CAT");
        PetType saveCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedSpecialty1 = specialtyService.save(radiology);
        Specialty savedSpecialty2 = specialtyService.save(dentistry);
        Specialty savedSpecialty3 = specialtyService.save(surgery);

        Owner owner1 = new Owner();
        owner1.setFirstName("Lucy");
        owner1.setLastName("Gordon");
        owner1.setAddress("1313 Mockingbird Lane");
        owner1.setCity("Detroit");
        owner1.setTelephone("555-555-5555");

        Pet pet1 = new Pet();
        pet1.setPetType(savedDogPetType);
        pet1.setName("Jessie");
        pet1.setOwner(owner1);
        pet1.setBirthDate(LocalDate.now());
        //petService.save(pet1);
        owner1.getPets().add(pet1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Paul");
        owner2.setLastName("Mount");
        owner2.setAddress("10 Downing St");
        owner2.setCity("London");
        owner2.setTelephone("041-555-5555");

        Pet pet2 = new Pet();
        pet2.setPetType(saveCatPetType);
        pet2.setName("Gabby");
        pet2.setOwner(owner2);
        pet2.setBirthDate(LocalDate.now());
        //petService.save(pet2);
        owner2.getPets().add(pet2);

        ownerService.save(owner1);
        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(pet2);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("A visit with "+pet2.getName());

        visitService.save(catVisit);

        System.out.println("Owners loaded...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Jessie");
        vet1.setLastName("Yellowlab");
        vet1.getSpecialties().add(savedSpecialty3);

        Vet vet2 = new Vet();
        vet2.setFirstName("Bennett");
        vet2.setLastName("Blacklab");
        vet2.getSpecialties().add(savedSpecialty1);

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("Vets loaded too...");
    }
}
