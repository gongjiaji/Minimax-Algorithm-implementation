//Commenting is not done deliberately

public class TicTacToe {

    public static void main(String[] args) {
        
        Board b = new Board();
        Point p = new Point(0, 0);

        
        b.displayBoard();

        System.out.println("Who makes first move? (1)Computer (2)User: ");
        int choice = b.scan.nextInt();
        if(choice == 1){ // if computer go first

            // AI PLAYER always take center point if possible because it has greatest advantage
            p.x = 1;
            p.y = 1;

            b.placeAMove(p, 1);  //  board[1][1] is player 1. so print x
            b.displayBoard(); //refresh board
        }
        // while the game is not over yet, get user's move
        while (!b.isGameOver()) {
            System.out.println("Your move: line (1, 2, or 3) colunm (1, 2, or 3)");
            // userMove contains the point info
            Point userMove = new Point(b.scan.nextInt()-1, b.scan.nextInt()-1); // convert [1][1] to [0][0]
	    while (b.getState(userMove)!=0) {// if a point is occupied
	    	System.out.println("Invalid move. Make your move again: ");
	    	userMove.x=b.scan.nextInt()-1;
	    	userMove.y=b.scan.nextInt()-1;
	    }
	    // user's movement
            b.placeAMove(userMove, 2);  //2 is O
            b.displayBoard();

            //if game is over
            if (b.isGameOver()) {
                break;  // jump out of the while loop and next move is unnecessary
            } 
                       
            //In the following do loop, Computer makes random moves. Your assignment is to replace it by implementing 
            //an AIplayer class that chooses the best moves based on minimax search.
            AIPlayer.minimax( b,0,1);
            b.placeAMove(AIPlayer.bestMove, 1);
            b.displayBoard();
        }

// who win, who lose or draw
        if (b.hasXWon()) {
            System.out.println("Unfortunately, you lost!");
        } else if (b.hasOWon()) {
            System.out.println("You win!");
        } else {
            System.out.println("It's a draw!");
        }
    }
    
}