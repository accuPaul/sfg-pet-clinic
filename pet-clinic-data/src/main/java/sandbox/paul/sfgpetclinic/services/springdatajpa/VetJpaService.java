package sandbox.paul.sfgpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sandbox.paul.sfgpetclinic.model.Vet;
import sandbox.paul.sfgpetclinic.repositories.VetRepository;
import sandbox.paul.sfgpetclinic.services.VetService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Vet findByLastName(String lastName) {
        return vetRepository.findByLastName(lastName);
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();

        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    //TODO implement check for unsaved specialties
    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
