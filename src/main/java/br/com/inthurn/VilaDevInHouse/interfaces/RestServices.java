package br.com.inthurn.VilaDevInHouse.interfaces;

import org.springframework.stereotype.Service;

import java.util.List;

public interface RestServices<E> {
    public List<E> listAll();
}
