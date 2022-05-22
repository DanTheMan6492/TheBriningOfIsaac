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
    public Room(int type, int x, int y){
        exits = new boolean[8];
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public void initRoom(){
        
    }
}
