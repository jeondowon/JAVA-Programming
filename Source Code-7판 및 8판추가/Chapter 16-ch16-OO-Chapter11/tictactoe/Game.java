
package tictactoe; 

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet; 

public class Game extends Applet {

  public Game() {
    players = new Player[2];
    board = new Board(this, 3, 3); 
    messageBar = new Label("Game begin."); 
    setLayout(new BorderLayout()); 
    add(board, BorderLayout.CENTER);  
    add(messageBar, BorderLayout.SOUTH);  

    Panel controlPanel = new Panel();     
    Button newGameButton = new Button("New Game");
    Choice gameTypeChoice = new Choice(); 
    gameTypeChoice.addItem("human-machine");
    gameTypeChoice.addItem("human-human");
    gameTypeChoice.addItem("machine-machine");
    add(controlPanel, BorderLayout.NORTH); 
    controlPanel.setLayout(new FlowLayout());
    controlPanel.add(newGameButton); 
    controlPanel.add(gameTypeChoice);
    
    newGameButton.addActionListener(new ActionListener() { 
	public void actionPerformed(ActionEvent event) { 
	  newGame(); 
	}
      });

    gameTypeChoice.addItemListener(new ItemListener() { 
	public void itemStateChanged(ItemEvent event)  {
	  if (event !=null &&
	      event.getStateChange() == ItemEvent.SELECTED) { 
	    setGameType((String) event.getItem());
	  }
	}
      });
  }

  public void init() {
    setGameType(getParameter("type"));
    newGame(); 
  }

  public void setGameType(String gameType) {
    this.gameType = gameType;
  }

  public void newGame() {
    if (gameType.equals("human-human")) {
      players[0] = new HumanPlayer(this, 1); 
      players[1] = new HumanPlayer(this, 2);
    } else if (gameType.equals("machine-machine")) {
      players[0] = new MachinePlayer(this, 1); 
      players[1] = new MachinePlayer(this, 2);
    } else {
      players[0] = new HumanPlayer(this, 1); 
      players[1] = new MachinePlayer(this, 2);
    }

    board.reset();
    messageBar.setText("Game begin.");
    players[0].start();
    players[1].start();
    players[0].setNext(players[1]);
    players[1].setNext(players[0]);
    players[0].turn(); 
  }

  /** 
   *  return false if it's an illegal move. 
   */
  public boolean makeMove(Move move) {
    if (board.makeMove(move, turn.getId())) {
      board.checkGame(turn.getId());
      if (isOver()) {
	int winner = board.getWinner(); 
	if (winner >= 0) {
	  displayMessage("Player " + winner + " won."); 
	} else {
	  displayMessage("It's a draw");
	}
	for (int n = 0; n < players.length; n++)
	  players[n].interrupt(); 
      }
      return true; 
    } else {
      return false; 
    }
  }

  public Player getPlayer() {
    return turn; 
  }

  public Board getBoard() {
    return board; 
  }

  public boolean isOver() {
    return board.isOver(); 
  }

  public void displayMessage(String msg) {
    messageBar.setText(msg); 
  }

  protected String gameType;
  protected Player players[];
  protected Player turn; 
  protected Board  board;
  protected Label  messageBar; 



  public static void main(String[] args) { 
    String gameType = "human-machine"; 
    if (args.length > 0) { 
      gameType = args[0];
    }
    Frame frame = new Frame("Tic-Tac-Toe");
    frame.setLayout(new BorderLayout());
    Game game = new Game();
    frame.add(game, BorderLayout.CENTER);
    game.setGameType(gameType); 
    game.newGame();
    frame.setSize(280, 300); 
    frame.addWindowListener(new WindowAdapter() { 
	public void windowClosing(WindowEvent e) { 
	  System.exit(0);
	}
      });
    frame.show();     
  }

}

