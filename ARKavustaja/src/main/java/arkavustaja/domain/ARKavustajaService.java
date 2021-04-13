/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkavustaja.domain;

import arkavustaja.dao.DinoDao;

/**
 *
 * @author ihaho
 */
public class ARKavustajaService {
    private DinoDao dinoDao;
    
    public ARKavustajaService(DinoDao dinoDao) {
        this.dinoDao = dinoDao;
    }
}
