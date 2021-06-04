package gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.controller;

import gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.dto.ResponseDto;
import gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.dto.ResponseError;
import gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.exception.CustomException;
import gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.service.ComputerVisionService;
import gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.service.ImageAnalysisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class AzureController {

    @Autowired
    ComputerVisionService service;

    @Autowired
    ImageAnalysisService imageAnalysisService;


    @CrossOrigin
    @RequestMapping( value = "/analysis", method = RequestMethod.POST, produces = "application/json")
    public ResponseDto imageAnalysis(@RequestParam MultipartFile file) {
        try {
            return service.service(imageAnalysisService, file);
        }catch (CustomException ex){
            return new ResponseError(ex.getStatus(),ex.getMessage());
        }
    }
}
