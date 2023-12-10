/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
The class provides an interface to manage a set of counters within an 
* application, enabling addition, removal, and access to the counters within 
* the set. Additionally, it utilizes the Singleton design pattern to ensure 
* the existence of a single instance, using getInstance(), of CounterSet 
* throughout the application's lifecycle The instance is created only if it 
* hasn't been initialized already.
 */
public class CounterSet {
    
    private static CounterSet instance;
    public ObservableList<Counter> counter_set;
    
    public static CounterSet getInstance() {
        if (instance == null) { 
            instance = new CounterSet();
        }
        return instance;
    }

    public CounterSet() {    
        this.counter_set = FXCollections.observableArrayList();
    }
    
    public ObservableList<Counter> getCounter_set() {
        return this.counter_set;
    }
    
    public void addCounter(Counter c){
        this.counter_set.add(c);
    }
    
    public void removeCounter(Counter c){
        this.counter_set.remove(c);
    }
    
    public void removeallCounter(){
       this.counter_set.removeAll(this.counter_set);
    }
    
    public Counter getCounter(String name){
        Counter c;
        c=this.counter_set.stream().filter(counter -> counter.getName().equals(name)).findFirst().orElse(null);
        return c;
    }
    
    
}
