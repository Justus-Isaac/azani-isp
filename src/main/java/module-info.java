module com.example.azaniisp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.azaniisp to javafx.fxml;
    exports com.example.azaniisp;
}