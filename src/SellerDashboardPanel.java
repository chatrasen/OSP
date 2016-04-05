import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SellerDashboardPanel extends JPanel {

	public JButton btnUploadAnItem;
	public JButton btnLogout;

	/**
	 * Create the panel.
	 */
	public SellerDashboardPanel() {
		setLayout(null);
		
		btnUploadAnItem = new JButton("Upload an Item");
		
		
		btnUploadAnItem.setBounds(68, 61, 151, 23);
		add(btnUploadAnItem);
		
		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogout.setBounds(312, 11, 89, 23);
		add(btnLogout);
		
	}

}
