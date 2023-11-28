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
public class SizeFileTriggerTest {
    
  @Test
    public void testTriggerWhenFileAboveThreshold() {
        String filePath = "test\\Ifttt_app\\Model\\TestSizeFile.txt"; // Replace with the actual file path
        int thresholdBytes = 10; // Set a threshold

        SizeFileTrigger sizeFileTrigger = new SizeFileTrigger(filePath, thresholdBytes);

        assertTrue("Trigger should be true for a file above the threshold.", sizeFileTrigger.checkTrigger());
    }

    @Test
    public void testTriggerWhenFileBelowThreshold() {
        String filePath = "test\\Ifttt_app\\Model\\TestSizeFile.txt"; // Replace with the actual file path
        int thresholdBytes = 1000; // Set a threshold
        SizeFileTrigger sizeFileTrigger = new SizeFileTrigger(filePath, thresholdBytes);
        assertFalse("Trigger should be false for a file below the threshold.",sizeFileTrigger.checkTrigger());
    }

    @Test
    public void testTriggerWithInvalidPath() {
        // Provide an invalid file path to test exception handling
        String invalidFilePath = "invalid/file/path.txt";
        int thresholdBytes = 100; // Set a threshold

        SizeFileTrigger sizeFileTrigger = new SizeFileTrigger(invalidFilePath, thresholdBytes);

        assertThrows("Exception should be thrown for an invalid file path.",IllegalArgumentException.class, sizeFileTrigger::checkTrigger);
    }
    
}
