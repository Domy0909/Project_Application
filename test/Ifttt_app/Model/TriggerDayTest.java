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

    // Test for trigger before the current day of the week
    @Test 
    public void testTriggerBeforeCurrentTime() {
        DayOfWeek previousDay = LocalDate.now().minusDays(1).getDayOfWeek();
        TriggerDay dayTrigger = new TriggerDay(previousDay);
        assertFalse(dayTrigger.checkTrigger());
    }
    
    // Test for trigger on the current day of the week
    @Test
    public void testTriggerCurrentTime() {
        DayOfWeek day = LocalDate.now().getDayOfWeek();
        TriggerDay dayTrigger = new TriggerDay(day);
        assertTrue(dayTrigger.checkTrigger());
    }
    
    // Test for trigger after the current day of the week
    @Test
    public void testTriggerAfterCurrentTime() {
        DayOfWeek nextDay = LocalDate.now().plusDays(1).getDayOfWeek();
        TriggerDay dayTrigger = new TriggerDay(nextDay);
        assertFalse(dayTrigger.checkTrigger());
    }
    
    
}
