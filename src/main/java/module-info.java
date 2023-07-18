module org.module {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;

    requires java.persistence;
    requires lombok;
    requires org.hibernate.orm.core;
    requires mysql.connector.java;
    requires java.sql;

    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;
    requires org.apache.poi.ooxml.schemas;

    requires org.apache.logging.log4j;

    opens com.supermarket to javafx.fxml;
    exports com.supermarket;

    opens com.supermarket.logistica.controls to javafx.fxml;
    exports com.supermarket.logistica.controls;

    opens com.supermarket.logistica.domain.models to org.hibernate.orm.core;
    exports com.supermarket.logistica.domain.models;

    opens com.supermarket.comercial.controls to javafx.fxml;
    exports com.supermarket.comercial.controls;

    opens com.supermarket.comercial.domain.model to org.hibernate.orm.core;
    exports com.supermarket.comercial.domain.model;

    opens com.supermarket.recursos_humanos.controle to javafx.fxml;
    exports com.supermarket.recursos_humanos.controle;

    opens com.supermarket.comercial.domain.model to org.hibernate.orm.core;
    exports com.supermarket.comercial.domain.model;
}
