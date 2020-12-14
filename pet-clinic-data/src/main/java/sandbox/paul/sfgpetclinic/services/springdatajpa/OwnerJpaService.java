package sandbox.paul.sfgpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sandbox.paul.sfgpetclinic.model.Owner;
import sandbox.paul.sfgpetclinic.repositories.OwnerRepository;
import sandbox.paul.sfgpetclinic.repositories.PetRepository;
import sandbox.paul.sfgpetclinic.services.OwnerService;
import sandbox.paul.sfgpetclinic.services.PetTypeService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeService petTypeService;

    public OwnerJpaService(OwnerRepository ownerRepository, PetRepository petRepository,
                           PetTypeService petTypeService) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeService = petTypeService;
    }


    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return ownerRepository.findAllByLastNameLike(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();

        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }
}
