import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ManagerLoginPanel extends JPanel {
	public JTextField userNameField;
	public JPasswordField passwordField;
	public JButton btnLogIn;
	

	/**
	 * Create the panel.
	 */
	public ManagerLoginPanel() {
		setLayout(null);
		
		JLabel lblManagerLoginPage = new JLabel("Manager Login Page");
		lblManagerLoginPage.setBounds(168, 11, 138, 14);
		add(lblManagerLoginPage);
		
		btnLogIn = new JButton("LOG IN");
		
		btnLogIn.setBounds(168, 170, 89, 23);
		add(btnLogIn);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(110, 100, 74, 14);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(110, 122, 74, 14);
		add(lblPassword);
		
		userNameField = new JTextField();
		userNameField.setBounds(209, 97, 155, 20);
		add(userNameField);
		userNameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(209, 119, 155, 20);
		add(passwordField);
		passwordField.setColumns(10);
		
	}
}