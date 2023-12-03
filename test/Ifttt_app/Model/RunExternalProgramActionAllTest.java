/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Ifttt_app.Model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aless
 */
public class RunExternalProgramActionAllTest {
    
    public RunExternalProgramActionAllTest() {
    }

    /**
     * Test of execute method, of class RunExternalProgramActionAll.
     */
    @Test
    public void testExecute() {
    String filepath="./External Programs\\myscript.bat";
    ArrayList<String> argument= new ArrayList<>();
    argument.add("Ciao");
    
    
    RunExternalProgramActionAll action= new RunExternalProgramActionAll(filepath,argument);
    assertTrue("should be true",action.execute());
    }
    
    
    @Test
    public void testExecute2() {
    
     String filepath="./External Programs\\CommandLine2.jar";
     ArrayList<String> argument= new ArrayList<>();
     argument.add("Ciao");
     argument.add("Sono");
     argument.add("Gennaro");
     RunExternalProgramActionAll action= new RunExternalProgramActionAll(filepath,argument);
     assertTrue("should be true",action.execute());
     }
    


    @Test
    public void testExecuteNONE() {
     String filepath="C:\\Users\\aless\\OneDrive\\Documenti\\NetBeansProjects\\CommandLine2\\dist\\dasasd.jar";
     ArrayList<String> argument= new ArrayList<>();
     argument.add("Ciao");
     argument.add("Sono");
     argument.add("Gennaro");
     RunExternalProgramActionAll action= new RunExternalProgramActionAll(filepath,argument);
     assertFalse("program not found so false",action.execute());
      }
    }


    /**
     * Test of description method, of class RunExternalProgramActionAll.
     */

