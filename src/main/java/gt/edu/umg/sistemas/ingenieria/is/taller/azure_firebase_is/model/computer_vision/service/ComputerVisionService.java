package gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.service;

import gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.dto.ResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ComputerVisionService {

    public ResponseDto service(IAlgorithmService algorithm){
        return algorithm.getAlgorithm();
    }
}
