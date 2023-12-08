

package Ifttt_app.Model;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;


public class TriggerExternalProgramTest {
    
    /*
 * TestCheckTrigger: Verifies that the TriggerExternalProgram correctly checks the trigger condition.
 * It sets up a TriggerExternalProgram instance with an exit status expectation of 5 and asserts false, as it doesn't meet the specified exit status.
 */
    
    @Test
    public void testCheckTrigger() {
        int i=5;
        String programPath = "./External Programs\\myscript.bat";
        ArrayList<String> argument = new ArrayList<>();
        TriggerExternalProgram trigger= new  TriggerExternalProgram(programPath,argument,i);
        assertFalse(trigger.checkTrigger());
        
    }
    
    /*
 * TestCheckTriggerbis: Verifies that the TriggerExternalProgram correctly checks the trigger condition.
 * It sets up a TriggerExternalProgram instance with an exit status expectation of 0 and asserts true, as it meets the specified exit status.
 */
    @Test
    public void testCheckTriggerbis() {
         int i=0;
        String programPath = "./External Programs\\myscript.bat";
        ArrayList<String> argument = new ArrayList<>();
        TriggerExternalProgram trigger= new  TriggerExternalProgram(programPath,argument,i);
        assertTrue(trigger.checkTrigger());
    }
    
}
