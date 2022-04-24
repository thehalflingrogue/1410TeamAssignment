package bangDice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menuFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuFrame frame = new menuFrame("Test name",new Color(255, 153, 51));
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
	public menuFrame(String userName, Color bColor) {
		Color bgColor = bColor;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBackground(bgColor);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(bgColor);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel tittleLabel = new JLabel("BANG THE DICE GAME");
		tittleLabel.setForeground(new Color(204, 0, 0));
		tittleLabel.setBackground(bgColor);
		tittleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tittleLabel.setFont(new Font("Palatino Linotype", Font.ITALIC, 47));
		panel.add(tittleLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(bgColor);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(5, 0, 0, 0));
		
		JLabel welcomeLb = new JLabel("Welcome " + userName);
		welcomeLb.setForeground(new Color(153, 0, 0));
		welcomeLb.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 33));
		welcomeLb.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(welcomeLb);
		
		JButton btnNewButton = new JButton("Start Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				gameFrame gf = new gameFrame(userName,bgColor);
				gf.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(51, 102, 0));
		btnNewButton.setForeground(new Color(51, 0, 0));
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 35));
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Setting");
		btnNewButton_1.setBackground(new Color(51, 102, 0));
		btnNewButton_1.setForeground(new Color(51, 0, 0));
		btnNewButton_1.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_1.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 35));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!userName.equals("Guess"))
				{
					dispose();
					settingsFrame sf = new settingsFrame(userName);
					sf.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(contentPane, "This feature is exclusive for users with a profile");
				}
			}
		});
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton_2 = new JButton("Next Frame");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				gameFrame gf = new gameFrame("Test name",new Color(255, 153, 51));
				gf.setVisible(true);
			}
		});
		
		JButton btnNewButton_3 = new JButton("Go Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				presentationFrame pf = new presentationFrame();
				pf.setVisible(true);
			}
		});
		panel_2.add(btnNewButton_3);
		panel_2.add(btnNewButton_2);
	}

}
