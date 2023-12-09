/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Ifttt_app.Model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class TriggerCounterCompValuesTest {
    
    // Test if the "GreaterThan" condition is activated correctly
    @Test
    public void testTriggerActivatedGreaterThan() {
        TriggerCounterCompValues trigger = new TriggerCounterCompValues("GreaterThan", 10);
        assertTrue(trigger.isTriggerActivated(15));
        assertFalse(trigger.isTriggerActivated(5));
        assertFalse(trigger.isTriggerActivated(10));
    }

    // Test if the "LessThan" condition is activated correctly
    @Test
    public void testTriggerActivatedLessThan() {
        TriggerCounterCompValues trigger = new TriggerCounterCompValues("LessThan", 10);
        assertTrue(trigger.isTriggerActivated(5));
        assertFalse(trigger.isTriggerActivated(15));
        assertFalse(trigger.isTriggerActivated(10));
    }

     // Test if the "EqualTo" condition is activated correctly
    @Test
    public void testTriggerActivatedEqualTo() {
        TriggerCounterCompValues trigger = new TriggerCounterCompValues("EqualTo", 10);
        assertTrue(trigger.isTriggerActivated(10));
        assertFalse(trigger.isTriggerActivated(5));
        assertFalse(trigger.isTriggerActivated(15));
    }

    // Test if the default condition (invalid) always returns false for any value
    @Test
    public void testTriggerActivatedDefault() {
        TriggerCounterCompValues trigger = new TriggerCounterCompValues("InvalidCondition", 10);
        assertFalse(trigger.isTriggerActivated(5));
        assertFalse(trigger.isTriggerActivated(10));
        assertFalse(trigger.isTriggerActivated(15));
    }
    
}
