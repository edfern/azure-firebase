package gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.globalconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Configuration
public class ApplicationConfig {


    @Bean
    File filesystemRoot(){
        try{
            Path path = Files.createTempDirectory("images");
            path.toFile().deleteOnExit();
            return path.toFile();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Bean
    public FileSystemResource fileSystemResource(){
        return new FileSystemResource(filesystemRoot().getAbsolutePath());
    }
}
