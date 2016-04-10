import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerPanel extends JPanel {
	public JTextField textName;
	public JTextField textTelephone;
	public JTextField textEmail;
	public JTextField textIM_ID;
	public JTextField textGender;
	public JTextField textDOB;
	public JTextField textAddress;
	public JTextField textBiometricID;
	
	public JButton btnCreateNewAccount;
	public JButton btnIWillTry;
	
	public Manager manager = new Manager();
	public JLabel lblUsername;
	public JTextField textUsername;
	public JLabel lblPassword;
	public JTextField textPassword;
	public JButton btnUpdate;

	/**
	 * Create the panel.
	 */
	public ManagerPanel() {
		setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(94, 22, 46, 14);
		add(lblName);
		
		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setEnabled(false);
		lblTelephone.setBounds(94, 47, 79, 14);
		add(lblTelephone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(94, 72, 46, 14);
		add(lblEmail);
		
		JLabel lblImid = new JLabel("IM_ID");
		lblImid.setBounds(94, 94, 46, 14);
		add(lblImid);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(94, 126, 46, 14);
		add(lblGender);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(94, 151, 103, 14);
		add(lblDateOfBirth);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(94, 176, 61, 14);
		add(lblAddress);
		
		JLabel lblBiometricId = new JLabel("Biometric ID");
		lblBiometricId.setBounds(94, 201, 91, 14);
		add(lblBiometricId);
		
		textName = new JTextField();
		textName.setBounds(227, 19, 86, 20);
		add(textName);
		textName.setColumns(10);
		
		textTelephone = new JTextField();
		textTelephone.setBounds(227, 44, 86, 20);
		add(textTelephone);
		textTelephone.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(227, 69, 86, 20);
		add(textEmail);
		textEmail.setColumns(10);
		
		textIM_ID = new JTextField();
		textIM_ID.setBounds(227, 94, 86, 20);
		add(textIM_ID);
		textIM_ID.setColumns(10);
		
		textGender = new JTextField();
		textGender.setBounds(227, 123, 86, 20);
		add(textGender);
		textGender.setColumns(10);
		
		textDOB = new JTextField();
		textDOB.setBounds(227, 148, 86, 20);
		add(textDOB);
		textDOB.setColumns(10);
		
		textAddress = new JTextField();
		textAddress.setBounds(227, 173, 86, 20);
		add(textAddress);
		textAddress.setColumns(10);
		
		textBiometricID = new JTextField();
		textBiometricID.setBounds(227, 198, 86, 20);
		add(textBiometricID);
		textBiometricID.setColumns(10);
		
		btnCreateNewAccount = new JButton("Create New Account");
		btnCreateNewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCreateNewAccount.setBounds(54, 248, 173, 23);
		add(btnCreateNewAccount);
		
		btnIWillTry = new JButton("I will create it later");
		
		btnIWillTry.setBounds(237, 248, 157, 23);
		add(btnIWillTry);
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(364, 44, 95, 15);
		add(lblUsername);
		
		textUsername = new JTextField();
		textUsername.setBounds(345, 69, 114, 19);
		add(textUsername);
		textUsername.setColumns(10);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(364, 114, 95, 15);
		add(lblPassword);
		
		textPassword = new JTextField();
		textPassword.setBounds(345, 146, 114, 19);
		add(textPassword);
		textPassword.setColumns(10);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(158, 283, 117, 25);
		add(btnUpdate);
	}

}
