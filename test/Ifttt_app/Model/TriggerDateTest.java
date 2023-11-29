/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Ifttt_app.Model;

import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;


public class TriggerDateTest {
 
// Test trigger when the provided date is the same as the current date
  @Test
    public void testTriggerOnCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        TriggerDate dateTrigger = new TriggerDate(currentDate);
        assertTrue(dateTrigger.checkTrigger());
    }

    // Test trigger when the provided date is before the current date
    @Test
    public void testTriggerBeforeCurrentDate() {
        LocalDate previousDate = LocalDate.now().minusDays(1);
        TriggerDate dateTrigger = new TriggerDate(previousDate);
        assertFalse(dateTrigger.checkTrigger());
    }

    // Test trigger when the provided date is after the current date
    @Test
    public void testTriggerAfterCurrentDate() {
        LocalDate nextDate = LocalDate.now().plusDays(1);
        TriggerDate dateTrigger = new TriggerDate(nextDate);
        assertFalse(dateTrigger.checkTrigger());
    }
    
}
