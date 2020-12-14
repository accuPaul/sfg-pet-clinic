package sandbox.paul.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import sandbox.paul.sfgpetclinic.model.Owner;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
