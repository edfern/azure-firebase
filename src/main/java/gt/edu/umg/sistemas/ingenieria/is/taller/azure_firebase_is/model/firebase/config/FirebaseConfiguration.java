package gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.firebase.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;

@Service
public class FirebaseConfiguration {
    @PostConstruct
    public void initialize(){
        try{

            FileInputStream serviceAccount =
                    new FileInputStream("./fir-db-spring-boot-b196e-firebase-adminsdk-exrwq-a56fad036a.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://fir-db-spring-boot-b196e-default-rtdb.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
