package gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.service;

import com.microsoft.azure.cognitiveservices.vision.computervision.models.*;
import gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.config.ClientComputerVision;
import gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.dto.ResponseDto;
import gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.dto.ResponseError;
import gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.dto.ResponseSuccess;
import gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import static gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.globalconfig.Config.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;



@Service
public class ImageAnalysisService implements IAlgorithmService{

    @Autowired
    ClientComputerVision client;

    @Autowired
    ImageService imgService;

    @Override
    public ResponseDto getAlgorithm(MultipartFile file) {

        List<VisualFeatureTypes> featuresToExtractFromLocalImage  = new ArrayList<>();
        featuresToExtractFromLocalImage.add(VisualFeatureTypes.DESCRIPTION);
        featuresToExtractFromLocalImage.add(VisualFeatureTypes.CATEGORIES);
        featuresToExtractFromLocalImage.add(VisualFeatureTypes.TAGS);
        featuresToExtractFromLocalImage.add(VisualFeatureTypes.FACES);
        featuresToExtractFromLocalImage.add(VisualFeatureTypes.OBJECTS);
        featuresToExtractFromLocalImage.add(VisualFeatureTypes.BRANDS);
        featuresToExtractFromLocalImage.add(VisualFeatureTypes.ADULT);
        featuresToExtractFromLocalImage.add(VisualFeatureTypes.COLOR);
        featuresToExtractFromLocalImage.add(VisualFeatureTypes.IMAGE_TYPE);

        try{
            File image = new File(imgService.convertMultipartFileToImage(file));
            byte[] imageBytes = Files.readAllBytes(image.toPath());

            ImageAnalysis analysis = client.getClient().computerVision()
                    .analyzeImageInStream()
                    .withImage(imageBytes)
                    .withVisualFeatures(featuresToExtractFromLocalImage).execute();

            return new ResponseSuccess(200,SUCCESS_AZURE,
                    analysis.description().captions(),analysis.tags(),
                    analysis.faces(),
                    analysis.brands(),
                    analysis.categories(),
                    analysis.objects(),
                    analysis.imageType().clipArtType()
                    );
        } catch (IOException e) {
            throw new CustomException(500,ERROR_AZURE);
        } catch (ComputerVisionErrorResponseException ex){
            throw new CustomException(500, ERROR_CLIENT);
        }
    }
}
