package ht.vn.model;

import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

public class BakeryForm {
    private Long id;

    private String bakeryName;

    private BigDecimal price;

    private BigDecimal quantity;

    private String description;

    private MultipartFile image;

    public BakeryForm() {
    }

    public BakeryForm(Long id, String bakeryName, BigDecimal price, BigDecimal quantity, String description, MultipartFile image) {
        this.id = id;
        this.bakeryName = bakeryName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBakeryName() {
        return bakeryName;
    }

    public void setBakeryName(String bakeryName) {
        this.bakeryName = bakeryName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
