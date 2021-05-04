/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkavustaja.dao;

import arkavustaja.domain.Dino;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ihaho
 */
public class FileDinoDao implements DinoDao {
    public List<Dino> dinos;
    private String file;
    
    public FileDinoDao(String file) throws Exception {
        dinos = new ArrayList<>();
        this.file = file;
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                List<Double> baseStats = new ArrayList<>();
                List<Double> statIncrease = new ArrayList<>();
                String[] parts = reader.nextLine().split(";");
                String name = parts[0];
                for (int i = 1; i < 7; i++) {
                    baseStats.add(Double.parseDouble(parts[i]));
                    statIncrease.add(Double.parseDouble(parts[i + 6]));
                }
                Dino dino = new Dino(name, baseStats, statIncrease);
                dinos.add(dino);
            }
            
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }
    
    @Override
    public void save() {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (Dino dino : dinos) {
                String stats = "";
                String increase = "";
                List<Double> baseStats = dino.getStats();
                List<Double> statIncrease = dino.getIncrease();
                for (int i = 0; i < 6; i++) {
                    stats += ";" + baseStats.get(i).toString();
                    increase += ";" + statIncrease.get(i).toString();
                }
                writer.write(dino.getName() + stats + increase + "\n");
            }
        } catch (Exception e) {
            System.out.println("Saving failed");
        }
    }
    
    @Override
    public List<Dino> getAll() {
        return this.dinos;
    }
    
    @Override
    public Dino getDino(String name) {
        for (Dino d : this.dinos) {
            if (d.getName().equals(name)) {
                return d;
            }
        }
        return null;
    }
}
