import java.util.Scanner;
public class Board {
    public String[][] grid = new String[8][8];

    public Board() {
        getGrid();
    }

    public void getGrid() {
        for(int i=0;i<8;i++){
            for(int j=0; j<8; j++){
                grid[i][j] = "\t" + "0";
            }
        }
    }

    public void printGrid(){
        for(int i = 0; i<8 ; i++) {
            for(int j = 0; j<8; j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    public void setUp(){
        Scanner firstMove = new Scanner(System.in);
        System.out.println("Ok player " + 1 + " what column will you put your piece in.");
        int move = firstMove.nextInt();
        move(1,move);
    }
    public void move(int playerThatMoves, int move){
        move--;
        int count=0;
        for(int i=0; i<8; i++){
            if(grid[i][move]== "\t" + "0"){
                count++;
            }
        }
        if(count==0){
            Scanner newMove = new Scanner(System.in);
            System.out.println("please choose a valid move");
            int thisMove = newMove.nextInt();
            move(playerThatMoves, thisMove);
        }else{
            if(playerThatMoves==1){
                grid[count-1][move]= "\t" + "\uD83D\uDFE1";
            }else{
                grid[count-1][move]= "\t" + "\uD83D\uDD34";
            }

            printGrid();
            checkWin(playerThatMoves);
        }

    }

    public void checkWin(int playerThatMoves){
        boolean result = false;
        for(int i=0; i<8; i++){
            for(int j= 0; j<8; j++) {
                if (j <=4){
                    if (grid[i][j] == "\t" + "\uD83D\uDFE1" && grid[i][j + 1] == "\t" + "\uD83D\uDFE1" && grid[i][j + 2] == "\t" + "\uD83D\uDFE1" && grid[i][j + 3] == "\t" + "\uD83D\uDFE1") {
                        result=true;
                    }else if(grid[i][j] == "\t" + "\uD83D\uDD34" && grid[i][j + 1] == "\t" + "\uD83D\uDD34" && grid[i][j + 2] == "\t" + "\uD83D\uDD34" && grid[i][j + 3] == "\t" + "\uD83D\uDD34"){
                        result = true;
                    }
                }
            }
            for (int h=0;h<8;h++){
                if(h<=4){
                    if(grid[h][i] == "\t" + "\uD83D\uDFE1" && grid[h+1][i] == "\t" + "\uD83D\uDFE1" && grid[h+2][i] == "\t" + "\uD83D\uDFE1" && grid[h+3][i] == "\t" + "\uD83D\uDFE1"){
                        result=true;
                    }else if(grid[h][i] == "\t" + "\uD83D\uDD34" && grid[h + 1][i] == "\t" + "\uD83D\uDD34" && grid[h + 2][i] == "\t" + "\uD83D\uDD34" && grid[h + 3][i] == "\t" + "\uD83D\uDD34"){
                        result=true;
                   }
                }
            }
        }
        if(result==true){
            System.out.println("Congratulations Player " + playerThatMoves+ " you won.");
        }else{
            int newPlayer = 1;
            if(playerThatMoves==1) {
                newPlayer = 2;
            }
            Scanner nextMove = new Scanner(System.in);
            System.out.println("Ok player " + newPlayer + " what column will you put your piece in.");
            int move = nextMove.nextInt();
            move(newPlayer,move);
        }
    }
}
