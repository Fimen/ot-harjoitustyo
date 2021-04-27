/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkavustaja.ui;

import arkavustaja.dao.DinoDao;
import arkavustaja.dao.FileDinoDao;
import arkavustaja.domain.Dino;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private Scene knockScene;
    private Scene probabilityScene;
    
    @Override
    public void init() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("config.properties"));
        
        String dinoFile = properties.getProperty("dinoFile");
        
        FileDinoDao dinoDao = new FileDinoDao(dinoFile);
        this.dinoDao = dinoDao;
        dinoDao.save();
    }
    
    @Override
    public void start(Stage stage){
        stage.setTitle("ARKavustaja");
        
        // Setting up dinosaur screen
        
        BorderPane asetteluDino = new BorderPane();
        VBox vBoxDino = new VBox(asetteluDino);
        GridPane ruudukkoDino = new GridPane();
        
        ruudukkoDino.setAlignment(Pos.TOP_CENTER);
        ruudukkoDino.setVgap(10);
        ruudukkoDino.setHgap(10);
        Label choose = new Label("Choose a dinosaur");
        Button tame = new Button("Tame");
        Label infoDino = new Label("");
        ruudukkoDino.setPadding(new Insets(20, 20, 20, 20));
        ComboBox dinos = new ComboBox();
        ObservableList<String> list = FXCollections.observableArrayList(dinoDao.getAll().stream().map(dino -> dino.toString()).toArray(String[]::new));
        dinos.setItems(list);
        ruudukkoDino.add(choose, 1, 0);
        ruudukkoDino.add(dinos, 1, 1);
        ruudukkoDino.add(infoDino, 1, 2);
        ruudukkoDino.add(tame, 1, 3);
        
        tame.setOnAction(e -> {
            if (dinos.getValue() == null) {
                infoDino.setText("You must choose a dinosaur to continue");
            } else {
                stage.setScene(knockScene);
            }
        });

        asetteluDino.setPrefSize(500, 500);
        asetteluDino.setTop(ruudukkoDino);
        
        // Setting up knocking Screen
        
        BorderPane asetteluKnock = new BorderPane();
        VBox vBoxKnock = new VBox(asetteluKnock);
        GridPane ruudukkoKnock = new GridPane();
        
        ruudukkoKnock.setAlignment(Pos.TOP_CENTER);
        ruudukkoKnock.setVgap(10);
        ruudukkoKnock.setHgap(10);
        ruudukkoKnock.setPadding(new Insets(20, 20, 20, 20));
        Label method = new Label("Choose a knocking method");
        Button knock = new Button("Knocked out");
        Label infoKnock = new Label("");
        ComboBox methods = new ComboBox();
        List<String> obsList = new ArrayList<>();
        obsList.add("Crossbow");
        ObservableList<String> knockList = FXCollections.observableArrayList(obsList);
        methods.setItems(knockList);
        ruudukkoKnock.add(method, 1, 0);
        ruudukkoKnock.add(infoKnock, 1, 1);
        ruudukkoKnock.add(methods, 1, 2);
        ruudukkoKnock.add(knock, 1, 3);
        
        knock.setOnAction(e -> {
            if (methods.getValue() == null) {
                infoKnock.setText("You must choose a knocking method to continue");
            } else {
                stage.setScene(probabilityScene);
            }
        });

        asetteluKnock.setPrefSize(500, 500);
        asetteluKnock.setTop(ruudukkoKnock);
        
        // Setting up the Probability Screen
        
        BorderPane asetteluProb = new BorderPane();
        VBox vBoxProb = new VBox(asetteluProb);
        GridPane ruudukkoProb = new GridPane();
        
        ruudukkoProb.setAlignment(Pos.TOP_CENTER);
        ruudukkoProb.setVgap(10);
        ruudukkoProb.setHgap(10);
        ruudukkoProb.setPadding(new Insets(20, 20, 20, 20));
        Label tamingFood = new Label("Choose taming food");
        Button calculate = new Button("Calculate");
        Label level = new Label("Wild dinosaur level");
        Label levelNumber = new Label("");
        Label infoProb = new Label("");
        Label insert = new Label("Insert stats");
        Label target = new Label("Target stat");
        Label probability = new Label ("Probability");
        Label health = new Label("");
        Label stamina = new Label("");
        Label oxygen = new Label("");
        Label food = new Label("");
        Label weight = new Label("");
        Label melee = new Label("");
        Label targetHealth = new Label("");
        Label targetStamina = new Label("");
        Label targetOxygen = new Label("");
        Label targetFood = new Label("");
        Label targetWeight = new Label("");
        Label targetMelee = new Label("");
        Label probHealth = new Label("");
        Label probStamina = new Label("");
        Label probOxygen = new Label("");
        Label probFood = new Label("");
        Label probWeight = new Label("");
        Label probMelee = new Label("");
        
        ComboBox foods = new ComboBox();
        List<String> obsFList = new ArrayList<>();
        obsFList.add("Regular Kibble");
        ObservableList<String> foodList = FXCollections.observableArrayList(obsFList);
        foods.setItems(foodList);
        ruudukkoProb.add(health, 0, 3);
        ruudukkoProb.add(targetHealth, 1, 3);
        ruudukkoProb.add(probHealth, 2, 3);
        ruudukkoProb.add(stamina, 0, 4);
        ruudukkoProb.add(targetStamina, 1, 4);
        ruudukkoProb.add(probStamina, 2, 4);
        ruudukkoProb.add(oxygen, 0, 5);
        ruudukkoProb.add(targetOxygen, 1, 5);
        ruudukkoProb.add(probOxygen, 2, 5);
        ruudukkoProb.add(food, 0, 6);
        ruudukkoProb.add(targetFood, 1, 6);
        ruudukkoProb.add(probFood, 2, 6);
        ruudukkoProb.add(weight, 0, 7);
        ruudukkoProb.add(targetWeight, 1, 7);
        ruudukkoProb.add(probWeight, 2, 7);
        ruudukkoProb.add(melee, 0, 8);
        ruudukkoProb.add(targetMelee, 1, 8);
        ruudukkoProb.add(probMelee, 2, 8);
        ruudukkoProb.add(tamingFood, 0, 0);
        ruudukkoProb.add(foods, 0, 1);
        ruudukkoProb.add(level, 2, 0);
        ruudukkoProb.add(levelNumber, 2, 1);
        ruudukkoProb.add(infoProb, 1, 0);
        ruudukkoProb.add(insert, 0, 2);
        ruudukkoProb.add(target, 1, 2);
        ruudukkoProb.add(probability, 2, 2);
        ruudukkoProb.add(calculate, 1, 9);
        
        
        calculate.setOnAction(e -> {
            if (foods.getValue() == null) {
                infoProb.setText("You must choose a taming food to continue");
            } else {
                health.setText("Here you will later see the new levels");
            }
        });

        asetteluProb.setPrefSize(500, 500);
        asetteluProb.setTop(ruudukkoProb);
        

        dinoScene = new Scene(vBoxDino, 500, 600);
        knockScene = new Scene(vBoxKnock, 500, 600);
        probabilityScene = new Scene(vBoxProb, 500, 600);
        stage.setScene(dinoScene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
