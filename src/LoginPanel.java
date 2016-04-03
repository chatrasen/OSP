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
	public JButton btnRegister;
	public JButton btnCustomer;
	public JButton btnManager;
	
	
	public LoginPanel() {
		
		setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		add(btnNewButton);
		
		btnRegister = new JButton("Register ");
		
		btnRegister.setBounds(183, 78, 89, 23);
		add(btnRegister);
		
		btnCustomer = new JButton("Customer");
		btnCustomer.setBounds(119, 214, 112, 23);
		add(btnCustomer);
		
		btnManager = new JButton("Manager");
		btnManager.setBounds(241, 214, 105, 23);
		add(btnManager);
		
		JLabel lblLoginAs = new JLabel("Login as");
		lblLoginAs.setBounds(200, 189, 89, 14);
		add(lblLoginAs);
	}
}
