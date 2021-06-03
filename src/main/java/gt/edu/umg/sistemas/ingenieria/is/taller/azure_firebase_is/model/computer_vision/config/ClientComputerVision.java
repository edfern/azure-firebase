package gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.config;

import com.microsoft.azure.cognitiveservices.vision.computervision.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ClientComputerVision {

    @Value("${microsoft.azure.key}")
    String key;
    @Value("${microsoft.azure.endpoint}")
    String endpoint;

    public ComputerVisionClient getClient(){
        return ComputerVisionManager.authenticate(key).withEndpoint(endpoint);
    }
}
