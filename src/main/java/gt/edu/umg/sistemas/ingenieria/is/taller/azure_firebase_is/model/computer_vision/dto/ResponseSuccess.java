package gt.edu.umg.sistemas.ingenieria.is.taller.azure_firebase_is.model.computer_vision.dto;

import com.microsoft.azure.cognitiveservices.vision.computervision.models.*;

import java.util.List;

public class ResponseSuccess extends ResponseDto {
    private List<ImageCaption> caption;
    private List<ImageTag> tag;
    private List<FaceDescription> face;
    private List<DetectedBrand> brand;
    private List<Category> category;
    private List<DetectedObject> object;
    private int typeImage;

    public ResponseSuccess(int status, String message, List<ImageCaption> caption, List<ImageTag> tag, List<FaceDescription> face, List<DetectedBrand> brand, List<Category> category, List<DetectedObject> object, int typeImage) {
        super(status, message);
        this.caption = caption;
        this.tag = tag;
        this.face = face;
        this.brand = brand;
        this.category = category;
        this.object = object;
        this.typeImage = typeImage;
    }

    public List<ImageCaption> getCaption() {
        return caption;
    }

    public List<ImageTag> getTag() {
        return tag;
    }

    public List<FaceDescription> getFace() {
        return face;
    }

    public List<DetectedBrand> getBrand() {
        return brand;
    }

    public List<Category> getCategory() {
        return category;
    }

    public List<DetectedObject> getObject() {
        return object;
    }

    public int getTypeImage() {
        return typeImage;
    }
}
