//Commenting is not done deliberately

import java.util.*;


// Point class assign point to x, y
class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }



    @Override
    public String toString() {
        // display actual point to user  eg. [1,1] to [3,3]
        return "[" + (x+1) + ", " + (y+1) + "]";
    }
}

class PointsAndScores {
    int score;
    Point point;

    // constructor for score and point
    PointsAndScores(int score, Point point) {
        this.score = score;
        this.point = point;
    }
}

class Board {
    // store all available points
    List<Point> availablePoints;

    Scanner scan = new Scanner(System.in);
    // 3 x 3 array, store all possible positions
    static int[][] board = new int[3][3];

    public Board() {
    }

    public boolean isGameOver() {
        // gameover is true means either xwon or owon or no more place(draw)
        // set them with methods.
        return (hasXWon() || hasOWon() || getAvailablePoints().isEmpty());
    }

    // check win state for both x and o
    public boolean hasXWon() {
        // if position 159 or 357 Diagonal win
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 1) || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 1)) {
            return true;
        }
        // these are horizontal or vertical win
        for (int i = 0; i < 3; ++i) {
            if (((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 1)
                    || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 1))) {
                return true;
            }
        }
        return false;
    }

    public boolean hasOWon() {
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 2) || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 2)) {
            return true;
        }
        for (int i = 0; i < 3; ++i) {
            if ((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 2)
                    || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 2)) {
                return true;
            }
        }
        return false;
    }

    // get all available points on the board     -->   List<Point>
    public List<Point> getAvailablePoints() {
        // if a point is empty, add this point to available point list
        //  if the list is empty, and neither x nor o won,  the game will draw.
        availablePoints = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board[i][j] == 0) {
                    availablePoints.add(new Point(i, j));
                }
            }
        }
        return availablePoints;   // get all available points in list.
    }
    
    public int getState(Point point){
    	return board[point.x][point.y];  //get the current position of instance
    }

    public void placeAMove(Point point, int player) {
        board[point.x][point.y] = player;
}
// make empty board with . , x's move replace with X
    public void displayBoard() {
        System.out.println();

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
 		if (board[i][j]==1)     // 1 is X
                    System.out.print("X ");
                else if (board[i][j]==2) // 2 is O
                    System.out.print("O ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
    }

    /**
     * reset the point
     * @param p
     */
    public static void clear(Point p){
        board[p.x][p.y] = 0;
    }

}
