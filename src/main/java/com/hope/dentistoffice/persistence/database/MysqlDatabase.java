package com.hope.dentistoffice.persistence.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDatabase implements IDatabase {
    private Connection con;
    private static final MysqlDatabase INSTANCE = new MysqlDatabase();

    private MysqlDatabase() {
        initDB();
    }

    private void initDB() {
        try {
            String URL = "jdbc:mysql://" + "localhost:3306" + "/" + "DentistOffice";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error in database connection");
        }
    }

    public static MysqlDatabase getInstance() {
        return INSTANCE;
    }

    @Override
    public Connection getConnection() {
        return con;
    }

}
