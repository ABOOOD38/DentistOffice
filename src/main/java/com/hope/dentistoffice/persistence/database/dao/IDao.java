package com.hope.dentistoffice.persistence.database.dao;

import java.sql.SQLException;
import java.util.Collection;

public interface IDao<T> {
    Collection<T> getAll() throws SQLException;

    Integer delete(int id) throws SQLException;

    Integer insert(T object) throws SQLException;

    Integer update(T object) throws SQLException;

}
