package sk.andrejmik.bank_server.business_logic.interfaces;

import sk.andrejmik.bank_server.entities.BaseEntity;

import java.util.List;

public interface IBaseProvider<T extends BaseEntity>
{
    boolean insert(T data);

    T get(Object id);

    boolean update(T data);

    boolean delete(Object id);

    List<T> getAll();
}
