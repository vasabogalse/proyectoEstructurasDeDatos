module org.example{
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jgrapht.core;

    opens org.example to javafx.fxml;
    opens org.example.Controladores to javafx.fxml;
    exports org.example;
}