/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;

import java.io.Serializable;


public interface Trigger extends Serializable{
    
   public boolean checkTrigger();
   public abstract String description();
    
}
