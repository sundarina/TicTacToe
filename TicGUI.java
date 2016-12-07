import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JOptionPane;

class TicGUI extends JFrame {

	JButton[][] buttons = new JButton[3][3];
	JFrame frame = new JFrame("TicTacToe");
	JButton reset = new JButton("Reset");
	JOptionPane turn;
	int moveCounter = 9;
	boolean gameWon = false;
	int WhoseTurn = 1;

	public TicGUI() {
		super();
		frame.setSize(350, 355);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
	}

	private void checkWin(int row, int col) {
		try {
			if (buttons[0][2].getText() == buttons[1][2].getText() && buttons[1][2].getText() == buttons[2][2].getText()
					&& buttons[2][2].getText() == buttons[0][2].getText() && buttons[1][2].getText() != "") {
				gameWon = true;
				WhoseTurn = 0;

				JOptionPane.showMessageDialog(frame, buttons[1][2].getText() + " wins!!!");
			}
			if (buttons[0][1].getText() == buttons[1][1].getText() && buttons[1][1].getText() == buttons[2][1].getText()
					&& buttons[2][1].getText() == buttons[0][1].getText() && buttons[1][1].getText() != "") {
				gameWon = true;
				WhoseTurn = 0;

				JOptionPane.showMessageDialog(frame, buttons[1][1].getText() + " wins!!!");
			}
			if (buttons[0][0].getText() == buttons[1][0].getText() && buttons[1][0].getText() == buttons[2][0].getText()
					&& buttons[2][0].getText() == buttons[0][0].getText() && buttons[1][0].getText() != "") {
				gameWon = true;
				WhoseTurn = 0;

				JOptionPane.showMessageDialog(frame, buttons[1][0].getText() + " wins!!!");
			}
			if (buttons[2][0].getText() == buttons[2][1].getText() && buttons[2][1].getText() == buttons[2][2].getText()
					&& buttons[2][2].getText() == buttons[2][0].getText() && buttons[2][1].getText() != "") {
				gameWon = true;
				WhoseTurn = 0;

				JOptionPane.showMessageDialog(frame, buttons[2][1].getText() + " wins!!!");
			}
			if (buttons[1][0].getText() == buttons[1][1].getText() && buttons[1][1].getText() == buttons[1][2].getText()
					&& buttons[1][2].getText() == buttons[1][0].getText() && buttons[1][1].getText() != "") {
				gameWon = true;
				WhoseTurn = 0;

				JOptionPane.showMessageDialog(frame, buttons[1][1].getText() + " wins!!!");
			}
			if (buttons[0][0].getText() == buttons[0][1].getText() && buttons[0][1].getText() == buttons[0][2].getText()
					&& buttons[0][2].getText() == buttons[0][0].getText() && buttons[0][1].getText() != "") {
				gameWon = true;
				WhoseTurn = 0;

				JOptionPane.showMessageDialog(frame, buttons[0][1].getText() + " wins!!!");
			}
			if (buttons[0][0].getText() == buttons[1][1].getText() && buttons[1][1].getText() == buttons[2][2].getText()
					&& buttons[2][2].getText() == buttons[0][0].getText() && buttons[1][1].getText() != "") {
				gameWon = true;
				WhoseTurn = 0;

				JOptionPane.showMessageDialog(frame, buttons[1][1].getText() + " wins!!!");
			}
			if (buttons[0][2].getText() == buttons[1][1].getText() && buttons[1][1].getText() == buttons[2][0].getText()
					&& buttons[2][0].getText() == buttons[0][2].getText() && buttons[1][1].getText() != "") {
				gameWon = true;
				WhoseTurn = 0;

				JOptionPane.showMessageDialog(frame, buttons[1][1].getText() + " wins!!!");
			}
		} catch (Exception e) {
			gameWon = true;
			WhoseTurn = 0;
			System.out.println("Stalemate");
			JOptionPane.showMessageDialog(frame, "Stalemate");
		}
	}

