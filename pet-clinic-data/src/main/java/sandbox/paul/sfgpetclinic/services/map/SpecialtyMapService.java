package sandbox.paul.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import sandbox.paul.sfgpetclinic.model.Specialty;
import sandbox.paul.sfgpetclinic.services.SpecialtiesService;

import java.util.Set;

@Service
public class SpecialtyMapService extends AbstractMapService<Specialty, Long> implements SpecialtiesService {
    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Specialty save(Specialty specialty) {
        return super.save(specialty);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Specialty specialty) {
        super.delete(specialty);
    }

}
