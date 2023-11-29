/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.application.Platform;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class ActionPlayAudio implements Action{
        private final String audioFilePath;
        private boolean running;

    
   
    public ActionPlayAudio(String audioFilePath) {
        this.audioFilePath = audioFilePath;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
    
     // esecuzione Azione PlayAudio
    @Override
    public boolean execute() {
        
        Platform.runLater(() -> {
        try {
            File audioFile = new File(audioFilePath);

            // Check se esiste e se è riproducibile 
            if (audioFile.exists() && audioFile.canRead()) {
                AudioInputStream audioInputStream;
                audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                
                Clip clip;
                clip= AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                
                // Attesa per la fine dell'audio
                Thread.sleep(clip.getMicrosecondLength() / 1000);

                clip.close();
                audioInputStream.close();
                this.setRunning(true);
               } 
        } catch (IOException | InterruptedException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println("Error playing the audio: " + e.getMessage());
        }
        }); 
            return false;
    }

    @Override
    public String description() {
        Path path=Paths.get(audioFilePath);
        String filename=path.getFileName().toString();
        return ActionPlayAudio.class.getSimpleName()+"\n"+"play: "+filename;
    }
}
