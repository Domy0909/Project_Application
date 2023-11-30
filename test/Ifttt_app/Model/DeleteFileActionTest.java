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
public class DeleteFileActionTest {
    
    public DeleteFileActionTest() {
    }

    /**
     * Test of getFilePath method, of class DeleteFileAction.
     */
    @Test
    public void testGetFilePath() {
    }

    /**
     * Test of execute method, of class DeleteFileAction.
     */
    @Test
    public void testExecute() {
        String file = "test\\Ifttt_app\\tracce20-21.pdf";
        DeleteFileAction test = new DeleteFileAction(file);
        Platform.startup(()->{
            boolean result = test.execute();
            assertTrue("Execution should return true on success.",result);
        });
    }

    /**
     * Test of description method, of class DeleteFileAction.
     */
    @Test
    public void testDescription() {
    }
    
}
