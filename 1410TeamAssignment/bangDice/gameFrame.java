package bangDice;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameFrame frame = new gameFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 563);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(205, 133, 63));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		playersPanel();
		
		currentPlayerPanel();
		
		diceImages();
		
		reRollCheckBxs();
	}

	private void diceImages() {
		JPanel diceImgPanel = new JPanel();
		diceImgPanel.setBackground(new Color(205, 133, 63));
		contentPane.add(diceImgPanel, BorderLayout.CENTER);
		diceImgPanel.setLayout(new GridLayout(7, 0, 0, 0));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		diceImgPanel.add(verticalStrut);
		
		JLabel Dice1Lbl = new JLabel("");
		Dice1Lbl.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Dice1Lbl.setOpaque(true);
		Dice1Lbl.setBackground(new Color(205, 133, 63));
		diceImgPanel.add(Dice1Lbl);
		
		JLabel Dice2Lbl = new JLabel("");
		Dice2Lbl.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Dice2Lbl.setBackground(new Color(205, 133, 63));
		Dice2Lbl.setOpaque(true);
		diceImgPanel.add(Dice2Lbl);
		
		JLabel Dice3Lbl = new JLabel("");
		Dice3Lbl.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Dice3Lbl.setOpaque(true);
		Dice3Lbl.setBackground(new Color(205, 133, 63));
		diceImgPanel.add(Dice3Lbl);
		
		JLabel Dice4Lbl = new JLabel("");
		Dice4Lbl.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Dice4Lbl.setBackground(new Color(205, 133, 63));
		Dice4Lbl.setOpaque(true);
		diceImgPanel.add(Dice4Lbl);
		
		JLabel Dice5Lbl = new JLabel("");
		Dice5Lbl.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Dice5Lbl.setOpaque(true);
		Dice5Lbl.setBackground(new Color(205, 133, 63));
		diceImgPanel.add(Dice5Lbl);
	}

	private void currentPlayerPanel() {
		JPanel currentPlayerPanel = new JPanel();
		currentPlayerPanel.setBackground(new Color(205, 133, 63));
		contentPane.add(currentPlayerPanel, BorderLayout.SOUTH);
		
		JLabel currentPlayerLbl = new JLabel("Current Player");
		currentPlayerPanel.add(currentPlayerLbl);
		
		JLabel roleLbl = new JLabel("Your Role:");
		currentPlayerPanel.add(roleLbl);
	}

	private void reRollCheckBxs() {
		JPanel reRollPanel = new JPanel();
		reRollPanel.setBackground(new Color(205, 133, 63));
		contentPane.add(reRollPanel, BorderLayout.WEST);
		reRollPanel.setLayout(new GridLayout(7, 1, 0, 0));
		
		JTextArea txtrSelectWhichDice = new JTextArea();
		txtrSelectWhichDice.setWrapStyleWord(true);
		txtrSelectWhichDice.setText("Select\nDice\nto Re-roll");
		txtrSelectWhichDice.setBackground(new Color(205, 133, 63));
		reRollPanel.add(txtrSelectWhichDice);
		
		JCheckBox dice1CheckBx = new JCheckBox("Dice 1:");
		dice1CheckBx.setHorizontalAlignment(SwingConstants.CENTER);
		dice1CheckBx.setBorderPainted(true);
		dice1CheckBx.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		dice1CheckBx.setBackground(new Color(205, 133, 63));
		reRollPanel.add(dice1CheckBx);
		
		JCheckBox dice2CheckBx = new JCheckBox("Dice 2:");
		dice2CheckBx.setHorizontalAlignment(SwingConstants.CENTER);
		dice2CheckBx.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		dice2CheckBx.setBorderPainted(true);
		dice2CheckBx.setBackground(new Color(205, 133, 63));
		reRollPanel.add(dice2CheckBx);
		
		JCheckBox dice3CheckBx = new JCheckBox("Dice 3:");
		dice3CheckBx.setHorizontalAlignment(SwingConstants.CENTER);
		dice3CheckBx.setBorderPainted(true);
		dice3CheckBx.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		dice3CheckBx.setBackground(new Color(205, 133, 63));
		reRollPanel.add(dice3CheckBx);
		
		JCheckBox dice4CheckBx = new JCheckBox("Dice 4:");
		dice4CheckBx.setHorizontalAlignment(SwingConstants.CENTER);
		dice4CheckBx.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		dice4CheckBx.setBorderPainted(true);
		dice4CheckBx.setBackground(new Color(205, 133, 63));
		reRollPanel.add(dice4CheckBx);
		
		JCheckBox dice5CheckBx = new JCheckBox("Dice 5:");
		dice5CheckBx.setHorizontalAlignment(SwingConstants.CENTER);
		dice5CheckBx.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		dice5CheckBx.setBorderPainted(true);
		dice5CheckBx.setBackground(new Color(205, 133, 63));
		reRollPanel.add(dice5CheckBx);
		
		/**
		 *Button Action Listener 
		 */
		JButton btnNewButton = new JButton("Re-roll Dice");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBackground(new Color(160, 82, 45));
		reRollPanel.add(btnNewButton);
	}

	private void playersPanel() {
		JPanel otherPlayersPanel = new JPanel();
		otherPlayersPanel.setBackground(new Color(205, 133, 63));
		contentPane.add(otherPlayersPanel, BorderLayout.NORTH);
		otherPlayersPanel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel PlayerLbl1 = new JLabel("Player1");
		PlayerLbl1.setHorizontalAlignment(SwingConstants.CENTER);
		PlayerLbl1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(139, 69, 19)));
		otherPlayersPanel.add(PlayerLbl1);
		
		JLabel PlayerLbl2 = new JLabel("Player2");
		PlayerLbl2.setHorizontalAlignment(SwingConstants.CENTER);
		PlayerLbl2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(139, 69, 19)));
		otherPlayersPanel.add(PlayerLbl2);
		
		JLabel PlayerLbl3 = new JLabel("Player3");
		PlayerLbl3.setHorizontalAlignment(SwingConstants.CENTER);
		PlayerLbl3.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(139, 69, 19)));
		otherPlayersPanel.add(PlayerLbl3);
		
		JLabel PlayerLbl4 = new JLabel("Player4");
		PlayerLbl4.setHorizontalAlignment(SwingConstants.CENTER);
		PlayerLbl4.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(139, 69, 19)));
		otherPlayersPanel.add(PlayerLbl4);
	}

}
