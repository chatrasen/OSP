import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerPanel extends JPanel {
	public JTextField textName;
	public JTextField textTelephone;
	public JTextField textEmail;
	public JTextField textIM_ID;
	public JTextField textCity;
	public JButton btnIllCreateIt;	
	public JButton btnCreateMyAccount;
	
	public Customer customer = new Customer();
	public JButton btnUpdateSeller;
	public JButton btnUpdateBuyer;
	public JLabel lblUsername;
	public JTextField textUsername;
	public JTextField textPassword;
	public JLabel lblPassword;
	public JButton btnOk;
	public JButton btnRemoveCustomer;
	
	/**
	 * Create the panel.
	 */
	public CustomerPanel() {
		setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(103, 31, 46, 14);
		add(lblName);
		
		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setBounds(86, 67, 63, 14);
		add(lblTelephone);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setBounds(103, 104, 46, 14);
		add(lblEmail);
		
		JLabel lblImid = new JLabel("IM_ID");
		lblImid.setBounds(103, 141, 46, 14);
		add(lblImid);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(103, 166, 46, 14);
		add(lblCity);
		
		textName = new JTextField();
		textName.setBounds(203, 29, 86, 20);
		add(textName);
		textName.setColumns(10);
		
		textTelephone = new JTextField();
		textTelephone.setBounds(203, 64, 86, 20);
		add(textTelephone);
		textTelephone.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(203, 101, 86, 20);
		add(textEmail);
		textEmail.setColumns(10);
		
		textIM_ID = new JTextField();
		textIM_ID.setBounds(203, 132, 86, 20);
		add(textIM_ID);
		textIM_ID.setColumns(10);
		
		textCity = new JTextField();
		textCity.setBounds(203, 163, 86, 20);
		add(textCity);
		textCity.setColumns(10);
		
		btnCreateMyAccount = new JButton("Create My Account ");
		btnCreateMyAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnCreateMyAccount.setBounds(57, 234, 162, 23);
		add(btnCreateMyAccount);
		
		btnIllCreateIt = new JButton("I will create it later");
		
		btnIllCreateIt.setBounds(252, 234, 123, 23);
		add(btnIllCreateIt);		
		
		btnUpdateSeller = new JButton("Update ");
		
		btnUpdateSeller.setBounds(102, 263, 117, 25);
		add(btnUpdateSeller);
		
		btnUpdateBuyer = new JButton("Update ");
		btnUpdateBuyer.setBounds(252, 263, 117, 25);
		add(btnUpdateBuyer);
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(345, 31, 93, 15);
		add(lblUsername);
		
		textUsername = new JTextField();
		textUsername.setBounds(324, 47, 114, 19);
		add(textUsername);
		textUsername.setColumns(10);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(345, 79, 93, 15);
		add(lblPassword);
		
		textPassword = new JTextField();
		textPassword.setBounds(324, 102, 114, 19);
		add(textPassword);
		textPassword.setColumns(10);
		
		btnOk = new JButton("OK");
		btnOk.setBounds(146, 192, 77, 25);
		add(btnOk);
		
		btnRemoveCustomer = new JButton("Remove Customer");
		btnRemoveCustomer.setBounds(252, 192, 117, 25);
		add(btnRemoveCustomer);
		
		
	}
}
