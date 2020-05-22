package sk.andrejmik.bank_server.business_logic.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import sk.andrejmik.bank_server.business_logic.interfaces.IPersonProvider;
import sk.andrejmik.bank_server.data_access.repository.IPersonRepository;
import sk.andrejmik.bank_server.entities.Person;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Repository
public class PersonProvider implements IPersonProvider
{
    private final IPersonRepository mPersonRepository;

    @Autowired
    @Lazy
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
        if (mPersonRepository.findById((String) id).isPresent())
        {
            return mPersonRepository.findById((String) id).get();
        }
        return null;
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
    public boolean delete(Object id)
    {
        try
        {
            mPersonRepository.deleteById((String) id);
            log.info("Person deleted");
        } catch (Exception e)
        {
            return false;
        }
        return true;
    }

    @Override
    public List<Person> getAll()
    {
        return StreamSupport.stream(mPersonRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
}
