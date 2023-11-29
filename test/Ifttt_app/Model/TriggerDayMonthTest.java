/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Ifttt_app.Model;

import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Asus
 */
public class TriggerDayMonthTest {
    
    public TriggerDayMonthTest() {
    }

     // Test for trigger before the current day of the month
    @Test
    public void testTriggerBeforeCurrentTime() {
        int previousDayOfMonth = LocalDate.now().minusDays(1).getDayOfMonth();
        TriggerDayMonth dayMonthTrigger = new TriggerDayMonth(previousDayOfMonth);
        assertFalse(dayMonthTrigger.checkTrigger());
    }

    // Test for trigger on the current day of the month
    @Test
    public void testTriggerCurrentTime() {
        int currentDayOfMonth = LocalDate.now().getDayOfMonth();
        TriggerDayMonth dayMonthTrigger = new TriggerDayMonth(currentDayOfMonth);
        assertTrue(dayMonthTrigger.checkTrigger());
    }

    // Test for trigger after the current day of the month
    @Test
    public void testTriggerAfterCurrentTime() {
        int nextDayOfMonth = LocalDate.now().plusDays(1).getDayOfMonth();
        TriggerDayMonth dayMonthTrigger = new TriggerDayMonth(nextDayOfMonth);
        assertFalse(dayMonthTrigger.checkTrigger());
    }
}
