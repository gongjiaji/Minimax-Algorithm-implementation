import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jg17339 on 25/10/2017.
 */

/**
 *@score stores all scores for points
 *@Points store all points
 *each position has one score & point

 *For every point of EMPTY points on current board, depends on the player, try the first position, place the move
 *See the first point:
 *get the score by find out the next depth of opponent's selection.
 *AI is expected to get minimum score from user, and AI select the highest value later.
 *if the win/lose/draw state haven't trigger, go deeper until the final state be triggered.
 *get max score for AI's turn and min score for user's turn
 *recurse method go back to upper depth, return the max/min score depends on player.
 *repeat the process until the first depth. The final score is selected by AI. It's max possible score
 *at this moment, the first point is done. Add its score and position to the list
 *Now, go to next point, execute the for each loop until all empty points get the score and position
 *Apparently, AI will choose the max score in the list.
 *get the index of this element, then get the best move in Points list.
 *Ai will place the best move in main()
 *User place a move, AI call minimax method again, this time the available points will be less.
 *repeat until the final state is triggered on board. Game over.
 */
public class AIPlayer {
    static Point bestMove;

    public static int minimax(Board board, int depth, int player) {

        List<Integer> scores = new ArrayList<>();
        List<Point> Points = new ArrayList<>();

        if (board.hasXWon()) return 10;
        if (board.hasOWon()) return -10;
        if (board.getAvailablePoints().isEmpty()) return 0;

        for (Point p : board.getAvailablePoints()) {
            if (player == 1) {
                board.placeAMove(p, 1);
                int score = minimax(board,depth + 1, 2);
                scores.add(score);
                Points.add(p);
                bestMove = Points.get(scores.indexOf(Collections.max(scores)));
            } else{
                board.placeAMove(p, 2);
                int score = minimax(board,depth + 1, 1);
                scores.add(score);
                Points.add(p);
            }
            Board.clear(p);
        }
        if (player == 1){
            return Collections.max(scores);
        }else{
            return Collections.min(scores);
        }
    }
}
