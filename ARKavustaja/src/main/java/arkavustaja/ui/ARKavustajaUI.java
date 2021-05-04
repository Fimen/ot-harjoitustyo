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
import java.util.Arrays;
import java.util.Collection;
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
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;

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
    public void start(Stage stage) {
        stage.setTitle("ARKavustaja");

        // Setting up dinosaur screen
        BorderPane layoutDino = new BorderPane();
        VBox vBoxDino = new VBox(layoutDino);
        GridPane gridDino = new GridPane();

        gridDino.setAlignment(Pos.TOP_CENTER);
        gridDino.setVgap(10);
        gridDino.setHgap(10);
        Label choose = new Label("Choose a dinosaur");
        Button tame = new Button("Tame");
        Label infoDino = new Label("");
        gridDino.setPadding(new Insets(20, 20, 20, 20));
        ComboBox dinos = new ComboBox();
        ObservableList<String> list = FXCollections.observableArrayList(dinoDao.getAll().stream().map(dino -> dino.toString()).toArray(String[]::new));
        dinos.setItems(list);
        gridDino.add(choose, 1, 0);
        gridDino.add(dinos, 1, 1);
        gridDino.add(infoDino, 1, 2);
        gridDino.add(tame, 1, 3);

        tame.setOnAction(e -> {
            if (dinos.getValue() == null) {
                infoDino.setText("You must choose a dinosaur to continue");
            } else {
                stage.setScene(knockScene);
            }
        });

        layoutDino.setPrefSize(500, 500);
        layoutDino.setTop(gridDino);

        // Setting up knocking Screen
        BorderPane layoutKnock = new BorderPane();
        VBox vBoxKnock = new VBox(layoutKnock);
        GridPane gridKnock = new GridPane();

        gridKnock.setAlignment(Pos.TOP_CENTER);
        gridKnock.setVgap(10);
        gridKnock.setHgap(10);
        gridKnock.setPadding(new Insets(20, 20, 20, 20));
        Label method = new Label("Choose a knocking method");
        Button knock = new Button("Knocked out");
        Label infoKnock = new Label("");
        ComboBox methods = new ComboBox();
        List<String> obsList = new ArrayList<>();
        obsList.add("Crossbow");
        ObservableList<String> knockList = FXCollections.observableArrayList(obsList);
        methods.setItems(knockList);
        gridKnock.add(method, 1, 0);
        gridKnock.add(infoKnock, 1, 1);
        gridKnock.add(methods, 1, 2);
        gridKnock.add(knock, 1, 3);

        knock.setOnAction(e -> {
            if (methods.getValue() == null) {
                infoKnock.setText("You must choose a knocking method to continue");
            } else {
                stage.setScene(probabilityScene);
            }
        });

        layoutKnock.setPrefSize(500, 500);
        layoutKnock.setTop(gridKnock);

        // Setting up the Probability Screen
        BorderPane layoutProb = new BorderPane();
        VBox vBoxProb = new VBox(layoutProb);
        GridPane gridProb = new GridPane();

        gridProb.setAlignment(Pos.TOP_CENTER);
        gridProb.setVgap(10);
        gridProb.setHgap(10);
        gridProb.setPadding(new Insets(20, 20, 20, 20));
        Label tamingFood = new Label("Choose taming food");
        Button calculate = new Button("Calculate");
        Label level = new Label("Wild dinosaur level");
        TextField levelNumber = new TextField("150");
        Label infoProb = new Label("");
        Label insert = new Label("Insert stats");
        Label target = new Label("Target stat");
        Label probability = new Label("Probability");
        TextField health = new TextField("");
        TextField stamina = new TextField("");
        TextField oxygen = new TextField("");
        TextField food = new TextField("");
        TextField weight = new TextField("");
        TextField melee = new TextField("");
        TextField targetHealth = new TextField("");
        TextField targetStamina = new TextField("");
        TextField targetOxygen = new TextField("");
        TextField targetFood = new TextField("");
        TextField targetWeight = new TextField("");
        TextField targetMelee = new TextField("");
        Label probHealth = new Label("- % Health");
        Label probStamina = new Label("- % Stamina");
        Label probOxygen = new Label("- % Oxygen");
        Label probFood = new Label("- % Food");
        Label probWeight = new Label("- % Weight");
        Label probMelee = new Label("- % Melee");
        ArrayList<TextField> textFields = new ArrayList<>();
        textFields.addAll(Arrays.asList(health, stamina, oxygen, food, weight, melee,
                targetHealth, targetStamina, targetOxygen, targetFood, targetWeight, targetMelee));
        ArrayList<Label> labels = new ArrayList<>();
        labels.addAll(Arrays.asList(probHealth, probStamina, probOxygen, probFood, probWeight, probMelee));
        ArrayList<String> strings = new ArrayList<>();
        strings.addAll(Arrays.asList("Health", "Stamina", "Oxygen", "Food", "Weight", "Melee"));
        
        ComboBox foods = new ComboBox();
        List<String> obsFList = new ArrayList<>();
        obsFList.add("Regular Kibble");
        ObservableList<String> foodList = FXCollections.observableArrayList(obsFList);
        foods.setItems(foodList);
        gridProb.add(health, 0, 3);
        gridProb.add(targetHealth, 1, 3);
        gridProb.add(probHealth, 2, 3);
        gridProb.add(stamina, 0, 4);
        gridProb.add(targetStamina, 1, 4);
        gridProb.add(probStamina, 2, 4);
        gridProb.add(oxygen, 0, 5);
        gridProb.add(targetOxygen, 1, 5);
        gridProb.add(probOxygen, 2, 5);
        gridProb.add(food, 0, 6);
        gridProb.add(targetFood, 1, 6);
        gridProb.add(probFood, 2, 6);
        gridProb.add(weight, 0, 7);
        gridProb.add(targetWeight, 1, 7);
        gridProb.add(probWeight, 2, 7);
        gridProb.add(melee, 0, 8);
        gridProb.add(targetMelee, 1, 8);
        gridProb.add(probMelee, 2, 8);
        gridProb.add(tamingFood, 0, 0);
        gridProb.add(foods, 0, 1);
        gridProb.add(level, 2, 0);
        gridProb.add(levelNumber, 2, 1);
        gridProb.add(infoProb, 1, 0);
        gridProb.add(insert, 0, 2);
        gridProb.add(target, 1, 2);
        gridProb.add(probability, 2, 2);
        gridProb.add(calculate, 1, 9);

        calculate.setOnAction(e -> {
            infoProb.setText("");
            try {
                if (foods.getValue() == null) {
                    // Check that food is chosen
                    infoProb.setText("You must choose a taming food to continue");
                } else {
                    // Check dino is loaded and calculate its points using its stats and textfields
                    Dino dino = dinoDao.getDino((String) dinos.getValue());

                    if (dino != null) {
                        List<Double> stats = dino.getStats();
                        List<Double> increase = dino.getIncrease();
                        for (int i = 0; i < textFields.size() / 2; i++) {
                            try {
                                double currentDoublePts = (Double.valueOf(textFields.get(i).getText()) - stats.get(i)) / increase.get(i);
                                double targetDoublePts = (Double.valueOf(textFields.get(i + 6).getText()) - stats.get(i)) / increase.get(i);
                                int currentPts = (int) currentDoublePts;
                                int targetPts = (int) targetDoublePts;

                                labels.get(i).setText("");
                            } catch (Exception y) {
                                labels.get(i).setText("- % " + strings.get(i));
                            }
                        }
                    } else {
                        infoProb.setText("Sumtin wong, error in files");
                    }
                }
            } catch (Exception x) {
                infoProb.setText("Check you have proper values in textfields");
            }

        });

        layoutProb.setPrefSize(500, 500);
        layoutProb.setTop(gridProb);

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
