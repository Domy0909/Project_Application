
package Ifttt_app.Model.Composite;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.scene.control.Alert;
/*
 * The RunExternalProgramAction class implements the Action interface and represents an action that executes an external program.
 * It allows for the execution of various types of files, such as .bat or .jar, with optional arguments.
 * The class provides methods to set and get the exit code of the executed program, check the execution result, and execute the program with or without output.
 * The executeFile method handles the execution of different file types and captures the output and exit code.
 * The showOutputDialog method displays an information dialog with the program arguments and output.
 * The execute method executes the external program, shows the output dialog, and sets the result.
 * The description method provides a simple description of the action, including the type of action and the program path.
 */
public class RunExternalProgramAction implements Action {
   private final String programPath;
   private final ArrayList<String> arguments;
   private int exitcode;
   private boolean result=false;



    public RunExternalProgramAction(String programPath,ArrayList<String> arguments) {
        this.programPath = programPath;
        this.arguments=arguments;
    }

    public void setExitcode(int exitcode) {
        this.exitcode = exitcode;
    }

    public int getExitcode() {
        return exitcode;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
    
    public String executeFile(String programPath, List<String> arguments) {
        StringBuilder output = new StringBuilder();

        try {
            
        ProcessBuilder processBuilder;
        if (programPath.toLowerCase().endsWith(".bat")) {
            
            processBuilder = new ProcessBuilder("cmd", "/c", "call",programPath);
        } else if (programPath.toLowerCase().endsWith(".jar")) {
            
            processBuilder = new ProcessBuilder("java", "-jar", programPath);
        } else {
           
            throw new IllegalArgumentException("Tipo di file non supportato");
        }

        
        processBuilder.command().addAll(arguments);
        processBuilder.redirectErrorStream(true); // Reindirizza l'output di errore allo stesso stream dell'output

        
        Process process = processBuilder.start();

        
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        
        this.setExitcode(process.waitFor());
        output.append("\nExit Code: ").append(this.getExitcode());

        } catch (IOException | InterruptedException e) {
            
            e.printStackTrace();
        }

        return output.toString();
    }

    private void showOutputDialog(String output, ArrayList<String> arguments) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("File Execution Result");
        alert.setHeaderText(null);
        alert.setContentText("Arguments: " + arguments + "\n\n" + output);

        
        alert.showAndWait();
    }

    @Override
    public boolean execute() {
        File programFile = new File(programPath);
        if (programFile.exists()) {
            if(this.getExitcode()==0){
                Platform.runLater(() -> {
            String absolutePath = programFile.getAbsolutePath();
            String output = executeFile(absolutePath,this.arguments);
            showOutputDialog(output,arguments);
            this.setResult(true);
            
            });
            }else{
                System.err.println("Il programma ha restituito un codice di uscita non zero: " + this.exitcode);
                this.setResult(false);
            }
        }else{
            
            this.setResult(false);
            System.err.println("Il programma non esiste: " + programFile.getAbsolutePath());
             
        }
        
        return true;
    }

    @Override
    public String description() {
        return RunExternalProgramAction.class.getSimpleName()+"\n"+"run: "+programPath;
    }
}
