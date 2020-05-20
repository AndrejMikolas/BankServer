package sk.andrejmik.bank_server.business_logic.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.andrejmik.bank_server.business_logic.interfaces.IPersonProvider;
import sk.andrejmik.bank_server.data_access.repository.IPersonRepository;
import sk.andrejmik.bank_server.entities.Person;

import java.util.Collection;

@Slf4j
@Service
public class PersonProvider implements IPersonProvider
{
    private final IPersonRepository mPersonRepository;

    @Autowired
    public PersonProvider(IPersonRepository personRepository)
    {
        mPersonRepository = personRepository;
    }

    @Override
    public boolean insert(Person data)
    {
        try
        {
            mPersonRepository.save(data);
            log.info("Person saved");
        } catch (Exception e)
        {
            return false;
        }
        return true;
    }

    @Override
    public Person get(Object id)
    {
        return mPersonRepository.getOne((Long) id);
    }

    @Override
    public boolean update(Person data)
    {
        try
        {
            mPersonRepository.save(data);
            log.info("Person updated");
        } catch (Exception e)
        {
            return false;
        }
        return true;
    }

    @Override
    public void delete(Object id)
    {
        mPersonRepository.deleteById((Long) id);
    }

    @Override
    public Collection<Person> getAll()
    {
        return mPersonRepository.findAll();
    }
}
