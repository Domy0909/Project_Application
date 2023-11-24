/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class SaveRules {
     // Metodo per salvare la regola presente nella classe RuleSet su un file, utilizzando la serializzazione.
    public static void saveRules(RuleSet ruleSet) {
        List<Rule> list = new ArrayList<>();
        for(Rule e : ruleSet.ruleSet)
            list.add(e);
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Ruleset.bin")))) {
            // Scrive la regola sul file "ruleset.ser".
            out.writeObject(list);
        } catch (IOException e) {
            // Stampa lo stack trace se si verifica un'eccezione di I/O.
            e.printStackTrace();
        }
    }

    // Metodo per caricare la regola della classe RuleSet da un file, utilizzando la deserializzazione.
    public static void loadRules(RuleSet ruleSet) {
        List<Rule> load = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("Ruleset.bin")))) {
            // Legge la regola dal file "ruleset.ser" e lo restituisce.
            load = (List<Rule>) in.readObject();
            for(Rule e : load)
                ruleSet.addRule(e);
        } catch(ClassNotFoundException e){
            System.err.println("File 'Ruleset.bin' not found: " + e.getMessage());
        }catch (IOException e) {
            // Stampa lo stack trace se si verifica un'eccezione di I/O o se la classe dell'oggetto serializzato non viene trovata.
            e.printStackTrace();
        }
    }
}
