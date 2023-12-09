/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Ifttt_app.Model.Composite;

import Ifttt_app.Model.Composite.ReplaceShowDialogAction;
import Ifttt_app.Model.Composite.ShowDialogAction;
import Ifttt_app.Model.Counter;
import Ifttt_app.Model.CounterSet;
import javafx.application.Platform;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author aless
 */
public class ReplaceShowDialogActionTest {
    
    public ReplaceShowDialogActionTest() {
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
            ShowDialogAction action = new ShowDialogAction("test $");
            ReplaceShowDialogAction replaceAction = new ReplaceShowDialogAction(action, "showdialogtest");

            boolean result = replaceAction.execute();
            assertTrue("Execution should return true on success.", result);
            assertEquals("Should be equal", "test 0", replaceAction.action.description() );
       });
    }

    @Test
    public void testExecuteNullCounter() {
       
            ShowDialogAction action = new ShowDialogAction("test $");
            ReplaceShowDialogAction replaceAction = new ReplaceShowDialogAction(action, "NULLCOUNTER");

            boolean result = replaceAction.execute();
            assertFalse("Execution should return false.", result);
            assertEquals("Should be equal", "test $", replaceAction.action.getSpecificstring());
    
    }
    
    

}


    /**
     * Test of description method, of class ReplaceShowDialogAction.
     */
  
    

