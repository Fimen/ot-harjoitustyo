/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkavustaja.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ihaho
 */
public class Dino {
    private String name;
    private List<Integer> baseStats;
    private List<Double> statIncrease;
    
    public Dino(String name, List<Integer> baseStats, List<Double> statIncrease) {
        this.name = name;
        this.baseStats = baseStats;
        this.statIncrease = statIncrease;
    }
    
    public List<Integer> getStats() {
        return this.baseStats;
    }
    
    public List<Double> getIncrease() {
        return this.statIncrease;
    }
    
    public String getName() {
        return this.name;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}
