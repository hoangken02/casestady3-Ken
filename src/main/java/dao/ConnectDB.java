package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static ConnectDB instance;
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/caseStudy3?useSSL=false";
    private final String JDBC_USERNAME = "root";
    private final String JDBC_PASSWORD = "hoang.ken@codegym.vn";

    private ConnectDB() {
    }

    public static ConnectDB getInstance() {
        if (instance == null) {
            instance = new ConnectDB();
            return instance;
        }
        return instance;
    }

    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD);
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;
    }
}
