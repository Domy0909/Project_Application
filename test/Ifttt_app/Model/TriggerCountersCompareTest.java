/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Ifttt_app.Model;

import org.junit.Test;
import static org.junit.Assert.*;

public class TriggerCountersCompareTest {
   // Fixed counters with specific values
    Counter softwareCounter = new Counter("Software", 80);
    Counter projectCounter = new Counter("Project", 30);
    Counter engineeringCounter = new Counter("Engineering", 46);
    Counter scrumCounter = new Counter("Scrum", 80);

    @Test
    public void testGreaterThan() {
        // Verify if "Software" counter is greater than "Project" counter
        TriggerCountersCompare trigger = new TriggerCountersCompare(softwareCounter.getName(), projectCounter.getName(), "GreaterThan");
        assertTrue( "Software > Project should return true",trigger.checkTrigger());
        
        // Verify if "Scrum" counter is less than "Software" counter
        trigger = new TriggerCountersCompare(scrumCounter.getName(), softwareCounter.getName(), "GreaterThan");
        assertFalse("Scrum < Software should return false",trigger.checkTrigger());
    }

    @Test
    public void testLessThan() {
        // Verify if "Project" counter is less than "Engineering" counter
        TriggerCountersCompare trigger = new TriggerCountersCompare(projectCounter.getName(), engineeringCounter.getName(), "LessThan");
        assertTrue( "Project < Engineering should return true",trigger.checkTrigger());

        // Verify if "Scrum" counter is greater than "Project" counter
        trigger = new TriggerCountersCompare(scrumCounter.getName(), projectCounter.getName(), "LessThan");
        assertFalse("Scrum > Project should return false",trigger.checkTrigger());
    }

    @Test
    public void testEqualTo() {
        // Verify if "Software" counter is equal to "Scrum" counter
        TriggerCountersCompare trigger = new TriggerCountersCompare(softwareCounter.getName(), scrumCounter.getName(), "EqualTo");
        assertTrue("Software == Scrum should return true",trigger.checkTrigger());

        // Verify if "Project" counter is not equal to "Engineering" counter
        trigger = new TriggerCountersCompare(projectCounter.getName(), engineeringCounter.getName(), "EqualTo");
        assertFalse("Project != Engineering should return false",trigger.checkTrigger());
    }

    @Test
    public void testDefaultCase() {
        // Verify with an invalid condition
        TriggerCountersCompare trigger = new TriggerCountersCompare(softwareCounter.getName(), engineeringCounter.getName(), "InvalidCondition");
        assertFalse("Invalid condition should return false",trigger.checkTrigger());
    
}
    
}
