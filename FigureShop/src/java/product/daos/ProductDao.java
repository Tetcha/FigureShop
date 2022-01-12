package product.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import product.dtos.Product;
import utils.Connector;

/**
 *
 * @author locnh
 */
public class ProductDao {

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

    // get product by given id
    public Product getProductById(String productId) throws Exception {
        Product product = null;
        try {
            conn = Connector.getConnection();
            String sql = "SELECT * FROM figure_product WHERE id = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, productId);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String categoryId = rs.getString("categoryId");
                String name = rs.getString("name");
                String image = rs.getString("image");
                Integer quantity = rs.getInt("quantity");
                Float price = rs.getFloat("price");
                String description = rs.getString("description");
                product = new Product(productId, name, image, quantity, price, description, categoryId);
            }
        } finally {
            this.closeConnection();
        }
        return product;
    }

    // get product with filter
    public ArrayList<Product> getProducts(String name, Float minPrice, Float maxPrice) throws Exception {
        ArrayList<Product> products = new ArrayList<Product>();
        try {
            Product product = null;
            name = "%" + name + "%";

            conn = Connector.getConnection();
            String sql = "SELECT * FROM figure_product WHERE name LIKE ? AND price BETWEEN ? AND ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "");
            preStm.setFloat(2, minPrice);
            preStm.setFloat(3, maxPrice);
            rs = preStm.executeQuery();

            while (rs.next()) {
                String id = rs.getString("id");
                String pName = rs.getString("name");
                String image = rs.getString("image");
                Integer quantity = rs.getInt("quantity");
                Float price = rs.getFloat("price");
                String description = rs.getString("description");
                String categoryId = rs.getString("categoryId");
                product = new Product(id, pName, image, quantity, price, description, categoryId);
                products.add(product);
            }
        } finally {
            this.closeConnection();
        }
        return products;
    }
}
