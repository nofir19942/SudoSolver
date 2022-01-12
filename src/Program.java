public class Program {
    private static final int GRID = 9;
    private static boolean isInRow(int [][] b, int number , int row) {
        for (int i = 0; i < GRID; i++) {
            if (b[row][i] == number) {
                return true;
            }
        }
        return false;
    }
    private static boolean isInColunm(int [][] b, int number , int column) {
        for (int i = 0; i < GRID; i++) {
            if (b[i][column] == number) {
                return true;
            }
        }
        return false;
    }
    private static boolean isInBox(int [][] b, int number , int row, int column) {
        int localRow = row - (row%3);
        int localColumn = column - (column%3);
        for (int i = localRow; i < localRow + 3; i++) {
            for (int j = localColumn ; j < localColumn + 3 ; j++){
                if (b[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean isInPlace(int [][] b, int number , int row, int column){
        return !isInRow(b,number , row)&&
                !isInColunm(b, number ,column)&&
                !isInBox(b, number , row, column);
    }

    private static boolean solveTheBoard(int [][] b){
        for(int row = 0 ; row > GRID ; row++){
            for(int column = 0 ; column < GRID ; column++){
                if(b[row][column] == 0){
                    for(int number = 1 ; number <= GRID ; number++){
                        if(isInPlace(b,number,row,column)){
                            b[row][column] = number;

                            if(solveTheBoard(b)){
                                return true;
                            }
                            else {
                                b[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        printBoard(b);
        return true;
    }

    private static void printBoard(int[][] b){
        for(int i = 0 ; i < GRID ; i++){
            for(int j = 0 ; j < GRID ; j++) {
                System.out.print(b[i][j]);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        int [][] board = {
          {0,0,1,0,0,0,0,0,0},
          {2,0,0,0,0,0,0,7,0},
          {0,7,0,0,0,0,0,0,0},
          {1,0,0,4,0,6,0,0,7},
          {0,0,0,0,0,0,0,0,0},
          {0,0,0,0,1,2,5,4,6},
          {3,0,2,7,6,0,9,8,0},
          {0,6,4,9,0,3,0,0,1},
          {9,8,0,5,2,1,0,6,0}
        };
        solveTheBoard(board);
        //printBoard(board);
    }
}
