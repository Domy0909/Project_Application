/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Ifttt_app.Model.Composite;

import Ifttt_app.Model.Composite.ReplaceShowDialogAction;
import Ifttt_app.Model.Composite.ShowDialogAction;
import Ifttt_app.Model.Composite.SpecifiedStringAction;
import Ifttt_app.Model.Counter;
import Ifttt_app.Model.CounterSet;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import javafx.application.Platform;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Test case for the ReplaceStringAppendAction class, validating its functionality to replace
 * a specified string pattern within a SpecifiedStringAction instance with the value of a counter
 * and append it to a file's content.
 */
public class ReplaceStringAppendActionTest {
    
    
     /**
     * Sets up the initial conditions by adding a counter named 'showdialogtest' with a value of 0
     * to the CounterSet.
     */
   
       @Before
    public void setUp() {
        Counter c = new Counter("showdialogtest", 0);
        CounterSet cset = CounterSet.getInstance();
        cset.addCounter(c);
        
        
    }
    /**
     * Tests the 'execute()' method of ReplaceStringAppendAction by creating a SpecifiedStringAction instance,
     * replacing a specific string pattern with the value of a counter ('showdialogtest'),
     * appending it to a file's content, and verifying the successful execution along with the updated content.
     */
    @Test
    public void testExecute() {
        Platform.startup(() -> {
            String filepath="test\\Ifttt_app\\Model\\Composite\\StringAppendTest.txt";
            SpecifiedStringAction action = new SpecifiedStringAction(filepath,"test $");
            ReplaceStringAppendAction replaceAction = new  ReplaceStringAppendAction (action, "showdialogtest");

            boolean result = replaceAction.execute();
            assertTrue("Execution should return true on success.", result);
            assertEquals("Should be equal", "test 0", replaceAction.action.getContentToAppend());
       });
    }
     /**
     * Tests the 'execute()' method of ReplaceStringAppendAction with a null counter name,
     * ensuring that the action does not execute successfully and retains the original content to append.
     */
    @Test
    public void testExecuteNullCounter() {
            String filepath="test\\Ifttt_app\\Model\\Composite\\StringAppendTest.txt";
            SpecifiedStringAction action = new SpecifiedStringAction(filepath,"test $");
            ReplaceStringAppendAction replaceAction = new  ReplaceStringAppendAction (action, "NULLCOUNTER");
            boolean result = replaceAction.execute();
            assertFalse("Execution should return false.", result);
            assertEquals("Should be equal", "test $", replaceAction.action.getContentToAppend());
    
    }
     /**
     * Cleans the contents of the test file after the tests.
     * It deletes the content inside the specified file.
     */
     @After
    public void cleanTestFile(){
        String filePath = "test\\Ifttt_app\\Model\\Composite\\StringAppendTest.txt";
        
        try {
            Path path = FileSystems.getDefault().getPath(filePath);
            Files.newOutputStream(path, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING).close();

            System.out.println("Contents of the file have been deleted.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
