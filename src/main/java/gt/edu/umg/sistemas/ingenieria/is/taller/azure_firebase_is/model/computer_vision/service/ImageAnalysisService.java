package gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.service;

import com.microsoft.azure.cognitiveservices.vision.computervision.models.*;
import gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.config.ClientComputerVision;
import gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.dto.ResponseDto;
import gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.dto.ResponseError;
import gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.dto.ResponseSuccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageAnalysisService implements IAlgorithmService{

    @Autowired
    ClientComputerVision client;

    @Override
    public ResponseDto getAlgorithm() {

        String path = "src\\main\\resources\\brand.jpg";
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
            File file = new File(path);
            byte[] imageBytes = Files.readAllBytes(file.toPath());

            ImageAnalysis analysis = client.getClient().computerVision()
                    .analyzeImageInStream()
                    .withImage(imageBytes)
                    .withVisualFeatures(featuresToExtractFromLocalImage).execute();

            return new ResponseSuccess(200,"SUCCESS",
                    analysis.description().captions(),analysis.tags(),
                    analysis.faces(),
                    analysis.brands(),
                    analysis.categories(),
                    analysis.objects(),
                    analysis.imageType().clipArtType()
                    );
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseError(400,"error");
        }
    }
}
