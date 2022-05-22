package Level;

public class Room {
    
    public Tile[][] layout;
    public boolean[] exits;
    public int type;
    public int x;
    public int y;


    //Type 0: Starting Room
    //Type 1: Battle Room
    //Type 2: Item Room
    //Type 3: Shop
    //Type 4: Exit
    public Room(int type){

    }

    public Room(){

    }

    public void initRoom(){
        
    }
}
