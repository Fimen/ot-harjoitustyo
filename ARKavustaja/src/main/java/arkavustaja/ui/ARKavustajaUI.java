/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkavustaja.ui;

import arkavustaja.dao.DinoDao;
import arkavustaja.dao.FileDinoDao;
import java.io.FileInputStream;
import java.util.Properties;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author ihaho
 */
public class ARKavustajaUI extends Application {
    private DinoDao dinoDao;
    
    private Scene dinoScene;
    
    @Override
    public void init() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("config.properties"));
        
        String dinoFile = properties.getProperty("dinoFile");
        
        FileDinoDao dinoDao = new FileDinoDao(dinoFile);
        this.dinoDao = dinoDao;
        
    }
    
    @Override
    public void start(Stage stage){
        stage.setTitle("ARKavustaja");
        
        BorderPane asettelu = new BorderPane();
        VBox vBox = new VBox(asettelu);
        GridPane ruudukko = new GridPane();
        
        ruudukko.setAlignment(Pos.TOP_CENTER);
        ruudukko.setVgap(10);
        ruudukko.setHgap(10);
        Label choose = new Label("Choose a dinosaur");
        ComboBox dinos = new ComboBox();
        Button tame = new Button("Tame");
        ruudukko.add(choose, 1, 0);
        ruudukko.add(dinos, 1, 1);
        ruudukko.add(tame, 1, 3);
        ruudukko.setPadding(new Insets(20, 20, 20, 20));

        asettelu.setPrefSize(500, 500);
        asettelu.setTop(ruudukko);

        Scene wordbook = new Scene(vBox, 500, 600);
        stage.setScene(wordbook);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
