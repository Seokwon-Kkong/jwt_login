package main.demo.mvc.service.basement;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;

public class BaseService<T> {

    protected final T repository;

    protected final EntityManager em;


    public BaseService(T repository, EntityManager em) {
        this.repository = repository;
        this.em = em;
    }

    protected Object entity_check(Optional<?> optional){

        if (optional.isEmpty()) throw new EntityNotFoundException();

        return optional.get();

    }
}
