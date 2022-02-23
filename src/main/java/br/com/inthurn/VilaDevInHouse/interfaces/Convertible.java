package br.com.inthurn.VilaDevInHouse.interfaces;

public interface Convertible<E, F> extends CRUDImplementable<F> {

    public E convertToEntity(F f);
    public F convertToDTO(E e);

}
