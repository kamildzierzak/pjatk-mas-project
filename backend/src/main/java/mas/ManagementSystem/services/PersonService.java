package mas.ManagementSystem.services;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.entities.people.PersonEntity;
import mas.ManagementSystem.repositories.PersonRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonService {

  private final PersonRepository personRepository;

  public Optional<PersonEntity> getPerson(Long id) {
    return personRepository.findById(id);
  }

  public List<PersonEntity> createPeople(List<PersonEntity> persons) {
    return personRepository.saveAll(persons);
  }

  public long getNumberOfPeople() {
    return personRepository.count();
  }
}
