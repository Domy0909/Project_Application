/*
 * The TriggerExternalProgram class implements the Trigger interface and represents a trigger based on the exit status of an external program.
 * It takes the path to the external program and the expected exit status as parameters during instantiation.
 * The checkTrigger method runs the external program using RunExternalProgramAction, retrieves its actual exit status, and compares it with the expected exit status.
 * If they match, the trigger is considered true; otherwise, it returns false.
 * The description method provides a formatted description of the trigger, including the program path and expected exit status.
 */

package Ifttt_app.Model;


public class TriggerExternalProgram implements Trigger{
    
    private String programPath;
    private int expectedExitStatus;

    public TriggerExternalProgram(String programPath, int expectedExitStatus) {
        this.programPath = programPath;
        this.expectedExitStatus = expectedExitStatus;
    }
    
    @Override
    public boolean checkTrigger() {
        try {
            RunExternalProgramAction action = new RunExternalProgramAction(programPath);
            int actualExitStatus = action.getExitcode();
            if(actualExitStatus == expectedExitStatus){
                return true;
            }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String description() {
        return String.format("Run external program '%s' with expected exit status %d", programPath, expectedExitStatus);
    }
}