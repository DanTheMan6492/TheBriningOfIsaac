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

        


    }
}
