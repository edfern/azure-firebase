package gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.controller;

import gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.dto.ResponseDto;
import gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.firebase.dto.FileInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.firebase.dto.*;
import gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.firebase.service.FirebaseService;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@RestController
public class FirebaseController {
    @Autowired
    FirebaseService firebaseService;


    @RequestMapping(value = "/saveInfo", method = RequestMethod.POST, produces = "application/json")
    public ResponseDto saveInfo(@RequestBody FileInfoDto fileInfo ) throws InterruptedException, ExecutionException {
        return firebaseService.save(fileInfo);
    }

}
