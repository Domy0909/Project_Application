/*
 * This test class, named RunExternalProgramActionTest, is designed to verify the behavior of the RunExternalProgramAction class.
 * The test involves executing a specified external program in the setUp method and ensuring that the execution is successful within a waiting period.
 * Note: When the external program runs successfully and the showDialog appears, click the OK button before the thread finishes its wait.
 */
package Ifttt_app.Model;

import java.util.ArrayList;
import javafx.application.Platform;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RunExternalProgramActionTest {
    
     private RunExternalProgramAction action1,action2,action3;
    @Before
    public void setUp() {
        String programPath = "./External Programs\\scriptSounds.bat";
        ArrayList<String> argument= new ArrayList<>();
        argument.add("Hello");
        action1 = new RunExternalProgramAction(programPath,argument);
        String filepath="./External Programs\\CommandLine2.jar";
        ArrayList<String> argument2= new ArrayList<>();
        argument2.add("Hello");
        argument2.add("I am");
        argument2.add("Gennaro");
        action2= new RunExternalProgramAction(filepath,argument2);
        String filepath2="./External Programs\\FileDoesNotExist.jar";
        ArrayList<String> argument3= new ArrayList<>();
        argument3.add("Hello");
        argument3.add("I am");
        argument3.add("Marco");
        action3= new RunExternalProgramAction(filepath2,argument3);
    }

     @Test
    public void TeatExecute1() throws InterruptedException{ 
        Platform.startup(()->{
            action1.execute();
        });
        Thread.sleep(5000);
        assertEquals(true,action1.isResult());
        }
    
    @Test
    public void TeatExecute2() throws InterruptedException{ 
        Platform.startup(()->{
            action2.execute();
        });
        Thread.sleep(5000);
        assertEquals(true,action2.isResult());
        }
    
    @Test
    public void testExecuteNONE() throws InterruptedException {
        Platform.startup(()->{
            action3.execute();
        });
        Thread.sleep(5000);
        assertEquals(false,action3.isResult());
      }
}
