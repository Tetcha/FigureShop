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

    //close connection of database
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
            String sql = "INSERT INTO figure_user (id, fullName, email, address, phone, password, isAdmin) VALUES (?, ?, ?, ?, ?, ?, ?)";
            preStm = conn.prepareStatement(sql);
            // set param
            preStm.setString(1, uuid);
            preStm.setString(2, user.getFullName());
            preStm.setString(3, user.getEmail());
            preStm.setString(4, null);
            preStm.setString(5, null);
            preStm.setString(6, user.getPassword());
            preStm.setBoolean(7, user.isIsAdmin());
            // insert
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
            String sql = "SELECT * FROM figure_user WHERE email = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, email);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String id = rs.getString("id");
                String fullName = rs.getString("fullName");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String password = rs.getString("password");
                boolean isAdmin = rs.getBoolean("isAdmin");
                user = new User(id, fullName, email, password, address, phone, isAdmin);
            }
        } finally {
            this.closeConnection();
        }
        return user;
    }
}
