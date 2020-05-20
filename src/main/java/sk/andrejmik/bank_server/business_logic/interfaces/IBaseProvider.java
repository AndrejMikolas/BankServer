package sk.andrejmik.bank_server.business_logic.interfaces;

import sk.andrejmik.bank_server.entities.BaseEntity;

import java.util.Collection;

public interface IBaseProvider<T extends BaseEntity>
{
    boolean insert(T data);

    T get(Object id);

    boolean update(T data);

    void delete(Object id);

    Collection<T> getAll();
}
