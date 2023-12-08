/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Ifttt_app.Model.Composite;

import Ifttt_app.Model.Composite.ActionPlayAudio;
import java.io.File;
import java.io.IOException;
import javafx.application.Platform;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Asus
 */
public class ActionPlayAudioTest {
    
    public ActionPlayAudioTest() {
    }
    
    /*The testExecute_withUnreadableAudioFile() test verifies whether the 
    execute() method properly handles an audio file that cannot be read or does 
    not exist. In this test, an instance of ActionPlayAudio is created using an 
    invalid path for an audio file. Subsequently, the action is executed, followed
    by a 6-second wait. After this waiting period, the test checks whether the 
    action is still running. The action should not be running (false) if the audio 
    cannot be played or if the audio file is not found.*/
     @Test 
    public void testExecute_withUnreadableAudioFile() throws InterruptedException {
        String AudioFilePath = "file.wav";
        ActionPlayAudio action = new ActionPlayAudio(AudioFilePath);
        Platform.startup(()->{
            action.execute();
        });
        Thread.sleep(6000);
        assertFalse(action.isRunning());
        }
    
}

   
    
 
