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
public class SumsCounterActionTest {
    
    public SumsCounterActionTest() {
    }

   @Before
    public void setup() {
       Counter c= new Counter("counter1",50);
       CounterSet.getInstance().addCounter(c);
       c= new Counter("counter2",25);
       CounterSet.getInstance().addCounter(c);
    }
   
    
    CounterSet cset=CounterSet.getInstance();
    
    @Test
    public void testExecute() {
       SumsCounterAction action=new SumsCounterAction("counter1","counter2");
       assertTrue("action should be executed",action.execute());
       assertTrue("Value should match the expected value",cset.getCounter("counter1").getValue().equals(75));
       
  
    }
    
    @Test
    public void testExecuteNULL1() {
       SumsCounterAction action=new SumsCounterAction("NULLCOUNTER","counter2");
       assertFalse("action should not be executed correctly",action.execute());
    }
    
    @Test
    public void testExecuteNULL2() {
       SumsCounterAction action=new SumsCounterAction("counter1","NULLCOUNTER");
       assertFalse("action should not be executed correctly",action.execute());
    }
}
