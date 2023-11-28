/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author aless
 */
public class ExistenceTrigger implements Trigger {
    String directoryPath;
    String fileName;
    @Override
    public boolean checkTrigger() {
        Path filePath = Paths.get(directoryPath, fileName);
        return Files.exists(filePath) && Files.isRegularFile(filePath);
    }

    public ExistenceTrigger(String directoryPath, String fileName) {
        this.directoryPath = directoryPath;
        this.fileName = fileName;
    }

    @Override
    public String description() {
        Path path=Paths.get(directoryPath);
        String dirname=path.getFileName().toString();
        return ExistenceTrigger.class.getSimpleName()+"\n"+"on existance of: "+fileName+"\n"+"in directory: "+dirname;
    }
    
}
