package io.github.awalm;

import javax.swing.JButton;

public class Grid implements java.awt.event.ActionListener
{
  JButton a1;
  JButton a2;
  JButton a3;
  JButton b1;
  JButton b2;
  JButton b3;
  JButton c1;
  JButton c2;
  JButton c3;
  int xval;
  int yval;
  int moveCount = 1;
  int number = 0;
  
  int[][] score;
  
  int[][] blank;
  javax.swing.JFrame frame;
  boolean rowWin;
  boolean diagonalWin;
  boolean tieGame;
  boolean columnWin;
  
  public Grid()
  {
    blank = new int[3][3];
    for (int i = 0; i < blank.length; i++) {
      for (int j = 0; j < blank[i].length; j++) {
        blank[i][j] = 0;
      }
    }
  }
  
  public void setGridZero() {
    blank = new int[3][3];
    for (int i = 0; i < blank.length; i++) {
      for (int j = 0; j < blank[i].length; j++) {
        blank[i][j] = 0;
      }
    }
  }
  
  public void frameBuilder() {
    frame = new javax.swing.JFrame("Tic Tac Toe");
    frame.setDefaultCloseOperation(3);
    frame.setSize(400, 400);
    
    javax.swing.JPanel grid = new javax.swing.JPanel();
    grid.setLayout(new java.awt.GridLayout(3, 3));
    
    a1 = new JButton("");
    a1.setBackground(java.awt.Color.WHITE);
    a1.addActionListener(this);
    
    a2 = new JButton("");
    a2.setBackground(java.awt.Color.WHITE);
    a2.addActionListener(this);
    
    a3 = new JButton("");
    a3.setBackground(java.awt.Color.WHITE);
    a3.addActionListener(this);
    
    b1 = new JButton("");
    b1.setBackground(java.awt.Color.WHITE);
    b1.addActionListener(this);
    
    b2 = new JButton("");
    b2.setBackground(java.awt.Color.WHITE);
    b2.addActionListener(this);
    
    b3 = new JButton("");
    b3.setBackground(java.awt.Color.WHITE);
    b3.addActionListener(this);
    
    c1 = new JButton("");
    c1.setBackground(java.awt.Color.WHITE);
    c1.addActionListener(this);
    
    c2 = new JButton("");
    c2.setBackground(java.awt.Color.WHITE);
    c2.addActionListener(this);
    
    c3 = new JButton("");
    c3.setBackground(java.awt.Color.WHITE);
    c3.addActionListener(this);
    
    grid.add(a1);
    grid.add(a2);
    grid.add(a3);
    grid.add(b1);
    grid.add(b2);
    grid.add(b3);
    grid.add(c1);
    grid.add(c2);
    grid.add(c3);
    
    frame.add(grid);
    frame.setVisible(true);
    frame.setResizable(true);
  }
  
  public void replaceX(JButton b)
  {
    b.setIcon(new javax.swing.ImageIcon(getClass().getResource("finalX.png")));
  }
  
  public void replaceO(JButton b)
  {
    b.setIcon(new javax.swing.ImageIcon(getClass().getResource("Oshape.png")));
  }
  
  public void addScore(int a, int b, int c)
  {
    blank[a][b] = c;
    System.out.println(java.util.Arrays.deepToString(blank) + " Current Score");
  }
  

  public void actionPerformed(java.awt.event.ActionEvent e)
  {
    Object source = e.getSource();
    if (source == a1) {
      if (moveCount % 2 != 0) {
        replaceX(a1);
        moveCount += 1;
        a1.removeActionListener(this);
        addScore(0, 0, 1);
      }
      else {
        replaceO(a1);
        moveCount += 1;
        a1.removeActionListener(this);
        addScore(0, 0, 4);
      }
      winConditionDiagonal();
      winConditionColumns();
      winConditionRows();
      tieGame();
      endGame();
    }
    
    if (source == a2) {
      if (moveCount % 2 != 0) {
        replaceX(a2);
        moveCount += 1;
        a2.removeActionListener(this);
        addScore(0, 1, 1);
      } else {
        replaceO(a2);
        moveCount += 1;
        a2.removeActionListener(this);
        addScore(0, 1, 4);
      }
      winConditionDiagonal();
      winConditionColumns();
      winConditionRows();
      tieGame();
      endGame();
    }
    
    if (source == a3) {
      if (moveCount % 2 != 0) {
        replaceX(a3);
        moveCount += 1;
        a3.removeActionListener(this);
        addScore(0, 2, 1);
      } else {
        replaceO(a3);
        moveCount += 1;
        a3.removeActionListener(this);
        addScore(0, 2, 4);
      }
      winConditionDiagonal();
      winConditionColumns();
      winConditionRows();
      tieGame();
      endGame();
    }
    
    if (source == b1) {
      if (moveCount % 2 != 0) {
        replaceX(b1);
        moveCount += 1;
        b1.removeActionListener(this);
        addScore(1, 0, 1);
      } else {
        replaceO(b1);
        moveCount += 1;
        b1.removeActionListener(this);
        addScore(1, 0, 4);
      }
      winConditionDiagonal();
      winConditionColumns();
      winConditionRows();
      tieGame();
      endGame();
    }
    
    if (source == b2) {
      if (moveCount % 2 != 0) {
        replaceX(b2);
        moveCount += 1;
        b2.removeActionListener(this);
        addScore(1, 1, 1);
      } else {
        replaceO(b2);
        moveCount += 1;
        b2.removeActionListener(this);
        addScore(1, 1, 4);
      }
      winConditionDiagonal();
      winConditionColumns();
      winConditionRows();
      tieGame();
      endGame();
    }
    
    if (source == b3) {
      if (moveCount % 2 != 0) {
        replaceX(b3);
        moveCount += 1;
        b3.removeActionListener(this);
        addScore(1, 2, 1);
      } else {
        replaceO(b3);
        moveCount += 1;
        b3.removeActionListener(this);
        addScore(1, 2, 4);
      }
      winConditionDiagonal();
      winConditionColumns();
      winConditionRows();
      tieGame();
      endGame();
    }
    
    if (source == c1) {
      if (moveCount % 2 != 0) {
        replaceX(c1);
        moveCount += 1;
        c1.removeActionListener(this);
        addScore(2, 0, 1);
      } else {
        replaceO(c1);
        moveCount += 1;
        c1.removeActionListener(this);
        addScore(2, 0, 4);
      }
      winConditionDiagonal();
      winConditionColumns();
      winConditionRows();
      tieGame();
      endGame();
    }
    
    if (source == c2) {
      if (moveCount % 2 != 0) {
        replaceX(c2);
        moveCount += 1;
        c2.removeActionListener(this);
        addScore(2, 1, 1);
      } else {
        replaceO(c2);
        moveCount += 1;
        c2.removeActionListener(this);
        addScore(2, 1, 4);
      }
      winConditionDiagonal();
      winConditionColumns();
      winConditionRows();
      tieGame();
      endGame();
    }
    
    if (source == c3) {
      if (moveCount % 2 != 0) {
        replaceX(c3);
        moveCount += 1;
        c3.removeActionListener(this);
        addScore(2, 2, 1);
      }
      else {
        replaceO(c3);
        moveCount += 1;
        c3.removeActionListener(this);
        addScore(2, 2, 4);
      }
      winConditionDiagonal();
      winConditionColumns();
      winConditionRows();
      tieGame();
      endGame();
    }
  }
  
