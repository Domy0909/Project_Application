/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Ifttt_app.Model;

import javafx.application.Platform;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marco
 */
public class CopyFileActionTest {
    
    public CopyFileActionTest() {
    }

    /**
     * Test of getFilePath method, of class CopyFileAction.
     */
    @Test
    public void testGetFilePath() {
    }

    /**
     * Test of getDirectoryPath method, of class CopyFileAction.
     */
    @Test
    public void testGetDirectoryPath() {
    }

    /**
     * Test of execute method, of class CopyFileAction.
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

    /**
     * Test of description method, of class CopyFileAction.
     */
    @Test
    public void testDescription() {
    }
    
}
