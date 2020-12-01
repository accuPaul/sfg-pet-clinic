package sandbox.paul.sfgpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sandbox.paul.sfgpetclinic.model.PetType;
import sandbox.paul.sfgpetclinic.services.PetTypeService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeJpaService implements PetTypeService {

    private final PetTypeService petTypeService;

    public PetTypeJpaService(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeService.findAll().forEach(petTypes::add);
        return petTypes;
    }

    //PetTypeService.findById does not have .orElse(). I do not know why...
    @Override
    public PetType findById(Long id) {
        return petTypeService.findById(id);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeService.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeService.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petTypeService.deleteById(id);
    }
}
