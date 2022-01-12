package orderitem.dtos;

/**
 *
 * @author locnh
 */
public class OrderItem {

    private String orderId;
    private String productId;
    private Integer quantity;
    private Float price;

    public OrderItem() {
    }

    public OrderItem(String orderId, String productId, Integer quantity, Float price) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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

    @Override
    public String toString() {
        return "OrderItem{" + "orderId=" + orderId + ", productId=" + productId + ", quantity=" + quantity + ", price=" + price + '}';
    }

}
