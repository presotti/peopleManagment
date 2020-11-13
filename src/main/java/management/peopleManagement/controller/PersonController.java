package management.peopleManagement.controller;


import management.peopleManagement.dto.MessageResponseDTO;
import management.peopleManagement.dto.request.PersonDTO;
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
