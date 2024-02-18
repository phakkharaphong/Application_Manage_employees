module org.openjfx.Pro_002 {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires javafx.graphics;
	requires java.desktop;

    opens org.openjfx.Pro_002 to javafx.fxml;
    exports org.openjfx.Pro_002;
}
