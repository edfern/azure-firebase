package gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.exception;

public class CustomException extends RuntimeException {
    private int status;
    private String message;

    public CustomException(int status, String message){
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
