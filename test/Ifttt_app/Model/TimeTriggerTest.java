/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Ifttt_app.Model;

import java.time.LocalTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aless
 */
public class TimeTriggerTest {
    // Set up a TimeTrigger with a time in the past 
    // The trigger should return false, as it's in the past
 @Test
    public void testTriggerBeforeCurrentTime() {
        
        LocalTime pastTime = LocalTime.now().minusHours(1);
        TimeTrigger timeTrigger = new TimeTrigger(pastTime);
       
        assertTrue(timeTrigger.checkTrigger());
    }
    // Set up a TimeTrigger with the current time
    // The trigger should return true, as it's at the current time
    @Test
    public void testTriggerAtCurrentTime() {
       
        LocalTime currentTime = LocalTime.now();
        TimeTrigger timeTrigger = new TimeTrigger(currentTime);

        assertTrue(timeTrigger.checkTrigger());
    }
    // Set up a TimeTrigger with a time in the future
    // The trigger should return true, as it's in the future
    @Test
    public void testTriggerAfterCurrentTime() {
       
        LocalTime futureTime = LocalTime.now().plusHours(1);
        TimeTrigger timeTrigger = new TimeTrigger(futureTime);

        
        assertFalse(timeTrigger.checkTrigger());
    }
  
    
}
