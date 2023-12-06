/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Ifttt_app.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author aless
 */
public class SpecifiedStringActionTest {
    
    public SpecifiedStringActionTest() {
    }

    /**
     * Test of execute method, of class SpecifiedStringAction.
     */
    
  
    @Test
    public void testExecute() {
        String filePath = "test\\Ifttt_app\\Model\\TestFile.txt";
        // Specify the content to append
        String contentToAppend = "Test string to append.";

        // Create an instance of SpecifiedStringAction
        SpecifiedStringAction action = new SpecifiedStringAction(filePath,contentToAppend);

        // Execute the action
        
         Platform.startup(()->{
            boolean result = action.execute();
            assertTrue("Execution should return true on success.",result);
        });

        // Verify the result
        
         testStringIsInFile();
    }
    
    public void testStringIsInFile(){
        String filePath = "test\\Ifttt_app\\Model\\TestFile.txt";
        // Specify the content to append
        String contentToAppend = "Test string to append.";
        
        // Read the file and check if it contains the appended string
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder fileContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line);
            }
            
            assertEquals("File content should match the appended string.", contentToAppend, fileContent.toString());
            } catch (IOException e) {
             e.printStackTrace();
            fail("Exception occurred while reading the file.");
        
        }    
    }
    
    @After
    public void cleanTestFile(){
           // Specify the path to your text file
        String filePath = "test\\Ifttt_app\\Model\\TestFile.txt";
        
        try {
            // Open the file with WRITE and TRUNCATE_EXISTING options
            Path path = FileSystems.getDefault().getPath(filePath);
            Files.newOutputStream(path, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING).close();

            System.out.println("Contents of the file have been deleted.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
