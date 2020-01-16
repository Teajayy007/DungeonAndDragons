/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonanddragon;

import javax.swing.JOptionPane;

/**
 *
 *
 * " Dungeon And Dragon. \n"
 + "in this program you will be traversing from room to room in a dungeon with each"
 + "rooms path displayed.\n the goal of this game is to reach room 7 and kill the dragon"
 + "you will pick up items in every room you go. watch out for trap rooms"
 */
public class DungeonAndDragon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JOptionPane.showMessageDialog(null,"Tissan Joel Dungeon And Dragon. \n" // welcom message
                + "in this program you will be traversing from room to room in a dungeon with each\n "
                + "rooms path displayed.\n the goal of this game is to reach room 7 and kill the dragon\n "
                + "you will pcik up items in every room you go. \nwatch out for trap rooms!");
       String menu = JOptionPane.showInputDialog("PLAY,QUIT");
       if (menu.equalsIgnoreCase("play")){
        do{
        Dungeon d = new Dungeon(); // start program
        
        String name = "";  // holds character's name and type
        String type = "";
        while(name.equals("")){ // validates input
               name = JOptionPane.showInputDialog("Enter Character name");
        }
        while(type.equals("")){
               type = JOptionPane.showInputDialog("Enter type of character");
        }
        int r = 7; // integer variables holding room 
        int p = 0;
        int x = 0;

        Character c = new Character(name, type); // creates new character
        c.setHealth(100); // sets health
        do {
            r = 7;
           
            while (r == 7) { // ensures 7 can not be entered
                try{
                    do{
                r = Integer.parseInt(JOptionPane.showInputDialog("Enter first room to go YOU CANT START AT 7"));
                }while(r > 10); // make sures input is not outa bound.
                } catch(Exception aob){
                    JOptionPane.showMessageDialog(null, "Invalid input");
                }
              
            }

            do {
                JOptionPane.showMessageDialog(null, d.getRinfo(r)); // displays room information
                c.gainHealth(d.gHealth(r)); // returns characters health
                c.addToBag(d.objs(r)); // adds item from room to bag
                JOptionPane.showMessageDialog(null, c.toString()); // displays characters info

                if (r != 7 && d.hasDragon(r)) { // while the room is not last fight 
                    c.fight(d.DgHealth(r));

                }
             
                d.showLegalRooms(r); // shows legal path
                x = r;

                do {
                    try{
                    p = Integer.parseInt(JOptionPane.showInputDialog("Enter next room to go")); // request for next room 
                     } catch(Exception aob){
                    JOptionPane.showMessageDialog(null, "Invalid input");
                }
              

                } while ((p != 7 && p != 6) && (!d.changeRoom(x, p) && c.getHealth() > 0 )); // make sure its a valid path

                r = p;
                
                  if (p == 7 && d.hasDragon(p) && d.changeRoom(x, p)) { // if character reaches room 7
                        c.fight(d.DgHealth(p));
                        if( c.getHealth() > 0) { // charcter kills dragom
                JOptionPane.showMessageDialog(null, "You have won the game");
                JOptionPane.showMessageDialog(null, "You are leaving with " + c.toString() + "\nThanks for playing!");
                  }
                        else{ // dragon kills character
                             c.fight(d.DgHealth(p));
                            JOptionPane.showMessageDialog(null,"You lost this game");
                            c.delete(); // loses everything
                        }
                        
              
            } 

            } while ((x != 7 && x != 6) && (d.changeRoom(x, p) && c.getHealth() > 0)); // while valid

          

        } while ((JOptionPane.showConfirmDialog(null, "continue") == 0 ) && c.getHealth() > 0); // continue game if health is not 0
        if(c.getHealth() <= 0){ // if low health cant continue
            JOptionPane.showMessageDialog(null,"sorry you cant continue this session start a new game");
        }

    }
 while(JOptionPane.showConfirmDialog(null,"Start over") == 0); // starts a new game
       }
       if(menu.equalsIgnoreCase("quit")){
        JOptionPane.showMessageDialog(null,"Thank you for playing");
        System.exit(0);
       }
       
 JOptionPane.showMessageDialog(null,"Thank you for playing");
}
  
}
