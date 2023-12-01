/*
 * This test class, SaveLoadRulesTest, is designed to test the functionality of saving and loading rules using the SaveRules class.
 * The testSaveRules method creates a sample RuleSet, saves it to a file, and verifies the existence and non-emptiness of the file.
 * The testLoadRules method tests loading rules from a file, ensuring the file exists, loading rules into an empty RuleSet, and verifying the loaded rules.
 * The createSampleRuleSet method is a utility to generate a sample RuleSet with a rule containing a ShowDialogAction triggered by the current time.
 */

package Ifttt_app.Model;

import java.io.File;
import java.time.LocalTime;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class SaveLoadRulesTest {
    
    @Test
    public void testSaveRules() {
        RuleSet ruleSet = createSampleRuleSet();

        String filePath = "Ruleset.bin";
        
        SaveRules.saveRules(ruleSet);
        
        File file = new File(filePath);
        assertTrue(file.exists());
        
        assertTrue(file.length() > 0);
    }

    @Test
    public void testLoadRules() {
        RuleSet ruleSet = createSampleRuleSet();

        String filePath = "Ruleset.bin"; 
       
        File file = new File(filePath);
        assertTrue(file.exists());
        // Chiamare il metodo di caricamento
        ruleSet.removeallRule();
        SaveRules.loadRules(ruleSet);
        
        assertEquals(1, ruleSet.getRules().size());  
    }


    private RuleSet createSampleRuleSet() {
        RuleSet ruleSet = RuleSet.getInstance();
        ruleSet.addRule(new Rule(new ShowDialogAction("Messaggio di prova"), new TimeTrigger(LocalTime.now())));
       
        return ruleSet;
    }
    }

    

