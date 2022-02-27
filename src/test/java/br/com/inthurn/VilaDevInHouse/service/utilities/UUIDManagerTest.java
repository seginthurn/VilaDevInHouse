package br.com.inthurn.VilaDevInHouse.service.utilities;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UUIDManagerTest {

    @Test
    public void shouldReturnStringWhenMethodIsCalled(){
        assertEquals(String.class, UUIDManager.generate().getClass());
    }
}