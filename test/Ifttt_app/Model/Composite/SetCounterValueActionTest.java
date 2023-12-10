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
 * Test case for the SetCounterValueAction class, validating its functionality to set
 * the value of a specified counter within the CounterSet.
 */
public class SetCounterValueActionTest {
    

     /**
     * Sets up initial conditions by adding a counter named 'setcountertest' with a value of 0
     * to the CounterSet.
     */
    @Before
    public void setup() {
       Counter c= new Counter("setcountertest",0);
       CounterSet.getInstance().addCounter(c);
    }
   
    
    CounterSet cset=CounterSet.getInstance();
     /**
     * Tests the 'execute()' method of SetCounterValueAction by setting the value of a specific counter
     * ('setcountertest') to 99 and verifying the successful execution along with the updated counter value.
     */
    @Test
    public void testExecute() {
       SetCounterValueAction action=new SetCounterValueAction("setcountertest",99);
       assertTrue("action should be executed",action.execute());
       assertTrue("Value should match the expected value",cset.getCounter("setcountertest").getValue().equals(99));
     
    }
     /**
     * Tests the 'execute()' method of SetCounterValueAction with a null counter name,
     * ensuring that the action does not execute correctly.
     */
    @Test
    public void testExecuteNULL() {
       SetCounterValueAction action=new SetCounterValueAction("NULLCOUNTER",99);
       assertFalse("action should not be executed correctly",action.execute());
    }
        
}
