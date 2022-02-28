package br.com.inthurn.VilaDevInHouse.service.utilities;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class UUIDManager {

    public static String generate(){
        return UUID.randomUUID().toString();
    }

    }
