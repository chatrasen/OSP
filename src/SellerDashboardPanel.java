import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SellerDashboardPanel extends JPanel {

	public JButton btnUploadAnItem;
	/**
	 * Create the panel.
	 */
	public SellerDashboardPanel() {
		setLayout(null);
		
		btnUploadAnItem = new JButton("Upload an Item");
		
		
		btnUploadAnItem.setBounds(130, 71, 151, 23);
		add(btnUploadAnItem);
		
	}

}
