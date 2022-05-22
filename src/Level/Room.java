package Level;

import java.util.ArrayList;

import general.Crab;
import general.ElectricEel;
import general.Enemy;
import general.Fish;
import general.Enemy;
import general.Frame;
import general.Item;
import general.Jellyfish;
import general.Lobster;
import general.Squid;
import general.SwordFish;
import general.Turtle;

public class Room {
    
    public Tile[][] layout;
    public boolean[] exits;
    public ArrayList<Item> items = new ArrayList<Item>();
    public ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    public int type;
    public int x;
    public int y;


    //Type 0: Starting Room
    //Type 1: Battle Room
    //Type 2: Item Room
    //Type 4: Exit
    public Room(int type, int x, int y){
        exits = new boolean[4];
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public void initRoom(){
        //initialize middle Tiles
        layout = new Tile[7][7];
        for(int i = 1; i < 6; i++){
            for(int j = 1; j < 6; j++){
                layout[i][j] = new Tile(x*770 + j*110, y*770 + i*110, 0);
            }
        }

        //initialize borders
        for(int i = 0; i < 7; i++){
            layout[0][i] = new Tile(x*770 + i*110, y*770, 1);
            layout[6][i] = new Tile(x*770 + i*110, y*770 + 660, 1);
            layout[i][0] = new Tile(x*770, y*770 + i*110, 1);
            layout[i][6] = new Tile(x*770 + 660, y*770 + i*110, 1);
        }

        //add exits
        //dir 0: up
        //dir 1: right
        //dir 2: down
        //dir 3: left
        
        if(exits[0]){
            layout[0][3] = new Tile(x*770 + 330, y*770 + 000, 0);
        }
        if(exits[1]){
            layout[3][6] = new Tile(x*770 + 660, y*770 + 330, 0);
        }
        if(exits[2]){
            layout[6][3] = new Tile(x*770 + 330, y*770 + 660, 0);
        }
        if(exits[3]){
            layout[3][0] = new Tile(x*770 + 000, y*770 + 330, 0);
        }

	    switch(type) {
	    case 0:
	    	Frame.isaac.x = x*770 + 3 * Tile.l;
	    	Frame.isaac.y = y*770 + 3 * Tile.l;
	    	break;
	    	
	    case 1:
	    	spawnEnemy();
	    	spawnEnemy();
	    	spawnEnemy();
	    	spawnEnemy();
	    	break;
	    	
	    case 2:
	    	
	    	break;
	    
	    case 3:
	    	
	    	break;
	    }
    }
    
    public void spawnEnemy() {
    	switch((int)(Math.random()*8)) {
    	case 0:
			enemies.add(new Fish(x*770 + 3 * Tile.l, y*770 + 3 * Tile.l));
			break;
			
    	case 1:
			enemies.add(new Crab(x*770 + 3 * Tile.l, y*770 + 3 * Tile.l, true));
			break;
			
    	case 2:
    		enemies.add(new Crab(x*770 + 3 * Tile.l, y*770 + 3 * Tile.l, false));
			break;
			
    	case 3:
    		enemies.add(new Lobster(x*770 + 3 * Tile.l, y*770 + 3 * Tile.l));
			break;
			
    	case 4:
    		enemies.add(new Squid(x*770 + 3 * Tile.l, y*770 + 3 * Tile.l));
			break;
			
    	case 5:
    		enemies.add(new SwordFish(x*770 + 3 * Tile.l, y*770 + 3 * Tile.l));
			break;
			
    	case 6:
    		enemies.add(new Turtle(x*770 + 3 * Tile.l, y*770 + 3 * Tile.l));
			break;
			
    	case 7:
    		enemies.add(new ElectricEel(x*770 + 3 * Tile.l, y*770 + 3 * Tile.l));
			break;
			
    	case 8:
    		enemies.add(new Jellyfish(x*770 + 3 * Tile.l, y*770 + 3 * Tile.l));
			break;
    	}
    }
}
