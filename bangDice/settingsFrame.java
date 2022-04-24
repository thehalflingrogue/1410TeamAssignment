package bangDice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class settingsFrame extends JFrame {

	private JPanel contentPane;
	private JTextField blueTf;
	private JTextField redTf;
	private JTextField greenTf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					settingsFrame frame = new settingsFrame("Test Name");
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
	public settingsFrame(String userName) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 200);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 153, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel tittleLb = new JLabel("Change the background");
		tittleLb.setForeground(new Color(51, 0, 0));
		tittleLb.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 20));
		tittleLb.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tittleLb, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 153, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 153, 0));
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(3, 0, 0, 0));
		
		JLabel redLb = new JLabel("Red");
		redLb.setBackground(new Color(255, 153, 51));
		redLb.setForeground(new Color(51, 0, 0));
		redLb.setFont(new Font("Tahoma", Font.PLAIN, 20));
		redLb.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(redLb);
		
		JLabel greenLb = new JLabel("Green");
		greenLb.setForeground(new Color(51, 0, 0));
		greenLb.setFont(new Font("Tahoma", Font.PLAIN, 20));
		greenLb.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(greenLb);
		
		JLabel blueLabel = new JLabel("Blue");
		blueLabel.setForeground(new Color(51, 0, 0));
		blueLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		blueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(blueLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 153, 0));
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(3, 1, 0, 5));
		
		redTf = new JTextField();
		panel_3.add(redTf);
		redTf.setColumns(10);
		
		greenTf = new JTextField();
		panel_3.add(greenTf);
		greenTf.setColumns(10);
		
		blueTf = new JTextField();
		panel_3.add(blueTf);
		blueTf.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 153, 0));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton changeBtn = new JButton("Change Color");
		changeBtn.setBackground(new Color(51, 102, 51));
		changeBtn.setForeground(new Color(51, 0, 0));
		changeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Color bgChange = new Color(Integer.parseInt(redTf.getText()),Integer.parseInt(greenTf.getText()),Integer.parseInt(blueTf.getText()));
					dispose();
					menuFrame mf = new menuFrame(userName,bgChange);
					mf.setVisible(true);
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(contentPane, "Invalid values");
					
				}
				
			}
		});
		changeBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(changeBtn);
	}

}
