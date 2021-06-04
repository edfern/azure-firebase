package gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.config;

import com.microsoft.azure.cognitiveservices.vision.computervision.*;
import gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.exception.CustomException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import static gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.globalconfig.Config.*;

@Component
public class ClientComputerVision {

    @Value("${microsoft.azure.key}")
    String key;
    @Value("${microsoft.azure.endpoint}")
    String endpoint;

    public ComputerVisionClient getClient(){

        if(key == null || key.isEmpty()){
            throw new CustomException(400,KEY_ERROR_AZURE);
        }else if( endpoint == null || endpoint.isEmpty()){
            throw new CustomException(400,ENDPOINT_ERROR_AZURE);
        }

        return ComputerVisionManager.authenticate(key).withEndpoint(endpoint);


    }
}
