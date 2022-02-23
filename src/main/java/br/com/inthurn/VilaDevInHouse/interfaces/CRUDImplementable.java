package br.com.inthurn.VilaDevInHouse.interfaces;

import java.util.List;
import java.util.UUID;

public interface CRUDImplementable<DTO>{

    public Boolean save(DTO dto);

    public List<DTO> listAll();

    public UUID delete(UUID UUID);

}
