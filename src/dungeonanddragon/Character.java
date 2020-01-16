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
public class Character {
//creating variables
    private String name;
    private String type;
    ArrayList<String> backpack;
    ArrayList<Room> bag = new ArrayList<>();
  
    private int health;
    

    public Character(String name, String type) { // character constructor
        this.name = name;
        this.type = type;
        backpack = new ArrayList<String>();
       
     
    }
    public void setHealth(int x){ // sets health
        health = x;
    }

    public String getName() { // returns character name
        return name;
    }

    public void addToBag(String v) { // adds objects to backpack
        if (!v.equals("")) {
            backpack.add(v);
        }

    }

    public String bagItems() { // displays all items in backpack
        String item = "";
        for (int i = 0; i < backpack.size(); i++) {
            item +=  " " + backpack.get(i);
        }
        return item;
    }

    public String getType() { // returns type of character
        return type;
    }

    public int getHealth() { // returns characters health
        return health;
    }

   

    public void fight(int dgHealth) { // fights method
       if (getHealth() > dgHealth) {
                setHealth(health - dgHealth); // deducts characters health off dragons health
                JOptionPane.showMessageDialog(null, "You Killed Dragon you have " + getHealth() + "% health left");
            }
        
        else{ setHealth(health - dgHealth);
            JOptionPane.showMessageDialog(null, "Your'e Dead you stood no chance");
        }
    }

    public void gainHealth(int elxir) { // increases health off elixir in a room
        if (health  > 0) {
            health += elxir;
            if (health >= 100) {
                JOptionPane.showMessageDialog(null, "Your are in good shape to kill some Dragon!");

            }
        }
    }
      @Override
    public String toString() { // to string method
      return " Helo " + getName() + " You are a " + getType() + "\n"
              + "Your health is at " + getHealth() + "% \n items in backpack are: \n"
             + bagItems();
              
    }
    public void delete(){ // deletes all items in bagpack if character looses game
        for(int i =0; i < backpack.size(); i++){
            backpack.remove(i);
            }
        }
    

}
