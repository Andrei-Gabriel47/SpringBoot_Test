package com.bearingpoint.test.API;

import com.bearingpoint.test.Model.Person;
import com.bearingpoint.test.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController
{
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public void addPerson(@RequestBody Person person)
    {
        personService.addPerson(person);
    }
    @GetMapping
    public ArrayList<Person> getAllPeople()
    {
       return personService.getAllPeople();
    }
    @GetMapping(path = "/{Id}")
    public Person getPersonById(@PathVariable("Id") UUID Id)
    {
        return personService.getPersonById(Id).orElse(null);
    }
    @DeleteMapping(path ="{Id}")
    public void deleteById(@PathVariable("Id") UUID Id)
    {
        personService.deletePerson(Id);
    }
    @PutMapping(path = "{Id}")
    public void updateById(@PathVariable("Id") UUID Id, @RequestBody Person personToUpdate)
    {
        personService.updatePerson(Id,personToUpdate);
    }
}
