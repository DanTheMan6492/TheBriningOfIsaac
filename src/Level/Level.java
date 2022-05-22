package Level;

public class Level {
    
    public static Room[][] level;
    public static boolean exitGenned;

    public static void genLevel(){
        level = new Room[4][3];
        exitGenned = false;
        levelHelper(1, 3, 0, true);
        initRooms();
        for(Room[] row : Level.level){
			for(Room room : row){
				if(room != null){
					for(boolean bool : room.exits) {
						System.out.print(bool);
					}
					System.out.println();
				} else {
					System.out.println("none");	
				}
			}
		}
    }

    //dir 0: up
    //dir 1: right
    //dir 2: down
    //dir 3: left
    public static void levelHelper(int x, int y, int dir, boolean init){
        if(level[y][x] == null){
            if(init)
                level[y][x] = new Room(0, x, y);
            else if (y == 0){
                level[y][x] = new Room(3, x, y);
            }
            else
                level[y][x] = new Room( (int) (Math.random() * 2) + 1, x, y);
        }
        if(!init){
            level[y][x].exits[(dir+2) % 4] = true;
            if(y == 0)
                return;
        }


        if(y == 1){
            if(!exitGenned){
        	    level[y][x].exits[0] = true;
                exitGenned = true;
        	    levelHelper(x, y-1, 0, false);
            }
        	return;
        }
        boolean flag = true;
        for(int i = 0; i < 4; i++){
            if(i != 2){
                int coin = (int) (Math.random() * 2);
                if(coin == 1){
                    flag = false;
                    int xNew = newX(x, i);
                    int yNew = newY(y, i);
                    if(xNew != -1 && xNew != 3){
                    	level[y][x].exits[i] = true;
                        levelHelper(xNew, yNew, i, false);
                    }
                }
            }
        }

        if(flag){
        	level[y][x].exits[0] = true;
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
            case 3:
            return x - 1;
            default:
            return x;
        }
    }

    
    public static int newY(int y, int dir){
        switch(dir){
            case 0:
            return y - 1;
            default:
            return y;
        }
    }
}
