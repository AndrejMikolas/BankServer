package sk.andrejmik.bank_server.business_logic.implementation;

import org.springframework.stereotype.Service;
import sk.andrejmik.bank_server.business_logic.interfaces.IAccountProvider;
import sk.andrejmik.bank_server.entities.Account;

import java.util.Collection;

@Service
public class AccountProvider implements IAccountProvider
{
    @Override
    public boolean insert(Account data)
    {
        return false;
    }

    @Override
    public Account get(Object id)
    {
        return null;
    }

    @Override
    public boolean update(Account data)
    {
        return false;
    }

    @Override
    public void delete(Object id)
    {

    }

    @Override
    public Collection<Account> getAll()
    {
        return null;
    }
}
