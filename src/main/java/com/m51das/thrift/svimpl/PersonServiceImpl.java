package com.m51das.thrift.svimpl;

import com.m51das.thrift.generated.DataException;
import com.m51das.thrift.generated.Person;
import com.m51das.thrift.generated.PersonService;
import org.apache.thrift.TException;

public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println("Got Client Param:"+username);
        Person person=new Person();
        person.setUsername(username);
        person.setAge(20);
        person.setMarried(false);
        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("Get client Param:"+person.toString());
    }
}
