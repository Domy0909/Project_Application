/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
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
        // Chiamare il metodo di salvataggio
        SaveRules.saveRules(ruleSet);
        // Verificare che il file esista dopo averlo salvato
        File file = new File(filePath);
        assertTrue(file.exists());
        // Verificare che il file non sia vuoto
        assertTrue(file.length() > 0);
    }

    @Test
    public void testLoadRules() {
        RuleSet ruleSet = createSampleRuleSet();

        String filePath = "Ruleset.bin"; // Output del messaggio di errore
        // Salvare le regole su un file
        //SaveRules.saveRules(createSampleRuleSet());
        // Verificare che il file esista prima di tentare di caricarlo
        File file = new File(filePath);
        assertTrue(file.exists());
        // Chiamare il metodo di caricamento
        ruleSet.removeallRule();
        SaveRules.loadRules(ruleSet);
        // Verificare che le regole caricate siano state caricate correttamente
        
        assertEquals(2, ruleSet.getRules().size());  //Modficare seconda del numero di regole nel RuleSet di esempio
    }

    // Metodo di utilità per creare un RuleSet di esempio
    private RuleSet createSampleRuleSet() {
        RuleSet ruleSet = RuleSet.getInstance();
        ruleSet.addRule(new Rule(new ShowDialogAction("Messaggio di prova"), new TimeTrigger(LocalTime.now())));
        // Aggiungi altre regole se necessario
        return ruleSet;
    }
    }

    

