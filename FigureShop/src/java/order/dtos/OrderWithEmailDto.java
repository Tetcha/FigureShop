package order.dtos;

import java.util.Date;
import order.models.Order;

/**
 *
 * @author locnh
 */
public class OrderWithEmailDto extends Order {

    private String email;

    public OrderWithEmailDto() {
    }

    public OrderWithEmailDto(String id, String userId, String address, String phoneNumber, String consigneeName, Integer status, Date createdDate, Float totalPrice) {
        super(id, userId, address, phoneNumber, consigneeName, status, createdDate, totalPrice);
    }

    public OrderWithEmailDto(String email, String id, String userId, String address, String phoneNumber, String consigneeName, Integer status, Date createdDate, Float totalPrice) {
        super(id, userId, address, phoneNumber, consigneeName, status, createdDate, totalPrice);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "OrderWithEmailDto{" + "email=" + email + '}';
    }
}
