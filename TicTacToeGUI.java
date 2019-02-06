package io.github.awalm;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToeGUI implements ActionListener {

	private static final int FRAME_HEIGHT = 480;
	private static final int FRAME_WIDTH = 480;
	private String playerOne;
	private String playerTwo;
	private TicTacToeGame game;
	private static JFrame gBoard;
	private int difficultyLevel;
	private static JButton[] buttons = new JButton[10];

	public TicTacToeGUI() {

		String windowTitle = "Initializing game";
		gBoard = new JFrame(windowTitle);
		gBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gBoard.setLayout(new GridLayout(3, 3));
		gBoard.setPreferredSize(new Dimension(FRAME_HEIGHT, FRAME_WIDTH));

		buttons[0] = null; // For easier manipulation, set the first index to null

		for (int i = 1; i <= 9; i++) {
			buttons[i] = new JButton();
			buttons[i].addActionListener(this);
			buttons[i].setName(Integer.toString(i));
			gBoard.add(buttons[i]);
		}
		gBoard.pack();
		gBoard.setLocationRelativeTo(null);
		gBoard.setVisible(true);

		this.setPlayerNames();
		this.initGame();

	}

	public void actionPerformed(ActionEvent e) {
		JButton clickSource = (JButton) e.getSource();

		game.clickButton(clickSource);

	}

	public void initGame() {

		if (difficultyLevel == 1) {
			game = new TicTacAutoEasy(gBoard, playerOne, playerTwo);
		} else if (difficultyLevel == 2) {
			game = new TicTacAutoHard(gBoard, playerOne, playerTwo);
		} else {
			game = new TicTacToeGame(gBoard, playerOne, playerTwo);
		}

		gBoard.setTitle("Game in progress...");
	}

	public void setPlayerNames() {
		playerOne = this.getPlayerOne();
		System.out.println(playerOne);
		playerTwo = this.getPlayerTwo();
		System.out.println(difficultyLevel);

	}

	public String getPlayerOne() {

		String playerOne = JOptionPane.showInputDialog(null, "Please enter name of Player 1", "Player 1");
		if (playerOne == null) {
			playerOne = "Player 1";
		}
		return playerOne;
	}

	public String getPlayerTwo() {

		this.playerTwo = JOptionPane.showInputDialog(null,
				"Please enter name of Player 2. Computer has two levels: easy & hard (UNIMPLEMENTED)", "Computer: Easy");

		if (playerTwo.equals("Computer: Hard")) {
			this.difficultyLevel = 2;
			return "Computer";
		} else if (playerTwo.equals("Computer: Easy")) {
			this.difficultyLevel = 1;
			return "Computer";

		} else if (playerTwo == null) {
			{
				return "Player 2";

			}

		} else {
			this.difficultyLevel = 0;
			return this.playerTwo;
		}

	}

	public	static void gameReset() {

		gBoard.dispose();
		

	}
	
	public static boolean canPressButton(int buttonNum) {
		if(buttons[buttonNum].getText().equals("")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void pressButton(int buttonNum) {
		buttons[buttonNum].doClick();
	}

}
