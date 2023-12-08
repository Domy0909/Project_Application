/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Ifttt_app.Model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Asus
 */
public class CounterModifyTest {
    /**
   * Verifies if the simulateUserInput method can correctly set
   * the value of a Counter object using input provided as a string.
   * It tests the conversion of the input into an integer and setting the value in the Counter.
   */
    @Test
    public void testModifyValue() {
        Counter selectedCounter = new Counter("TestCounter",5);
        simulateUserInput(selectedCounter, "10");
        assertEquals(10, selectedCounter.getValue().intValue());
    }
    //Simulates user input to set the value of a Counter object.
    private void simulateUserInput(Counter selectedCounter, String input) {
        assertTrue(input.matches("\\d+"));
        int intValue = Integer.parseInt(input);
        selectedCounter.setValue(intValue);
    }
}
