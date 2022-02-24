package br.com.inthurn.VilaDevInHouse.service.restservice.appservices;

import br.com.inthurn.VilaDevInHouse.interfaces.Convertible;
import br.com.inthurn.VilaDevInHouse.model.entity.RoleEntity;
import br.com.inthurn.VilaDevInHouse.model.transport.RoleDTO;
import br.com.inthurn.VilaDevInHouse.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService implements Convertible<RoleEntity, RoleDTO> {

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    public RoleService(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public RoleEntity convertToEntity(RoleDTO roleDTO) {
        return modelMapper.map(roleDTO, RoleEntity.class);
    }


    @Override
    public RoleDTO convertToDTO(RoleEntity role) {
        return modelMapper.map(role, RoleDTO.class);
    }

    @Override
    public Boolean save(RoleDTO roleDTO) {
        if(roleDTO == null){
            return false;
        }

        try {
           RoleEntity role = modelMapper.map(roleDTO, RoleEntity.class);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<RoleDTO> listAll() {
        return roleRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public String delete(String externalId) {
        if(externalId == null){
            return externalId;
        }
        try{
            return externalId;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