	private void compTurn(int count) {
		int randomMove = count;
		Random num = new Random();

		// if(randomMove >=0){
		randomMove = num.nextInt(randomMove) + 1;
		while (gameWon == false & WhoseTurn == 2) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (buttons[i][j].isEnabled() == true) {
						randomMove--;
						if (randomMove == 0) {
							buttons[i][j].setFont(new Font("Dialog", Font.BOLD, 24));
							buttons[i][j].setBackground(new Color(0, 191, 255));
							buttons[i][j].setText("O");
							buttons[i][j].setEnabled(false);
							moveCounter--;
							checkWin(i, j);
							WhoseTurn = 1;
						}
					}
				}
			}
		}
		// } else JOptionPane.showMessageDialog(frame, "Stalemate");
	}

	private void initialize() {
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel menu = new JPanel(new BorderLayout());
		JPanel game = new JPanel(new GridLayout(3, 3));

		frame.add(mainPanel);

		mainPanel.setPreferredSize(new Dimension(325, 425));
		menu.setPreferredSize(new Dimension(300, 25));
		game.setPreferredSize(new Dimension(300, 300));
		mainPanel.add(menu, BorderLayout.NORTH);
		mainPanel.add(game, BorderLayout.SOUTH);
		menu.add(reset, BorderLayout.NORTH);

		reset.addActionListener(new myActionListener());
		reset.setBackground(new Color(0, 255, 255));

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].setText("");
				buttons[i][j].setVisible(true);
				game.add(buttons[i][j]);
				buttons[i][j].addActionListener(new myActionListener());
			}
		}

	}

	private class myActionListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {

			if (gameWon == false) {
				if (a.getSource() == buttons[0][0]) {
					buttons[0][0].setFont(new Font("Dialog", Font.BOLD, 24));
					buttons[0][0].setBackground(new Color(124, 252, 0));
					buttons[0][0].setText("X");
					buttons[0][0].setEnabled(false);
					WhoseTurn = 2;
					moveCounter--;
					compTurn(moveCounter);
					checkWin(0, 0);
				} else if (a.getSource() == buttons[0][1]) {
					buttons[0][1].setFont(new Font("Dialog", Font.BOLD, 24));
					buttons[0][1].setBackground(new Color(124, 252, 0));
					buttons[0][1].setText("X");
					buttons[0][1].setEnabled(false);
					WhoseTurn = 2;
					moveCounter--;
					compTurn(moveCounter);
					checkWin(0, 1);
				} else if (a.getSource() == buttons[1][0]) {
					buttons[1][0].setFont(new Font("Dialog", Font.BOLD, 24));
					buttons[1][0].setBackground(new Color(124, 252, 0));
					buttons[1][0].setText("X");
					buttons[1][0].setEnabled(false);
					WhoseTurn = 2;
					moveCounter--;
					compTurn(moveCounter);
					checkWin(1, 0);
				} else if (a.getSource() == buttons[1][1]) {
					buttons[1][1].setFont(new Font("Dialog", Font.BOLD, 24));
					buttons[1][1].setBackground(new Color(124, 252, 0));
					buttons[1][1].setText("X");
					buttons[1][1].setEnabled(false);
					WhoseTurn = 2;
					moveCounter--;
					compTurn(moveCounter);
					checkWin(1, 1);
				} else if (a.getSource() == buttons[1][2]) {
					buttons[1][2].setFont(new Font("Dialog", Font.BOLD, 24));
					buttons[1][2].setBackground(new Color(124, 252, 0));
					buttons[1][2].setText("X");
					buttons[1][2].setEnabled(false);
					WhoseTurn = 2;
					moveCounter--;
					compTurn(moveCounter);
					checkWin(1, 2);
				} else if (a.getSource() == buttons[2][2]) {
					buttons[2][2].setFont(new Font("Dialog", Font.BOLD, 24));
					buttons[2][2].setBackground(new Color(124, 252, 0));
					buttons[2][2].setText("X");
					buttons[2][2].setEnabled(false);
					WhoseTurn = 2;
					moveCounter--;
					compTurn(moveCounter);
					checkWin(2, 2);
				} else if (a.getSource() == buttons[0][2]) {
					buttons[0][2].setFont(new Font("Dialog", Font.BOLD, 24));
					buttons[0][2].setBackground(new Color(124, 252, 0));
					buttons[0][2].setText("X");
					buttons[0][2].setEnabled(false);
					WhoseTurn = 2;
					moveCounter--;
					compTurn(moveCounter);
					checkWin(0, 2);
				} else if (a.getSource() == buttons[2][1]) {
					buttons[2][1].setFont(new Font("Dialog", Font.BOLD, 24));
					buttons[2][1].setBackground(new Color(124, 252, 0));
					buttons[2][1].setText("X");
					buttons[2][1].setEnabled(false);
					WhoseTurn = 2;
					moveCounter--;
					compTurn(moveCounter);
					checkWin(2, 1);
				} else if (a.getSource() == buttons[2][0]) {
					buttons[2][0].setFont(new Font("Dialog", Font.BOLD, 24));
					buttons[2][0].setBackground(new Color(124, 252, 0));
					buttons[2][0].setText("X");
					buttons[2][0].setEnabled(false);
					WhoseTurn = 2;
					moveCounter--;
					compTurn(moveCounter);
					checkWin(2, 0);
				}
			}
			if (a.getSource() == reset) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						gameWon = false;
						buttons[i][j].setText("");
						buttons[i][j].setBackground(null);
						buttons[i][j].setEnabled(true);
						moveCounter = 9;
						WhoseTurn = 1;

					}
				}
			}
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				TicGUI game = new TicGUI();
				game.initialize();
			}
		});

	}
}