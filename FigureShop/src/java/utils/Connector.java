package utils;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Connector {

    /**
     * Get connection
     */
    public static Connection getConnection() {
        try {
            Context context = new InitialContext();
            Context end = (Context) context.lookup("java:comp/env");
            DataSource env = (DataSource) end.lookup("BookShop");
            Connection conn = env.getConnection();
            return conn;
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
            return null;
        }

    }
}
