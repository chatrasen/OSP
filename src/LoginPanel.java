import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private JTextField userNameField;
	private JPasswordField passwordField;
	public JButton btnRegister;
	
	Connection conn = null;
	
	public LoginPanel() {
		
		setLayout(null);
		userNameField = new JTextField();
		userNameField.setBounds(333, 60, 86, 20);
		add(userNameField);
		userNameField.setColumns(10);
		
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(214, 58, 84, 25);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(214, 110, 72, 14);
		add(lblPassword);
		
		JButton btnNewButton = new JButton("New button");
		add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(333, 108, 86, 17);
		add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query = "select * from customer_data where Username=? and Password=?";
				conn = sqliteConnection.dbConnector();

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
					pst.close();
					rs.close();
				} catch (SQLException e) {					
					e.printStackTrace();
				}
				
			}
		});
		btnLogin.setBounds(261, 171, 89, 23);
		add(btnLogin);
		
		btnRegister = new JButton("Register ");
		
		btnRegister.setBounds(43, 110, 89, 23);
		add(btnRegister);
	}

}
