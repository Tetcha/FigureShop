package order.dtos;

import java.util.Date;

/**
 *
 * @author locnh
 */
public class Order {

    private String id;
    private String userId;
    private String address;
    private String phoneNumber;
    private String consigneeName;
    private Integer status;
    private Date createdDate;

    public Order() {
    }

    public Order(String id, String userId, String address, String phoneNumber, String consigneeName, Integer status, Date createdDate) {
        this.id = id;
        this.userId = userId;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.consigneeName = consigneeName;
        this.status = status;
        this.createdDate = createdDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", userId=" + userId + ", address=" + address + ", phoneNumber=" + phoneNumber + ", consigneeName=" + consigneeName + ", status=" + status + ", createdDate=" + createdDate + '}';
    }

}
