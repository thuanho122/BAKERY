package ht.vn.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Entity
@Table(name = "bakerys")

public class Bakery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "bakery_name")
    private String bakeryName;

    @Column(updatable = false)
    private BigDecimal price;

    @Column(updatable = false)
    private BigDecimal quantity = BigDecimal.valueOf(0);

    private String description;

    private String image;

    @Column(columnDefinition = "boolean default false")
    private boolean deleted;

    public Bakery() {
    }

    public Bakery(Long id, String bakeryName, String description, String image) {
        this.id = id;
        this.bakeryName = bakeryName;
        this.description = description;
        this.image = image;
    }

    public Bakery(String bakeryName, BigDecimal price, BigDecimal quantity, String description, String image) {
        this.bakeryName = bakeryName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.image = image;
    }

    public Bakery(Long id, String bakeryName, BigDecimal price, BigDecimal quantity, String description, String image) {
        this.id = id;
        this.bakeryName = bakeryName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.image = image;
    }

    public Bakery(Long id, String bakeryName, BigDecimal price, BigDecimal quantity, String description, String image, boolean deleted) {
        this.id = id;
        this.bakeryName = bakeryName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.image = image;
        this.deleted = deleted;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
