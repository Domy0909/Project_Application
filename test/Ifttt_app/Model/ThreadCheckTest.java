/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Ifttt_app.Model;

import Ifttt_app.Model.Composite.ActionPlayAudio;
import java.time.LocalDate;
import javafx.application.Platform;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Asus
 */
public class ThreadCheckTest {
    
    
     /**
    * Verifies if the system rules are executed correctly and adhere to the specified settings.
    * In this test, two rules with specific actions and triggers are simulated to verify if the rules
    * are activated or not based on their trigger settings. The first rule is set with "Fired Only Once" mode,
    * which should be activated only once. The second rule is set with "Sleeping" mode.
    * note: thread.sleep is set to 65000 milliseconds to wait for rule2 to execute twice before completing the test
    */
      @Test
    public void testRunRuleChecking() throws InterruptedException {
        RuleSet ruleSet = RuleSet.getInstance();
        Rule rule1= new Rule(new ActionPlayAudio("sounds\\clip_1.wav"), new TriggerDayMonth (LocalDate.now().getDayOfMonth()));
        Rule rule2 = new Rule(new ActionPlayAudio("sounds\\whippoorwill.wav"), new TriggerDayMonth (LocalDate.now().getDayOfMonth()));
        rule1.setFiredOnlyOnce(true);
        rule2.setSleeping(true);
        rule2.setDay(0);
        rule2.setMinutes(1);
        rule2.setHours(0);
        ruleSet.addRule(rule2);
        ruleSet.addRule(rule1);
 
        ThreadCheck threadCheck = new ThreadCheck(ruleSet, false);
         Platform.startup(()->{
             threadCheck.runRuleChecking();
        });
   
        Thread.sleep(65000); 
      
        assertTrue(rule1.isFired_oo()); 
        assertFalse(rule2.isAwake()); 
        threadCheck.stopRuleChecking();
    }
    
}
