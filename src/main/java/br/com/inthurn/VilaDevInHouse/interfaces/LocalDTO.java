package br.com.inthurn.VilaDevInHouse.interfaces;

import java.io.Serializable;

public interface LocalDTO<E> extends Serializable {

    public E convertToEntity();

}
