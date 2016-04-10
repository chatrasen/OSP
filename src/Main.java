

import java.awt.BorderLayout;
import java.security.SecureRandom;
import java.math.BigInteger;
import java.util.Iterator;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;


public class Main extends JFrame {

	private JPanel contentPane;
	
	Connection conn = null;
	
	public String currentCustomerId;
	public String currentManagerId;
	public String currentItemId;
	public float negotiationPrice;
	public boolean isNegotiate = false;
	
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
	   return new BigInteger(60, random).toString(32);
	}
	
	public Main() {
		setTitle("Online Sale Portal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));	
		
		LoginPanel panelLogin = new LoginPanel();
		panelLogin.btnRegister.setBounds(183, 78, 112, 23);
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
				
				panelCustomer.btnCreateMyAccount.setVisible(true);
				panelCustomer.btnIllCreateIt.setVisible(true);
				panelCustomer.btnUpdateBuyer.setVisible(false);
				panelCustomer.btnUpdateSeller.setVisible(false);
				
				panelCustomer.lblUsername.setVisible(false);
				panelCustomer.textUsername.setVisible(false);
				panelCustomer.textPassword.setVisible(false);
				panelCustomer.lblPassword.setVisible(false);
				
				panelCustomer.setVisible(true);
			}
		});		
		
		panelCustomer.btnIllCreateIt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panelCustomer.textName.setText("");
				panelCustomer.textCity.setText("");
				panelCustomer.textEmail.setText("");
				panelCustomer.textTelephone.setText("");
				panelCustomer.textIM_ID.setText("");
				
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
				String customerId = generatePassword();
				System.out.println(username);
				String update = "INSERT INTO customer_data VALUES(" 								
								+ "'" + panelCustomer.customer.getName()+"',"
								+ "'" + username + "',"
								+ "'" + password + "',"
								+ "'" + panelCustomer.customer.getTelephone() + "',"
								+ "'" + panelCustomer.customer.getIM_ID() + "',"
								+ "'" + panelCustomer.customer.getCity() + "',"
								+ "'" + panelCustomer.customer.getEmail() + "',"
								+ "'" + customerId + "',"
								+ "'" + "" + "',"
								+ "'" + "" + "',"
								+ "'" + "" + "',"
								+ "'" + "" + "',"
								+ "'" + ""
								+ "')";
				try {
					stmt.executeUpdate(update);
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				panelCustomer.textName.setText("");
				panelCustomer.textCity.setText("");
				panelCustomer.textEmail.setText("");
				panelCustomer.textTelephone.setText("");
				panelCustomer.textIM_ID.setText("");
				
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
				panelManager.textName.setText("");
				panelManager.textGender.setText("");
				panelManager.textEmail.setText("");
				panelManager.textTelephone.setText("");
				panelManager.textIM_ID.setText("");
				panelManager.textDOB.setText("");
				panelManager.textAddress.setText("");
				panelManager.textBiometricID.setText("");
				
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
				String managerId = generatePassword();
				
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
								+ "'" + panelManager.manager.getBiometricID() + "',"
								+ "'" + managerId
								+ "')";
				try {
					stmt.executeUpdate(update);
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				panelManager.textName.setText("");
				panelManager.textGender.setText("");
				panelManager.textEmail.setText("");
				panelManager.textTelephone.setText("");
				panelManager.textIM_ID.setText("");
				panelManager.textDOB.setText("");
				panelManager.textAddress.setText("");
				panelManager.textBiometricID.setText("");
				
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
						currentCustomerId = rs.getString("Customer_id");
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
				panelCustomerLogin.userNameField.setText("");
				panelCustomerLogin.passwordField.setText("");
				
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
						currentManagerId = rs.getString("ManagerId");
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
				panelManagerLogin.userNameField.setText("");
				panelManagerLogin.passwordField.setText("");
			}
		});
		
		panelCustomerDashboard.btnSeller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCustomerDashboard.setVisible(false);
				
				try{
					Connection conn = null;
					conn = sqliteConnection.dbConnector();
				    Statement stmt = null;
				    
					stmt = (Statement) conn.createStatement();
					ResultSet rs = stmt.executeQuery( "SELECT * FROM customer_data where Customer_id = '" + currentCustomerId + "'");
					panelSellerDashboard.modelUpload.clear();
					
					String uploadedItems = null;
					while(rs.next())
					{
						uploadedItems = rs.getString("Uploaded_Items");
					}		
					
					String[] imageIds = null;
					if(uploadedItems!=null)
						imageIds = uploadedItems.split("\\s+");

					
					int len = 0;
					if(imageIds != null)
						len = imageIds.length;
					for(int i =0; i<len; i++)
					{
						rs = stmt.executeQuery("SELECT * FROM item_data where Item_Id = '" + imageIds[i] + "'");
						boolean inserted = false;
						
						if(rs.next())
						{
							ImageIcon imageIcon = new ImageIcon(rs.getString("Image_File"));				
							Image image = imageIcon.getImage(); 
							Image newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);  
							imageIcon = new ImageIcon(newimg);  
							inserted = true;
							panelSellerDashboard.modelUpload.addElement(new ImagesAndText("Price: " + rs.getString("Price"), imageIcon, rs.getString("Item_Id"), inserted, Float.parseFloat(rs.getString("Price"))));
						
							//cartItems.addElement(new ImagesAndText("Price: " + rs.getString("Price"), imageIcon, rs.getString("Item_Id"), inserted));
					
						}
					}
					conn.close();
					
					
					
					panelSellerDashboard.listUploadedItems.setCellRenderer(new Renderer());
					
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
				panelSellerDashboard.setVisible(true);
				
				try{
					Connection conn = null;
					conn = sqliteConnection.dbConnector();
				    Statement stmt = null;
				    
					stmt = (Statement) conn.createStatement();
					ResultSet rs = stmt.executeQuery( "SELECT * FROM customer_data where Customer_id = '" + currentCustomerId + "'");
					panelSellerDashboard.modelNego.clear();
					
					String sellerMsg = null;
					while(rs.next())
					{
						sellerMsg = rs.getString("Seller_msg");
					}		
					
					String[] imageIds = null;
					if(sellerMsg!=null)
						imageIds = sellerMsg.split("\\s+");

					
					int len = 0;
					if(imageIds != null)
						len = imageIds.length;
					for(int i =0; i<len; i++)
					{						
						rs = stmt.executeQuery("SELECT * FROM item_data where Item_Id = '" + imageIds[i] + "'");
						if(!rs.next())
							continue;
						
						boolean inserted = false;
						
						
						ImageIcon imageIcon = new ImageIcon(rs.getString("Image_File"));				
						Image image = imageIcon.getImage(); 
						Image newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);  
						imageIcon = new ImageIcon(newimg);  
						inserted = true;
						panelSellerDashboard.modelNego.addElement(new ImagesAndText("Price: " + imageIds[i+1], imageIcon, rs.getString("Item_Id"), inserted, Float.parseFloat(rs.getString("Price"))));					
					
						
					}
					conn.close();
					
					panelSellerDashboard.listNegoReq.setCellRenderer(new Renderer());
					
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
				
				try{
					Connection conn = null;
					conn = sqliteConnection.dbConnector();
				    Statement stmt = null;
				    
					stmt = (Statement) conn.createStatement();
					ResultSet rs = stmt.executeQuery( "SELECT * FROM customer_data where Customer_id = '" + currentCustomerId + "'");
					panelSellerDashboard.modelBuy.clear();
					
					String buyReq = null;
					while(rs.next())
					{
						buyReq = rs.getString("Buy_req");
					}		
					
					String[] imageIds = null;
					if(buyReq!=null)
						imageIds = buyReq.split("\\s+");

					
					int len = 0;
					if(imageIds != null)
						len = imageIds.length;
					for(int i =0; i<len; i++)
					{						
						rs = stmt.executeQuery("SELECT * FROM item_data where Item_Id = '" + imageIds[i] + "'");
						if(!rs.next())
							continue;
						
						boolean inserted = false;
						
						
						ImageIcon imageIcon = new ImageIcon(rs.getString("Image_File"));				
						Image image = imageIcon.getImage(); 
						Image newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);  
						imageIcon = new ImageIcon(newimg);  
						inserted = true;
						panelSellerDashboard.modelBuy.addElement(new ImagesAndText("Price: " + imageIds[i+1] + " Customer_Id: " + imageIds[i+2], imageIcon, rs.getString("Item_Id"), inserted, Float.parseFloat(rs.getString("Price"))));					
					
						
					}
					conn.close();
					
					panelSellerDashboard.listBuyReq.setCellRenderer(new Renderer());
					
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
			}
			
			
		});
		
		panelSellerDashboard.listBuyReq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try{
					conn = sqliteConnection.dbConnector();
				   
				    
				    int index = panelSellerDashboard.listBuyReq.locationToIndex(e.getPoint());
				    ImagesAndText is = (ImagesAndText)panelSellerDashboard.modelBuy.getElementAt(index);
				    currentItemId = is.getItemId();
				    
					ResultSet rs = conn.createStatement().executeQuery( "SELECT * FROM item_data Where Item_Id = '"+currentItemId+"'" );					
					String buyerId = rs.getString("BuyerId");

				 
		    		JOptionPane.showMessageDialog(null, "The Item with item Id " + currentItemId + " has been delivered to the customer with Customer_Id + " + buyerId);
 

					rs = conn.createStatement().executeQuery("SELECT * from customer_data where Customer_id = '"+ buyerId +"'");					
					String buyReq = "";
				
					buyReq = rs.getString("Buy_req");
					
					String[] imageIds = null;
					if(buyReq!="")
						imageIds = buyReq.split("\\s+");
					
					int len = 0;
					if(imageIds != null)
						len = imageIds.length;
					
					for(int i=0; i<len; i++)
					{
						if(currentItemId.compareTo(imageIds[i])==0)
						{
							i+=2;
							continue;
						}
						else
						{
							buyReq += " " + imageIds[i];
						}
					}
					
					conn.createStatement().executeUpdate("UPDATE customer_data SET Buy_req = '" + buyReq + "' "+ "Where Customer_id = '"+buyerId+"'");
					conn.createStatement().executeQuery("Delete from item_data where Item_Id = '" + currentItemId + "'");
					conn.close();
					
					panelSellerDashboard.modelBuy.removeElementAt(index);
					panelSellerDashboard.listBuyReq.setCellRenderer(new Renderer());
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
		panelSellerDashboard.listNegoReq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try{
					conn = sqliteConnection.dbConnector();
				    Statement stmt = null;
				    float revisedPrice = 0;
				    boolean priceRevised = false;
				    
				    int index = panelSellerDashboard.listNegoReq.locationToIndex(e.getPoint());
				    ImagesAndText is = (ImagesAndText)panelSellerDashboard.modelNego.getElementAt(index);
				    currentItemId = is.getItemId();
				    
				    while(true)
				    {
				    	try{
				    		revisedPrice = Float.parseFloat(JOptionPane.showInputDialog(null, "Enter the amount you want to sell your item for:"));
				    		priceRevised = true;
				    		break;
				    	}
				    	catch(Exception e1)
				    	{
				    		JOptionPane.showMessageDialog(null, "Invalid Input Format");
				    	}
				    }
		    		JOptionPane.showMessageDialog(null, "The new price has been updated with the buyer");

					stmt = (Statement) conn.createStatement();
					ResultSet rs = stmt.executeQuery( "SELECT * FROM item_data Where Item_Id = '"+currentItemId+"'" );					
					String buyerId = rs.getString("BuyerId");
					rs.close();

					rs = conn.createStatement().executeQuery("SELECT * from customer_data where Customer_id = '"+ buyerId +"'");					
					String buyerMsg = "";
				
					buyerMsg = rs.getString("Buyer_msg");
					
					String[] imageIds = null;
					if(buyerMsg!="")
						imageIds = buyerMsg.split("\\s+");
					
					int len = 0;
					if(imageIds != null)
						len = imageIds.length;
					
					boolean found = false;
					
					for(int i=0; i<len; i++)
					{
						if(imageIds[i].compareTo(currentItemId)==0 && priceRevised)
						{
							imageIds[i+1] = Float.toString(revisedPrice);
							found = true;
						}
					}
					buyerMsg = "";
					for(int i=0; i<len; i++)
					{
						buyerMsg += " " + imageIds[i];
					}
					
					if(!found)
						buyerMsg += " " + currentItemId + " " + revisedPrice;
					
					stmt.executeUpdate("UPDATE customer_data SET Buyer_msg = '" + buyerMsg + "' "+ "Where Customer_id = '"+buyerId+"'");
					conn.close();
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
		
		Vector<ImagesAndText> cartItems = new Vector<ImagesAndText>();
		
		panelCustomerDashboard.btnBuyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCustomerDashboard.setVisible(false);
				
				try{
					Connection conn = null;
					conn = sqliteConnection.dbConnector();
				    Statement stmt = null;
				    
					stmt = (Statement) conn.createStatement();
					ResultSet rs = stmt.executeQuery( "SELECT Cart FROM customer_data where Customer_id = '" + currentCustomerId + "'");
					panelBuyerDashboard.modelCart.clear();
					
					String cart = null;
					while(rs.next())
					{
						cart = rs.getString("Cart");
					}		
					
					String[] imageIds = null;
					if(cart!=null)
						imageIds = cart.split("\\s+");

					
					int len = 0;
					if(imageIds != null)
						len = imageIds.length;
					for(int i =0; i<len; i++)
					{
						rs = stmt.executeQuery("SELECT * FROM item_data where Item_Id = '" + imageIds[i] + "'");
						boolean inserted = false;
						
						if(rs.next())
						{
							ImageIcon imageIcon = new ImageIcon(rs.getString("Image_File"));				
							Image image = imageIcon.getImage(); 
							Image newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);  
							imageIcon = new ImageIcon(newimg);  
							inserted = true;
							panelBuyerDashboard.modelCart.addElement(new ImagesAndText("Price: " + rs.getString("Price"), imageIcon, rs.getString("Item_Id"), inserted, Float.parseFloat(rs.getString("Price"))));
						
							cartItems.addElement(new ImagesAndText("Price: " + rs.getString("Price"), imageIcon, rs.getString("Item_Id"), inserted, Float.parseFloat(rs.getString("Price"))));
					
						}
					}
					conn.close();
					
					panelBuyerDashboard.listCart.setCellRenderer(new Renderer());
					
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
				
				panelBuyerDashboard.setVisible(true);
				setBounds(100, 100, 600, 400);
				
				try{
					Connection conn = null;
					conn = sqliteConnection.dbConnector();
				    Statement stmt = null;
				    
					stmt = (Statement) conn.createStatement();
					ResultSet rs = stmt.executeQuery( "SELECT * FROM customer_data where Customer_id = '" + currentCustomerId + "'");
					panelBuyerDashboard.modelMessages.clear();
					
					String buyerMsg = null;
					while(rs.next())
					{
						buyerMsg = rs.getString("Buyer_msg");
					}		
					
					String[] imageIds = null;
					if(buyerMsg!=null)
						imageIds = buyerMsg.split("\\s+");

					
					int len = 0;
					if(imageIds != null)
						len = imageIds.length;
					for(int i =0; i<len; i++)
					{						
						rs = stmt.executeQuery("SELECT * FROM item_data where Item_Id = '" + imageIds[i] + "'");
						if(!rs.next())
							continue;
						
						boolean inserted = false;
						
						
						ImageIcon imageIcon = new ImageIcon(rs.getString("Image_File"));				
						Image image = imageIcon.getImage(); 
						Image newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);  
						imageIcon = new ImageIcon(newimg);  
						inserted = true;
						panelBuyerDashboard.modelMessages.addElement(new ImagesAndText("Price: " + imageIds[i+1], imageIcon, rs.getString("Item_Id"), inserted, Float.parseFloat(imageIds[i+1])));					
					
						
					}
					conn.close();
					
					panelBuyerDashboard.listMessages.setCellRenderer(new Renderer());
					
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
			}		
			
		});	
		
		
		
		
		
		
		ItemPanel panelItem = new ItemPanel();
		contentPane.add(panelItem, "Item Panel");
		
		panelSellerDashboard.btnUploadAnItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSellerDashboard.setVisible(false);
				
				panelItem.btnUpdate.setVisible(false);
				panelItem.btnUploadItem.setVisible(true);
				
				panelItem.setVisible(true);
			}
		});
		
		panelItem.btnUploadItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelItem.setVisible(false);
				
				
				panelItem.item.setPrice(Float.parseFloat(panelItem.textPrice.getText()));
				panelItem.item.setWeight(Float.parseFloat(panelItem.textWeight.getText()));
				panelItem.item.setAge(Integer.parseInt(panelItem.textAge.getText()));
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
					e1.printStackTrace();
				}
				String itemId  = generatePassword();
				currentItemId = itemId;
				String update = "INSERT INTO item_data VALUES(" 								
								+ "'" + panelItem.item.getPrice()+"',"								
								+ "'" + panelItem.item.getAge() + "',"
								+ "'" + panelItem.item.getCity() + "',"
								+ "'" + panelItem.item.getCompanyName() + "',"
								+ "'" + panelItem.item.getWeight() + "',"
								+ "'" + panelItem.item.getDetails() + "',"
								+ "'" + panelItem.item.getImageFile() + "',"
								+ "'" + panelItem.item.getCategory().getName() + "',"
								+ "'" + itemId + "',"
								+ "'" + currentCustomerId + "',"
								+ "'" + " "
								+ "')";
				try {
					stmt.executeUpdate(update);
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				panelItem.textAge.setText("");
 				panelItem.textPrice.setText("");
 				panelItem.textCity.setText("");
 				panelItem.textCompanyName.setText("");
 				panelItem.textWeight.setText("");
 				panelItem.textDetails.setText("");
 				panelItem.textCategory.setText("");
 				panelItem.textImage.setText("");
 				panelItem.labelImage.setIcon(null);
 				
 				try{
					conn = sqliteConnection.dbConnector();
				   
					ResultSet rs = conn.createStatement().executeQuery("Select * from customer_data where Customer_id = '"+currentCustomerId + "'");
					boolean isPresent = false;
					
					String uploadedItems = rs.getString("Uploaded_Items");
					String[] imageIds = null;
					if(uploadedItems!=null)
						imageIds = uploadedItems.split("\\s+");			
												

					
					if(!isPresent)
					{
						rs = conn.createStatement().executeQuery( "SELECT * FROM item_data Where Item_Id = '"+currentItemId+"'" );
						
						boolean inserted = false;
						ImageIcon imageIcon = new ImageIcon(rs.getString("Image_File"));				
						Image image = imageIcon.getImage(); 
						Image newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);  
						imageIcon = new ImageIcon(newimg);  
						inserted = true;
						
						panelSellerDashboard.modelUpload.addElement(new ImagesAndText("Price: " + rs.getString("Price"), imageIcon, rs.getString("Item_Id"), inserted, Float.parseFloat(rs.getString("Price"))));				
						panelSellerDashboard.listUploadedItems.setCellRenderer(new Renderer());					
						
						
						conn.createStatement().executeUpdate("UPDATE customer_data SET Uploaded_Items = '" + uploadedItems+" "+currentItemId+"' "+ "Where Customer_id = '"+currentCustomerId+"'" );
					}
					conn.close();

				}				
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
				
				panelSellerDashboard.setVisible(true);
			}
		});
		
		
		panelSellerDashboard.listUploadedItems.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				panelItem.btnUpdate.setVisible(true);
				panelItem.btnUploadItem.setVisible(false);
				
				if(e.getClickCount()==2)
				{

					panelSellerDashboard.setVisible(false);
					conn = sqliteConnection.dbConnector();
					
					
					try {
						conn = sqliteConnection.dbConnector();
					    Statement stmt = null;
					    
					    int index = panelSellerDashboard.listUploadedItems.locationToIndex(e.getPoint());
					    ImagesAndText is = (ImagesAndText)panelSellerDashboard.modelUpload.getElementAt(index);
					    currentItemId = is.getItemId();
					    
						stmt = (Statement) conn.createStatement();
						ResultSet rs = stmt.executeQuery( "SELECT * FROM item_data where Item_Id = '"+currentItemId + "'");						
						
							
						ImageIcon imageIcon = new ImageIcon(rs.getString("Image_File"));				
						Image image = imageIcon.getImage(); 
						Image newimg = image.getScaledInstance(172, 182, java.awt.Image.SCALE_SMOOTH);  
						imageIcon = new ImageIcon(newimg); 
						
						
						panelItem.textAge.setText(rs.getString("Age"));
		 				panelItem.textPrice.setText(rs.getString("Price"));
		 				panelItem.textCity.setText(rs.getString("City"));
		 				panelItem.textCompanyName.setText(rs.getString("Company_Name"));
		 				panelItem.textWeight.setText(rs.getString("Weight"));
		 				panelItem.textDetails.setText(rs.getString("Details"));
		 				panelItem.textCategory.setText(rs.getString("Category"));
		 				panelItem.textImage.setText(rs.getString("Image_File"));
		 				panelItem.labelImage.setIcon(imageIcon);
						
						conn.close();
					} catch (SQLException e1) {					
						e1.printStackTrace();
					}
					
					panelItem.setVisible(true);
				}
			}
		});
		
		panelItem.btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelItem.setVisible(false);
				try{
					conn = sqliteConnection.dbConnector();
				    Statement stmt = conn.createStatement();
				    
				    stmt.executeUpdate("UPDATE item_data SET Price = '"+ panelItem.textPrice.getText() +"',"
				    					+ "Age = '" + panelItem.textAge.getText() + "',"
				    					+ "City = '" + panelItem.textCity.getText() + "',"
				    					+ "Company_Name = '" + panelItem.textCompanyName.getText() + "',"
				    					+ "Weight = '" + panelItem.textWeight.getText() + "',"
				    					+ "Details = '" + panelItem.textDetails.getText() + "',"
				    					+ "Image_File = '" + panelItem.textImage.getText() + "',"
				    					+ "Category = '" + panelItem.textCategory.getText() + "'"
				    					+ " Where Item_Id = '"+currentItemId+"'");
				    
				    
				    panelItem.textAge.setText("");
	 				panelItem.textPrice.setText("");
	 				panelItem.textCity.setText("");
	 				panelItem.textCompanyName.setText("");
	 				panelItem.textWeight.setText("");
	 				panelItem.textDetails.setText("");
	 				panelItem.textCategory.setText("");
	 				panelItem.textImage.setText("");
	 				panelItem.labelImage.setIcon(null);
	 				
				    conn.close();
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
				panelSellerDashboard.setVisible(true);
			}
		});
		
		/* Buyer Dashboard*/ 
		panelBuyerDashboard.btnDisplayCategories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Set<String> categories = new HashSet<String>();
			    try {
			    	Connection conn = null;
					conn = sqliteConnection.dbConnector();
				    Statement stmt = null;
				    
					stmt = (Statement) conn.createStatement();
					ResultSet rs = stmt.executeQuery( "SELECT * FROM item_data" );
					
					while(rs.next())
					{
						categories.add(rs.getString("Category"));
					}					
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();				
				}
			    
			    
				Iterator<String> it = categories.iterator();
				panelBuyerDashboard.model.removeAllElements();
				while(it.hasNext())
				{
					panelBuyerDashboard.model.addElement(it.next());
				}
			}
		});
		
		Vector<ImagesAndText> imgInfo = new Vector<ImagesAndText>();
		
		panelBuyerDashboard.listCategories.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{		
				String selectedCategory = panelBuyerDashboard.listCategories.getSelectedValue().toString();
				if(e.getClickCount()==2)
				{
					try{
						Connection conn = null;
						conn = sqliteConnection.dbConnector();
					    Statement stmt = null;
					    
						stmt = (Statement) conn.createStatement();
						ResultSet rs = stmt.executeQuery( "SELECT * FROM item_data" );
						panelBuyerDashboard.modelDisplay.clear();
						imgInfo.clear();
						
						while(rs.next())
						{
							boolean inserted = false;

							ImageIcon imageIcon = null;				
							Image image = null; 
							Image newimg = null;  
							if(rs.getString("Category").compareTo(selectedCategory)==0)
							{	
								imageIcon = new ImageIcon(rs.getString("Image_File"));				
								image = imageIcon.getImage(); 
								newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);  
								imageIcon = new ImageIcon(newimg);  
								inserted = true;
								panelBuyerDashboard.modelDisplay.addElement(new ImagesAndText("Price: " + rs.getString("Price"), imageIcon, rs.getString("Item_Id"), inserted, Float.parseFloat(rs.getString("Price"))));
							}
							imgInfo.addElement(new ImagesAndText("Price: " + rs.getString("Price"), imageIcon, rs.getString("Item_Id"), inserted, Float.parseFloat(rs.getString("Price"))));
							
						}					
						conn.close();
						
						panelBuyerDashboard.listDisplay.setCellRenderer(new Renderer());
						
					}
					catch(SQLException e1)
					{
						e1.printStackTrace();
					}
					
				}
			}			
		});
		ImageSpecs panelImageSpecs = new ImageSpecs();
		contentPane.add(panelImageSpecs, "Image Specification Panel");
		
		panelBuyerDashboard.listDisplay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//int clickIndex = panelBuyerDashboard.listDisplay.getSelectedIndex();
				if(e.getClickCount()==2)
				{
					panelBuyerDashboard.setVisible(false);
					//String query = "select * from item_data";
					conn = sqliteConnection.dbConnector();
					
					
					try {
						conn = sqliteConnection.dbConnector();
					    Statement stmt = null;
					    
					    int index = panelBuyerDashboard.listDisplay.locationToIndex(e.getPoint());
					    ImagesAndText is = (ImagesAndText)panelBuyerDashboard.modelDisplay.getElementAt(index);
					    currentItemId = is.getItemId();
					    
						stmt = (Statement) conn.createStatement();
						ResultSet rs = stmt.executeQuery( "SELECT * FROM item_data where Item_Id = '"+currentItemId + "'");						
						
						
						panelImageSpecs.textArea.setText(null);
						//int count = 0;						
						
						/*while(rs.next())
						{				
							if(imgInfo.elementAt(count).isInserted)
							{*/
								//System.out.println(count);
								panelImageSpecs.textArea.append("Price: " + rs.getString("Price") + "\n");
								panelImageSpecs.textArea.append("Age: " + rs.getString("Age") + "\n");
								panelImageSpecs.textArea.append("City: " + rs.getString("City") + "\n");
								panelImageSpecs.textArea.append("Company Name: " + rs.getString("Company_Name")+ "\n");
								panelImageSpecs.textArea.append("Weight: " + rs.getString("Weight") + "\n");
								panelImageSpecs.textArea.append("Details: " + rs.getString("Details")+ "\n");
								panelImageSpecs.textArea.append("Category: " + rs.getString("Category") + "\n");
								
								ImageIcon imageIcon = new ImageIcon(rs.getString("Image_File"));				
								Image image = imageIcon.getImage(); 
								Image newimg = image.getScaledInstance(172, 182, java.awt.Image.SCALE_SMOOTH);  
								imageIcon = new ImageIcon(newimg); 
								panelImageSpecs.lblImage.setIcon(imageIcon);
							/*}
							count++;
						}*/
						
						conn.close();
					} catch (SQLException e1) {					
						e1.printStackTrace();
					}
					
					panelImageSpecs.setVisible(true);
					panelImageSpecs.btnAddToCart.setVisible(true);

					panelImageSpecs.btnRemoveFromCart.setVisible(false);
				}
			}
		});
		panelImageSpecs.btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelImageSpecs.setVisible(false);
				panelBuyerDashboard.setVisible(true);
				isNegotiate = false;
			}
		});
		
		panelImageSpecs.btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelImageSpecs.setVisible(false);
				try{
					conn = sqliteConnection.dbConnector();
				    Statement stmt = null;
				    
					stmt = (Statement) conn.createStatement();
					ResultSet rs = stmt.executeQuery("Select * from customer_data where Customer_id = '"+currentCustomerId + "'");
					boolean isPresent = false;
					int index = 0;
					
					String cart = rs.getString("Cart");
					String[] imageIds = null;
					if(cart!=null)
						imageIds = cart.split("\\s+");
					
					int len = 0;
					if(imageIds != null)
						len = imageIds.length;
					

					
					for(int i=0; i<len; i++)
					{
						if(currentItemId.compareTo(imageIds[i])==0)
						{
							isPresent = true;
							index = i;
							break;
						}
					}				

					
					if(!isPresent)
					{
						rs = stmt.executeQuery( "SELECT * FROM item_data Where Item_Id = '"+currentItemId+"'" );
						
						float currentPrice = Float.parseFloat(rs.getString("Price"));
						
						if(isNegotiate)
							currentPrice = negotiationPrice;
						
						boolean inserted = false;
						ImageIcon imageIcon = new ImageIcon(rs.getString("Image_File"));				
						Image image = imageIcon.getImage(); 
						Image newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);  
						imageIcon = new ImageIcon(newimg);  
						inserted = true;
						panelBuyerDashboard.modelCart.addElement(new ImagesAndText("Price: " + currentPrice, imageIcon, rs.getString("Item_Id"), inserted, currentPrice));				
						panelBuyerDashboard.listCart.setCellRenderer(new Renderer());
						
						
						
						stmt.executeUpdate("UPDATE customer_data SET Cart = '" + cart+" "+currentItemId+"' "+ "Where Customer_id = '"+currentCustomerId+"'" );
					}
					else
					{
						//System.out.println(panelBuyerDashboard.modelCart.size());
					    ImagesAndText is = (ImagesAndText)panelBuyerDashboard.modelCart.getElementAt(index-1);
					    is.setName("Price: " + negotiationPrice );					

					}
					isNegotiate = false;
					conn.close();

				}				
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
				panelBuyerDashboard.setVisible(true);
			}
		});
		
		panelBuyerDashboard.listCart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelImageSpecs.btnAddToCart.setVisible(false);
				panelImageSpecs.btnRemoveFromCart.setVisible(true);

				if(e.getClickCount()==2)
				{
					panelBuyerDashboard.setVisible(false);
					conn = sqliteConnection.dbConnector();
					
					
					try {
						conn = sqliteConnection.dbConnector();
					    Statement stmt = null;
					    
					    int index = panelBuyerDashboard.listCart.locationToIndex(e.getPoint());
					    ImagesAndText is = (ImagesAndText)panelBuyerDashboard.modelCart.getElementAt(index);
					    currentItemId = is.getItemId();
					    
						stmt = (Statement) conn.createStatement();
						ResultSet rs = stmt.executeQuery( "SELECT * FROM item_data where Item_Id = '"+currentItemId + "'");						
						
						
						panelImageSpecs.textArea.setText(null);
						
						panelImageSpecs.textArea.append("Price: " + rs.getString("Price") + "\n");
						panelImageSpecs.textArea.append("Age: " + rs.getString("Age") + "\n");
						panelImageSpecs.textArea.append("City: " + rs.getString("City") + "\n");
						panelImageSpecs.textArea.append("Company Name: " + rs.getString("Company_Name")+ "\n");
						panelImageSpecs.textArea.append("Weight: " + rs.getString("Weight") + "\n");
						panelImageSpecs.textArea.append("Details: " + rs.getString("Details")+ "\n");
						panelImageSpecs.textArea.append("Category: " + rs.getString("Category") + "\n");
							
						ImageIcon imageIcon = new ImageIcon(rs.getString("Image_File"));				
						Image image = imageIcon.getImage(); 
						Image newimg = image.getScaledInstance(172, 182, java.awt.Image.SCALE_SMOOTH);  
						imageIcon = new ImageIcon(newimg); 
						panelImageSpecs.lblImage.setIcon(imageIcon);
						
						
						conn.close();
					} catch (SQLException e1) {					
						e1.printStackTrace();
					}
					
					panelImageSpecs.setVisible(true);
				}
			}
		});
	panelBuyerDashboard.listMessages.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				panelImageSpecs.btnAddToCart.setVisible(true);
				panelImageSpecs.btnRemoveFromCart.setVisible(false);
				

				if(e.getClickCount()==2)
				{
					panelBuyerDashboard.setVisible(false);
					conn = sqliteConnection.dbConnector();
					isNegotiate = true;
					
					try {
						conn = sqliteConnection.dbConnector();
					    Statement stmt = null;
					    
					    int index = panelBuyerDashboard.listMessages.locationToIndex(e.getPoint());
					   // System.out.println("Index = " + index);
					    ImagesAndText is = (ImagesAndText)panelBuyerDashboard.modelMessages.getElementAt(index);
					    currentItemId = is.getItemId();
					    negotiationPrice = is.price;
					    
						stmt = (Statement) conn.createStatement();
						ResultSet rs = stmt.executeQuery( "SELECT * FROM item_data where Item_Id = '"+currentItemId + "'");						
						
						
						panelImageSpecs.textArea.setText(null);
						
						panelImageSpecs.textArea.append("Price: " + negotiationPrice + "\n");
						panelImageSpecs.textArea.append("Age: " + rs.getString("Age") + "\n");
						panelImageSpecs.textArea.append("City: " + rs.getString("City") + "\n");
						panelImageSpecs.textArea.append("Company Name: " + rs.getString("Company_Name")+ "\n");
						panelImageSpecs.textArea.append("Weight: " + rs.getString("Weight") + "\n");
						panelImageSpecs.textArea.append("Details: " + rs.getString("Details")+ "\n");
						panelImageSpecs.textArea.append("Category: " + rs.getString("Category") + "\n");
							
						ImageIcon imageIcon = new ImageIcon(rs.getString("Image_File"));				
						Image image = imageIcon.getImage(); 
						Image newimg = image.getScaledInstance(172, 182, java.awt.Image.SCALE_SMOOTH);  
						imageIcon = new ImageIcon(newimg); 
						panelImageSpecs.lblImage.setIcon(imageIcon);	
						
						rs = conn.createStatement().executeQuery( "SELECT Cart FROM customer_data where Customer_id = '" + currentCustomerId + "'");
						
						String buyerMsg = null;
						while(rs.next())
						{
							buyerMsg = rs.getString("Cart");
						}		
						
						String[] imageIds = null;
						if(buyerMsg!=null)
							imageIds = buyerMsg.split("\\s+");

						
						int len = 0;
						if(imageIds != null)
							len = imageIds.length;
						
						buyerMsg = "";
						for(int i=0; i<len; i++)
						{
							if(currentItemId.compareTo(imageIds[i])==0)
							{
								i++;
								continue;
							}
							else
							{
								buyerMsg += " " + imageIds[i];
							}
						}
						
						conn.createStatement().executeUpdate("UPDATE customer_data SET Buyer_msg = '" + buyerMsg+ "' Where Customer_id = '"+currentCustomerId+"'" );

						
						panelBuyerDashboard.modelMessages.removeElementAt(index);
						panelBuyerDashboard.listMessages.setCellRenderer(new Renderer());

						
						conn.close();
						
					} catch (SQLException e1) {					
						e1.printStackTrace();
					}
					
					panelImageSpecs.setVisible(true);
				}
				
				
			}
		});
		
		panelImageSpecs.btnRemoveFromCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelImageSpecs.setVisible(false);
				try{
					isNegotiate = false;	
					conn = sqliteConnection.dbConnector();
				    Statement stmt = null;
				    
					stmt = (Statement) conn.createStatement();
					ResultSet rs = stmt.executeQuery( "SELECT * FROM item_data Where Item_Id = '"+currentItemId+"'" );
					
					for(int i=0; i<panelBuyerDashboard.modelCart.size(); i++)
					{
					    ImagesAndText is = (ImagesAndText)panelBuyerDashboard.modelCart.getElementAt(i);
					    if(is.getItemId().compareTo(currentItemId)==0)
					    {
					    	panelBuyerDashboard.modelCart.removeElementAt(i);
					    	break;
					    }
					}
					
					panelBuyerDashboard.listCart.setCellRenderer(new Renderer());
					
					rs = stmt.executeQuery( "SELECT * FROM customer_data Where Customer_id = '"+currentCustomerId+"'" );
					String cart = rs.getString("Cart");
					
					String[] imageIds = null;
					if(cart!=null)
						imageIds = cart.split("\\s+");
					
					int len = 0;
					if(imageIds != null)
						len = imageIds.length;
					
					cart = "";
					for(int i=0; i<len; i++)
					{
						if(imageIds[i].compareTo(currentItemId)!=0)
						{
							if(cart == "")
								cart = imageIds[i];
							else
								cart = cart + " " + imageIds[i];
						}
					}
					
					stmt.executeUpdate("UPDATE customer_data SET cart = '" + cart + "' "+ "Where Customer_id = '"+currentCustomerId+"'" );
					conn.close();
				}				
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
				panelBuyerDashboard.setVisible(true);
			}
		});
		
		panelImageSpecs.btnNegotiate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					conn = sqliteConnection.dbConnector();
				    Statement stmt = null;
				    float revisedPrice = 0;
				    boolean priceRevised = false;
				    while(true)
				    {
				    	try{
				    		revisedPrice = Float.parseFloat(JOptionPane.showInputDialog(null, "Enter the amount you want to lower the price to:"));
				    		priceRevised = true;
				    		break;
				    	}
				    	catch(Exception e1)
				    	{
				    		JOptionPane.showMessageDialog(null, "Invalid Input Format");
				    	}
				    }
		    		JOptionPane.showMessageDialog(null, "Your request has been sent to the seller");

					stmt = (Statement) conn.createStatement();
					ResultSet rs = stmt.executeQuery( "SELECT * FROM item_data Where Item_Id = '"+currentItemId+"'" );					
					String sellerId = rs.getString("UploaderId");
					//System.out.println(sellerId);
					rs.close();

					ResultSet rs1 = conn.createStatement().executeQuery("SELECT * from customer_data where Customer_id = '"+ sellerId +"'");					
					String sellerMsg = "";
				
					sellerMsg = rs1.getString("Seller_msg");
					//System.out.println(sellerMsg);
					
					String[] imageIds = null;
					if(sellerMsg!="")
						imageIds = sellerMsg.split("\\s+");
					
					int len = 0;
					if(imageIds != null)
						len = imageIds.length;
					
					boolean found = false;
					
					for(int i=0; i<len; i++)
					{
						if(imageIds[i].compareTo(currentItemId)==0 && priceRevised)
						{
							imageIds[i+1] = Float.toString(revisedPrice);
							found = true;
						}
					}
					sellerMsg = "";
					for(int i=0; i<len; i++)
					{
						sellerMsg += " " + imageIds[i];
					}
					
					if(!found)
						sellerMsg += " " + currentItemId + " " + revisedPrice;
					
					stmt.executeUpdate("UPDATE customer_data SET Seller_msg = '" + sellerMsg + "' "+ "Where Customer_id = '"+sellerId+"'");
					conn.createStatement().executeUpdate("Update item_data SET BuyerId = '"+currentCustomerId+"' Where Item_Id = '" + currentItemId + "'" );
					conn.close();
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		
		panelBuyerDashboard.btnPlaceOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    try {
			    	Connection conn = null;
					conn = sqliteConnection.dbConnector();
					
					ResultSet rs = null;				
					String buyReq = null;
					//rs = conn.createStatement().executeQuery("SELECT * from customer_data where Customer_id = '"+  +"'")
					
					for(int i=0; i<panelBuyerDashboard.modelCart.size(); i++)
					{					    
					    ImagesAndText is = (ImagesAndText)panelBuyerDashboard.modelCart.getElementAt(i);
					    String itemId = is.getItemId();
						rs = conn.createStatement().executeQuery("SELECT * from item_data where Item_Id = '"+ itemId +"'");
						
						String customerId = rs.getString("UploaderId");
						rs = conn.createStatement().executeQuery("SELECT * from customer_data where Customer_id = '"+ customerId +"'");
						
						buyReq = rs.getString("Buy_req");
						
						boolean exists = false;
						

						String[] imageIds = null;
						if(buyReq!="")
							imageIds = buyReq.split("\\s+");
						
						int len = 0;
						if(imageIds != null)
							len = imageIds.length;
						
						for(int j=0; i<len; i++)
						{
							if(imageIds[i].compareTo(itemId)==0)
							{
								if(imageIds[i+2].compareTo(customerId)==0)
								{
									imageIds[i+1] = Float.toString(is.price);
									exists = true;
								}
							}
						}
						
						if(!exists)
							buyReq += " " + itemId + " " + is.price + " " + " "  + customerId;	
						else
						{
							buyReq = "";
							for(i=0; i<len; i++)
							{
								buyReq += " " + imageIds[i];
							}
						}
						
						
						conn.createStatement().executeUpdate("Update customer_data SET Buy_req = '"+buyReq+"' Where Customer_id = '" + customerId + "'");
						conn.createStatement().executeUpdate("Update item_data SET BuyerId = '"+currentCustomerId+"' Where Item_Id = '" + itemId + "'");	
					}
					
					panelBuyerDashboard.modelCart.clear();
					
					panelBuyerDashboard.listCart.setCellRenderer(new Renderer());
					
					String cart = "";
					conn.createStatement().executeUpdate("Update customer_data SET Cart = '"+cart+"' Where Customer_id = '" + currentCustomerId + "'");		
						

					conn.close();
					
					JOptionPane.showMessageDialog(null, "All the corresponding sellers have been notified with your request to buy.");
					
				} catch (SQLException e1) {
					e1.printStackTrace();				
				}
			    
			   
			}
		});
		

		panelSellerDashboard.btnUpdateProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSellerDashboard.setVisible(false);
				
				panelCustomer.btnCreateMyAccount.setVisible(false);
				panelCustomer.btnIllCreateIt.setVisible(false);
				panelCustomer.btnUpdateBuyer.setVisible(false);
				panelCustomer.btnUpdateSeller.setVisible(true);	
				

				panelCustomer.lblUsername.setVisible(true);
				panelCustomer.textUsername.setVisible(true);
				panelCustomer.textPassword.setVisible(true);
				panelCustomer.lblPassword.setVisible(true);
				
				try{
					Connection conn = sqliteConnection.dbConnector();
					
					ResultSet rs = null;
					
					rs = conn.createStatement().executeQuery("Select * from customer_data Where Customer_id = '"+currentCustomerId+ "'");
					

					panelCustomer.textName.setText(rs.getString("Name"));
					panelCustomer.textCity.setText(rs.getString("City"));
					panelCustomer.textEmail.setText(rs.getString("Email"));
					panelCustomer.textTelephone.setText(rs.getString("Telephone"));
					panelCustomer.textIM_ID.setText(rs.getString("IM_ID"));
					panelCustomer.textUsername.setText(rs.getString("Username"));
					panelCustomer.textPassword.setText(rs.getString("Password"));
					
					conn.close();
					
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
				
				
				
				panelCustomer.setVisible(true);
			}
		});
		
		panelBuyerDashboard.btnUpdateProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBuyerDashboard.setVisible(false);
				
				panelCustomer.btnCreateMyAccount.setVisible(false);
				panelCustomer.btnIllCreateIt.setVisible(false);
				panelCustomer.btnUpdateBuyer.setVisible(true);
				panelCustomer.btnUpdateSeller.setVisible(false);	
				

				panelCustomer.lblUsername.setVisible(true);
				panelCustomer.textUsername.setVisible(true);
				panelCustomer.textPassword.setVisible(true);
				panelCustomer.lblPassword.setVisible(true);
				
				try{
					Connection conn = sqliteConnection.dbConnector();
					
					ResultSet rs = null;
					
					rs = conn.createStatement().executeQuery("Select * from customer_data Where Customer_id = '"+currentCustomerId+ "'");
					

					panelCustomer.textName.setText(rs.getString("Name"));
					panelCustomer.textCity.setText(rs.getString("City"));
					panelCustomer.textEmail.setText(rs.getString("Email"));
					panelCustomer.textTelephone.setText(rs.getString("Telephone"));
					panelCustomer.textIM_ID.setText(rs.getString("IM_ID"));
					panelCustomer.textUsername.setText(rs.getString("Username"));
					panelCustomer.textPassword.setText(rs.getString("Password"));
					
					conn.close();
					
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
				
				
				
				panelCustomer.setVisible(true);
			}
		});
		
		panelManagerDashboard.btnUpdateProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSellerDashboard.setVisible(false);			
					

				panelManager.lblUsername.setVisible(true);
				panelManager.textUsername.setVisible(true);
				panelManager.textPassword.setVisible(true);
				panelManager.lblPassword.setVisible(true);
				
				try{
					Connection conn = sqliteConnection.dbConnector();
					
					ResultSet rs = null;
					
					rs = conn.createStatement().executeQuery("Select * from manager_data Where Customer_id = '"+currentManagerId+ "'");
					

					panelManager.textName.setText(rs.getString("Name"));
					panelManager.textGender.setText(rs.getString("Gender"));
					panelManager.textEmail.setText(rs.getString("Email"));
					panelManager.textTelephone.setText(rs.getString("Telephone"));
					panelManager.textIM_ID.setText(rs.getString("IM_ID"));
					panelManager.textDOB.setText(rs.getString("Date_of_birth"));
					panelManager.textAddress.setText(rs.getString("Address"));
					panelManager.textBiometricID.setText(rs.getString("Biometric_ID"));
					panelManager.textUsername.setText(rs.getString("Username"));
					panelManager.textPassword.setText(rs.getString("Password"));
					
					conn.close();
					
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
				
				
				
				panelManager.setVisible(true);
			}
		});
		
		panelCustomer.btnUpdateSeller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCustomer.setVisible(false);
				
				panelCustomer.customer.setCity(panelCustomer.textCity.getText());
				panelCustomer.customer.setEmail(panelCustomer.textEmail.getText());
				panelCustomer.customer.setIM_ID(panelCustomer.textIM_ID.getText());
				panelCustomer.customer.setName(panelCustomer.textName.getText());
				panelCustomer.customer.setTelephone(panelCustomer.textTelephone.getText());
				
				
				
				Connection conn = sqliteConnection.dbConnector();
				

				
				String username = panelCustomer.textUsername.getText();
				
				String password = panelCustomer.textPassword.getText();
				
				try {
					conn.createStatement().executeUpdate("Update customer_data SET Name = '"+panelCustomer.customer.getName() + "', "
														  + "Username = '" + username + "', "
														  + "Password = '" + password + "', "
														  + " Telephone = '" + panelCustomer.customer.getTelephone() + "', "
														  + "IM_ID = '" + panelCustomer.customer.getIM_ID()+ "', "
														  + "City = '" + panelCustomer.customer.getCity() + "', "
														  + "Email = '" + panelCustomer.customer.getEmail() + "' "
														  + "Where Customer_id = '" + currentCustomerId + "' "
														  );
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				panelCustomer.textName.setText("");
				panelCustomer.textCity.setText("");
				panelCustomer.textEmail.setText("");
				panelCustomer.textTelephone.setText("");
				panelCustomer.textIM_ID.setText("");
				panelCustomer.textUsername.setText("");
				panelCustomer.textPassword.setText("");
				
				panelSellerDashboard.setVisible(true);
			}
		});
		
		panelCustomer.btnUpdateBuyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCustomer.setVisible(false);
				
				panelCustomer.customer.setCity(panelCustomer.textCity.getText());
				panelCustomer.customer.setEmail(panelCustomer.textEmail.getText());
				panelCustomer.customer.setIM_ID(panelCustomer.textIM_ID.getText());
				panelCustomer.customer.setName(panelCustomer.textName.getText());
				panelCustomer.customer.setTelephone(panelCustomer.textTelephone.getText());
				
				
				
				Connection conn = sqliteConnection.dbConnector();
				

				
				String username = panelCustomer.textUsername.getText();
				
				String password = panelCustomer.textPassword.getText();
				
				try {
					conn.createStatement().executeUpdate("Update customer_data SET Name = '"+panelCustomer.customer.getName() + "', "
														  + "Username = '" + username + "', "
														  + "Password = '" + password + "', "
														  + " Telephone = '" + panelCustomer.customer.getTelephone() + "', "
														  + "IM_ID = '" + panelCustomer.customer.getIM_ID()+ "', "
														  + "City = '" + panelCustomer.customer.getCity() + "', "
														  + "Email = '" + panelCustomer.customer.getEmail() + "' "
														  + "Where Customer_id = '" + currentCustomerId + "' "
														  );
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				panelCustomer.textName.setText("");
				panelCustomer.textCity.setText("");
				panelCustomer.textEmail.setText("");
				panelCustomer.textTelephone.setText("");
				panelCustomer.textIM_ID.setText("");
				panelCustomer.textUsername.setText("");
				panelCustomer.textPassword.setText("");
				
				panelBuyerDashboard.setVisible(true);
			}
		});
		
		
		
		
		
		panelBuyerDashboard.btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBuyerDashboard.setVisible(false);
				
				panelBuyerDashboard.model.clear();
				panelBuyerDashboard.modelCart.clear();
				panelBuyerDashboard.modelDisplay.clear();
				panelBuyerDashboard.modelMessages.clear();

				panelLogin.setVisible(true);
			}
		});
		
		panelSellerDashboard.btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSellerDashboard.setVisible(false);
				
				panelSellerDashboard.modelBuy.clear();
				panelSellerDashboard.modelNego.clear();
				panelSellerDashboard.modelUpload.clear();

				panelLogin.setVisible(true);
			}
		});
		
		
	}
}
	
	
