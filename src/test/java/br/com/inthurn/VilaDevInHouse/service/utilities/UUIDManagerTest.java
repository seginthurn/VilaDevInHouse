package br.com.inthurn.VilaDevInHouse.service.utilities;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class UUIDManagerTest {

    @Autowired
    UUIDManager uuidManager;

    @Test
    public void ShouldReturnUUID(){
        UUID uuid = UUIDManager.generate();
        assertEquals(UUID.class, uuid.getClass());
    }

    @Test
    public void ShouldReturnStringUUID(){
        String UUIDAsString = UUIDManager.generateAsString();
        assertEquals(String.class, UUIDAsString.getClass());
    }

    @Test
    public void shouldReturnUUIDifUUIDisNull(){
        UUID mockedUUID = null;
        assertEquals(UUID.class, UUIDManager.checkIfUUIDisNotNull(mockedUUID).getClass());
    }

    @Test
    public void shouldReturnTheSameUUIDIfUUIDIsNotNull(){
        UUID mockedUUID = UUID.randomUUID();
        assertEquals(mockedUUID, UUIDManager.checkIfUUIDisNotNull(mockedUUID));
    }
}
