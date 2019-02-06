package io.github.awalm;

import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToeGame {

	protected int currPlayer;
	protected int currTurn;
	private boolean endGame;
	private String P_ONE_CLK = "X";
	private String P_TWO_CLK = "O";
	private int[] gameBoard;
	// private int[] rowOne;
	// private int[] rowTwo;
	// private int[] rowThree;
	private int winner;
	protected JFrame gBoard;
	protected String playerOne;
	protected String playerTwo;

	public TicTacToeGame(JFrame gBoard, String playerOne, String playerTwo) {
		this.currTurn = 0;
		this.endGame = false;
		this.currPlayer = 1;
		this.gameBoard = new int[10];
		this.gameBoard[0] = 0;
		// this.rowOne = new int[4];
		// this.rowOne[0] = 0;
		// this.rowTwo = new int[4];
		// this.rowTwo[0] = 0;
		// this.rowThree = new int[4];
		// this.rowThree[0] = 0;
		this.gBoard = gBoard;
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;

	}

	public void clickButton(JButton button) {

		if (canClick(button)) {
			button.setText(playerLetter(this.currPlayer));
			this.updateBoardState(Integer.parseInt(button.getName()), this.currPlayer);
			this.nextTurn();
		}

	}

	public boolean canClick(JButton button) { // Cannot click if already clicked or if game is finished

		if (!endGame) {

			if (!(prevClicked(button))) {
				return true;
			} else {
				return false;
			}
		} else
			return false;

	}

	public boolean prevClicked(JButton button) {

		if (button.getText().equals("")) {
			return false;
		} else {

			return true;
		}
	}

	public void nextTurn() {

		if (!isFinished()) {
			if (this.currTurn % 2 == 0) {
				this.currPlayer = 2;
				currTurn++;
				gBoard.setTitle(playerTwo);
			} else {
				this.currPlayer = 1;
				currTurn++;
				gBoard.setTitle(playerOne);
			}
			isFinished();

		}

	}

	public boolean isFinished() {
		if (this.currTurn == 9) {
			this.setGameState(0);
			gBoard.setTitle("It's a tie!");
			JOptionPane.showMessageDialog(null, "It's a tie!", "The game has ended...", 1);
			TicTacToeGUI.gameReset();
			return true;
		} else {
			this.checkForWin();
			if (endGame) {
				gBoard.setTitle(this.getPlayerName(this.winner) + " wins!");
				JOptionPane.showMessageDialog(null, this.getPlayerName(this.winner) + " wins!",
						"The game has ended...", 1);
				TicTacToeGUI.gameReset();
				return true;
			}
		}
		return false;
	}

	// Game state 0 = Tied, 1 = player1 win, 2 = playe2 win, anything else is an
	// error
	public void setGameState(int gameState) {
		if (gameState == 0) {
			endGame = true;
			//System.out.println("Tied!");
		} else if (gameState == 1) {
			//System.out.println("P1 win!");
		} else if (gameState == 2) {
			//System.out.println("P2 win!");
		} else {
			throw new IllegalArgumentException("An error occured! Error code: " + gameState);
		}

	}

	public String playerLetter(int playerNum) {
		if (playerNum == 1) {
			return P_ONE_CLK;
		} else if (playerNum == 2) {
			return P_TWO_CLK;
		} else {
			this.setGameState(3);
			throw new IllegalArgumentException("Error: Invalid player number!");

		}
	}

	public void updateBoardState(int loc, int player) {

		this.gameBoard[loc] = player;
		// int idx = 0;
		// if (loc > 0 && loc <= 3) {
		// idx = loc;
		// rowOne[idx] = player;
		// } else if (loc > 3 && loc <= 6) {
		// idx = loc - 3;
		// rowTwo[idx] = player;
		// } else if (loc > 6 && loc <= 9) {
		// idx = loc - 6;
		// rowThree[idx] = player;
		// } else {
		// this.setGameState(4);
		// throw new IllegalArgumentException("Invalid loc");
		// }

		this.printGameBoard();
	}

	public void checkForWin() {
		// win conditions: row, col, diagonal

		for (int player = 1; player <= 2; player++) {
			checkWinRow(player);
			checkWinCol(player);
			checkWinDiag(player);
		}

	}

	public void checkWinRow(int player) {

		if (gameBoard[1] == player && gameBoard[2] == player && gameBoard[3] == player) {
			this.declareWinner(player);
		}

		if (gameBoard[4] == player && gameBoard[5] == player && gameBoard[6] == player) {
			this.declareWinner(player);
		}

		if (gameBoard[7] == player && gameBoard[8] == player && gameBoard[9] == player) {
			this.declareWinner(player);
		}

		// for (int idx = 1; idx <= 3; idx++) {
		// if (rowOne[idx] == player) {
		// sumOne += rowOne[idx];
		// }
		// if (rowTwo[idx] == player) {
		// sumTwo += rowTwo[idx];
		// }
		// if (rowThree[idx] == player) {
		// sumThree += rowThree[idx];
		// }
		//
		// }

		// checkSums(player, sumOne, sumTwo, sumThree);

	}

	public void checkWinCol(int player) {

		if (gameBoard[1] == player && gameBoard[4] == player && gameBoard[7] == player) {
			this.declareWinner(player);
		}

		if (gameBoard[2] == player && gameBoard[5] == player && gameBoard[8] == player) {
			this.declareWinner(player);
		}

		if (gameBoard[3] == player && gameBoard[6] == player && gameBoard[9] == player) {
			this.declareWinner(player);
		}

		// int sumOne = 0;
		// int sumTwo = 0;
		// int sumThree = 0;
		//
		// for (int idx = 1; idx <= 3; idx++) {
		// if (rowOne[idx] == player) {
		// if (idx == 1) {
		// sumOne += rowOne[idx];
		// } else if (idx == 2) {
		// sumTwo += rowTwo[idx];
		// } else if (idx == 3) {
		// sumThree += rowThree[idx];
		// }
		//
		// }
		// if (rowTwo[idx] == player) {
		// if (idx == 1) {
		// sumOne += rowOne[idx];
		// } else if (idx == 2) {
		// sumTwo += rowTwo[idx];
		// } else if (idx == 3) {
		// sumThree += rowThree[idx];
		// }
		// }
		// if (rowThree[idx] == player) {
		// if (idx == 1) {
		// sumOne += rowOne[idx];
		// } else if (idx == 2) {
		// sumTwo += rowTwo[idx];
		// } else if (idx == 3) {
		// sumThree += rowThree[idx];
		// }
		//
		// }
		//
		// checkSums(player, sumOne, sumTwo, sumThree);
		//
		// }

	}

	public void checkWinDiag(int player) {

		if (gameBoard[1] == player && gameBoard[5] == player && gameBoard[9] == player) {
			this.declareWinner(player);
		}

		if (gameBoard[3] == player && gameBoard[5] == player && gameBoard[7] == player) {
			this.declareWinner(player);
		}
	}

	// if (rowOne[1] == player && rowTwo[2] == player && rowThree[3] == player) {
	// this.winner = player;
	// this.setGameState(player);
	// this.endGame = true;
	// }
	//
	// if (rowOne[3] == player && rowTwo[2] == player && rowThree[1] == player) {
	// this.winner = player;
	// this.setGameState(player);
	// this.endGame = true;
	// }

	public void declareWinner(int player) {
		this.winner = player;
		this.setGameState(player);
		this.endGame = true;
	}

	public int getWinner() {
		if (!endGame) {
			return 404;
		} else {
			return this.winner;
		}
	}

	public String getPlayerName(int playerNum) {
		if (playerNum == 1) {
			return playerOne;
		} else if (playerNum == 2) {
			return playerTwo;
		} else {
			throw new IllegalArgumentException("Invalid player number!");
		}

	}

	public void printGameBoard() {

		//System.out.println(Arrays.toString(gameBoard));

			System.out.println("" + gameBoard[1] + gameBoard[2] + gameBoard[3]);
			System.out.println("" + gameBoard[4] + gameBoard[5] + gameBoard[6]);
			System.out.println("" + gameBoard[7] + gameBoard[8] + gameBoard[9]);
		
	}
}
