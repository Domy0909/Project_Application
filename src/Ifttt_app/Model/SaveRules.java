/*
 * The SaveRules class provides methods for saving and loading rules from a file using serialization and deserialization.
 * The saveRules method takes a RuleSet, serializes its rules into a file named "Ruleset.bin," and handles IOExceptions by printing the stack trace.
 * The loadRules method deserializes rules from the "Ruleset.bin" file into a RuleSet, adding them to the existing set of rules, and handles ClassNotFoundException and IOException by printing relevant error messages.
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


public class SaveRules {
     
    public static void saveRules(RuleSet ruleSet) {
        List<Rule> list = new ArrayList<>();
        for(Rule e : ruleSet.ruleSet)
            list.add(e);
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Ruleset.bin")))) {
            out.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public static void loadRules(RuleSet ruleSet) {
        List<Rule> load = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("Ruleset.bin")))) {
            load = (List<Rule>) in.readObject();
            for(Rule e : load)
                ruleSet.addRule(e);
        } catch(ClassNotFoundException e){
            System.err.println("File 'Ruleset.bin' not found: " + e.getMessage());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
