/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Ifttt_app.Model;

import Ifttt_app.Model.Composite.ShowDialogAction;
import Ifttt_app.Model.Composite.ActionPlayAudio;
import java.time.LocalTime;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import org.junit.After;
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
    
    @Before
    public void setUp() {
        ruleSet = RuleSet.getInstance();
        rule1 = new Rule(new ShowDialogAction("rule1"), new TimeTrigger(LocalTime.now())); 
        rule2 = new Rule(new ActionPlayAudio("sounds\\clip_1.wav"), new TimeTrigger(LocalTime.now())); 
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
      ruleSet.getRules().removeAll(ruleSet.getRules());
    }

    /**
     * Test of removeRule method, of class RuleSet.
     */
    @Test
    public void testRemoveRule() {
        ruleSet.addRule(rule1);
        ruleSet.addRule(rule2);

        ruleSet.removeRule(rule2);

        ObservableList<Rule> rules = ruleSet.getRules();
        
        assertEquals(1, rules.size()); // Verifica che solo una regola sia stata rimossa
        assertEquals(rule1, rules.get(0)); // Verifica che la regola 2 sia rimasta
        ruleSet.getRules().removeAll(ruleSet.getRules());
    }

    
   
    @After
    public void afterTesting(){
      ruleSet.getRules().removeAll(ruleSet.getRules());
     }
  }

