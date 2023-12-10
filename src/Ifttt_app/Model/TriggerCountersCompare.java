/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;

/**
 * This class represents a trigger for comparing two counter values.
 * It implements the Trigger interface and provides methods to check the trigger condition
 * and retrieve a description of the trigger.
 */
public class TriggerCountersCompare implements Trigger{
    private final int counterValue1;
    private final int counterValue2;
    private final String condition;

    public TriggerCountersCompare(int counterValue1, int counterValue2, String condition) {
        this.counterValue1 = counterValue1;
        this.counterValue2 = counterValue2;
        this.condition = condition;
    }

    public int getCounterValue1() {
        return counterValue1;
    }

    public int getCounterValue2() {
        return counterValue2;
    }

    public String getCondition() {
        return condition;
    }
    
    @Override
    public boolean checkTrigger() {
        return switch (condition) {
            case "GreaterThan" -> counterValue1 > counterValue2;
            case "LessThan" -> counterValue1 < counterValue2;
            case "EqualTo" -> counterValue1 == counterValue2;
            default -> false;
        };
    }
    
    

    @Override
    public String description() {
        switch(condition){
            case "GreaterThan" -> {
                return " ( "+ counterValue1+" ) \n GreaterThan \n( "+counterValue2+" )";
            }
            
            case "LessThan" -> {
                return " ( "+ counterValue1+" ) \n LessThan \n( "+counterValue2+" )";
            }
            case "EqualTo" -> {
                return " ( "+ counterValue1+" ) \n EqualTo \n( "+counterValue2+" )";
            }
        }
        return condition;
            
    }
    
}
