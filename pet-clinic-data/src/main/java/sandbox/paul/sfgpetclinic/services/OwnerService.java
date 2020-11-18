package sandbox.paul.sfgpetclinic.services;

import sandbox.paul.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
