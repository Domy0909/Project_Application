/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Ifttt_app.Model.Composite;

import Ifttt_app.Model.Composite.CopyFileAction;
import javafx.application.Platform;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test case for the CopyFileAction class, validating the file copying functionality.
 */
public class CopyFileActionTest {
    

       /**
     * Verifies the functionality of copying a file from a source location to a destination.
     * It instantiates CopyFileAction with a source file path and a destination directory path,
     * executes the copy operation within the Platform context, and asserts that the execution
     * of the 'execute()' method returns true, indicating a successful file copy operation.
     */
    @Test
    public void testExecute() {
        String file = "test\\tracce20-21.pdf";
        String directory = "test\\Ifttt_app";
        CopyFileAction test = new CopyFileAction(file,directory);
        Platform.startup(()->{
            boolean result = test.execute();
            assertTrue("Execution should return true on success.",result);
        });
    }  
}
