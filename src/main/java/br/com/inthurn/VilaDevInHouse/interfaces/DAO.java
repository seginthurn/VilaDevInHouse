package br.com.inthurn.VilaDevInHouse.interfaces;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface DAO<E> {

    public List<E> listAll();
    public E listDetailsById(Integer id);
    public Boolean addNew(E e);
    public Boolean delete(Integer id);

}
