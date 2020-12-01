package sandbox.paul.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import sandbox.paul.sfgpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
