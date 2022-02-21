package order.dtos;

import java.util.Date;
import order.models.Order;
import user.models.User;

/**
 *
 * @author locnh
 */
public class OrderWithEmailDto extends Order {

    private String email;

    public OrderWithEmailDto() {
    }

    public OrderWithEmailDto(String id, User user, String address, String phoneNumber, String consigneeName, Integer status, Date createdDate, Float totalPrice) {
        super(id, user, address, phoneNumber, consigneeName, status, createdDate, totalPrice);
    }

    public OrderWithEmailDto(String email, String id, User user, String address, String phoneNumber, String consigneeName, Integer status, Date createdDate, Float totalPrice) {
        super(id, user, address, phoneNumber, consigneeName, status, createdDate, totalPrice);
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
