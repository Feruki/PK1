package pk1.mv.gui;

import javafx.application.Application;
import javafx.scene.control.MenuBar;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pk1.mv.fachlogik.Audio;
import pk1.mv.fachlogik.Bild;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Medienverwaltung");

        BorderPane bp = new BorderPane();

        MenuBar bar = new MenuBar();
            Menu datei = new Menu("Datei");
                MenuItem laden = new MenuItem("Laden");
                MenuItem speichern = new MenuItem("Speichern");
                MenuItem inDatei = new MenuItem("Medienliste in Datei");
                MenuItem beenden = new MenuItem("Beenden");
                datei.getItems().addAll(laden, speichern, new SeparatorMenuItem(), inDatei, new SeparatorMenuItem(), beenden);

            Menu medium = new Menu("Medium");
                MenuItem audio = new MenuItem("Audio neu");
                MenuItem bild = new MenuItem("Bild neu");
                medium.getItems().addAll(audio, bild);

            Menu anzeige = new Menu("Anzeige");
                MenuItem jahr = new MenuItem("Erscheinungsjahr");
                MenuItem neuestes = new MenuItem("Neuestes Medium");
                anzeige.getItems().addAll(jahr, neuestes);

        bar.getMenus().addAll(datei, medium, anzeige);
        bp.setTop(bar);
        stage.setScene(new Scene(bp));
        stage.setWidth(720);
        stage.setHeight(480);
        stage.show();

        Bild b1 = new Bild("Test", 2000, "Test");
        BildErfassungsView b = new BildErfassungsView(b1, stage);
        b.showView();

        Audio a1 = new Audio("Test", 2000, "Test", 2000);
        AudioErfassungsView a = new AudioErfassungsView(a1, stage);
        a.showView();
    }

    public static void main(String[] args) {
        launch(args);
    }
}