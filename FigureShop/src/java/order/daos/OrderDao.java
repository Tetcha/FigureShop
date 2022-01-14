package order.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import order.models.Order;
import utils.Connector;
import product.models.Product;

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

    // add a new order
    public boolean addNewOrder(ArrayList<Product> products, Integer status, String userId, String consigneeName, String address, String phoneNumber) throws Exception {
        String uuid = UUID.randomUUID().toString();
        boolean isTrue = true;
        try {
            PreparedStatement preStm1;
            conn = Connector.getConnection();
            conn.setAutoCommit(false);

            // insert order to db
            String sqlOrder = "INSERT INTO figure_order (id, status, userId, consigneeName, address, phoneNumber) VALUES (?, ?, ?, ?, ?, ?)";
            preStm1 = conn.prepareStatement(sqlOrder);
            preStm1.setString(1, uuid);
            preStm1.setInt(2, status);
            preStm1.setString(3, userId);
            preStm1.setString(4, consigneeName);
            preStm1.setString(5, address);
            preStm1.setString(6, phoneNumber);
            preStm1.executeUpdate();

            // insert order items to db
            for (Product product : products) {
                String sql = "INSERT INTO figure_order_item (orderId, quantity, price, productId) VALUES (?, ?, ?, ?)";
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, uuid);
                preStm.setInt(2, product.getQuantity());
                preStm.setFloat(3, product.getPrice());
                preStm.setString(4, product.getId());
                preStm.executeUpdate();
            }

            // commit if success
            conn.commit();
        } catch (Exception e) {
            isTrue = false;
            conn.rollback();
        } finally {
            this.closeConnection();
        }
        return isTrue;
    }
}
