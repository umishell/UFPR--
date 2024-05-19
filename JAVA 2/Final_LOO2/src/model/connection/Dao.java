package model.connection;

import java.util.List;

public interface Dao<T> {

    public void add(T object) throws Exception;

    public List<T> getAll() throws Exception;

    public T getById(int id) throws Exception;

    public void update(T object) throws Exception;

    public void delete(T object) throws Exception;

    public void deleteAll() throws Exception;
}
