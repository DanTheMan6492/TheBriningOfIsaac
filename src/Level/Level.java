package Level;

public class Level {
    
    public static Room[][] level;

    public static void genLevel(){
        Room[][] level = new Room[4][3];
        levelHelper(1, 3, 0, true);
        initRooms();
    }

    //dir 0: up
    //dir 1: up-right
    //dir 2: right
    //dir 3: down-right
    //dir 4: down;
    //dir 5: down-left;
    //dir 6: left
    //dir 7: moving up-left
    public static void levelHelper(int x, int y, int dir, boolean init){
        if(level[y][x] == null){
            if(init)
                level[y][x] = new Room(0);
            else if (y == 0){
                level[y][x] = new Room(4);
            }
            else
                level[y][x] = new Room( (int) (Math.random() * 3) + 1);
        }
        if(!init){
            level[y][x].exits[(dir+4)%8] = true;;
            if(y == 0)
                return;
        }


        if(y == 1){
            switch(x){
                case 0:
                levelHelper(x+1, y-1, 1, false);
                return;
                case 1:
                levelHelper(x, y-1, 0, false);
                return;
                case 2:
                levelHelper(x-1, y-1, 7, false);
                return;

            }
        }
        boolean flag = true;
        for(int i = 0; i < 8; i++){
            if((i < 3) || (i > 5)){
                int coin =  (int) (Math.random() * 2);
                if(coin == 0){
                    flag = false;
                    int xNew = newX(x, i);
                    int yNew = newY(y, i);
                    if(xNew != -1 && xNew != 3){
                        levelHelper(xNew, yNew, i, false);
                    }
                }
            }
        }

        if(flag){
            levelHelper(x, y-1, 0, false);
        }
    }

    public static void initRooms(){
        for(Room[] row : level){
            for(Room room : row){
                if(room != null){
                    room.initRoom();
                }
            }
        }
    }

    public static int newX(int x, int dir){
        switch(dir){
            case 1:
            return x + 1;
            case 2:
            return x + 1;
            case 6:
            return x - 1;
            case 7:
            return x - 1;
            default:
            return x;
        }
    }

    
    public static int newY(int y, int dir){
        switch(dir){
            case 0:
            return y + 1;
            case 1:
            return y + 1;
            case 7:
            return y + 1;
            default:
            return y;
        }
    }
}
