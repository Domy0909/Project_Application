/*
This class implemetns the Copy file action that copy a file choosen by the user 
in a directory also choosed by the user. 
*/
package Ifttt_app.Model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javafx.application.Platform;

/**
 *
 * @author marco
 */
public class CopyFileAction implements Action{
    private final String filePath;
    private final String directoryPath;
    

    public String getFilePath() {
        return filePath;
    }

    public String getDirectoryPath() {
        return directoryPath;
    }
    
    
    public CopyFileAction(String filePath, String directoryPath){
        this.directoryPath = directoryPath;
        this.filePath = filePath;
    }
    

    @Override
    public boolean execute() {
        Platform.runLater( () -> {
            try{
                Path file = Paths.get(this.getFilePath());
                Path directory = Paths.get(this.getDirectoryPath(), file.getFileName().toString());
                Files.copy(file, directory,StandardCopyOption.REPLACE_EXISTING);
            }catch (IOException e){
                e.printStackTrace();
            }
        
        });
        return true;

    }

    @Override
    public String description() {
        return CopyFileAction.class.getSimpleName() + "\n" + "copy this file:" + this.getFilePath() + "\n" + "to this directory" + this.getDirectoryPath();
    }
    
    
}
