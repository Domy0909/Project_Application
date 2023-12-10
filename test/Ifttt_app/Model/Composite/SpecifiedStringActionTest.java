/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Ifttt_app.Model.Composite;

import Ifttt_app.Model.Composite.SpecifiedStringAction;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import javafx.application.Platform;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test case for the SpecifiedStringAction class, verifying its functionality to append a specific string
 * to a file's content using the execute method.
 */
public class SpecifiedStringActionTest {
    
    /**
     * Executes the SpecifiedStringAction by appending a string to a specified file and verifies
     * the successful execution.
     */
  
    @Test
    public void testExecute() {
        String filePath = "test\\Ifttt_app\\Model\\TestFile.txt";
        String contentToAppend = "Test string to append.";
        SpecifiedStringAction action = new SpecifiedStringAction(filePath,contentToAppend);
         Platform.startup(()->{
            boolean result = action.execute();
            assertTrue("Execution should return true on success.",result);
        });
         testStringIsInFile();
    }
    /**
     * Checks if the specified string content is present in the file.
     */
    public void testStringIsInFile(){
        String filePath = "test\\Ifttt_app\\Model\\TestFile.txt";
        String contentToAppend = "Test string to append.";
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
     /**
     * Cleans the contents of the test file after the tests.
     * It deletes the content inside the specified file.
     */
    @After
    public void cleanTestFile(){
        String filePath = "test\\Ifttt_app\\Model\\TestFile.txt";
        
        try {
            Path path = FileSystems.getDefault().getPath(filePath);
            Files.newOutputStream(path, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING).close();

            System.out.println("Contents of the file have been deleted.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
