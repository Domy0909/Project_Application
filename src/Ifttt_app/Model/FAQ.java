/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;

/**
 *
 * @author Asus
 */
//This class allows the user to easily use triggers and actions.
public class FAQ {
    private String textFAQ;

  
    public FAQ(String textFAQ) {
        if(textFAQ.compareTo("trigger")==0){
        this.textFAQ = """
                   
                   To close the FAQ section, press the '?' button.
                   
                   How can I create a trigger?
                   You can create a trigger by selecting the desired type and setting the required conditions. 
                   Once created, the trigger will be listed in the trigger table.
                   
                   What can I do with a trigger?
                   You can manage triggers by right-clicking on a specific trigger in the dedicated table. 
                   This will provide two options: SELECT to use it in creating a rule or DELETE to remove it.
                   
                   How can I create combined triggers?
                   To create combined triggers, you need to generate at least two separate triggers. 
                   Then, by selecting the 'Composite Trigger' option in the selection menu, you can combine
                   the triggers. By right-clicking on the trigger table, you can designate the trigger as 
                   'Set First Composite Field' or 'Set Second Composite Field'. You can select the logical 
                   operation to apply before creating the new trigger.
                   
                   Can I repeat the procedure to create multiple combined triggers?
                   Yes, the steps to create combined triggers can be executed multiple times, allowing 
                   the creation of multiple combinations of simple or complex triggers, thus offering greater
                   flexibility in managing actions to be activated in response to specific conditions.""";
        
        } else if(textFAQ.compareTo("action")==0){
            this.textFAQ = """
                   
                    To close the FAQ section, press the '?' button
                           
                    How can I create an action?
                    Select the actions table and create a new action, customizing it according to your 
                    preferences. Once created, the action will be visible in the same table.
                    
                    What can I do with an action?
                    By right-clicking on the action in the dedicated table, a menu will appear. You can
                    choose between two options: 'SELECT' to use the action in creating a rule or 'DELETE'
                    to remove it.
                    
                    How can I create combined actions?
                    To create a sequence of actions, you need to have at least two actions created. Select
                    'action sequence' and proceed in the actions table. By right-clicking on the desired 
                    actions, add them to the sequence using the 'ADD to Sequence' option. To use the 
                    combined action, create click on 'create Action' and then select it for use in the 
                    desired rule as if it were a basic action.""";
        }
        
    }
    
   

    public String gettextFAQ() {
        return textFAQ;
    }
}
