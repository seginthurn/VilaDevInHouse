package br.com.inthurn.VilaDevInHouse.service.utilities;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class UUIDGenerator {

    public static UUID generate(){
        return UUID.randomUUID();
    }

    public static String generateAsString(){
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

}
