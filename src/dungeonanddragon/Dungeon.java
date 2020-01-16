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
public class Dungeon {
  // making variables 
    private int[][] matrix;
    private Room[] rooms;
    private boolean isLegalRoom;
    ArrayList<Character> chara;
    int max;
    int numRooms;

    public Dungeon() { // dungeon constructor
        rooms = new Room[10];
        matrix = new int[10][10];

        insertRoom();
        makeMatrix();
        insertEdge();
        showDungeon();

    }

    public void makeMatrix() { // making matrix

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 0; // sets the values of rows and column to String

            }

        }
    }

    public boolean insertRoom() { // creating rooms with object
        rooms[0] = new Room("Nest", 10, "Fire-Dragon", 0, "Gold");//String name, int elixir, String dragon, int dgHealth, String weapon
        rooms[1] = new Room("Castle", 0, "Fire-Dragon", 40, "BOWandARROW");
        rooms[2] = new Room("Life", 500, "FireDragon", 80, "Silver");
        rooms[3] = new Room("Armory", 0, "Fire-Dragon", 70, "Diamond");
        rooms[4] = new Room("Swamp", 10, "Fire-Dragon", 70, "Knife");
        rooms[5] = new Room("swamp", 50, "Fire-Dragon", 200, "Ring");
        rooms[6] = new Room("Trap", 70, "Fire-Dragon", 1000, "arrows");
        rooms[7] = new Room("Haven", 600, "Last-Dragon", 1000, "Princess-Fiona");
        rooms[8] = new Room("Death", 0, "FireDragon", 500, "");
        rooms[9] = new Room("castle", 100, "Fire-Dragon", 100, "Diamond");
        return true;

    }

    public boolean insertEdge() { // assigning paths to rooms
        
        matrix[0][1] = 1;
        matrix[0][2] = 1;
        matrix[1][0] = 1;
        matrix[1][2] = 1;
        matrix[1][4] = 1;
        matrix[2][0] = 1;
        matrix[2][1] = 1;
        matrix[2][3] = 1;
        matrix[2][6] = 1;
        matrix[3][2] = 1;
        matrix[3][4] = 1;
        matrix[3][5] = 1;
        matrix[4][1] = 1;
        matrix[4][3] = 1;
        matrix[4][5] = 1;
        matrix[5][3] = 1;
        matrix[5][4] = 1;
        matrix[5][7] = 1;
        matrix[5][9] = 1;
        matrix[6][2] = 1;
        matrix[7][5] = 1;
        matrix[8][9] = 1;
        matrix[9][5] = 1;
        matrix[9][8] = 1;

        return true;

    }

    public boolean isLegal(int x, int z) { // is legal method compares room entered to path
        boolean answer = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[x][i] == 1) {
                if (i == z) {
                    answer = true;
                }
            }
        }
        return answer;
    }

    public int gHealth(int x) {// returns elixir in a room
        return rooms[x].getElixir();
    }

    public int DgHealth(int x) { // returns health of dragon in a room
        return rooms[x].getdragHealth();
    }

    public boolean showLegalRooms(int y) { // displays legal rooms
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[y][i] == 1) {
             JOptionPane.showMessageDialog(null," valid rooms are room : " + i);
                
            }

        }
        return true;

    }

    public boolean changeRoom(int x, int z) { // changes room by checking if its legal
        boolean ook = false;
       if (isLegal(x, z)) {
            ook = true;
        }
       else{
           JOptionPane.showMessageDialog(null, "Sorry you cant go there yet");
       }

        return ook;
    }

    public String getRinfo(int x) { // displays all the information about a room
        return rooms[x].toString();

    }

    public String objs(int x) { // gets the objects in a specific room
        String items = "";
        items = " " + rooms[x].getObjects();
        return items;
    }

    public boolean hasDragon(int x) { // checks if room has specific type of dragon to fight
        if (rooms[x].getDragon().equalsIgnoreCase("Fire-Dragon")) {
            JOptionPane.showMessageDialog(null, "fighting  Dragon!.........");
        }
        if (rooms[x].getDragon().equalsIgnoreCase("Last-Dragon")) {
            JOptionPane.showMessageDialog(null, "Congratulations on making it here.\n You "
                    + "kill me, you take the princes in the next room!!!");
            JOptionPane.showMessageDialog(null, "fighting  Dragon!.........");

        }
        if (rooms[x].getName().equalsIgnoreCase("Trap")) {
            JOptionPane.showMessageDialog(null, "Ooppss this was a trap");
        }

        return true;
    }

public void showDungeon(){ // shows the rooms
    for(int i = 0; i < rooms.length; i++){
        JOptionPane.showMessageDialog(null, rooms[i].toString());
    }
}
    
    

}
