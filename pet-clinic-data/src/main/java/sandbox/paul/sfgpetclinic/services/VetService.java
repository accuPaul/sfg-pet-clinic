package sandbox.paul.sfgpetclinic.services;

import sandbox.paul.sfgpetclinic.model.Vet;

public interface VetService extends CrudService<Vet, Long>{

    Vet findByLastName(String lastName);
}
