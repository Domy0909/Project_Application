/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Ifttt_app.Model.Composite;

import Ifttt_app.Model.Composite.DeleteFileAction;
import javafx.application.Platform;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test case for the DeleteFileAction class, evaluating the file deletion functionality.
 */
public class DeleteFileActionTest {
    
    /**
     * Verifies the 'execute()' method functionality of the DeleteFileAction class,
     * which deletes a specified file. It instantiates DeleteFileAction with a file path,
     * executes the deletion operation within the Platform context, and asserts that
     * the execution of 'execute()' returns true, indicating a successful file deletion.
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

    
}
