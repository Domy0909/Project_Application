/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
This SizeFileTrigger class implements the Trigger interface. Its main function 
is to check if the size of a file exceeds a certain threshold in bytes.
*/
public class SizeFileTrigger implements Trigger{
    private String filePath;
    private int thresholdBytes;
    
    /*
    The checkTrigger() method is implemented to verify if the file exists and 
    if its size exceeds the specified threshold. It returns true if the file 
    exists and its size surpasses the threshold; otherwise, it returns false. 
    If the file doesn't exist, it throws an IllegalArgumentException.
    */
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
