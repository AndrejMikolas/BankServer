package sk.andrejmik.bank_server.data_access.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.andrejmik.bank_server.entities.Person;

@Repository
public interface IPersonRepository extends CrudRepository<Person, String>
{
}
