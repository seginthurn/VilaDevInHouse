package br.com.inthurn.VilaDevInHouse.interfaces;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface DAO<E> {

    public List<E> listAll();
    public E listDetailsPerId(Integer id);
    public List<E> listPerPage(Integer Page);
    public List<E> listPerName(String name);
    public  List<E> listPerMonth(String Month);
    public ResponseEntity<String> addNew(E e);
    public ResponseEntity<String> deletePerId();

}
