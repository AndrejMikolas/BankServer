package sk.andrejmik.bank_server.business_logic.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import sk.andrejmik.bank_server.business_logic.interfaces.IAccountProvider;
import sk.andrejmik.bank_server.data_access.repository.IAccountRepository;
import sk.andrejmik.bank_server.entities.Account;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Repository
public class AccountProvider implements IAccountProvider
{
    private final IAccountRepository mAccountRepository;

    @Autowired
    @Lazy
    public AccountProvider(IAccountRepository accountRepository)
    {
        mAccountRepository = accountRepository;
    }

    @Override
    public boolean insert(Account data)
    {
        try
        {
            mAccountRepository.save(data);
            log.info("Account saved");
        } catch (Exception e)
        {
            return false;
        }
        return true;
    }

    @Override
    public Account get(Object id)
    {
        return mAccountRepository.findById((String) id).get();
    }

    @Override
    public boolean update(Account data)
    {
        try
        {
            mAccountRepository.save(data);
            log.info("Account updated");
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
            mAccountRepository.deleteById((String) id);
            log.info("Account deleted");
        } catch (Exception e)
        {
            return false;
        }
        return true;
    }

    @Override
    public List<Account> getAll()
    {
        return StreamSupport.stream(mAccountRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }
}
