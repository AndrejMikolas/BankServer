package sk.andrejmik.bank_server.business_logic.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import sk.andrejmik.bank_server.business_logic.interfaces.ICardProvider;
import sk.andrejmik.bank_server.data_access.repository.ICardRepository;
import sk.andrejmik.bank_server.entities.Card;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Repository
public class CardProvider implements ICardProvider
{
    private final ICardRepository mCardRepository;

    @Autowired
    @Lazy
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
        if (mCardRepository.findById((String) id).isPresent())
        {
            return mCardRepository.findById((String) id).get();
        }
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
    public boolean delete(Object id)
    {
        try
        {
            mCardRepository.deleteById((String) id);
            log.info("Card deleted");
        } catch (Exception e)
        {
            return false;
        }
        return true;
    }

    @Override
    public List<Card> getAll()
    {
        return StreamSupport.stream(mCardRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
}
