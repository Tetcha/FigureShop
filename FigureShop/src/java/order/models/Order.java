package order.models;

import java.util.Date;
import user.models.User;

/**
 *
 * @author locnh
 */
public class Order {

    private String id;
    private User user;
    private String address;
    private String phoneNumber;
    private String consigneeName;
    private Integer status;
    private Date createdDate;
    private Float totalPrice;

    public Order() {
    }

    public Order(String id, User user, String address, String phoneNumber, String consigneeName, Integer status, Date createdDate, Float totalPrice) {
        this.id = id;
        this.user = user;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.consigneeName = consigneeName;
        this.status = status;
        this.createdDate = createdDate;
        this.totalPrice = totalPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", user=" + user + ", address=" + address + ", phoneNumber=" + phoneNumber + ", consigneeName=" + consigneeName + ", status=" + status + ", createdDate=" + createdDate + ", totalPrice=" + totalPrice + '}';
    }

}
