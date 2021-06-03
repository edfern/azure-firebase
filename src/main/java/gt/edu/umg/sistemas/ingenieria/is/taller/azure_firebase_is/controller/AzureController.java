package gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.controller;

import gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.dto.ResponseDto;
import gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.service.ComputerVisionService;
import gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.service.ImageAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AzureController {

    @Autowired
    ComputerVisionService service;

    @Autowired
    ImageAnalysisService imageAnalysisService;

    @RequestMapping( value = "/analysis", method = RequestMethod.GET, produces = "application/json")
    public ResponseDto imageAnalysis(){
        ComputerVisionService service = new ComputerVisionService();
        return service.service(imageAnalysisService);
    }
}
