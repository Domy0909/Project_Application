/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Ifttt_app.Model;

import java.time.LocalTime;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test case for the NotTrigger class, specifically evaluating the behavior of the 'checkTrigger' method.
 * Verifies if the 'NotTrigger' correctly returns false when applied to a 'TimeTrigger' set in the past.
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

    
}
