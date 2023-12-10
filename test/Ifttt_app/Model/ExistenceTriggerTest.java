/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Ifttt_app.Model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test case for the ExistenceTrigger class, validating its 'checkTrigger' method functionality
 * when dealing with file existence.
 */

public class ExistenceTriggerTest {
    
    public ExistenceTriggerTest() {
    }

    /**
     * Tests the 'checkTrigger' method of ExistenceTrigger when the specified file exists.
     */
    @Test
    public void testTriggerWhenFileExists() {
        String directoryPath = "test\\Ifttt_app\\Model"; 
        String fileName = "TestFile.txt";

        ExistenceTrigger existenceTrigger = new ExistenceTrigger(directoryPath, fileName);
        assertTrue("Trigger should be true for an existing file.",existenceTrigger.checkTrigger());
    }
     /**
     * Tests the 'checkTrigger' method of ExistenceTrigger when the specified file does not exist.
     */
     @Test
    public void testTriggerWhenFileDoesNotExist() {
        String directoryPath = "test\\Ifttt_app\\Model";
        String fileName = "nonexistentfile.txt";

        ExistenceTrigger existenceTrigger = new ExistenceTrigger(directoryPath, fileName);

        assertFalse("Trigger should be false for a non-existing file.",existenceTrigger.checkTrigger());
    }
    
}
