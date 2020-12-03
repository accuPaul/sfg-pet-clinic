package sandbox.paul.sfgpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sandbox.paul.sfgpetclinic.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    final Long idValue = 1L;
    final String testName = "Tester";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(),new PetMapService());

        ownerMapService.save(Owner.builder().id(idValue).lastName(testName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {

        Owner owner = ownerMapService.findById(idValue);

        assertEquals(idValue, owner.getId());
    }

    @Test
    void save() {
        Long testId = 2L;
        Owner testOwner = Owner.builder().id(testId).build();

        Owner savedOwner = ownerMapService.save(testOwner);

        assertEquals(testId, savedOwner.getId());
        assertEquals(2, ownerMapService.findAll().size());
    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        Integer startSize = ownerMapService.findAll().size();
        ownerMapService.delete(ownerMapService.findById(idValue));

        assertEquals(startSize-1, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        Integer startSize = ownerMapService.findAll().size();
        ownerMapService.deleteById(idValue);

        assertEquals(startSize-1, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {

        Owner foundOwner = ownerMapService.findByLastName(testName);

        assertNotNull(foundOwner);
        assertEquals(testName, foundOwner.getLastName());
    }
}