/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Ifttt_app.Model;

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
    
    @Test // test con audio valido 
    public void testExecute_withValidAudioFile() throws InterruptedException{
        String validAudioFilePath = "sounds\\clip_1.wav";
        ActionPlayAudio action = new ActionPlayAudio(validAudioFilePath);
        Platform.startup(()->{
            action.execute();
        });
        Thread.sleep(10000);
        assertEquals(true , action.isRunning());
    }
    @Test // test con audio non leggibile o non presente
    public void testExecute_withUnreadableAudioFile() throws InterruptedException {
        String unreadableAudioFilePath = "file.wav";
        ActionPlayAudio action = new ActionPlayAudio(unreadableAudioFilePath);
        Platform.startup(()->{
            action.execute();
        });
        Thread.sleep(10000);
        assertEquals(false , action.isRunning());
        }
    
}

   
    
 
