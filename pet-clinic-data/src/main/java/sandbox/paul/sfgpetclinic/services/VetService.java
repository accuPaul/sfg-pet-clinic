package sandbox.paul.sfgpetclinic.services;

import sandbox.paul.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);

    Vet findByLastName(String lastName);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
