package sandbox.paul.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import sandbox.paul.sfgpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
