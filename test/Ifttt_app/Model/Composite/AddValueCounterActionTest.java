/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Ifttt_app.Model.Composite;

import Ifttt_app.Model.Counter;
import Ifttt_app.Model.CounterSet;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author aless
 */
public class AddValueCounterActionTest {
    
    public AddValueCounterActionTest() {
    }

    /**
     * Test of execute method, of class AddValueCounterAction.
     */

    /**
     * Test of execute method, of class SetCounterValueAction.
     */
    @Before
    public void setup() {
       Counter c= new Counter("setcountertest",1);
       CounterSet.getInstance().addCounter(c);
    }
   
    
    CounterSet cset=CounterSet.getInstance();
    
    @Test
    public void testExecute() {
       AddValueCounterAction action=new AddValueCounterAction("setcountertest",99);
       assertTrue("action should be executed",action.execute());
       assertTrue("Value should match the expected value",cset.getCounter("setcountertest").getValue().equals(100));
    }
    
    @Test
    public void testExecuteNULL() {
      AddValueCounterAction action=new AddValueCounterAction("NULLCOUNTER",99);
      assertFalse("action should not be executed correctly",action.execute());
    }
    
}
