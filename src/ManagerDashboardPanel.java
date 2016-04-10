import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;

public class ManagerDashboardPanel extends JPanel {

	
	public JButton btnUpdateProfile;
	public JButton btnLogout;
	
	public JList<String> listCustomers;
	public JList<Object> listItems;
	
	public DefaultListModel<String> modelCustomers = new DefaultListModel<String>();
	public DefaultListModel<Object> modelItems = new DefaultListModel<Object>();
	/**
	 * Create the panel.
	 */
	public ManagerDashboardPanel() {
		setLayout(null);
		
		btnUpdateProfile = new JButton("Update Profile");
		btnUpdateProfile.setBounds(28, 22, 154, 25);
		add(btnUpdateProfile);
		
		btnLogout = new JButton("Logout");
		btnLogout.setBounds(338, 22, 117, 25);
		add(btnLogout);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 114, 159, 151);
		add(scrollPane);
		
		listCustomers = new JList<String>(modelCustomers);
		scrollPane.setViewportView(listCustomers);
		
		JLabel lblCustomers = new JLabel("Customers");
		lblCustomers.setBounds(64, 87, 101, 15);
		add(lblCustomers);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(338, 122, 138, 143);
		add(scrollPane_1);
		
		listItems = new JList<Object>(modelItems);
		scrollPane_1.setViewportView(listItems);
		
		JLabel lblItems = new JLabel("Items");
		lblItems.setBounds(373, 95, 82, 15);
		add(lblItems);
	}
}
