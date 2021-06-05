package gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.firebase.service;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.dto.ResponseDto;
import gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.firebase.config.FirebaseConfiguration;
import gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.firebase.dto.FileInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;


@Service
public class FirebaseService {

    @Autowired
    FirebaseConfiguration firebaseConfiguration;

    public static final String COL_NAME="users";


    public ResponseDto save(FileInfoDto fileInfoDto) throws InterruptedException, ExecutionException {

        try{
            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference();

            DatabaseReference usersRef = ref.child(COL_NAME);

            DatabaseReference newPostRef = usersRef.push();
            newPostRef.setValueAsync(fileInfoDto);
            return new ResponseDto(200,"The information was saved successfully");

        }catch (Exception e){
            return new ResponseDto(500,"The information could not be saved");
        }

    }
}
