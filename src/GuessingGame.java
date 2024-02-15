import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	public void checkGuess() {
		String guessTxt = txtGuess.getText();
		String message = "";
		try {
		int guess = Integer.parseInt(guessTxt);
		if (guess < theNumber)
			message = guess + " is too low. Try Again..";
		else if (guess > theNumber)
			message = guess + " is too high. Try Again..";
		else {
			message = guess + " is correct. You WIN! Let's play again!";
			newGame();
		}
		} catch (Exception e) {
			message = "Enter a whole number between 1 - 100.";
			}
		finally {
		lblOutput.setText(message);
		txtGuess.requestFocus();
		txtGuess.selectAll();
			}
		}
		
	public void newGame() {
		theNumber = (int)(Math.random() * 100 + 1);
	}
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Just a game!");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Rohan's Guessing Game");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(136, 39, 161, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Guess a number between 1 - 100 : ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 11));
		lblNewLabel_1.setBounds(21, 92, 161, 14);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("GUESS!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnNewButton.setBounds(172, 145, 89, 23);
		getContentPane().add(btnNewButton);
		
		lblOutput = new JLabel("Enter a number above and Hit Guess!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(94, 207, 245, 14);
		getContentPane().add(lblOutput);
		
		txtGuess = new JTextField();
		txtGuess.setHorizontalAlignment(SwingConstants.RIGHT);
		txtGuess.setBounds(193, 87, 53, 20);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			checkGuess();
			}
			});
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);

	}
}
