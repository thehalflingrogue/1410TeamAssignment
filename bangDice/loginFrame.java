package bangDice;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class loginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField passwordField;
	private JTextField userNameField;
	private playerProfileLogin log = new playerProfileLogin();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginFrame frame = new loginFrame();
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
	public loginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 200);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 153, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel tittleLb = new JLabel("LogIn");
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
		panel_2.setLayout(new GridLayout(2, 0, 0, 0));
		
		JLabel usernameLb = new JLabel("Username");
		usernameLb.setBackground(new Color(255, 153, 51));
		usernameLb.setForeground(new Color(51, 0, 0));
		usernameLb.setFont(new Font("Tahoma", Font.PLAIN, 20));
		usernameLb.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(usernameLb);
		
		JLabel passwordLb = new JLabel("Password");
		passwordLb.setForeground(new Color(51, 0, 0));
		passwordLb.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordLb.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(passwordLb);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 153, 0));
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 5));
		
		userNameField = new JTextField();
		userNameField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_3.add(userNameField);
		userNameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_3.add(passwordField);
		passwordField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 153, 0));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton logInBtn = new JButton("LogIn");
		logInBtn.setBackground(new Color(51, 102, 51));
		logInBtn.setForeground(new Color(51, 0, 0));
		logInBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			    
			    log.setUsername(userNameField.getText());
			    log.setPassword(passwordField.getText());
			    log.Validate();
			    
			    if(log.Validate())
			    {
			    	dispose();
					menuFrame mf = new menuFrame(log.getUsername(),new Color(255, 153, 51));
					mf.setVisible(true);
			    }
			    else
			    {
			    	JOptionPane.showMessageDialog(contentPane, "Wrong username or password.");
			    }
			}
		});
		logInBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(logInBtn);
	}

}