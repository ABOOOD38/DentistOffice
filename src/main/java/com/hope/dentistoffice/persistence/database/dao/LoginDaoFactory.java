package com.hope.dentistoffice.persistence.database.dao;

import com.hope.dentistoffice.models.domainmodels.LoginInfo;
import com.hope.dentistoffice.persistence.database.MysqlDatabase;

public class LoginDaoFactory implements IDaoFactory<LoginInfo> {
    @Override
    public IDao<LoginInfo> createDao() {
        return new ConcreteLoginDao(MysqlDatabase.getInstance());
    }
}
