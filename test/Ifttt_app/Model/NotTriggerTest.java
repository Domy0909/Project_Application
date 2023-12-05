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
public class NotTriggerTest {
    
    public NotTriggerTest() {
    }

    /**
     * Test of checkTrigger method, of class NotTrigger.
     */
    @Test
    public void testCheckTrigger() {
        
       LocalTime pastTime = LocalTime.now().minusHours(1);
       TimeTrigger timeTrigger = new TimeTrigger(pastTime);
       NotTrigger notTrigger=new NotTrigger(timeTrigger);
       assertFalse("should return false",notTrigger.checkTrigger());
       
    }

    /**
     * Test of description method, of class NotTrigger.
     */
  
    
}
