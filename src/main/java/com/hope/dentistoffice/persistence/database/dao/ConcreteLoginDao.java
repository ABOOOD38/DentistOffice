package com.hope.dentistoffice.persistence.database.dao;

import com.hope.dentistoffice.persistence.database.IDatabase;
import com.hope.dentistoffice.models.domainmodels.LoginInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class ConcreteLoginDao implements IDao<LoginInfo> {
    private final Connection DB_CON;
    public ConcreteLoginDao(final IDatabase database) {
        DB_CON = database.getConnection();
    }

    /**
     * Fetch all LoginInfo objects form the database and return them in an ArrayList
     *
     * @return ArrayList contains all loginInfo objects fetched from the database
     */
    @Override
    public Collection<LoginInfo> getAll() throws SQLException {
        String sql = "SELECT * FROM Login";

        Collection<LoginInfo> loginInfos = new ArrayList<>();
        try (PreparedStatement statement = DB_CON.prepareStatement(sql)) {
            ResultSet result = statement.executeQuery();
            LoginInfo empInfo;

            while (result.next()) {
                empInfo = buildLoginInfoInstance(result.getInt("ID"), result.getString("user_name"),
                        result.getString("password"), result.getInt("role_id"));
                loginInfos.add(empInfo);
            }
            return loginInfos;
        } catch (SQLException e) {
            System.err.println("Error happened login info getAll()");
            throw new SQLException();
        }
    }

    /**
     * Delete the LoginInfo record of the specified primary key
     *
     * @param id The primary key for the record to be deleted
     * @return Number of deleted rows
     */
    @Override
    public Integer delete(int id) throws SQLException {
        String sql = "DELETE FROM Login WHERE ID = ?";
        try (PreparedStatement statement = DB_CON.prepareStatement(sql)) {
            statement.setInt(1, id);
            return statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in delete loginInfo()");
            throw new SQLException(e);
        }
    }

    /**
     * Insert the specified LoginInfo object parameter to the database
     *
     * @param loginInfo The loginInfo object to be inserted
     * @return The generated primary key when this object inserted or 0 if inserting failed
     */
    @Override
    public Integer insert(LoginInfo loginInfo) throws SQLException {
        String sql = "INSERT INTO Login (user_name, password, role_id) VALUES (?,?,?)";

        int generatedID = 0;
        try (PreparedStatement statement = DB_CON.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, loginInfo.userName());
            statement.setString(2, loginInfo.password());
            statement.setInt(3, 2);
            statement.executeUpdate();

            ResultSet key = statement.getGeneratedKeys();
            if (key.next()) generatedID = key.getInt(1);

        } catch (SQLException e) {
            System.err.println("Creating user failed, no ID obtained.");
            throw new SQLException(e);
        }
        return generatedID;
    }

    /**
     * Update Username and Password of the specified loginInfo object
     *
     * @param loginInfo The loginInfo object to be updated
     * @return Number of updated rows
     */
    @Override
    public Integer update(LoginInfo loginInfo) throws SQLException {
        String sql = "UPDATE Login SET password = ? WHERE ID = ?";

        try (PreparedStatement statement = DB_CON.prepareStatement(sql)) {
            statement.setString(1, loginInfo.password());
            statement.setInt(2, loginInfo.ID());
            return statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in login info update()");
            throw new SQLException(e);
        }
    }

    /**
     * @return ConcreteLoginDao instance
     */

    private LoginInfo buildLoginInfoInstance(Integer ID, String userName, String password, Integer roleID) {
        return LoginInfo.getBuilder().
                withID(ID).
                withUserName(userName).
                withPassword(password).
                withRoleID(roleID).
                build();
    }
}
