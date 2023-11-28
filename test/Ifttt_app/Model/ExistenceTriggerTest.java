/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Ifttt_app.Model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aless
 */
public class ExistenceTriggerTest {
    
    public ExistenceTriggerTest() {
    }

    /**
     * Test of checkTrigger method, of class ExistenceTrigger.
     */
    @Test
    public void testTriggerWhenFileExists() {
        String directoryPath = "test\\Ifttt_app\\Model"; // Change this to the actual path
        String fileName = "TestFile.txt";

        ExistenceTrigger existenceTrigger = new ExistenceTrigger(directoryPath, fileName);

        assertTrue("Trigger should be true for an existing file.",existenceTrigger.checkTrigger());
    }
     @Test
    public void testTriggerWhenFileDoesNotExist() {
        String directoryPath = "test\\Ifttt_app\\Model"; // Change this to the actual path
        String fileName = "nonexistentfile.txt";

        ExistenceTrigger existenceTrigger = new ExistenceTrigger(directoryPath, fileName);

        assertFalse("Trigger should be false for a non-existing file.",existenceTrigger.checkTrigger());
    }
    
}
