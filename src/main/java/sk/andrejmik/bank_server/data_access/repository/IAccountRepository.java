package sk.andrejmik.bank_server.data_access.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.andrejmik.bank_server.entities.Account;

@Repository
public interface IAccountRepository extends CrudRepository<Account, Long>
{
}
