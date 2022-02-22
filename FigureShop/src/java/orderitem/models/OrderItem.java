package orderitem.models;

import order.models.Order;
import product.models.Product;

/**
 *
 * @author locnh
 */
public class OrderItem {

    private Order order;
    private Product product;
    private Integer quantity;
    private Float price;

    public OrderItem() {
    }

    public OrderItem(Order order, Product product, Integer quantity, Float price) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
        return "OrderItem{" + "order=" + order + ", product=" + product + ", quantity=" + quantity + ", price=" + price + '}';
    }

}
