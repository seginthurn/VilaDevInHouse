package br.com.inthurn.VilaDevInHouse.interfaces;

import java.util.List;

public interface CRUDImplementable<DTO>{

    public Boolean save(DTO dto);

    public List<DTO> listAll();

    public String delete(String externalId);

}
