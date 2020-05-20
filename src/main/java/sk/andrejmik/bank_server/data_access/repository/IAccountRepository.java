package sk.andrejmik.bank_server.data_access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.andrejmik.bank_server.entities.Account;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long>
{
}
