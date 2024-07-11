package com.bearingpoint.test.DAO;

import com.bearingpoint.test.Model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
@Repository("FakeDAO")
public class PersonToAccesService implements PersonDAO {
    private static ArrayList<Person> personList = new ArrayList<>();
    @Override
    public int insertPerson(UUID Id, Person person) {
        personList.add(new Person(Id, person.getName()));
        return 1;
    }

    @Override
    public ArrayList<Person> selectAllPeople() {
        return personList;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return personList.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteById(UUID Id) {
        Optional<Person> personMaybe = selectPersonById(Id);
        if(personMaybe.isEmpty())
        return 0;
        else personList.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updateById(UUID Id, Person person) {
        return selectPersonById(Id).map(person1 ->
        { int indexpersonToUpdate = personList.indexOf(person1);
        if(indexpersonToUpdate>=0)
        {
            personList.set(indexpersonToUpdate,new Person(Id,person.getName()));
            return 1;
        }
        return 0;
        }).orElse(0);
    }
}
