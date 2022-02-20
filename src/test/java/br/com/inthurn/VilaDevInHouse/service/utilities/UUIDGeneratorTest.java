package br.com.inthurn.VilaDevInHouse.service.utilities;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class UUIDGeneratorTest {

    UUIDGenerator uuidGenerator;

    @Test
    public void ShouldReturnUUID(){
        UUID uuid = UUIDGenerator.generate();
        assertEquals(UUID.class, uuid.getClass());
    }

    @Test
    public void ShouldReturnStringUUID(){
        String UUIDAsString = UUIDGenerator.generateAsString();
        assertEquals(String.class, UUIDAsString.getClass());
    }
}
