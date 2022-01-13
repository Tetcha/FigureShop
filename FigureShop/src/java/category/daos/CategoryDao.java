package category.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import category.models.Category;
import utils.Connector;

/**
 *
 * @author locnh
 */
public class CategoryDao {

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

    // get category by id
    public Category getCategoryByID(String id) throws Exception {
        Category category = null;
        try {
            conn = Connector.getConnection();
            String sql = "SELECT * FROM figure_category WHERE id = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                category = new Category(id, name);
            }
        } finally {
            this.closeConnection();
        }
        return category;
    }
}
