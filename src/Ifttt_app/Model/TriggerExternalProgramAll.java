/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author aless
 */
public class TriggerExternalProgramAll  implements Trigger {
    String filePath;
    ArrayList<String> arguments;
    private int expectedExitStatus;

    @Override
  public boolean checkTrigger() {
    try {
        RunExternalProgramActionAll action = new RunExternalProgramActionAll(filePath, arguments);
       if(action.execute()){ 
        return action.getExitcode() == expectedExitStatus;
       }
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Caught an exception: " + e.getMessage());
        // Handle any other exceptions here
    }
    System.out.println("Method completed without returning true");
    return false;
}
    public TriggerExternalProgramAll(String filePath, ArrayList<String> arguments, int expectedExitStatus) {
        this.filePath = filePath;
        this.arguments = arguments;
        this.expectedExitStatus = expectedExitStatus;
    }

    
    
    
    
    @Override
    public String description() {
       File programFile = new File(filePath);
       return String.format("Run external program '%s' \n with expected exit status %d", programFile.getName(), expectedExitStatus);
    }

   
    
}
