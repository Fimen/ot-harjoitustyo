/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkavustaja.dao;

import arkavustaja.domain.Dino;
import java.util.List;

/**
 *
 * @author ihaho
 */
public interface DinoDao {
    List<Dino> getAll();
    void save();
}
