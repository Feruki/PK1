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
import pk1.mv.fachlogik.Audio;

public class AudioErfassungsView extends Stage {
    public AudioErfassungsView(Audio a1, Stage primary) {
        super();
        this.setTitle("Audio Erfassung");
        this.initOwner(primary);
        this.initModality(Modality.WINDOW_MODAL);

        GridPane grid = new GridPane();
            TextField titel = new TextField();
            TextField jahr = new TextField();
            TextField interpret = new TextField();
            TextField dauer = new TextField();
            
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
        grid.addRow(3, new Label("Interpret"), interpret);
        grid.addRow(4, new Label("Dauer"), dauer);

        hb.getChildren().addAll(neu, abbrechen);
        bp.setBottom(hb);
        bp.setCenter(grid);

        if(a1 != null) {
            titel.setPromptText(a1.getTitel());
            jahr.setPromptText(String.valueOf(a1.getJahr()));
            interpret.setPromptText(a1.getInterpret());
            dauer.setPromptText(String.valueOf(a1.getDauer()));

            neu.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    a1.setJahr(Integer.parseInt(jahr.getText()));
                    a1.setTitel(titel.getText());
                    a1.setInterpret(interpret.getText());
                    a1.setDauer(Integer.parseInt(dauer.getText()));
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
