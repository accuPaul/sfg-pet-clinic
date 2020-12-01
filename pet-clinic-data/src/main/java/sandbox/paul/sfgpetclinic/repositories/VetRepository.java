package sandbox.paul.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import sandbox.paul.sfgpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {

    Vet findByLastName(String lastName);
}
