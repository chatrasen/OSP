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
	private JTextField userNameField;
	private JPasswordField passwordField;
	public JButton btnLogIn;
	
	Connection conn = null;

	/**
	 * Create the panel.
	 */
	public ManagerLoginPanel() {
		setLayout(null);
		
		JLabel lblManagerLoginPage = new JLabel("Manager Login Page");
		lblManagerLoginPage.setBounds(168, 11, 138, 14);
		add(lblManagerLoginPage);
		
		btnLogIn = new JButton("LOG IN");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "select * from manager_data where Username=? and Password=?";
				conn = sqliteConnection.dbConnector();

				try {
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1,userNameField.getText());
					pst.setString(2,userNameField.getText());
					
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
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
			}
		});
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
