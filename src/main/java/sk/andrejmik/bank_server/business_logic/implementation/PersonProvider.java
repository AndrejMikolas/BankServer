package sk.andrejmik.bank_server.business_logic.implementation;

import org.springframework.stereotype.Service;
import sk.andrejmik.bank_server.business_logic.interfaces.IPersonProvider;
import sk.andrejmik.bank_server.entities.Person;

import java.util.Collection;

@Service
public class PersonProvider implements IPersonProvider
{
    @Override
    public boolean insert(Person data)
    {
        return false;
    }

    @Override
    public Person get(Object id)
    {
        return null;
    }

    @Override
    public boolean update(Person data)
    {
        return false;
    }

    @Override
    public void delete(Object id)
    {

    }

    @Override
    public Collection<Person> getAll()
    {
        return null;
    }
}
