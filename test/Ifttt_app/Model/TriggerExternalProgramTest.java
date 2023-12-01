/*
 * The TriggerExternalProgramTest class is designed to test the functionality of the TriggerExternalProgram class.
 * The testCheckTrigger method checks if the trigger condition is false when the specified external program has not run successfully (exit status is not 0).
 * The testCheckTriggerbis method checks if the trigger condition is true when the specified external program has run successfully (exit status is 0).
 */

package Ifttt_app.Model;

import org.junit.Test;
import static org.junit.Assert.*;


public class TriggerExternalProgramTest {
    
    @Test
    public void testCheckTrigger() {
        int i=5;
        String programPath = "./External Programs\\myscript.bat";
        TriggerExternalProgram trigger= new  TriggerExternalProgram(programPath,i);
        assertFalse(trigger.checkTrigger());
    }
    @Test
    public void testCheckTriggerbis() {
        int i=0;
        String programPath = "./External Programs\\myscript.bat";
        TriggerExternalProgram trigger= new  TriggerExternalProgram(programPath,i);
        assertTrue(trigger.checkTrigger());
    }
    
}
