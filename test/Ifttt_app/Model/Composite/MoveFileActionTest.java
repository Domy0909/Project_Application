/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Ifttt_app.Model.Composite;

import Ifttt_app.Model.Composite.MoveFileAction;
import javafx.application.Platform;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marco
 */
public class MoveFileActionTest {
    
    public MoveFileActionTest() {
    }

    /**
     * Test of getFilePath method, of class MoveFileAction.
     */
    @Test
    public void testGetFilePath() {
    }

    /**
     * Test of getDirectoryPath method, of class MoveFileAction.
     */
    @Test
    public void testGetDirectoryPath() {
    }

    /**
     * Test of execute method, of class MoveFileAction.
     */
    @Test
    public void testExecute() {
        String file = "test\\tracce20-21.pdf";
        String directory = "test\\Ifttt_app";
        MoveFileAction test = new MoveFileAction(file,directory);
        Platform.startup(()->{
            boolean result = test.execute();
            assertTrue("Execution should return true on success.",result);
        });
    }

    /**
     * Test of description method, of class MoveFileAction.
     */
    @Test
    public void testDescription() {
    }
    
}
