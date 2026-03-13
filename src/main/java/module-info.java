module com.example.shirtsandshirts {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.shirtsandshirts to javafx.fxml;
    exports com.example.shirtsandshirts;
}