/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Ifttt_app.Model;

import javafx.application.Platform;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class RunExternalProgramActionTest {
    
     private RunExternalProgramAction action;
    @Before
    public void setUp() {
        String programPath = "./External Programs\\myscript123.bat";
        action = new RunExternalProgramAction(programPath);
    }

     @Test
    public void execute() throws InterruptedException{ 
        Platform.startup(()->{
            action.execute();
        });
        Thread.sleep(5000);
        assertEquals(false,action.isResult());
        }
    
}
