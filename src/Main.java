import java.awt.BorderLayout;
import java.security.SecureRandom;
import java.math.BigInteger;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	private SecureRandom random = new SecureRandom();

	public String generatePassword() {
	   return new BigInteger(40, random).toString(32);
	}
	
	public Main() {
		setTitle("Online Sale Portal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));	
		
		
		LoginPanel panelLogin = new LoginPanel();
		contentPane.add(panelLogin, "Login panel");
		
		RegisterPanel panelRegister = new RegisterPanel();
		contentPane.add(panelRegister, "Register Panel");
		
		panelLogin.btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLogin.setVisible(false);
				panelRegister.setVisible(true);
				
			}
		});
		
		/**/
		CustomerPanel panelCustomer = new CustomerPanel();
		contentPane.add(panelCustomer, "Customer Register Panel");
		
		panelRegister.btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelRegister.setVisible(false);
				panelCustomer.setVisible(true);
			}
		});		
		
		panelCustomer.btnIllCreateIt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panelCustomer.setVisible(false);
				panelLogin.setVisible(true);
			}
		});
		
		panelCustomer.btnCreateMyAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				panelCustomer.customer.setCity(panelCustomer.textCity.getText());
				panelCustomer.customer.setEmail(panelCustomer.textEmail.getText());
				panelCustomer.customer.setIM_ID(panelCustomer.textIM_ID.getText());
				panelCustomer.customer.setName(panelCustomer.textName.getText());
				panelCustomer.customer.setTelephone(panelCustomer.textTelephone.getText());
				
				panelCustomer.setVisible(false);
				
				Connection conn = sqliteConnection.dbConnector();
				Statement stmt = null;
				try {
					stmt = conn.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				String username = panelCustomer.customer.getEmail();
				String password = generatePassword();
				System.out.println(username);
				String update = "INSERT INTO customer_data VALUES(" 								
								+ "'" + panelCustomer.customer.getName()+"',"
								+ "'" + username + "',"
								+ "'" + password + "',"
								+ "'" + panelCustomer.customer.getTelephone() + "',"
								+ "'" + panelCustomer.customer.getIM_ID() + "',"
								+ "'" + panelCustomer.customer.getCity() + "',"
								+ "'" + panelCustomer.customer.getEmail()
								+ "')";
				try {
					stmt.executeUpdate(update);
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				panelLogin.setVisible(true);
				JOptionPane.showMessageDialog(null, "Account Created. Please Login to Continue.");
			}
		});
		/**/
		ManagerPanel panelManager = new ManagerPanel();
		contentPane.add(panelManager, "Manager Register Panel");
		
		panelRegister.btnManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelRegister.setVisible(false);
				panelManager.setVisible(true);
			}
		});		
		
		panelManager.btnIWillTry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelManager.setVisible(false);
				panelLogin.setVisible(true);				
			}
		});
		
		panelManager.btnCreateNewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				panelManager.manager.setEmail(panelManager.textEmail.getText());
				panelManager.manager.setIM_ID(panelManager.textIM_ID.getText());
				panelManager.manager.setName(panelManager.textName.getText());
				panelManager.manager.setTelephone(panelManager.textTelephone.getText());
				panelManager.manager.setGender(panelManager.textGender.getText());
				panelManager.manager.setDateOfBirth(panelManager.textDOB.getText());
				panelManager.manager.setAddress(panelManager.textAddress.getText());
				panelManager.manager.setBiometricID(panelManager.textBiometricID.getText());

				panelManager.setVisible(false);
				
				Connection conn = sqliteConnection.dbConnector();
				Statement stmt = null;
				try {
					stmt = conn.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				String username = panelManager.manager.getEmail();
				String password = generatePassword();
				System.out.println(username);
				String update = "INSERT INTO manager_data VALUES(" 								
								+ "'" + panelManager.manager.getName()+"',"
								+ "'" + username + "',"
								+ "'" + password + "',"
								+ "'" + panelManager.manager.getTelephone() + "',"
								+ "'" + panelManager.manager.getIM_ID() + "',"
								+ "'" + panelManager.manager.getGender() + "',"
								+ "'" + panelManager.manager.getEmail() + "',"
								+ "'" + panelManager.manager.getDateOfBirth() + "',"
								+ "'" + panelManager.manager.getAddress() + "',"
								+ "'" + panelManager.manager.getBiometricID()
								+ "')";
				try {
					stmt.executeUpdate(update);
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				panelLogin.setVisible(true);
				JOptionPane.showMessageDialog(null, "Account Created. Please Login to Continue.");
			}
		});
	}
	
	
}
