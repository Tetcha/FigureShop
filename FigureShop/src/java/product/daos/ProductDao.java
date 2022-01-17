package product.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;
import product.models.Product;
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
    public ArrayList<Product> getProducts(String name, String categoryId, Float minPrice, Float maxPrice, Integer page, int limit) throws Exception {
        ArrayList<Product> products = new ArrayList<Product>();
        try {
            Product product = null;
            name = "%" + name + "%";
            categoryId = "%" + categoryId + "%";
            Integer offset = (page - 1) * limit;

            conn = Connector.getConnection();
            String sql = "SELECT * FROM figure_product WHERE name LIKE ? AND categoryId LIKE ? AND price BETWEEN ? AND ? ORDER BY price ASC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, name);
            preStm.setString(2, categoryId);
            preStm.setFloat(3, minPrice);
            preStm.setFloat(4, maxPrice);
            preStm.setInt(5, offset);
            preStm.setInt(6, limit);
            rs = preStm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String pName = rs.getString("name");
                String image = rs.getString("image");
                Integer quantity = rs.getInt("quantity");
                Float price = rs.getFloat("price");
                String description = rs.getString("description");
                String category = rs.getString("categoryId");
                product = new Product(id, pName, image, quantity, price, description, category);
                products.add(product);
            }
        } finally {
            this.closeConnection();
        }
        return products;
    }

    // get product with filter
    public ArrayList<Product> filterAllProducts(String name, String categoryId, Float minPrice, Float maxPrice) throws Exception {
        ArrayList<Product> products = new ArrayList<Product>();
        try {
            Product product = null;
            name = "%" + name + "%";
            categoryId = "%" + categoryId + "%";

            conn = Connector.getConnection();
            String sql = "SELECT * FROM figure_product WHERE name LIKE ? AND categoryId LIKE ? AND price BETWEEN ? AND ? ORDER BY price ASC";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, name);
            preStm.setString(2, categoryId);
            preStm.setFloat(3, minPrice);
            preStm.setFloat(4, maxPrice);
            rs = preStm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String pName = rs.getString("name");
                String image = rs.getString("image");
                Integer quantity = rs.getInt("quantity");
                Float price = rs.getFloat("price");
                String description = rs.getString("description");
                String category = rs.getString("categoryId");
                product = new Product(id, pName, image, quantity, price, description, category);
                products.add(product);
            }
        } finally {
            this.closeConnection();
        }
        return products;
    }

    // get product by category
    public Product getProductByCategory(String name) throws Exception {
        Product product = null;
        try {
            conn = Connector.getConnection();
            String sql = "SELECT * FROM figure_product WHERE name = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, name);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String id = rs.getString("id");
                String categoryId = rs.getString("categoryId");
                String image = rs.getString("image");
                Integer quantity = rs.getInt("quantity");
                Float price = rs.getFloat("price");
                String description = rs.getString("description");
                product = new Product(id, name, image, quantity, price, description, categoryId);
            }
        } finally {
            this.closeConnection();
        }
        return product;
    }

    // get product by name
    public Product getProductByName(String name) throws Exception {
        Product product = null;
        try {
            conn = Connector.getConnection();
            String sql = "SELECT * FROM figure_product WHERE name = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, name);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String id = rs.getString("id");
                String categoryId = rs.getString("categoryId");
                String image = rs.getString("image");
                Integer quantity = rs.getInt("quantity");
                Float price = rs.getFloat("price");
                String description = rs.getString("description");
                product = new Product(id, name, image, quantity, price, description, categoryId);
            }
        } finally {
            this.closeConnection();
        }
        return product;
    }

    // add a new product
    public void addNewProduct(Product product) throws Exception {
        String uuid = UUID.randomUUID().toString();
        try {
            conn = Connector.getConnection();
            String sql = "INSERT INTO figure_product (id, name, image, quantity, price, description, categoryId) VALUES (?, ?, ?, ?, ?, ?, ?)";
            preStm = conn.prepareStatement(sql);
            //
            preStm.setString(1, uuid);
            preStm.setString(2, product.getName());
            preStm.setString(3, product.getImage());
            preStm.setInt(4, product.getQuantity());
            preStm.setFloat(5, product.getPrice());
            preStm.setString(6, product.getDescription());
            preStm.setString(7, product.getCategoryId());
            //
            preStm.executeUpdate();
        } finally {
            this.closeConnection();
        }
    }

    // update product information
    public void updateProduct(String productId, String name, String image, Integer quantity, Float price, String description, String categoryId) throws Exception {
        try {
            conn = Connector.getConnection();
            String sql = "UPDATE figure_product "
                    + "SET name = ?, image = ?, quantity = ?, price = ?, description = ?, categoryId = ? WHERE id = ?;";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, name);
            preStm.setString(2, image);
            preStm.setInt(3, quantity);
            preStm.setFloat(4, price);
            preStm.setString(5, description);
            preStm.setString(7, categoryId);
            preStm.setString(8, productId);
            preStm.executeUpdate();

        } finally {
            this.closeConnection();
        }
    }

    // update product quantity
    public void updateProductQuantity(Integer quantity, String productId) throws Exception {
        try {
            conn = Connector.getConnection();
            String sql = "UPDATE figure_product SET quantity = ? WHERE id = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, quantity);
            preStm.setString(2, productId);
            preStm.executeUpdate();
        } finally {
            this.closeConnection();
        }
    }
}
