package com.bearingpoint.test.DAO;

import com.bearingpoint.test.Model.Person;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public interface PersonDAO
{
    int insertPerson(UUID Id, Person person);
    default int insertPerson(Person person)
    {
        UUID Id = UUID.randomUUID();
        return insertPerson(Id,person);
    }
    ArrayList<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID Id);
    int deleteById(UUID Id);
    int updateById(UUID Id, Person person);

}
