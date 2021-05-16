/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkavustaja.domain;

/**
 *
 * @author ihaho
 */
public class Calc {
    
    public Calc() {
    }
    
    private double comb(int n, int k) {
        double value = 1;
        while (k > 0) {
            value = value * ((double) n / (double) k);
            n--;
            k--;    
        }
        return value;
    }
    
    public double probability(int n, int k) {
        double value = 0;
        if (n <= 0) {
            return -1;
        }
        double p = (double) 1 / 7;
        
        for (int i = k; i <= n; i++) {
            double prob = comb(n, i) * Math.pow(p, (double)i) * Math.pow((1 - p), ((double)n - i));
            value += prob;
        }
        return value;
    }
}
