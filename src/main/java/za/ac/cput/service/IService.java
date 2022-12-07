package za.ac.cput.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IService<T, ID> {
    T save(T t) throws IOException;
    Optional<T> read(ID id);
    List<T> findAll();
    void delete(T t);
}