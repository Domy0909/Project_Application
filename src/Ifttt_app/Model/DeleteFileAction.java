/*
This class implemetns the Delete file action that delete a file choosen by the user 
in a directory also choosed by the user. 
*/
package Ifttt_app.Model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.application.Platform;

/**
 *
 * @author marco
 */
public class DeleteFileAction implements Action{
    private final String filePath;
    
    public DeleteFileAction(String filePath){
        this.filePath = filePath;
    }
    
    public String getFilePath(){
        return this.filePath;
    }
    @Override
    public boolean execute() {
        Platform.runLater( () -> {
            try{
                Path file = Paths.get(this.getFilePath());
                Files.delete(file);
            }catch (IOException e){
                e.printStackTrace();
            }
        
        });
        return true;
    }

    @Override
    public String description() {
        return DeleteFileAction.class.getSimpleName() + "\n" + "delete this file:";
    }
    
    
}
