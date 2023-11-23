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
    
 @Test
    public void testTriggerBeforeCurrentTime() {
        // Set up a TimeTrigger with a time in the past
        LocalTime pastTime = LocalTime.now().minusHours(1);
        TimeTrigger timeTrigger = new TimeTrigger(pastTime);

        // The trigger should return false, as it's in the past
        //assertFalse(timeTrigger.checkTrigger());
        assertTrue(timeTrigger.checkTrigger());
    }

    @Test
    public void testTriggerAtCurrentTime() {
        // Set up a TimeTrigger with the current time
        LocalTime currentTime = LocalTime.now();
        TimeTrigger timeTrigger = new TimeTrigger(currentTime);

        // The trigger should return true, as it's at the current time
        assertTrue(timeTrigger.checkTrigger());
    }

    @Test
    public void testTriggerAfterCurrentTime() {
        // Set up a TimeTrigger with a time in the future
        LocalTime futureTime = LocalTime.now().plusHours(1);
        TimeTrigger timeTrigger = new TimeTrigger(futureTime);

        // The trigger should return true, as it's in the future
        assertFalse(timeTrigger.checkTrigger());
    }
    
    
}
