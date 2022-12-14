module com.hope.dentistoffice {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires mysql.connector.java;
    requires org.jetbrains.annotations;

    opens com.hope.dentistoffice to javafx.fxml;
    exports com.hope.dentistoffice;
    exports com.hope.dentistoffice.models.domainmodels;
    exports com.hope.dentistoffice.controllers;
    exports com.hope.dentistoffice.persistence.database;
    opens com.hope.dentistoffice.controllers to javafx.fxml;
    exports com.hope.dentistoffice.persistence.database.dao;
    opens com.hope.dentistoffice.persistence.database.dao to javafx.fxml;
}