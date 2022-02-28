package br.com.inthurn.VilaDevInHouse.service.restservice.appservices;

import br.com.inthurn.VilaDevInHouse.model.entity.UserEntity;

import br.com.inthurn.VilaDevInHouse.model.entity.VillagerEntity;
import br.com.inthurn.VilaDevInHouse.model.transport.entities.UserDTO;
import br.com.inthurn.VilaDevInHouse.model.transport.entities.VillagerDTO;
import br.com.inthurn.VilaDevInHouse.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.modelmapper.ModelMapper;
import test.utils.GenerateUser;
import test.utils.GenerateVillager;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static test.utils.GenerateVillager.generateEntity;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
        List<UserEntity> users = new ArrayList<>();
        List<UserDTO> userDTOList = new ArrayList<>();
        when(userRepository.findAll()).thenReturn(users);

        assertEquals(userDTOList, userService.findAll());
    }

    @Test
    void findByUsername() {
        UserEntity user = GenerateUser.generateEntity();

        when(userRepository.findByUsername(eq(user.getUsername()))).thenReturn(user);
        assertEquals(UserDTO.class, userService.findByUsername(user.getUsername()).getClass());
        verify(userRepository, times(1)).findByUsername(anyString());
    }

    @Test
    public void shouldReturnTrueWhenUserIsSaved() {
        UserEntity user = GenerateUser.generateEntity();
        when(userRepository.save(user)).thenReturn(user);
        assertTrue(userService.save(user.convertToDTO()));
    }

    @Test
    public void shouldReturnFalseIfUserIsNull(){

        assertFalse(userService.save(null));

    }


    @Test
    void convertToDTO() {
        UserDTO userDTO = GenerateUser.generateEntity().convertToDTO();
        UserEntity userEntity = userDTO.convertToEntity();
        when(modelMapper.map(eq(userEntity), eq(UserDTO.class))).thenReturn(userDTO);
        assertEquals(userDTO, userService.convertToDTO(userEntity));
        verify(modelMapper, times(1)).map(any(UserEntity.class), eq(UserDTO.class));

    }

}