package sandbox.paul.sfgpetclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sandbox.paul.sfgpetclinic.model.Owner;
import sandbox.paul.sfgpetclinic.repositories.OwnerRepository;
import sandbox.paul.sfgpetclinic.repositories.PetRepository;
import sandbox.paul.sfgpetclinic.services.PetTypeService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeService petTypeService;

    @InjectMocks
    OwnerJpaService ownerJpaService;

    final Long testId = 1L;
    final String testName = "Tester";

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().lastName(testName).id(testId).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner testOwner = ownerJpaService.findByLastName(testName);
        assertEquals(testName, testOwner.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Integer testSize = 0;
        Set<Owner> owners = new HashSet<>();
        owners.add(returnOwner);
        owners.add(Owner.builder().build());

        when(ownerRepository.findAll()).thenReturn(owners);
        testSize = owners.size();

        Set<Owner> testOwners = ownerJpaService.findAll();

        assertNotNull(testOwners);
        assertEquals(testSize, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(testId)).thenReturn(Optional.of(returnOwner));

        Owner foundOwner = ownerJpaService.findById(testId);

        assertNotNull(foundOwner);
        assertEquals(testId, foundOwner.getId());
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(testId)).thenReturn(Optional.empty());

        Owner foundOwner = ownerJpaService.findById(testId);

        assertNull(foundOwner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(testId).build();

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = ownerJpaService.save(ownerToSave);

        assertNotNull(savedOwner);
        assertEquals(testId, savedOwner.getId());
    }

    @Test
    void delete() {
        ownerJpaService.delete(returnOwner);

        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerJpaService.deleteById(testId);

        verify(ownerRepository).deleteById(any());
    }
}