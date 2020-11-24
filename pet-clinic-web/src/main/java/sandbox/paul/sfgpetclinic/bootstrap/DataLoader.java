package sandbox.paul.sfgpetclinic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sandbox.paul.sfgpetclinic.model.Owner;
import sandbox.paul.sfgpetclinic.model.Pet;
import sandbox.paul.sfgpetclinic.model.PetType;
import sandbox.paul.sfgpetclinic.model.Vet;
import sandbox.paul.sfgpetclinic.services.OwnerService;
import sandbox.paul.sfgpetclinic.services.PetService;
import sandbox.paul.sfgpetclinic.services.PetTypeService;
import sandbox.paul.sfgpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;

    @Autowired  //No longer needed with Spring 5
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("CAT");
        PetType saveCatPetType = petTypeService.save(cat);

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

        System.out.println("Owners loaded...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Jessie");
        vet1.setLastName("Yellowlab");

        Vet vet2 = new Vet();
        vet2.setFirstName("Bennett");
        vet2.setLastName("Blacklab");

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("Vets loaded too...");
    }
}
