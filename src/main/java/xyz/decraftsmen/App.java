package xyz.decraftsmen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.controlsfx.dialog.Dialogs;
import org.controlsfx.tools.Borders;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Button button = new Button("Welcome to JMessenger!");
        Node wrappedButton = Borders.wrap(button)
                .lineBorder().color(Color.RED).build()
                .lineBorder().color(Color.GREEN).build()
                .build();
        StackPane stackPane = new StackPane(wrappedButton);
        Scene scene = new Scene(stackPane, 400,400);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}