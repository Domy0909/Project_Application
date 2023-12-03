/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author aless
 */
public class RunExternalProgramActionAll implements Action {
    String filePath;
    ArrayList<String> arguments;
    private int exitcode=999;
    
    
    
    
    public RunExternalProgramActionAll(String filePath, ArrayList<String> arguments) {
        this.filePath = filePath;
        this.arguments = arguments;
    }
    
  @Override
  public boolean execute() {
    try {
        File file = new File(filePath);
       
        if(!file.exists()){
            throw new FileNotFoundException("The specified file does not exist: " + filePath);
        }
        if (file.getName().toLowerCase().endsWith(".jar") && file.exists()) {
            ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", filePath);
            processBuilder.command().addAll(arguments); // Move this line up
            Process process = processBuilder.start();
            printProcessOutput(process);
            setExitcode(process.waitFor());
            System.out.println(file.getName());
            System.out.println("Exit Code: " + exitcode);
            return true;

        } else {
            if (file.exists()) {
                ProcessBuilder processBuilder = new ProcessBuilder(filePath);
                processBuilder.command().addAll(arguments); // Move this line up
                Process process = processBuilder.start();
                printProcessOutput(process);
                setExitcode(process.waitFor()); 
                System.out.println("Exit Code: " + exitcode);
                return true;
               
            }
        }
    } catch (IOException | InterruptedException e) {
        e.printStackTrace();
     
    }
    return false;
}

   
    
       private static void printProcessOutput(Process process) throws IOException {
        // Get the input stream of the process
        InputStream inputStream = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        // Read and print each line of the output
        String line;
        System.out.println("Process output:");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        // Close the reader
        reader.close();
    }

    public int getExitcode() {
        return exitcode;
    }

    public void setExitcode(int exitcode) {
        this.exitcode = exitcode;
    }
     

    @Override
    public String description() {
        File programFile = new File(filePath);
        return RunExternalProgramAction.class.getSimpleName()+"\n"+"run: "+programFile.getName();
    }
    
}
