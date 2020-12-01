package sandbox.paul.sfgpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sandbox.paul.sfgpetclinic.model.Specialty;
import sandbox.paul.sfgpetclinic.services.SpecialtyService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialtyJpaService implements SpecialtyService {
    private final SpecialtyService specialtyService;

    public SpecialtyJpaService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyService.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long id) {
        return specialtyService.findById(id);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyService.save(object);
    }

    @Override
    public void delete(Specialty object) {
        specialtyService.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        specialtyService.deleteById(id);
    }
}
