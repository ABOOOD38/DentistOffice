package com.hope.dentistoffice.persistence.database.dao;

import com.hope.dentistoffice.persistence.database.dao.IDao;

public interface IDaoFactory<T> {
    IDao<T> createDao();
}
