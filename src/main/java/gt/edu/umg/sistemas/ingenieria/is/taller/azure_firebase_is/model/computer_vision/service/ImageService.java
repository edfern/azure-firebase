package gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class ImageService {
    public String convertMultipartFileToImage(MultipartFile file) throws IOException {

        Path pathDir = Paths.get("images");

        Files.createDirectories(pathDir);
        pathDir.toFile().deleteOnExit();

        try(InputStream inputStream = file.getInputStream()){
            Path pathImage = pathDir.resolve(Objects.requireNonNull(file.getOriginalFilename()));
            Files.copy(inputStream, pathImage, StandardCopyOption.REPLACE_EXISTING);
            pathImage.toFile().deleteOnExit();
            return pathImage.toFile().getPath();
        }

    }
}
