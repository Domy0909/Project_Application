
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

/*
 * The SaveLoadCounters class provides methods for saving and loading counters from a file using serialization and deserialization.
 * The saveCounters method takes a CounterSet, serializes its rules into a file named "Counterset.bin," and handles IOExceptions by printing the stack trace.
 * The loadCounters method deserializes counters from the "Counterset.bin" file into a CounterSet, adding them to the existing set of counters, and handles ClassNotFoundException and IOException by printing relevant error messages.
 */
public class SaveLoadCounters {
    
     public static void saveCounters(CounterSet counterSet) {
        List<Counter> list = new ArrayList<>();
        for(Counter e : counterSet.counter_set)
            list.add(e);
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Counterset.bin")))) {
            out.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public static void loadCounters(CounterSet counterSet) {
        List<Counter> load = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("Counterset.bin")))) {
            load = (List<Counter>) in.readObject();
            for(Counter e : load)
                counterSet.addCounter(e);
        } catch(ClassNotFoundException e){
            System.err.println("File 'Counterset.bin' not found: " + e.getMessage());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
