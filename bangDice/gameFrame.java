package bangDice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class gameFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameFrame frame = new gameFrame("Test name",new Color(255, 153, 51));
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
	public gameFrame(String userName, Color bgColor) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBackground(bgColor);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(bgColor);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel tittleLabel = new JLabel("BANG THE DICE GAME");
		tittleLabel.setForeground(new Color(102, 0, 0));
		tittleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tittleLabel.setFont(new Font("Palatino Linotype", Font.ITALIC, 47));
		panel.add(tittleLabel);
	}

}
