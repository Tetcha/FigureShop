package orderitem.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import orderitem.dtos.OrderItemDto;
import utils.Connector;
import orderitem.models.OrderItem;

/**
 *
 * @author locnh
 */
public class OrderItemDao {

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

    //get order item dto by orderId
    public ArrayList<OrderItemDto> getOrderItemDtoByOrderId(String orderId) throws Exception {
        ArrayList<OrderItemDto> orderItemDtos = new ArrayList<OrderItemDto>();

        try {
            conn = Connector.getConnection();
            String sql = "SELECT oi.quantity, oi.price, p.name, p.image FROM figure_order_item oi JOIN figure_product p ON oi.productId = p.id WHERE orderId=?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, orderId);
            rs = preStm.executeQuery();
            OrderItemDto orderItemDto = null;
            while (rs.next()) {
                Integer quantity = rs.getInt("quantity");
                Float price = rs.getFloat("price");
                String name = rs.getString("name");
                String image = rs.getString("image");
                orderItemDto = new OrderItemDto(quantity, price, name, image);
                orderItemDtos.add(orderItemDto);
            }
        } finally {
            this.closeConnection();
        }

        return orderItemDtos;
    }

    //get order item by orderId
    public ArrayList<OrderItem> getOrderItemByOrderId(String orderId) throws Exception {
        ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();

        try {
            conn = Connector.getConnection();
            String sql = "SELECT * FROM figure_order_item WHERE orderId=?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, orderId);
            rs = preStm.executeQuery();
            OrderItem orderItem = null;
            while (rs.next()) {
                String productId = rs.getString("productId");
                Integer quantity = rs.getInt("quantity");
                Float price = rs.getFloat("price");
                orderItem = new OrderItem(orderId, productId, quantity, price);
                orderItems.add(orderItem);
            }
        } finally {
            this.closeConnection();
        }
        return orderItems;
    }
}
