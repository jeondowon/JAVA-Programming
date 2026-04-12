
package tictactoe; 

import java.awt.*;
import java.awt.event.*;

public class Board extends Canvas {

  public Board(Game game, int row, int column) {
    this.game = game; 
    this.row = row; 
    this.column = column; 
    maxMoves = row * column; 
    moves = 0; 
    board = new int[row][column]; 
    addMouseListener(new MouseAdapter() {
	public void mouseClicked(MouseEvent event) {
	  Point p = event.getPoint();  
	  Board.this.game.getPlayer().selectCell(p.x / columnWidth, p.y / rowHeight); 
	}
      });
  }

  public void reset() { 
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) { 
	board[i][j] = 0;
      }
    }
    isover = false;
    winner = -1; 
    moves = 0; 
    repaint();
  }

  public void paint(Graphics g) {
    Dimension d = getSize(); 
    columnWidth = d.width / column;
    rowHeight = d.height / row; 

    int fontSize = Math.min(rowHeight, columnWidth) - 8;
    Font font = new Font("Sans serif", Font.BOLD, fontSize);

    g.setColor(Color.white); 
    g.fillRect(0, 0, d.width, d.height);
    g.setColor(Color.black);
    int i, j; 
    for (i = 0; i <= row; i++) {
      g.drawLine(0, i * rowHeight, d.width, i * rowHeight); 
    }
    for (j = 0; j <= column; j++) {
      g.drawLine(j * columnWidth, 0, j * columnWidth, d.height); 
    }
    
    g.setFont(font); 
    FontMetrics fm = g.getFontMetrics();
    int adjX = (columnWidth - fm.stringWidth("X")) / 2; 
    int adjO = (columnWidth - fm.stringWidth("O")) / 2; 
    int adjy = (rowHeight - fm.getHeight()) / 2 + fm.getAscent(); 
    
    for (i = 0; i < row; i++) {
      for (j = 0; j < column; j++) { 
	if (board[i][j] != 0) {
	  switch (board[i][j]) {
	  case 1:
	    g.setColor(Color.red); 
	    g.drawString("X", i * columnWidth + adjX, j * rowHeight + adjy); 
	    break; 
	  case 2:
	    g.setColor(Color.blue); 
	    g.drawString("O", i * columnWidth + adjO, j * rowHeight + adjy); 
	    break; 
	  }
	}
      }
    }
  }

  public int getRow() {
    return row; 
  }

  public int getColumn() {
    return column; 
  }

  public boolean isOver() {
    return isover; 
  }

  public int getWinner() {
    return winner; 
  }

  public boolean makeMove(Move move, int playerId) {
    if (isLegalMove(move)) {
      moves++; 
      board[move.row][move.column] = playerId; 
      repaint(); 
      return true; 
    } else {
      return false; 
    }
  }

  public boolean isLegalMove(Move move) {
    return (board[move.row][move.column] == 0); 
  }

  protected void checkGame(int playerId) {
    if (moves > maxMoves) {
      isover = true;
      return; 
    }

    boolean win = false; 
    for (int i = 0; i < row; i++)
      if (checkRow(playerId, i)) {
	win = true; 
	break; 
      }
    if (!win) 
      for (int i = 0; i < column; i++)
	if (checkColumn(playerId, i)) {
	  win = true; 
	  break; 
	}
    if (!win) 
      win = checkDiagnal(playerId); 
    
    if (win) {
      winner = playerId; 
      isover = true; 
    }

    if (moves >= maxMoves) {
      isover = true; 
    }
  }

  protected boolean checkRow(int playerId, int row) {
    for (int i = 0; i < column; i++) 
      if (board[row][i] != playerId) 
	return false; 
    return true; 
  }

  protected boolean checkColumn(int playerId, int column) {
    for (int i = 0; i < row; i++) 
      if (board[i][column] != playerId) 
	return false; 
    return true; 
  }

  protected boolean checkDiagnal(int playerId) {
    boolean result = true; 
    for (int i = 0; i < row; i++) 
      if (board[i][i] != playerId) {
	result = false; 
	break; 
      }
    if (result)
      return true;
    result = true; 
    for (int i = 0; i < row; i++) 
      if (board[i][column - i - 1] != playerId) {
	result = false; 
	break; 
      }
    return result; 
  }

  protected Game game; 
  protected int row, column;
  protected int columnWidth, rowHeight;
  protected int board[][];
  protected int maxMoves; 
  protected int moves;   
  protected boolean isover = false; 
  protected int winner = -1; 

}
