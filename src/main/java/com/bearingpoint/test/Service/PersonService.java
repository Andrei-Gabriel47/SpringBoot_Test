package com.bearingpoint.test.Service;

import com.bearingpoint.test.DAO.PersonDAO;
import com.bearingpoint.test.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService
{
    private final PersonDAO personDAO;

    @Autowired
    public PersonService(@Qualifier("FakeDAO") PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public int addPerson(Person person)
    {
      return   personDAO.insertPerson(person);
    }
    public ArrayList<Person> getAllPeople()
    {
        return personDAO.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID Id)
    {
        return personDAO.selectPersonById(Id);
    }
    public int deletePerson(UUID Id)
    {
        return personDAO.deleteById(Id);
    }
    public int updatePerson(UUID Id, Person newPerson)
    {
        return  personDAO.updateById(Id,newPerson);
    }
}
