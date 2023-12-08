/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author aless
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
    
    public Counter getCounter(String name){
        Counter c;
        c=this.counter_set.stream().filter(counter -> counter.getName().equals(name)).findFirst().orElse(null);
        return c;
    }
    
    
}
