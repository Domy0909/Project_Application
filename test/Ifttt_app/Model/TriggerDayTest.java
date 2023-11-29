/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Ifttt_app.Model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Asus
 */
public class TriggerDayTest {
    
    public TriggerDayTest() {
    }

    /**
     * Test of checkTrigger method, of class TriggerDay.
     */
    @Test
    public void testTriggerBeforeCurrentTime() {
           // Get the previous day compared to the current day
        DayOfWeek previousDay = LocalDate.now().minusDays(1).getDayOfWeek();

         // Create a TriggerDay instance using the previous day compared to the current day
        TriggerDay dayTrigger = new TriggerDay(previousDay);

       // Verify that the trigger doesn't activate correctly for the previous day
        assertFalse(dayTrigger.checkTrigger());
    }
    
    @Test
    public void testTriggerCurrentTime() {
        // Get the current day
        DayOfWeek day = LocalDate.now().getDayOfWeek();

        // Create a TriggerDay instance
        TriggerDay dayTrigger = new TriggerDay(day);

        // Verify that the trigger activates correctly for the current day
        assertTrue(dayTrigger.checkTrigger());
    }
    
    @Test
    public void testTriggerAfterCurrentTime() {
         // Get the next day compared to the current day
        DayOfWeek nextDay = LocalDate.now().plusDays(1).getDayOfWeek();

        // Create a TriggerDay instance using the next day compared to the current day
        TriggerDay dayTrigger = new TriggerDay(nextDay);

        // Verify that the trigger doesn't activate correctly for the next day
        assertFalse(dayTrigger.checkTrigger());
    }
    
    
}
