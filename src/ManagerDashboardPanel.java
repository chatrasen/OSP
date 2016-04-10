import javax.swing.JPanel;
import javax.swing.JButton;

public class ManagerDashboardPanel extends JPanel {

	
	public JButton btnUpdateProfile;
	/**
	 * Create the panel.
	 */
	public ManagerDashboardPanel() {
		setLayout(null);
		
		btnUpdateProfile = new JButton("Update Profile");
		btnUpdateProfile.setBounds(284, 12, 154, 25);
		add(btnUpdateProfile);
	}
}
