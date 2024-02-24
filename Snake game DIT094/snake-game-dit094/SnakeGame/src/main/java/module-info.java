module com.team3.snakegame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.google.gson;


    opens com.team3.snakegame to javafx.fxml;
    exports com.team3.snakegame;
    exports com.team3.snakegame.Frontend;
    opens com.team3.snakegame.Frontend to javafx.fxml;
}