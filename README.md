# Minimax-Algorithm-implementation
This is a university assignment that applied on TIC TAC TOE game, an unbeatable Bot

The implementation of Minimax algorithm is in AIPlayer.java file, the other 2 .java files are making the TIC-TAC-TOE game.

I was struggled on this algorithm when I had limited knowledge of programming and I hope this naive implementation could help.

The Minimax algorithm is a stupid way to make Bot, the code recursively find every possible result in the state space, pick the best move, and search again. You can't apply this algorithm on a TIC-TAC-TOE game that has more states, say 5X5. The solution is using Alpha-Beta purning optimation to cut down the impossible branch that the navie minimax meant to search. 
