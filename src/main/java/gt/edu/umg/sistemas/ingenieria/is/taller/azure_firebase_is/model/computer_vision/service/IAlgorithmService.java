package gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.service;

import gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.dto.ResponseDto;
import org.springframework.web.multipart.MultipartFile;


public interface IAlgorithmService {
    ResponseDto getAlgorithm(MultipartFile file);
}
