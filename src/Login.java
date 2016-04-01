import java.awt.EventQueue;

import javax.swing.JFrame;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection conn = null;
	private JTextField userNameField;
	private JPasswordField passwordField;
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		conn = sqliteConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(103, 58, 84, 25);
		frame.getContentPane().add(lblUsername);
		
		userNameField = new JTextField();
		userNameField.setBounds(255, 60, 86, 20);
		frame.getContentPane().add(userNameField);
		userNameField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(103, 110, 72, 14);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(255, 107, 86, 17);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query = "select * from user_data where Username=? and Password=?";
				try {
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1,userNameField.getText());
					pst.setString(2,passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					
					int count = 0;
					while(rs.next())
					{
						count++;
					}
					if(count == 1)
					{
						JOptionPane.showMessageDialog(null, "Username and password is correct");
					}
					else if(count > 1)
					{
						JOptionPane.showMessageDialog(null, "Duplicate users exist");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Username or password is incorrect");
					}
				} catch (SQLException e) {					
					e.printStackTrace();
				}
				
			}
		});
		btnLogin.setBounds(161, 195, 89, 23);
		frame.getContentPane().add(btnLogin);
	}
}
