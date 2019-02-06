package io.github.awalm;

import java.util.Random;

import javax.swing.JFrame;
/*
 Note: Unimplemented!
*/
public class TicTacAutoHard extends TicTacAutoEasy {

	public TicTacAutoHard(JFrame gBoard, String playerOne, String playerTwo) {
		super(gBoard, playerOne, playerTwo);

	}

	@Override
	public void computerClick() {

		int attemptClick = this.getButtonToClick();
		boolean canClick = TicTacToeGUI.canPressButton(attemptClick);

		while (!canClick) {
			attemptClick = this.getButtonToClick();
			canClick = TicTacToeGUI.canPressButton(attemptClick);
		}

		TicTacToeGUI.pressButton(attemptClick);

	}

	@Override
	public int getButtonToClick() {

		if (canPress(5)) {
			return 5;
		}
//		} else if (cantPress(1) && cantPress(2)) {
//			return 3;
//		} else if (cantPress(4) && cantPress(5)) {
//			return 6;
//		} else if (cantPress(7) && cantPress(8)) {
//			return 9;
//		} else if (cantPress(4) && cantPress(5)) {
//			return
//		} else if (cantPress(4) && cantPress(5)) {
//			return
//		} else if (cantPress(4) && cantPress(5)) {
//			return
//		} else if (cantPress(4) && cantPress(5)) {
//			return
//		}
		return 0;
	}

	public boolean cantPress(int button) {
		return !(TicTacToeGUI.canPressButton(button));
	}

	public boolean canPress(int button) {
		return (TicTacToeGUI.canPressButton(button));
	}
}
