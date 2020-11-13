package management.peopleManagement.service;

import management.peopleManagement.dto.MessageResponseDTO;
import management.peopleManagement.dto.request.PersonDTO;
import management.peopleManagement.entity.Person;
import management.peopleManagement.mapper.PersonMapper;
import management.peopleManagement.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO personSave(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO.builder().message("Created person with ID " + savedPerson.getId()).build();
    }
}