

import java.awt.BorderLayout;
import java.security.SecureRandom;
import java.math.BigInteger;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	Connection conn = null;
	
	public String currentCustomerId;
	public String currentManagerId;
	
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
		
		CustomerLoginPanel panelCustomerLogin = new CustomerLoginPanel();
		contentPane.add(panelCustomerLogin, "Login page for the customer");
		panelLogin.btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelLogin.setVisible(false);
				panelCustomerLogin.setVisible(true);
			}
		});
		
		ManagerLoginPanel panelManagerLogin = new ManagerLoginPanel();
		contentPane.add(panelManagerLogin, "Login page for the Manager");	
		panelLogin.btnManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelLogin.setVisible(false);
				panelManagerLogin.setVisible(true);
			}
		});
		
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
				panelCustomer.setVisible(false);
				panelCustomer.customer.setCity(panelCustomer.textCity.getText());
				panelCustomer.customer.setEmail(panelCustomer.textEmail.getText());
				panelCustomer.customer.setIM_ID(panelCustomer.textIM_ID.getText());
				panelCustomer.customer.setName(panelCustomer.textName.getText());
				panelCustomer.customer.setTelephone(panelCustomer.textTelephone.getText());
				
				
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
				JOptionPane.showMessageDialog(null, "Account Created. Your password is "+password + ". Please Login to Continue.");
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
				JOptionPane.showMessageDialog(null, "Account Created. Your password is "+password + ". Please Login to Continue.");
				//SendMail.send("vaiagarwal96@gmail.com","chatrasen@gmail.com");
			}
		});
		CustomerDashboardPanel panelCustomerDashboard = new CustomerDashboardPanel();
		contentPane.add(panelCustomerDashboard, "Customer Dashboard Panel");
		
		ManagerDashboardPanel panelManagerDashboard = new ManagerDashboardPanel();
		contentPane.add(panelManagerDashboard, "Manager Dashboard Panel");
		
		SellerDashboardPanel panelSellerDashboard = new SellerDashboardPanel();
		contentPane.add(panelSellerDashboard, "Seller Dashboard Panel");
		
		BuyerDashboardPanel panelBuyerDashboard = new BuyerDashboardPanel();
		contentPane.add(panelBuyerDashboard, "Buyer Dashboard Panel");
		
		panelCustomerLogin.btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "select * from customer_data where Username=? and Password=?";
				conn = sqliteConnection.dbConnector();

				try {
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1,panelCustomerLogin.userNameField.getText());
					pst.setString(2,panelCustomerLogin.passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					
					int count = 0;
					while(rs.next())
					{
						count++;
						currentCustomerId = rs.getString("IM_ID");
					}
					if(count == 1)
					{
						//JOptionPane.showMessageDialog(null, "Username and password is correct");
						panelCustomerLogin.setVisible(false);
						panelCustomerDashboard.setVisible(true);
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
		
		panelManagerLogin.btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "select * from manager_data where Username=? and Password=?";
				conn = sqliteConnection.dbConnector();

				try {
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1,panelManagerLogin.userNameField.getText());
					pst.setString(2,panelManagerLogin.passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					
					int count = 0;
					while(rs.next())
					{
						count++;
						currentManagerId = rs.getString("IM_ID");
					}
					if(count == 1)
					{
						//JOptionPane.showMessageDialog(null, "Username and password is correct");
						panelManagerLogin.setVisible(false);
						panelManagerDashboard.setVisible(true);
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
		
		panelCustomerDashboard.btnSeller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCustomerDashboard.setVisible(false);
				panelSellerDashboard.setVisible(true);
			}
		});
		
		panelCustomerDashboard.btnBuyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCustomerDashboard.setVisible(false);
				panelBuyerDashboard.setVisible(true);
			}
		});
		
		ItemPanel panelItem = new ItemPanel();
		contentPane.add(panelItem, "Item Panel");
		
		panelSellerDashboard.btnUploadAnItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSellerDashboard.setVisible(false);
				panelItem.setVisible(true);
			}
		});
		
		panelItem.btnUploadItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelItem.setVisible(false);
				
				panelItem.item.setPrice(Float.parseFloat(panelItem.textPrice.getText()));
				panelItem.item.setWeight(Float.parseFloat(panelItem.textWeight.getText()));
				panelItem.item.setAge(Integer.parseInt(panelItem.textWeight.getText()));
				panelItem.item.setCompanyName(panelItem.textCompanyName.getText());
				panelItem.item.setDetails(panelItem.textDetails.getText());
				panelItem.item.setImageFile(panelItem.textImage.getText());
				panelItem.item.getCategory().setName(panelItem.textCategory.getText());
				panelItem.item.setCity(panelItem.textCity.getText());
				
				Connection conn = sqliteConnection.dbConnector();
				Statement stmt = null;
				try {
					stmt = conn.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				String update = "INSERT INTO item_data VALUES(" 								
								+ "'" + panelItem.item.getPrice()+"',"								
								+ "'" + panelItem.item.getAge() + "',"
								+ "'" + panelItem.item.getCity() + "',"
								+ "'" + panelItem.item.getCompanyName() + "',"
								+ "'" + panelItem.item.getWeight() + "',"
								+ "'" + panelItem.item.getDetails() + "',"
								+ "'" + panelItem.item.getImageFile() + "',"
								+ "'" + panelItem.item.getCategory().getName() + "',"
								+ "'" + currentCustomerId + "',"
								+ "'" + " "
								+ "')";
				try {
					stmt.executeUpdate(update);
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				panelSellerDashboard.setVisible(true);
			}
		});
		
	}
}
	
	
