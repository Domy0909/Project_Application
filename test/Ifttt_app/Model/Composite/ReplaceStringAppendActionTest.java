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
 *
 * @author aless
 */
public class ReplaceStringAppendActionTest {
    
    public ReplaceStringAppendActionTest() {
    }

       @Before
    public void setUp() {
        Counter c = new Counter("showdialogtest", 0);
        CounterSet cset = CounterSet.getInstance();
        cset.addCounter(c);
        
            // Optional: Additional initialization code
        
    }

    @Test
    public void testExecute() {
        Platform.startup(() -> {
            String filepath="Project_Application\\test\\Ifttt_app\\Model\\TestFile.txt";
            SpecifiedStringAction action = new SpecifiedStringAction(filepath,"test $");
            ReplaceStringAppendAction replaceAction = new  ReplaceStringAppendAction (action, "showdialogtest");

            boolean result = replaceAction.execute();
            assertTrue("Execution should return true on success.", result);
            assertEquals("Should be equal", "test 0", replaceAction.action.getContentToAppend());
       });
    }

    @Test
    public void testExecuteNullCounter() {
            String filepath="Project_Application\\test\\Ifttt_app\\Model\\TestFile.txt";
            SpecifiedStringAction action = new SpecifiedStringAction(filepath,"test $");
            ReplaceStringAppendAction replaceAction = new  ReplaceStringAppendAction (action, "NULLCOUNTER");
            boolean result = replaceAction.execute();
            assertFalse("Execution should return false.", result);
            assertEquals("Should be equal", "test $", replaceAction.action.getContentToAppend());
    
    }
    
     @After
    public void cleanTestFile(){
           // Specify the path to your text file
        String filePath = "test\\Ifttt_app\\Model\\TestFile.txt";
        
        try {
            // Open the file with WRITE and TRUNCATE_EXISTING options
            Path path = FileSystems.getDefault().getPath(filePath);
            Files.newOutputStream(path, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING).close();

            System.out.println("Contents of the file have been deleted.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
