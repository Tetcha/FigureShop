package user.models;

/**
 *
 * @author locnh
 */
public class User {

    private String id;
    private String fullName;
    private String email;
    private String password;
    private String address;
    private String phone;
    private boolean isAdmin;

    public User() {
    }

    public User(String id, String fullName, String email, String password, String address, String phone, boolean isAdmin) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.isAdmin = isAdmin;
    }

    public User(String fullName, String email, String password, boolean isAdmin) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", fullName=" + fullName + ", email=" + email + ", password=" + password + ", address=" + address + ", phone=" + phone + ", isAdmin=" + isAdmin + '}';
    }

}
