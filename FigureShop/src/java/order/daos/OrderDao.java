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
    private static final Integer LIMIT = 20;

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
            String sql = "SELECT * FROM figure_order WHERE userId=? ORDER BY createdDate DESC";
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
                Date createDate = rs.getDate("createdDate");
                Float totalPrice = rs.getFloat("totalPrice");
                order = new Order(id, userId, address, phoneNumber, consigneeName, status, createDate, totalPrice);
                orders.add(order);
            }
        } finally {
            this.closeConnection();
        }
        return orders;
    }

    // add a new order
    public boolean addNewOrder(ArrayList<Product> products, Integer status, String userId, String consigneeName, String address, String phoneNumber, Float totalPrice) throws Exception {
        String uuid = UUID.randomUUID().toString();
        boolean isTrue = true;
        try {
            PreparedStatement preStm1;
            conn = Connector.getConnection();
            conn.setAutoCommit(false);

            // insert order to db
            String sqlOrder = "INSERT INTO figure_order (id, status, userId, consigneeName, address, phoneNumber, totalPrice) VALUES (?, ?, ?, ?, ?, ?, ?)";
            preStm1 = conn.prepareStatement(sqlOrder);
            preStm1.setString(1, uuid);
            preStm1.setInt(2, status);
            preStm1.setString(3, userId);
            preStm1.setString(4, consigneeName);
            preStm1.setString(5, address);
            preStm1.setString(6, phoneNumber);
            preStm1.setFloat(7, totalPrice);
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

    // get orders by date
    public ArrayList<Order> getOrdersByDate(String formDate, String toDate, Integer page) throws Exception {
        ArrayList<Order> orders = new ArrayList();
        try {
            Integer skip = (page - 1) * LIMIT;
            conn = Connector.getConnection();
            String sql = "SELECT * FROM figure_order WHERE createdDate BETWEEN ? AND ? ORDER BY createdDate DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, formDate);
            preStm.setString(2, toDate);
            preStm.setInt(3, skip);
            preStm.setInt(4, LIMIT);
            rs = preStm.executeQuery();
            Order order = null;
            while (rs.next()) {
                String id = rs.getString("id");
                Integer status = rs.getInt("status");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                String consigneeName = rs.getString("consigneeName");
                Date createDate = rs.getDate("createdDate");
                String userId = rs.getString("userId");
                Float totalPrice = rs.getFloat("totalPrice");
                order = new Order(id, userId, address, phoneNumber, consigneeName, status, createDate, totalPrice);
                orders.add(order);
            }
        } finally {
            this.closeConnection();
        }
        return orders;
    }

    // get all order
    public ArrayList<Order> getOrders() throws Exception {
        ArrayList<Order> orders = new ArrayList();
        try {
            conn = Connector.getConnection();
            String sql = "SELECT * FROM figure_order";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            Order order = null;
            while (rs.next()) {
                String id = rs.getString("id");
                Integer status = rs.getInt("status");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                String consigneeName = rs.getString("consigneeName");
                Date createDate = rs.getDate("createdDate");
                String userId = rs.getString("userId");
                Float totalPrice = rs.getFloat("totalPrice");
                order = new Order(id, userId, address, phoneNumber, consigneeName, status, createDate, totalPrice);
                orders.add(order);
            }
        } finally {
            this.closeConnection();
        }
        return orders;
    }
}
