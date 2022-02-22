package br.com.inthurn.VilaDevInHouse.service.utilities;

<<<<<<< Updated upstream:src/main/java/br/com/inthurn/VilaDevInHouse/service/utilities/UUIDGenerator.java
=======
import org.springframework.beans.factory.annotation.Autowired;

>>>>>>> Stashed changes:src/main/java/br/com/inthurn/VilaDevInHouse/service/utilities/UUIDManager.java
import java.util.UUID;

public class UUIDManager {

    public static UUID generate(){
        return UUID.randomUUID();
    }

    public static String generateAsString(){
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    public static UUID checkIfUUIDisNotNull(UUID uuid){
        if(uuid == null){
            return generate();
        }
        return uuid;
    }

}
