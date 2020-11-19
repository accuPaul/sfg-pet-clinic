package sandbox.paul.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sandbox.paul.sfgpetclinic.model.Owner;
import sandbox.paul.sfgpetclinic.model.Vet;
import sandbox.paul.sfgpetclinic.services.OwnerService;
import sandbox.paul.sfgpetclinic.services.VetService;
import sandbox.paul.sfgpetclinic.services.map.OwnerServiceMap;
import sandbox.paul.sfgpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId((1L));
        owner1.setFirstName("Lucy");
        owner1.setLastName("Gordon");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Paul");
        owner2.setLastName("Mount");

        ownerService.save(owner1);
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setId((1L));
        vet1.setFirstName("Jessie");
        vet1.setLastName("Yellowlab");

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Bennett");
        vet2.setLastName("Blacklab");

        vetService.save(vet1);
        vetService.save(vet2);
    }
}