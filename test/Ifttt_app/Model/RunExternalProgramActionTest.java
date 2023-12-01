/*
 * This test class, named RunExternalProgramActionTest, is designed to verify the behavior of the RunExternalProgramAction class.
 * The test involves executing a specified external program in the setUp method and ensuring that the execution is successful within a waiting period.
 * Note: When the external program runs successfully and the showDialog appears, click the OK button before the thread finishes its wait.
 */
package Ifttt_app.Model;

import javafx.application.Platform;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RunExternalProgramActionTest {
    
     private RunExternalProgramAction action;
    @Before
    public void setUp() {
        String programPath = "./External Programs\\scriptSounds.bat";
        action = new RunExternalProgramAction(programPath);
    }

     @Test
    public void execute() throws InterruptedException{ 
        Platform.startup(()->{
            action.execute();
        });
        Thread.sleep(5000);
        assertEquals(true,action.isResult());
        }
    
}
