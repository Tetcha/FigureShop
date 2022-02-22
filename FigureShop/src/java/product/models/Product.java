package product.models;

import category.models.Category;

/**
 *
 * @author locnh
 */
public class Product {

    private String id;
    private String name;
    private String image;
    private Integer quantity;
    private Float price;
    private String description;
    private Category category;

    public Product() {
    }

    public Product(String name, String image, Integer quantity, Float price, String description, Category category) {
        this.name = name;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public Product(String id, String name, String image, Integer quantity, Float price, String description, Category category) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", image=" + image + ", quantity=" + quantity + ", price=" + price + ", description=" + description + ", category=" + category + '}';
    }

}
