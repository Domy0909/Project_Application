/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;


public class SizeFileTrigger implements Trigger{
    String filePath;
    int thresholdBytes;
    @Override
    public boolean checkTrigger() {
        File file = new File(filePath);
        // Check if the file exists
        if (!file.exists()) {
            throw new IllegalArgumentException("File does not exist: " + filePath);
        }
        // Check if the file size is above the threshold
        return file.length() > thresholdBytes;
    }

    public SizeFileTrigger(String filePath, int thresholdBytes) {
        this.filePath = filePath;
        this.thresholdBytes = thresholdBytes;
    }

    @Override
    public String description() {
        Path path=Paths.get(filePath);
        String fileName=path.getFileName().toString();
        return SizeFileTrigger.class.getSimpleName()+"\n"+"when size of "+fileName+"\n"+"is bigger than "+thresholdBytes+ " bytes";
    }
    
    
    
}
