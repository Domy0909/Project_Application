/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Ifttt_app.Model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aless
 */
public class TriggerExternalProgramAllTest {
    
    public TriggerExternalProgramAllTest() {
    }

    /**
     * Test of checkTrigger method, of class TriggerExternalProgramAll.
     */
@Test
 public void testCheckTriggerBat() {
    String filepath = "C:\\Users\\aless\\OneDrive\\Documenti\\NetBeansProjects\\b-progApp\\Project_Application\\External Programs\\myscript.bat";
    ArrayList<String> argument = new ArrayList<>();
    // argument.add("Ciao");
    TriggerExternalProgramAll instance = new TriggerExternalProgramAll(filepath, argument, 0);
    boolean expResult = true; // Change to true if you expect the result to be true
    boolean result = instance.checkTrigger();
    assertEquals("should be true", expResult, result);
}

@Test
public void testCheckTriggerNONE() {
    String filepath = "C:\\Users\\aless\\OneDrive\\Documenti\\NetBeansProjects\\b-progApp\\Project_Application\\External Programs\\dsadasdasdasd";
    ArrayList<String> argument = new ArrayList<>();
    // argument.add("Ciao");
    TriggerExternalProgramAll instance = new TriggerExternalProgramAll(filepath, argument, 1);
    boolean expResult = false; // Change to true if you expect the result to be true
    assertThrows(FileNotFoundException.class, () -> {
            instance.checkTrigger();
        });
    
}

    /**
     * Test of description method, of class TriggerExternalProgramAll.
     */

    
}
