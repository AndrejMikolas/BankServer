package sk.andrejmik.bank_server.business_logic.implementation;

import org.springframework.stereotype.Service;
import sk.andrejmik.bank_server.business_logic.interfaces.ICardProvider;
import sk.andrejmik.bank_server.entities.Card;

import java.util.Collection;

@Service
public class CardProvider implements ICardProvider
{
    @Override
    public boolean insert(Card data)
    {
        return false;
    }

    @Override
    public Card get(Object id)
    {
        return null;
    }

    @Override
    public boolean update(Card data)
    {
        return false;
    }

    @Override
    public void delete(Object id)
    {

    }

    @Override
    public Collection<Card> getAll()
    {
        return null;
    }
}
