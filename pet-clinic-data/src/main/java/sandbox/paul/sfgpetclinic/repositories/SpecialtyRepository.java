package sandbox.paul.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import sandbox.paul.sfgpetclinic.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
