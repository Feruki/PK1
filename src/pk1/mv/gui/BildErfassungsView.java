package pk1.mv.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pk1.mv.fachlogik.Bild;

public class BildErfassungsView extends Stage {
    public BildErfassungsView(Bild b1, Stage primary) {
        super();
        this.setTitle("Bild Erfassung");
        this.initOwner(primary);
        this.initModality(Modality.WINDOW_MODAL);

        GridPane grid = new GridPane();
            TextField titel = new TextField();
            TextField jahr = new TextField();
            TextField ort = new TextField();
            grid.setAlignment(Pos.CENTER);

        HBox hb = new HBox();
            Button neu = new Button("Neu");
            Button abbrechen = new Button("Abbrechen");
            hb.setPadding(new Insets(10));
            hb.setSpacing(10);
            hb.setAlignment(Pos.CENTER);

        BorderPane bp = new BorderPane();

        grid.setHgap(10);
        grid.setVgap(10);

        grid.addRow(1, new Label("Titel"), titel);
        grid.addRow(2, new Label("Erscheinungsjahr"), jahr);
        grid.addRow(3, new Label("Ort"), ort);
        
        hb.getChildren().addAll(neu, abbrechen);
        bp.setBottom(hb);
        bp.setCenter(grid);

        if(b1 != null) {
            titel.setPromptText(b1.getTitel());
            jahr.setPromptText(String.valueOf(b1.getJahr()));
            ort.setPromptText(b1.getOrt());

            neu.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    b1.setJahr(Integer.parseInt(jahr.getText()));
                    b1.setTitel(titel.getText());
                    b1.setOrt(ort.getText());
                    close();
                }
            });
        }

        this.setScene(new Scene(bp, 300, 250));
    }

    public void showView() {
        this.show();
    }
}
