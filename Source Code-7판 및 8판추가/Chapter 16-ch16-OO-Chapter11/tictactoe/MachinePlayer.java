
package tictactoe;

public class MachinePlayer extends Player {

  public MachinePlayer(Game game, int id) {
    super(game, id); 
    Board board = game.getBoard(); 
    ncells = board.getRow() * board.getColumn(); 
  }

  public Move makeMove() {
    try {
      Thread.currentThread().sleep(1000); 
    } catch (InterruptedException e) {} 

    Move move = new Move();   
    Board board = game.getBoard(); 
    int row = game.getBoard().getRow();
    int i = (int)(Math.random() * ncells); 
    move.row = i / row; 
    move.column = i % row; 
    while (!board.isLegalMove(move)) {
      i++; 
      if (i >= ncells) 
	i = i % ncells;
      move.row = i / row; 
      move.column = i % row; 
    }
    return move; 
  }

  protected int ncells;

}
