package order.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import order.models.Order;
import orderitem.daos.OrderItemDao;
import product.daos.ProductDao;
import utils.Connector;
import product.models.Product;
import orderitem.models.OrderItem;

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
    public ArrayList<Order> getOrdersForAdmin(String formDate, String toDate, Integer page, String userId) throws Exception {
        ArrayList<Order> orders = new ArrayList();
        try {
            Integer skip = (page - 1) * LIMIT;
            conn = Connector.getConnection();
            String sql = "SELECT * FROM figure_order WHERE userId = ? AND createdDate BETWEEN ? AND ? ORDER BY createdDate DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, userId);
            preStm.setString(2, formDate);
            preStm.setString(3, toDate);
            preStm.setInt(4, skip);
            preStm.setInt(5, LIMIT);
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

    // get order by orderId
    public Order getOrderByOrderId(String orderId) throws Exception {
        Order order = null;
        try {
            conn = Connector.getConnection();
            String sql = "SELECT * FROM figure_order WHERE id=?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, orderId);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String userId = rs.getString("userId");
                Integer status = rs.getInt("status");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                String consigneeName = rs.getString("consigneeName");
                Date createdDate = rs.getDate("createdDate");
                Float totalPrice = rs.getFloat("totalPrice");
                order = new Order(orderId, userId, address, phoneNumber, consigneeName, status, createdDate, totalPrice);
            }
        } finally {
            this.closeConnection();
        }
        return order;
    }

    // update order status
    public boolean updateOrderStatus(Order order, Integer nStatus) throws Exception {
        boolean isTrue = true;
        try {
            conn = Connector.getConnection();
            conn.setAutoCommit(false);
            String sql = "UPDATE figure_order SET status = ?, address = ?, phoneNumber = ?, consigneeName = ? WHERE id = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, nStatus);
            preStm.setString(2, order.getAddress());
            preStm.setString(3, order.getPhoneNumber());
            preStm.setString(4, order.getConsigneeName());
            preStm.setString(5, order.getId());
            preStm.executeUpdate();

            // check status
            if ((order.getStatus() == 0 || order.getStatus() == 3) && (nStatus != 3 && nStatus != 0)) {
                OrderItemDao orderItemDao = new OrderItemDao();
                ProductDao productDao = new ProductDao();
                ArrayList<OrderItem> orderItems = orderItemDao.getOrderItemByOrderId(order.getId());
                for (OrderItem orderItem : orderItems) {
                    Product product = productDao.getProductById(orderItem.getProductId());
                    productDao.updateProductQuantity(product.getQuantity() - orderItem.getQuantity(), orderItem.getProductId());
                }
            } else if ((order.getStatus() != 0 && order.getStatus() != 3) && (nStatus == 3 || nStatus == 0)) {
                OrderItemDao orderItemDao = new OrderItemDao();
                ProductDao productDao = new ProductDao();
                ArrayList<OrderItem> orderItems = orderItemDao.getOrderItemByOrderId(order.getId());
                for (OrderItem orderItem : orderItems) {
                    Product product = productDao.getProductById(orderItem.getProductId());
                    productDao.updateProductQuantity(product.getQuantity() + orderItem.getQuantity(), orderItem.getProductId());
                }
            }
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
