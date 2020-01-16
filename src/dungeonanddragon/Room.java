

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonanddragon;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class Room {
    // making all variables
    private String Rname;
    ArrayList <String> objects;
    private int elixir;
    private String Dragon;
    
    
    
    private int dgHealth;
    
    public Room(String name, int elixir, String dragon, int dgHealth, String weapon){ // room constructor
        Rname = name;
        objects =  new ArrayList<String>();
        objects.add(weapon);
         this.elixir = elixir;
        Dragon = dragon;
        this.dgHealth = dgHealth;
    }

    public String getName(){ // returns room name
        return Rname;
    }
    public String getDragon(){ // returns dragon name
        return Dragon;
    }
     public String getObjects(){ // returns object in room
         String allObjects = "";
         for (int i = 0; i  < objects.size(); i++){
             allObjects += " " + objects.get(i);
              }
         return allObjects;
         
     }
     public int getElixir(){ // returns amount of elixir
         return elixir;
     }
     public int getdragHealth(){ // returns dragon health
         return dgHealth;
     }
     
           @Override
    public String toString() { // to string
      return getName() + " room has " + getElixir() + "% of Elixir, \n"
              + " a " + getDragon() + ", that has " + getdragHealth()
             + "% health, \n" + " and the follwing items : \n"
              + getObjects();
              
    }
  
   
    
    
}
