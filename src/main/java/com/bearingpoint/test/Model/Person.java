package com.bearingpoint.test.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Person
{
    private final UUID Id;
    private final String Name;


    public Person(@JsonProperty("Id") UUID id,@JsonProperty("name") String name)
    {
        Id = id;
        Name = name;
    }

    public UUID getId()
    {
        return Id;
    }

    public String getName()
    {
        return Name;
    }

}
