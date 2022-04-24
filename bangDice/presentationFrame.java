package bangDice;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class presentationFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					presentationFrame frame = new presentationFrame();
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
	public presentationFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 153, 51));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel tittleLabel = new JLabel("BANG THE DICE GAME");
		tittleLabel.setForeground(new Color(204, 0, 0));
		tittleLabel.setBackground(new Color(255, 153, 51));
		tittleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tittleLabel.setFont(new Font("Palatino Linotype", Font.ITALIC, 47));
		panel.add(tittleLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 153, 51));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(5, 1, 0, 5));
		
		JButton logInBtn = new JButton("LogIn");
		logInBtn.setForeground(new Color(51, 0, 0));
		logInBtn.setBackground(new Color(51, 102, 0));
		logInBtn.setFont(new Font("Palatino Linotype", Font.PLAIN, 40));
		logInBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				dispose();
				loginFrame lf = new loginFrame();
				lf.setVisible(true);
				
			}
		});
		panel_1.add(logInBtn);
		
		JButton registrationBtn = new JButton("Create new Profile");
		registrationBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				dispose();
				registrationFrame rf = new registrationFrame();
				rf.setVisible(true);
			}
		});
		registrationBtn.setForeground(new Color(51, 0, 0));
		registrationBtn.setBackground(new Color(51, 102, 0));
		registrationBtn.setFont(new Font("Palatino Linotype", Font.PLAIN, 40));
		panel_1.add(registrationBtn);
		
		JButton guessBtn = new JButton("Play as Guess");
		guessBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				menuFrame mf = new menuFrame("Guess",new Color(255, 153, 51));
				mf.setVisible(true);
			}
		});
		guessBtn.setForeground(new Color(51, 0, 0));
		guessBtn.setBackground(new Color(51, 102, 0));
		guessBtn.setFont(new Font("Palatino Linotype", Font.PLAIN, 40));
		panel_1.add(guessBtn);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton_2 = new JButton("Next Frame");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				menuFrame mf = new menuFrame("Test Name",new Color(255, 153, 51));
				mf.setVisible(true);
				
			}
		});
		btnNewButton_2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(btnNewButton_2);
	}

}
