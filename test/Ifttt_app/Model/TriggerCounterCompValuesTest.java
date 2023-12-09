
package Ifttt_app.Model;

import org.junit.Test;
import static org.junit.Assert.*;

public class TriggerCounterCompValuesTest {
    
    Counter softwareCounter = new Counter("Software", 80);
    private int value1,value2,value3;
    
    // Test if the "GreaterThan" condition is activated correctly
    @Test
    public void testTriggerActivatedGreaterThan() {
       TriggerCounterCompValues trigger1 = new TriggerCounterCompValues(softwareCounter.getValue(),value1, "GreaterThan");
        trigger1.setValue(30);
        assertTrue("Software > 30 should return true", trigger1.checkTrigger());

        TriggerCounterCompValues trigger2 = new TriggerCounterCompValues(softwareCounter.getValue(),value2, "GreaterThan");
        trigger2.setValue(100);
        assertFalse("Software > 100 should return false", trigger2.checkTrigger());

        TriggerCounterCompValues trigger3 = new TriggerCounterCompValues( softwareCounter.getValue(),value3, "GreaterThan");
        trigger3.setValue(80);
        assertFalse("Software > 80 should return false", trigger3.checkTrigger());
    }
    
    
    

    // Test if the "LessThan" condition is activated correctly
    @Test
    public void testTriggerActivatedLessThan() {
        TriggerCounterCompValues trigger1 = new TriggerCounterCompValues(softwareCounter.getValue(),value1, "LessThan");
        trigger1.setValue(100);
        assertTrue("Software < 100 should return true", trigger1.checkTrigger());

        TriggerCounterCompValues trigger2 = new TriggerCounterCompValues(softwareCounter.getValue(),value2, "LessThan");
        trigger2.setValue(30);
        assertFalse("Software < 30 should return false", trigger2.checkTrigger());

        TriggerCounterCompValues trigger3 = new TriggerCounterCompValues( softwareCounter.getValue(),value3, "LessThan");
        trigger3.setValue(80);
        assertFalse("Software < 80 should return false", trigger3.checkTrigger());
    }

     // Test if the "EqualTo" condition is activated correctly
    @Test
    public void testTriggerActivatedEqualTo() {
        TriggerCounterCompValues trigger1 = new TriggerCounterCompValues(softwareCounter.getValue(),value1, "EqualTo");
        trigger1.setValue(80);
        assertTrue("Software = 80 should return true", trigger1.checkTrigger());

        TriggerCounterCompValues trigger2 = new TriggerCounterCompValues(softwareCounter.getValue(),value2, "EqualTo");
        trigger2.setValue(30);
        assertFalse("Software = 30 should return false", trigger2.checkTrigger());

        TriggerCounterCompValues trigger3 = new TriggerCounterCompValues( softwareCounter.getValue(),value3, "EqualTo");
        trigger3.setValue(100);
        assertFalse("Software = 100 should return false", trigger3.checkTrigger());
    }

    // Test if the default condition (invalid) always returns false for any value
    @Test
    public void testTriggerActivatedDefault() {
        TriggerCounterCompValues trigger1 = new TriggerCounterCompValues(softwareCounter.getValue(),value1, "InvalidCondition");
        trigger1.setValue(80);
        assertFalse("Invalid condition should return false", trigger1.checkTrigger());

        TriggerCounterCompValues trigger2 = new TriggerCounterCompValues(softwareCounter.getValue(),value2, "InvalidCondition");
        trigger2.setValue(30);
        assertFalse("Invalid condition should return false", trigger2.checkTrigger());

        TriggerCounterCompValues trigger3 = new TriggerCounterCompValues( softwareCounter.getValue(),value3, "InvalidCondition");
        trigger3.setValue(100);
        assertFalse("Invalid condition should return false", trigger3.checkTrigger());
    }
    
}
