/*
This class represents an action to run an external program.
The program's path is specified during instantiation.
The executeWithOutput method runs the program and captures its output.
The execute method calls executeWithOutput and prints the result to the console.
The description method returns a string describing the action.
 */
package Ifttt_app.Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.application.Platform;
import javafx.scene.control.Alert;

public class RunExternalProgramAction implements Action {
   private String programPath;
   private String[] commandLineArguments;
   private int exitcode;
   private boolean result=false;

    public RunExternalProgramAction(String programPath) {
        this.programPath = programPath;
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
    
    
    public String executeWithOutput() throws IOException, InterruptedException {
        List<String> commands = new ArrayList<>();
        commands.add(programPath);
        if (commandLineArguments != null) {
            commands.addAll(Arrays.asList(commandLineArguments));
        }

        ProcessBuilder processBuilder = new ProcessBuilder(commands);

        Process process = processBuilder.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        setExitcode(process.waitFor());
        //System.out.println("Script exited with code " + exitCode);

        return output.toString();
    }
    private String executeBatchFile(String batchFilePath) {
        StringBuilder output = new StringBuilder();

        try {
            // Crea il processo del file batch
            ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "call", batchFilePath);
            processBuilder.redirectErrorStream(true); // Reindirizza l'output di errore allo stesso stream dell'output

            // Avvia il processo
            Process process = processBuilder.start();

            // Ottieni l'output del processo
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Attendi il termine del processo
            int exitCode = process.waitFor();
            output.append("\nExit Code: ").append(exitCode);

        } catch (IOException | InterruptedException e) {
            
            e.printStackTrace();
        }

        return output.toString();
    }

    private void showOutputDialog(String output) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Batch File Execution Result");
        alert.setHeaderText(null);
        alert.setContentText(output);

        // Mostra la finestra di dialogo
        alert.showAndWait();
    }

    @Override
    public boolean execute() {
        File programFile = new File(programPath);
        if (programFile.exists()) {
            // Otteniamo il percorso assoluto del file
            Platform.runLater(() -> {
            String absolutePath = programFile.getAbsolutePath();
            String output = executeBatchFile(absolutePath);
            showOutputDialog(output);
            this.setResult(true);
            // Imposta il risultato in base al codice di uscita
            });
            
        } else {
            // Il programma non esiste, quindi non può essere eseguito correttamente
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