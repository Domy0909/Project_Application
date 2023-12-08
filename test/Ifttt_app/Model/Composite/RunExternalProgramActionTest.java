package Ifttt_app.Model.Composite;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RunExternalProgramActionTest {
     private RunExternalProgramAction action1,action2,action3;
     private String programPath,filepath,filepath2;
     private ArrayList<String> argument,argument2,argument3;
    
     
    @Before
    public void setUp() {
        programPath = "./External Programs\\scriptSounds.bat";
        argument= new ArrayList<>();
        argument.add("Hello");
        action1 = new RunExternalProgramAction(programPath,argument);
        filepath="./External Programs\\CommandNotFound.bat";
        argument2= new ArrayList<>();
        argument2.add("Hello");
        argument2.add("I am");
        argument2.add("Gennaro");
        action2= new RunExternalProgramAction(filepath,argument2);
        filepath2="./External Programs\\ProgramException.jar";
        argument3= new ArrayList<>();
        argument3.add("Hello");
        argument3.add("I am");
        argument3.add("Marco");
        action3= new RunExternalProgramAction(filepath2,argument3);
    }
    
/*
 * TestExecuteWithExitCode0: Executes action1 using the executeFile method and checks that the exit code is 0.
 * Prints the obtained exit code to the console and asserts equality with the expected value (0).
 */
     @Test
    public void TestExecuteWithExitCode0() throws InterruptedException, IOException { 
      String output = action1.executeFile(programPath, argument);
      int exitCode = action1.getExitcode();
      System.out.println("Exit Code: " + exitCode);

     assertEquals(0, exitCode);
    }
    
    /*
 * TestExecuteWithExitCode255: Executes action2 using the executeFile method and checks that the exit code is 255.
 * Prints the obtained exit code to the console, asserts equality with the expected value (255), and ensures the result is false.
 */
    @Test
    public void TestExecuteWithExitCode255() throws InterruptedException, IOException{ 
      String output = action2.executeFile(filepath, argument2);
      int exitCode = action2.getExitcode();
      System.out.println("Exit Code: " + exitCode);

     assertEquals(255, exitCode);
     assertFalse(action2.isResult());
   }
    
    /*
 * TestExecuteWithExitCode1: Executes action3 using the executeFile method and checks that the exit code is 1.
 * Prints the obtained exit code to the console, asserts equality with the expected value (1), and ensures the result is false.
 */
    @Test
    public void TestExecuteWithExitCode1() throws InterruptedException, IOException{ 
      String output = action3.executeFile(filepath2, argument3);
      int exitCode = action3.getExitcode();
      System.out.println("Exit Code: " + exitCode);

     assertEquals(1, exitCode);
     assertFalse(action3.isResult());
   } 
}
