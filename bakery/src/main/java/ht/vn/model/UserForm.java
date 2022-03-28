package ht.vn.model;

import org.springframework.web.multipart.MultipartFile;

public class UserForm {
    private MultipartFile fileImage;

    public UserForm() {
    }

    public UserForm(MultipartFile fileImage) {
        this.fileImage = fileImage;
    }

    public MultipartFile getFileImage() {
        return fileImage;
    }

    public void setFileImage(MultipartFile fileImage) {
        this.fileImage = fileImage;
    }
}
