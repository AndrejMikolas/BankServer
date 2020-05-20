package sk.andrejmik.bank_server.business_logic.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.andrejmik.bank_server.business_logic.interfaces.ICardProvider;
import sk.andrejmik.bank_server.data_access.repository.ICardRepository;
import sk.andrejmik.bank_server.entities.Card;

import java.util.Collection;

@Slf4j
@Service
public class CardProvider implements ICardProvider
{
    private final ICardRepository mCardRepository;

    @Autowired
    public CardProvider(ICardRepository cardRepository)
    {
        mCardRepository = cardRepository;
    }

    @Override
    public boolean insert(Card data)
    {
        try
        {
            mCardRepository.save(data);
            log.info("Card saved");
        } catch (Exception e)
        {
            return false;
        }
        return true;
    }

    @Override
    public Card get(Object id)
    {
        return null;
    }

    @Override
    public boolean update(Card data)
    {
        try
        {
            mCardRepository.save(data);
            log.info("Card updated");
        } catch (Exception e)
        {
            return false;
        }
        return true;
    }

    @Override
    public void delete(Object id)
    {
        mCardRepository.deleteById((Long) id);
    }

    @Override
    public Collection<Card> getAll()
    {
        return mCardRepository.findAll();
    }
}
