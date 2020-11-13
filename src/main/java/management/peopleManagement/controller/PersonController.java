package management.peopleManagement.controller;


import lombok.AllArgsConstructor;
import management.peopleManagement.dto.MessageResponseDTO;
import management.peopleManagement.dto.request.PersonDTO;
import management.peopleManagement.entity.Person;
import management.peopleManagement.esception.PersonNotFoundException;
import management.peopleManagement.mapper.PersonMapper;
import management.peopleManagement.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@Valid  @RequestBody PersonDTO personDTO) {
        return personService.personSave(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        personService.deleteById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @Valid @RequestBody PersonDTO personDTO) throws PersonNotFoundException {
        return personService.updateById(id, personDTO);
    }
    /*@GetMapping
    public String listPersons() {
        return personRepository.
    }*/
/*
    @PostMapping
    public ResponseEntity<Person> createPerson(@Validated @RequestBody Person person){
        Person savedPerson = personRepository.save(person);
        return ResponseEntity.ok(savedPerson);
    }
*/
}
