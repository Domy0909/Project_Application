/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.View;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javafx.stage.FileChooser;

/**
 *
 * @author aless
 */
public class SelectProgramController {
    
    private String programPath;

    public SelectProgramController() {
    }

    public String getProgramPath() {
        return programPath;
    }
       
    
    public void selectProgram() throws IOException{
        programPath=null;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a File");

        File currentDirectory = new File(new File("./External Programs").getAbsolutePath());
        File initialDirectory = new File(currentDirectory.getCanonicalPath());
        fileChooser.setInitialDirectory(initialDirectory);
        fileChooser.setTitle("Open Executable File");
        // Define a list of executable file extensions
        List<String> executableExtensions = Arrays.asList(
                "*.exe", "*.com", "*.bat", "*.cmd", "*.msi",
                "*.vbs", "*.js", "*.jar", "*.ps1", "*.psm1",
                "*.py", "*.pyc", "*.ps1xml", "*.wsf"
        );

        // Create an ExtensionFilter that includes all executable extensions
        FileChooser.ExtensionFilter executableFilter = new FileChooser.ExtensionFilter(
                "Executable Files", executableExtensions
        );
        fileChooser.getExtensionFilters().add(executableFilter);
        File selectedFile = fileChooser.showOpenDialog(null);
            if (selectedFile != null) {
                programPath = selectedFile.getAbsolutePath();
           
            }
    }
}
