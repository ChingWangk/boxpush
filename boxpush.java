package lab6;
import java.util.*;

public class boxpush {
    
    public static void main(String[] args) {
        // 
        StringBuffer cmd=new StringBuffer("");
        Scanner scanner = new Scanner(System.in);

        //角色昵称
        String name=scanner.nextLine();
        String[] Name = new String[20];
        Name = name.split(" ");
        player p1 = new player(Name[0]);
        player p2 = new player(Name[1]);
        
        //创建地图
        int[][] map = readMap(scanner, cmd);
        int[][] map1 = new int[map.length][map[0].length];
        int[][] map2 = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map1[i][j] = map[i][j];
                map2[i][j] = map[i][j];
            }
        }


        //
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 2) {
                    p1.playerRow = p2.playerRow = i;
                    p1.playerCol = p2.playerCol = j;
                    map[i][j] = 0;
                    map1[i][j]=0;
                    map2[i][j]=0;
                    break;
                }
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 5) {
                    p1.boxRow = p2.boxRow = i;
                    p1.boxCol = p2.boxCol = j;
                    
                    break;
                }
            }
        }


        


        //读取指令
        String inst = cmd.toString();
        String[] instruction = new String[20];
        instruction = inst.split(" ");
        String lastOne ="";

        //终点位置
        int  EndRow=0;
        int  EndCol=0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 3) {
                    EndRow = i;
                    EndCol = j;
                    map[i][j] = 0;
                    map1[i][j]=0;
                    map2[i][j]=0;
                    break;
                }
            }
        }
        while (map1[EndRow][EndCol] != 5 ||map2[EndRow][EndCol] != 5){
            
            //判断移动次序
            if(map1[EndRow][EndCol] == 5)lastOne=p1.name;
            if(map2[EndRow][EndCol] == 5)lastOne=p2.name;
            if(instruction[0].equals(lastOne)){
                if(instruction[0].equals(p1.name) ) p1.orderMis+=1;
                else if(instruction[0].equals(p2.name) ) p2.orderMis+=1;
                inst = scanner.nextLine();
                instruction = inst.split(" ");
                continue;
            }
            //p1移动
            if(instruction[0].equals(p1.name) ){
                if (instruction[1].equals("h")){
                    switch(map1[p1.playerRow][p1.playerCol-1]){
                        case 0 :
                            p1.playerCol -= 1;
                            p1.moveCount += 1;
                            if (map1[p1.playerRow][p1.playerCol] == 4){
                                p1.coverCount += 1;
                            }
                            break;
                        case 1 :
                            p1.wallCount += 1;
                            p1.moveCount += 1;
                            break;
                        case 5 :
                            switch(map1[p1.playerRow][p1.playerCol-2]){
                                case 0:
                                    map1[p1.playerRow][p1.playerCol-2]=5;
                                    map1[p1.playerRow][p1.playerCol-1]=0;
                                    p1.playerCol -= 1;
                                    p1.moveCount += 1;
                                    break;
                                case 1:
                                    p1.boxWall ++;
                                    p1.moveCount += 1;
                                    break;
                                case 4:
                                    p1.boxCover ++;
                                    p1.moveCount += 1;
                                    break;
                                default:
                                    break;
                            }
                            break;
                        default:
                            break;

                    }
                    lastOne = p1.name;
                } else if (instruction[1].equals("j")) {
                    switch(map1[p1.playerRow+1][p1.playerCol]){
                        case 0 :
                            p1.playerRow += 1;
                            p1.moveCount += 1;
                            if (map1[p1.playerRow][p1.playerCol] == 4){
                                p1.coverCount += 1;
                            }
                            break;
                        case 1 :
                            p1.wallCount += 1;
                            p1.moveCount += 1;
                            break;
                        case 5 :
                            switch(map1[p1.playerRow+2][p1.playerCol]){
                                case 0:
                                    map1[p1.playerRow+2][p1.playerCol]=5;
                                    map1[p1.playerRow+1][p1.playerCol]=0;
                                    p1.playerRow += 1;
                                    p1.moveCount += 1;
                                    break;
                                case 1:
                                    p1.boxWall ++;
                                    p1.moveCount += 1;
                                    break;
                                case 4:
                                    p1.boxCover ++;
                                    p1.moveCount += 1;
                                    break;
                                default:
                                    break;
                            }
                            break;
                        default:
                            break;

                    }
                    lastOne = p1.name;
                } else if (instruction[1].equals("k")) {
                    switch(map1[p1.playerRow-1][p1.playerCol]){
                        case 0 :
                            p1.playerRow -= 1;
                            p1.moveCount += 1;
                            if (map1[p1.playerRow][p1.playerCol] == 4){
                                p1.coverCount += 1;
                            }
                            break;
                        case 1 :
                            p1.wallCount += 1;
                            p1.moveCount += 1;
                            break;
                        case 5 :
                            switch(map1[p1.playerRow-2][p1.playerCol]){
                                case 0:
                                    map1[p1.playerRow-2][p1.playerCol]=5;
                                    map1[p1.playerRow-1][p1.playerCol]=0;
                                    p1.playerRow -= 1;
                                    p1.moveCount += 1;
                                    break;
                                case 1:
                                    p1.boxWall ++;
                                    p1.moveCount += 1;
                                    break;
                                case 4:
                                    p1.boxCover ++;
                                    p1.moveCount += 1;
                                    break;
                                default:
                                    break;
                            }
                            break;
                        default:
                            break;

                    }
                    lastOne = p1.name;
                } else if (instruction[1].equals("l")) {
                    switch(map1[p1.playerRow][p1.playerCol+1]){
                        case 0 :
                            p1.playerCol += 1;
                            p1.moveCount += 1;
                            if (map1[p1.playerRow][p1.playerCol] == 4){
                                p1.coverCount += 1;
                            }
                            break;
                        case 1 :
                            p1.wallCount += 1;
                            p1.moveCount += 1;
                            break;
                        case 5 :
                            switch(map1[p1.playerRow][p1.playerCol+2]){
                                case 0:
                                    map1[p1.playerRow][p1.playerCol+2]=5;
                                    map1[p1.playerRow][p1.playerCol+1]=0;
                                    p1.playerCol += 1;
                                    p1.moveCount += 1;
                                    break;
                                case 1:
                                    p1.boxWall ++;
                                    p1.moveCount += 1;
                                    break;
                                case 4:
                                    p1.boxCover ++;
                                    p1.moveCount += 1;
                                    break;
                                default:
                                    break;
                            }
                            break;
                        default:
                            break;

                    }
                    lastOne = p1.name;
                } else if (instruction[1].equals("q")){
                    map1[EndRow][EndCol]=5;
                    p1.hasq=1;
                }else {
                    p1.wrongEnter +=1;
                }
                
                
            }

            //p2移动
            if(instruction[0].equals(p2.name)){
                if (instruction[1].equals("h")){
                    switch(map2[p2.playerRow][p2.playerCol-1]){
                        case 0 :
                            p2.playerCol -= 1;
                            p2.moveCount += 1;
                            if (map2[p2.playerRow][p2.playerCol] == 4){
                                p2.coverCount += 1;
                            }
                            break;
                        case 1 :
                            p2.wallCount += 1;
                            p2.moveCount += 1;
                            break;
                        case 5 :
                            switch(map2[p2.playerRow][p2.playerCol-2]){
                                case 0:
                                    map2[p2.playerRow][p2.playerCol-2]=5;
                                    map2[p2.playerRow][p2.playerCol-1]=0;
                                    p2.playerCol -= 1;
                                    p2.moveCount += 1;
                                    break;
                                case 1:
                                    p2.boxWall ++;
                                    p2.moveCount += 1;
                                    break;
                                case 4:
                                    p2.boxCover ++;
                                    p2.moveCount += 1;
                                    break;
                                default:
                                    break;
                            }
                            break;
                        default:
                            break;
                
                    }
                    lastOne = p2.name;
                } else if (instruction[1].equals("j")) {
                    switch(map2[p2.playerRow+1][p2.playerCol]){
                        case 0 :
                            p2.playerRow += 1;
                            p2.moveCount += 1;
                            if (map2[p2.playerRow][p2.playerCol] == 4){
                                p2.coverCount += 1;
                            }
                            break;
                        case 1 :
                            p2.wallCount += 1;
                            p2.moveCount += 1;
                            break;
                        case 5 :
                            switch(map2[p2.playerRow+2][p2.playerCol]){
                                case 0:
                                    map2[p2.playerRow+2][p2.playerCol]=5;
                                    map2[p2.playerRow+1][p2.playerCol]=0;
                                    p2.playerRow += 1;
                                    p2.moveCount += 1;
                                    break;
                                case 1:
                                    p2.boxWall ++;
                                    p2.moveCount += 1;
                                    break;
                                case 4:
                                    p2.boxCover ++;
                                    p2.moveCount += 1;
                                    break;
                                default:
                                    break;
                            }
                            break;
                        default:
                            break;
                
                    }
                    lastOne = p2.name;
                } else if (instruction[1].equals("k")) {
                    switch(map2[p2.playerRow-1][p2.playerCol]){
                        case 0 :
                            p2.playerRow -= 1;
                            p2.moveCount += 1;
                            if (map2[p2.playerRow][p2.playerCol] == 4){
                                p2.coverCount += 1;
                            }
                            break;
                        case 1 :
                            p2.wallCount += 1;
                            p2.moveCount += 1;
                            break;
                        case 5 :
                            switch(map2[p2.playerRow-2][p2.playerCol]){
                                case 0:
                                    map2[p2.playerRow-2][p2.playerCol]=5;
                                    map2[p2.playerRow-1][p2.playerCol]=0;
                                    p2.playerRow -= 1;
                                    p2.moveCount += 1;
                                    break;
                                case 1:
                                    p2.boxWall ++;
                                    p2.moveCount += 1;
                                    break;
                                case 4:
                                    p2.boxCover ++;
                                    p2.moveCount += 1;
                                    break;
                                default:
                                    break;
                            }
                            break;
                        default:
                            break;
                
                    }
                    lastOne = p2.name;
                } else if (instruction[1].equals("l")) {
                    switch(map2[p2.playerRow][p2.playerCol+1]){
                        case 0 :
                            p2.playerCol += 1;
                            p2.moveCount += 1;
                            if (map2[p2.playerRow][p2.playerCol] == 4){
                                p2.coverCount += 1;
                            }
                            break;
                        case 1 :
                            p2.wallCount += 1;
                            p2.moveCount += 1;
                            break;
                        case 5 :
                            switch(map2[p2.playerRow][p2.playerCol+2]){
                                case 0:
                                    map2[p2.playerRow][p2.playerCol+2]=5;
                                    map2[p2.playerRow][p2.playerCol+1]=0;
                                    p2.playerCol += 1;
                                    p2.moveCount += 1;
                                    break;
                                case 1:
                                    p2.boxWall ++;
                                    p2.moveCount += 1;
                                    break;
                                case 4:
                                    p2.boxCover ++;
                                    p2.moveCount += 1;
                                    break;
                                default:
                                    break;
                            }
                            break;
                        default:
                            break;
                
                    }
                    lastOne = p2.name;
                } else if (instruction[1].equals("q")){
                    map2[EndRow][EndCol]=5;
                    p2.hasq=1;
                }else {
                    p2.wrongEnter +=1;
                }
                
                
            }
            if(scanner.hasNextLine()){
                inst = scanner.nextLine();
                instruction = inst.split(" ");
            }
            
        }
        
        
        //
        System.out.printf("%s %d %d %d %d %d %d %d\n",p1.name,p1.moveCount,p1.orderMis,p1.wrongEnter,p1.wallCount,p1.coverCount,p1.boxWall,p1.boxCover);
        System.out.printf("%s %d %d %d %d %d %d %d\n",p2.name,p2.moveCount,p2.orderMis,p2.wrongEnter,p2.wallCount,p2.coverCount,p2.boxWall,p2.boxCover);
        
       
        //判定输赢

        if(p1.hasq==0&&p2.hasq==0){
            if(p1.moveCount+p1.wallCount+p1.coverCount+p1.boxCover+p1.boxWall<p2.moveCount+p2.wallCount+p2.coverCount+p2.boxCover+p2.boxWall)
            System.out.print(p1.name);
            else if(p1.moveCount+p1.wallCount+p1.coverCount+p1.boxCover+p1.boxWall>p2.moveCount+p2.wallCount+p2.coverCount+p2.boxCover+p2.boxWall)
            System.out.print(p2.name);
            else if(p1.moveCount+p1.wallCount+p1.coverCount+p1.boxCover+p1.boxWall==p2.moveCount+p2.wallCount+p2.coverCount+p2.boxCover+p2.boxWall){
                if(lastOne.equals(p2.name))System.out.print(p1.name);
                else if(lastOne.equals(p1.name))System.out.print(p2.name);
                
            }
        }
        
        if(p1.hasq==1&&p2.hasq==0)System.out.print(p2.name);
        else if(p1.hasq==0&&p2.hasq==1)System.out.print(p1.name);
        
        if(p1.hasq==1&&p2.hasq==1)System.out.print("draw");

        scanner.close();
    }

    

    public static int[][] readMap(Scanner scanner, StringBuffer cmd) {
        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            
            if (line.isEmpty() || !Character.isDigit(line.charAt(0))) {
                cmd.append(line);
                break;
            }
            line = line.replaceAll(" +","");
            lines.add(line);
        }
    
        int height = lines.size();
        int width = lines.stream().mapToInt(String::length).max().orElse(0);
        int[][] map = new int[height][width];
        for (int i = 0; i < height; i++) {
            String line = lines.get(i);
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                int value;
                switch (c) {
                    case '1':
                        value = 1;
                        break;
                    case '2':
                        value = 2;
                        break;
                    case '3':
                        value = 3;
                        break;
                    case '4':
                        value = 4;
                        break;
                    case '5':
                        value = 5;
                        break;
                    default:
                        value = 0;
                        break;
                }
                map[i][j] = value;
            }
        }
        return map;
    }
    

}
    class player{
    String name ;
    int playerRow ;
    int playerCol ;
    int boxRow ;
    int boxCol ;
    int moveCount = 0 ;
    int orderMis = 0 ;
    int wrongEnter = 0 ;
    int coverCount = 0 ;
    int wallCount = 0 ;
    int hasq = 0 ;
    int boxWall = 0 ;
    int boxCover = 0 ;

    public player(String name){
        this.name=name;
    }
    public void col(int col){
        playerCol=col;
    }
    public void move(int move){
        moveCount=move;
    }
    public void row(int row){
        playerRow=row;
    }
    public void boxCol(int col){
        boxCol=col;
    }
    public void boxRow(int row){
        boxRow=row;
    }
    public void om(int om){
        orderMis=om;
    }
    public void we(int we){
        wrongEnter=we;
    }
    public void cover(int cover){
        coverCount=cover;
    }
    public void wall(int wall){
        wallCount=wall;
    }
    public void boxCover(int cover){
        boxCover=cover;
    }
    public void boxWall(int wall){
        boxWall=wall;
    }
}

