package com.hope.dentistoffice.persistence.database;

import java.sql.Connection;

public interface IDatabase {
    Connection getConnection();

}
