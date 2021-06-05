package gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.firebase.dto;

public class ResponseDto {
    private String message;
    private int status;

    public ResponseDto(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}
