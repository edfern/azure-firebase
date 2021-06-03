package gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.dto;

public class ResponseDto {
    private int status;
    private String message;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public ResponseDto(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
