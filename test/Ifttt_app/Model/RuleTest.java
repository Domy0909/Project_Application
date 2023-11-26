/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Ifttt_app.Model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import org.junit.*;
import static org.junit.Assert.*;
/**
 *
 * @author marco
 */
public class RuleTest {

    /**
     * Test of setAction method, of class Rule.
     */
    @Test
    public void testSetAction() {
        // Test della funzione setAction
        ShowDialogAction action = new ShowDialogAction("Testing");
        Rule rule = new Rule();
        rule.setAction(action);

        assertEquals(action, rule.getAction());
    }

    /**
     * Test of setTrigger method, of class Rule.
     */
    @Test
    public void testSetTrigger() {
        // Test della funzione setTrigger
        TimeTrigger trigger = new TimeTrigger(LocalTime.now());
        Rule rule = new Rule();
        rule.setTrigger(trigger);

        assertEquals(trigger, rule.getTrigger());
    }

    /**
     * Test of setActive method, of class Rule.
     */
    @Test
    public void testSetActive() {
        // Test della funzione setActive
        Rule rule = new Rule();
        rule.setActive(true);

        assertTrue(rule.isActive());
    }

    /**
     * Test of setFiredOnlyOnce method, of class Rule.
     */
    @Test
    public void testSetFiredOnlyOnce() {
        // Test della funzione setFiredOnlyOnce
        Rule rule = new Rule();
        rule.setFiredOnlyOnce(true);

        assertTrue(rule.isFiredOnlyOnce());
    }

    /**
     * Test of setFired_oo method, of class Rule.
     */
    @Test
    public void testSetFired_oo() {
        // Test della funzione setFired_oo
        Rule rule = new Rule();
        rule.setFired_oo(true);

        assertTrue(rule.isFired_oo());
    }

    /**
     * Test of setSleeping method, of class Rule.
     */
    @Test
    public void testSetSleeping() {
        // Test della funzione setSleeping
        Rule rule = new Rule();
        rule.setSleeping(true);

        assertTrue(rule.isSleeping());
    }

    /**
     * Test of setSleepingDate method, of class Rule.
     */
    @Test
    public void testSetSleepingDate() {
    }

    /**
     * Test of getAction method, of class Rule.
     */
    @Test
    public void testGetAction() {
    }

    /**
     * Test of getTrigger method, of class Rule.
     */
    @Test
    public void testGetTrigger() {
    }

    /**
     * Test of isActive method, of class Rule.
     */
    @Test
    public void testIsActive() {
    }

    /**
     * Test of isFiredOnlyOnce method, of class Rule.
     */
    @Test
    public void testIsFiredOnlyOnce() {
    }

    /**
     * Test of isFired_oo method, of class Rule.
     */
    @Test
    public void testIsFired_oo() {
    }

    /**
     * Test of isSleeping method, of class Rule.
     */
    @Test
    public void testIsSleeping() {
    }

    /**
     * Test of getSleepingDate method, of class Rule.
     */
    @Test
    public void testGetSleepingDate() {
    }

    /**
     * Test of setAwake method, of class Rule.
     */
    @Test
    public void testSetAwake() {
        Rule test = new Rule();
        LocalDateTime testd = LocalDateTime.now();
        test.setAwake(testd);
        assertEquals(testd,test.getAwake());
        
    }

    /**
     * Test of getAwake method, of class Rule.
     */
    @Test
    public void testGetAwake() {
    }

    /**
     * Test of whenAwake method, of class Rule.
     */
    @Test
    public void testWhenAwake() {
        Rule test = new Rule();
        LocalDateTime today = LocalDateTime.now().plusMinutes(5);
        test.whenAwake();
        //assertEquals(today,test.getAwake());
        test.setDay(5);
        test.setHours(3);
        LocalDateTime today1 = LocalDateTime.now().plusDays(5).plusHours(3).plusMinutes(5);
        test.whenAwake();
        assertEquals(today1,test.getAwake());
        
        
        
    }

    /**
     * Test of isAwake method, of class Rule.
     */
    @Test
    public void testIsAwake() {
        Rule test = new Rule();
        LocalDateTime testd = LocalDateTime.now();
        LocalDateTime testt = testd.plusDays(5);
        test.setAwake(testt);
        assertEquals(false,test.isAwake());
        LocalDateTime testt1 = testd.plusHours(1);
        test.setAwake(testt1);
        //assertEquals(true,test.isAwake());
        LocalDateTime testd2 = testd.plusMinutes(1);
        test.setAwake(testd2);
        //assertEquals(true,test.isAwake());
        LocalDateTime testm = testd.minusDays(1);
        test.setAwake(testm);
        assertEquals(true,test.isAwake());
    }
    
}
