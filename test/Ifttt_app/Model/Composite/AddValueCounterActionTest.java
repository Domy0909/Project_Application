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
    /**
    * Test case for the AddValueCounterAction class, which verifies the functionality
   * of adding a value to a counter.
    */
    public AddValueCounterActionTest() {
    }

   /**
     * Setting up the initial conditions for the tests.
     * Adds a counter named "setcountertest" with an initial value of 1 to the CounterSet.
     */
    @Before
    public void setup() {
       Counter c= new Counter("setcountertest",1);
       CounterSet.getInstance().addCounter(c);
    }
   
    
    CounterSet cset=CounterSet.getInstance();
    /**
     * Verifies the execution of adding a specific value to a counter and checks if
     * the action has been executed correctly.
     */
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
