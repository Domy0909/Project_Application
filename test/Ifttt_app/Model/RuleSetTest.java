/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Ifttt_app.Model;

import java.time.LocalTime;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Asus
 */
public class RuleSetTest {
     RuleSet ruleSet;
     Rule rule1;
     Rule rule2;
    public RuleSetTest() {
    }

    /**
     * Test of getInstance method, of class RuleSet.
     */
    @Test
    public void testGetInstance() {
    }

    /**
     * Test of getRules method, of class RuleSet.
     */
    @Test
    public void testGetRules() {
    }

    @Before
    public void setUp() {
        ruleSet = RuleSet.getInstance();
        rule1 = new Rule(new ShowDialogAction("rule1"), new TimeTrigger(LocalTime.now())); // Inizializza la regola 1
        rule2 = new Rule(new ActionPlayAudio("src//Ifttt_app//View//Beep.wav"), new TimeTrigger(LocalTime.now())); // Inizializza la regola 2
    }
    /**
     * Test of addRule method, of class RuleSet.
     */
    @Test
    public void testAddRule() {
      ruleSet.addRule(rule1);
      ruleSet.addRule(rule2);
      
      ObservableList<Rule> rules = ruleSet.getRules();
      
      assertEquals(2, rules.size());
      assertEquals(rule1, rules.get(0));
      assertEquals(rule2, rules.get(1));
    }

    /**
     * Test of removeRule method, of class RuleSet.
     */
    @Test
    public void testRemoveRule() {
        ruleSet.addRule(rule1);
        ruleSet.addRule(rule2);

        ruleSet.removeRule(rule1);

        ObservableList<Rule> rules = ruleSet.getRules();
        
        assertEquals(1, rules.size()); // Verifica che solo una regola sia stata rimossa
        assertEquals(rule2, rules.get(0)); // Verifica che la regola 2 sia rimasta
    }

    /**
     * Test of removeallRule method, of class RuleSet.
     */
    @Test
    public void testRemoveallRule() {
    }

    /**
     * Test of stopRuleChecking method, of class RuleSet.
     */
    @Test
    public void testStopRuleChecking() {
    }

    /**
     * Test of runRuleChecking method, of class RuleSet.
     * @throws java.lang.InterruptedException
     */
    @Test //test azione show dialog
    public void testRunRuleCheckingDialog() throws InterruptedException {
        ruleSet.addRule(rule1);
        Platform.startup(()->{
            ruleSet.runRuleChecking();
        });
        Thread.sleep(6000);
        assertEquals(true, rule1.isFired_oo());    
    }
    
    @Test //test azione play audio
    public void testRunRuleCheckingAudio() throws InterruptedException{
        ruleSet.addRule(rule2);
        Platform.startup(()->{
            ruleSet.runRuleChecking();
        });
        Thread.sleep(6000);
        assertEquals(true, rule2.isFired_oo());    
    }
  }

