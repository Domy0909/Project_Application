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
 * Test case for the ReplaceShowDialogAction class, verifying its functionality to replace
 * a specific string pattern within a ShowDialogAction with the value of a counter.
 */

public class ReplaceShowDialogActionTest {
    
    
    /**
     * Sets up initial conditions by adding a counter named 'showdialogtest' with a value of 0
     * to the CounterSet.
     */
     @Before
    public void setUp() {
        Counter c = new Counter("showdialogtest", 0);
        CounterSet cset = CounterSet.getInstance();
        cset.addCounter(c);      
    }
    /**
     * Tests the 'execute()' method of ReplaceShowDialogAction by creating a ShowDialogAction,
     * replacing a specific string pattern with the value of a counter ('showdialogtest'),
     * and verifying the successful execution along with the expected description update.
     */
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

    /**
     * Tests the 'execute()' method of ReplaceShowDialogAction with a null counter name,
     * ensuring that the action does not execute successfully and retains the original string pattern.
     */
    @Test
    public void testExecuteNullCounter() {
       
            ShowDialogAction action = new ShowDialogAction("test $");
            ReplaceShowDialogAction replaceAction = new ReplaceShowDialogAction(action, "NULLCOUNTER");

            boolean result = replaceAction.execute();
            assertFalse("Execution should return false.", result);
            assertEquals("Should be equal", "test $", replaceAction.action.getSpecificstring());
    
    }
}

