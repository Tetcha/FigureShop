package orderitem.dtos;

/**
 *
 * @author locnh
 */
public class OrderItemDto {

    private Integer quantity;
    private Float price;
    private String name;
    private String image;

    public OrderItemDto() {
    }

    public OrderItemDto(Integer quantity, Float price, String name, String image) {
        this.quantity = quantity;
        this.price = price;
        this.name = name;
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

    @Override
    public String toString() {
        return "OrderItemDto{" + "quantity=" + quantity + ", price=" + price + ", name=" + name + ", image=" + image + '}';
    }
}
