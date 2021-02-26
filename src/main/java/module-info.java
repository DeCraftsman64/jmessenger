module xyz.decraftsmen {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires controlsfx;

    opens xyz.decraftsmen to javafx.fxml;
    exports xyz.decraftsmen;
}