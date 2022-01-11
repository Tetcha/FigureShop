package user.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;
import user.dtos.User;
import utils.Connector;

/**
 *
 * @author locnh
 */
public class UserDao {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    //this function will close connection of database
    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }

        if (preStm != null) {
            preStm.close();
        }

        if (conn != null) {
            conn.close();
        }
    }

    // add a new user
    public void addNewUser(User user) throws Exception {
        String uuid = UUID.randomUUID().toString().substring(0, 30);
        try {
            conn = Connector.getConnection();
            String sql = "INSERT INTO bookshop_user (userId, username, fullName, email, address, phone, avatar, password, roleId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preStm = conn.prepareStatement(sql);
            //
            preStm.setString(1, uuid);
            preStm.setString(3, user.getFullName());
            preStm.setString(4, user.getEmail());
            preStm.setString(5, null);
            preStm.setString(6, null);
            preStm.setString(7, null);
            preStm.setString(8, user.getPassword());
            //
            preStm.executeUpdate();
        } finally {
            this.closeConnection();
        }
    }

    // get a user by id
    public User getUserByEmail(String email) throws Exception {
        User user = null;
        try {
            conn = Connector.getConnection();
            String sql = "SELECT * FROM bookshop_user WHERE email = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, email);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String id = rs.getString("id");
                String fullName = rs.getString("fullName");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String password = rs.getString("password");
                user = new User(id, fullName, email, password, address, phone);
            }
        } finally {
            this.closeConnection();
        }
        return user;
    }
}
