/*
 * The TriggerExternalProgramTest class is designed to test the functionality of the TriggerExternalProgram class.
 * The testCheckTrigger method checks if the trigger condition is false when the specified external program has not run successfully (exit status is not 0).
 * The testCheckTriggerbis method checks if the trigger condition is true when the specified external program has run successfully (exit status is 0).
 */

package Ifttt_app.Model;

import java.util.ArrayList;
import javafx.application.Platform;
import org.junit.Test;
import static org.junit.Assert.*;


public class TriggerExternalProgramTest {
    
    @Test
    public void testCheckTrigger() {
        Platform.startup(()->{
            int i=5;
        String programPath = "./External Programs\\myscript.bat";
        ArrayList<String> argument = new ArrayList<>();
        TriggerExternalProgram trigger= new  TriggerExternalProgram(programPath,argument,i);
        assertFalse(trigger.checkTrigger());
        });
        
    }
    @Test
    public void testCheckTriggerbis() {
        Platform.startup(()->{
            int i=0;
        String programPath = "./External Programs\\myscript.bat";
        ArrayList<String> argument = new ArrayList<>();
        TriggerExternalProgram trigger= new  TriggerExternalProgram(programPath,argument,i);
        assertTrue(trigger.checkTrigger());
        });
    }
    
}
