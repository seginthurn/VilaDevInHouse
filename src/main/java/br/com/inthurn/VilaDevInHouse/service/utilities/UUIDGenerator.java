package br.com.inthurn.VilaDevInHouse.service.utilities;

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
