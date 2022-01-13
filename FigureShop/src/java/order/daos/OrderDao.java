package order.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import order.dtos.Order;
import utils.Connector;

/**
 *
 * @author locnh
 */
public class OrderDao {

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

    // get orders by userId
    public ArrayList<Order> getOrdersByUserId(String userId) throws Exception {
        ArrayList<Order> orders = new ArrayList<Order>();
        try {
            conn = Connector.getConnection();
            String sql = "SELECT * FROM figure_order WHERE id=? ORDER BY createDate DESC";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, userId);
            rs = preStm.executeQuery();
            Order order = null;
            while (rs.next()) {
                String id = rs.getString("id");
                Integer status = rs.getInt("status");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                String consigneeName = rs.getString("consigneeName");
                Date createDate = rs.getDate("createDate");
                order = new Order(id, userId, address, phoneNumber, consigneeName, status, createDate);
                orders.add(order);
            }
        } finally {
            this.closeConnection();
        }
        return orders;
    }

}
