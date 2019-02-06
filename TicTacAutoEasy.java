package io.github.awalm;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.Random;

public class TicTacAutoEasy extends TicTacToeGame {

	public TicTacAutoEasy(JFrame gBoard, String playerOne, String playerTwo) {
		super(gBoard, playerOne, playerTwo);

	}

	@Override
	public void clickButton(JButton button) {

		if (canClick(button)) {
			button.setText(playerLetter(this.currPlayer));
			this.updateBoardState(Integer.parseInt(button.getName()), this.currPlayer);
			this.nextTurn();
			
		}
	}
	@Override
	public void nextTurn() {

		if (!isFinished()) {
			if (this.currTurn % 2 == 0) {
				this.currPlayer = 2;
				currTurn++;
				if(currTurn < 9) {
					this.computerClick();
				}
				gBoard.setTitle(playerTwo);
			} else {
				this.currPlayer = 1;
				currTurn++;
				gBoard.setTitle(playerOne);
			}
			isFinished();

		}

	}
	
	public void computerClick() {

		
		int attemptClick = this.getButtonToClick();
		boolean canClick = TicTacToeGUI.canPressButton(attemptClick);
		
		while(!canClick) {
			attemptClick = this.getButtonToClick();
			canClick = TicTacToeGUI.canPressButton(attemptClick);
		}
		
		TicTacToeGUI.pressButton(attemptClick);

	}

	public int getButtonToClick() {
		Random rand = new Random();
		int buttonToClick = rand.nextInt(9) + 1;
		System.out.println(buttonToClick);
		return buttonToClick;
	}
}
