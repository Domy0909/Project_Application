/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Ifttt_app.Model;

import java.time.LocalTime;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aless
 */
public class CompositeTriggerTest {
    
    public CompositeTriggerTest() {
    }

     /**
     * Tests the 'checkTrigger' method of CompositeTrigger using various combinations of triggers.
     */
   @Test
    public void testCheckTrigger() {
        System.out.println("checkTrigger");
        
        LocalTime pastTime = LocalTime.now().minusHours(1);
        TimeTrigger timeTrigger = new TimeTrigger(pastTime);
        NotTrigger notTrigger=new NotTrigger(timeTrigger);
        Boolean c=false; //or
        
        CompositeTrigger etrigger=new   CompositeTrigger(timeTrigger,notTrigger,c);
        
        assertTrue("should be true",etrigger.checkTrigger());
        etrigger=new CompositeTrigger(etrigger,etrigger,true); //and 
        assertTrue("should be true",etrigger.checkTrigger());
        
        etrigger=new CompositeTrigger(etrigger,etrigger,true);
        assertTrue("should be true",etrigger.checkTrigger());
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
