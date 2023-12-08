/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model.Composite;
import Ifttt_app.Model.Composite.Action;
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

/*The ActionPlayAudio class implements the Action interface and manages
the playback of audio files. */
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
    
     /**
     * Attempts to play the specified audio file.
     * Checks if the file exists and is readable, then initiates playback.
     * Updates the 'running' flag upon successful playback completion.
     * 
     * @return 'true' if audio playback is successful, 'false' otherwise
     */
    @Override
    public boolean execute() {
        this.setRunning(false);
        Platform.runLater(() -> {
        try {
            File audioFile = new File(audioFilePath);

            if (audioFile.exists() && audioFile.canRead()) {
                AudioInputStream audioInputStream;
                audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                
                Clip clip;
                clip= AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
               
                Thread.sleep(clip.getMicrosecondLength() / 1000);

                clip.close();
                audioInputStream.close();
                this.setRunning(true);
               } 
        } catch (IOException | InterruptedException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println("Error playing the audio: " + e.getMessage());
        }
        }); 
            return this.isRunning();
    }

    @Override
    public String description() {
        Path path=Paths.get(audioFilePath);
        String filename=path.getFileName().toString();
        return ActionPlayAudio.class.getSimpleName()+"\n"+"play: "+filename;
    }
}