  public void winConditionRows() {
    for (int i = 0; i < blank.length; i++) {
      int sum = blank[i][0] + blank[i][1] + blank[i][2];
      if (sum == 12) {
        javax.swing.JDialog.setDefaultLookAndFeelDecorated(true);
        javax.swing.JOptionPane.showMessageDialog(frame, "O (Player 2) Wins!");
        rowWin = true;
      } else if (sum == 3) {
        System.out.println("X wins");
        javax.swing.JOptionPane.showMessageDialog(frame, "X (Player 1) Wins!");
        rowWin = true;
      }
    }
  }
  
  public void winConditionColumns() { for (int i = 0; i < blank.length; i++) {
      int sum = blank[0][i] + blank[1][i] + blank[2][i];
      if (sum == 12) {
        javax.swing.JDialog.setDefaultLookAndFeelDecorated(true);
        javax.swing.JOptionPane.showMessageDialog(frame, "O (Player 2) Wins!");
        columnWin = true;
      } else if (sum == 3) {
        javax.swing.JDialog.setDefaultLookAndFeelDecorated(true);
        javax.swing.JOptionPane.showMessageDialog(frame, "X (Player 1) Wins!");
        columnWin = true;
      }
    }
  }
  
  public void winConditionDiagonal() {
    int sum = 0;
    if (sum + blank[0][0] + blank[1][1] + blank[2][2] == 3) {
      javax.swing.JDialog.setDefaultLookAndFeelDecorated(true);
      javax.swing.JOptionPane.showMessageDialog(frame, "X (Player 1) Wins!");
      diagonalWin = true;
    } else if (sum + blank[0][0] + blank[1][1] + blank[2][2] == 12) {
      javax.swing.JDialog.setDefaultLookAndFeelDecorated(true);
      javax.swing.JOptionPane.showMessageDialog(frame, "O (Player 2) Wins!");
      diagonalWin = true;
    }
    if (sum + blank[0][2] + blank[1][1] + blank[2][0] == 3) {
      javax.swing.JDialog.setDefaultLookAndFeelDecorated(true);
      javax.swing.JOptionPane.showMessageDialog(frame, "X (Player 1) Wins!");
      diagonalWin = true;
    } else if (sum + blank[0][2] + blank[1][1] + blank[2][0] == 12) {
      javax.swing.JDialog.setDefaultLookAndFeelDecorated(true);
      javax.swing.JOptionPane.showMessageDialog(frame, "O (Player 2) Wins!");
      diagonalWin = true;
    }
  }
  
  public boolean tieGame() {
    if ((moveCount == 10) && (!columnWin) && (!diagonalWin) && 
      (!rowWin)) {
      javax.swing.JOptionPane.showMessageDialog(frame, "Tie Game!");
      tieGame = true;
      return true;
    }
    return false;
  }
  
  public void resetPopup() {
    javax.swing.JDialog.setDefaultLookAndFeelDecorated(true);
    int response = javax.swing.JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Confirm", 
      0, 3);
    
    if (response == 1) {
      System.out.println("No button clicked");
      System.exit(0);
    }
    if (response == 0) {
      System.out.println("Yes button clicked");
      reset();
      moveCount = (moveCount - moveCount + 1);
      setGridZero();
    }
    else if (response == -1) {
      System.out.println("JOptionPane closed");
    }
  }
  
  public void endGame() { if ((rowWin) || (columnWin) || (tieGame) || (diagonalWin)) {
      resetPopup();
      rowWin = false;
      columnWin = false;
      tieGame = false;
      diagonalWin = false;
    }
  }
  
  public void reset() { frame.removeAll();
    frame.dispose();
    frameBuilder();
  }
  
  public static void main(String[] args) {
    Grid tictac = new Grid();
    tictac.frameBuilder();
  }
}
