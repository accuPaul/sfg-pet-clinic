package sandbox.paul.sfgpetclinic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sandbox.paul.sfgpetclinic.model.Owner;
import sandbox.paul.sfgpetclinic.model.Vet;
import sandbox.paul.sfgpetclinic.services.OwnerService;
import sandbox.paul.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired  //No longer needed with Spring 5
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Lucy");
        owner1.setLastName("Gordon");

        Owner owner2 = new Owner();
        owner2.setFirstName("Paul");
        owner2.setLastName("Mount");

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
