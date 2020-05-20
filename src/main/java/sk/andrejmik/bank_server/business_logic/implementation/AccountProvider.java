package sk.andrejmik.bank_server.business_logic.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.andrejmik.bank_server.business_logic.interfaces.IAccountProvider;
import sk.andrejmik.bank_server.data_access.repository.IAccountRepository;
import sk.andrejmik.bank_server.entities.Account;

import java.util.Collection;

@Slf4j
@Service
public class AccountProvider implements IAccountProvider
{
    private final IAccountRepository mAccountRepository;

    @Autowired
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
        return mAccountRepository.getOne((Long) id);
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
    public void delete(Object id)
    {
        mAccountRepository.deleteById((Long) id);
    }

    @Override
    public Collection<Account> getAll()
    {
        return mAccountRepository.findAll();
    }
}
