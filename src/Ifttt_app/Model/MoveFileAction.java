/*
This class implemetns the Move file action that move a file choosen by the user 
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
public class MoveFileAction implements Action{
    private final String filePath;
    private final String directoryPath;
    
    public MoveFileAction(String filePath, String directoryPath){
        this.directoryPath = directoryPath;
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getDirectoryPath() {
        return directoryPath;
    }
    
    

    @Override
    public boolean execute() {
                Platform.runLater( () -> {
            try{
                Path file = Paths.get(this.getFilePath());
                Path directory = Paths.get(this.getDirectoryPath(), file.getFileName().toString());
                Files.move(file, directory,StandardCopyOption.REPLACE_EXISTING);
            }catch (IOException e){
                e.printStackTrace();
            }
        
        });
        return true;
    }

    @Override
    public String description() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
