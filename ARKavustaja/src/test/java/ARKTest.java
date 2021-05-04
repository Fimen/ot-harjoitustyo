/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import arkavustaja.dao.DinoDao;
import arkavustaja.dao.FileDinoDao;
import arkavustaja.domain.Dino;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ihaho
 */
public class ARKTest {
    
    public ARKTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void hello() {
        
    }
    
    @Test
    public void DinoNameGetterWorks() {
        List<Integer> list1 = new ArrayList<>();
        List<Double> list2 = new ArrayList<>();
        
        for (int i = 0; i < 7; i++) {
            list1.add(i);
            list2.add((double)i);
        }
        
        Dino d = new Dino("Ankylo", new ArrayList<>(), new ArrayList<>());
        
        assertTrue(d.getName().equals("Ankylo"));
    }
    
    @Test
    public void AnkylosaurusIsReturnedOnGetAll() throws Exception {
        FileDinoDao fileDinoDao = new FileDinoDao("dinos.txt");
        DinoDao dinoDao = fileDinoDao;
        assertTrue(dinoDao.getAll().get(0).getName().equals("Ankylosaurus"));
    }
    
    @Test
    public void saveSavesNewStats() throws Exception {
        FileDinoDao fileDinoDao = new FileDinoDao("dinos.txt");
        DinoDao dinoDao = fileDinoDao;
        dinoDao.getAll().get(0).getStats().remove(5);
        dinoDao.getAll().get(0).getStats().add(200.0);
        dinoDao.save();
        
        FileDinoDao newFileDinoDao = new FileDinoDao("dinos.txt");
        DinoDao newDinoDao = newFileDinoDao;
        assertTrue(newDinoDao.getAll().get(0).getStats().get(5) == 200.0);
        
        //returning changed value back to 100
        dinoDao.getAll().get(0).getStats().remove(5);
        dinoDao.getAll().get(0).getStats().add(100.0);
        dinoDao.save();
    }
}
