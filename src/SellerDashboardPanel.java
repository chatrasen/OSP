import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class SellerDashboardPanel extends JPanel {

	public JButton btnUploadAnItem;
	public JButton btnLogout;

	/**
	 * Create the panel.
	 */
	public SellerDashboardPanel() {
		setLayout(null);
		
		btnUploadAnItem = new JButton("Upload an Item");
		
		
		btnUploadAnItem.setBounds(169, 53, 151, 23);
		add(btnUploadAnItem);
		
		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogout.setBounds(393, 11, 89, 23);
		add(btnLogout);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(336, 100, 170, 162);
		add(scrollPane);
		
		JLabel lblNegotiations = new JLabel("Negotiation Requests");
		lblNegotiations.setBounds(368, 84, 125, 14);
		add(lblNegotiations);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 100, 160, 162);
		add(scrollPane_1);
		
		JLabel lblUploadedItems = new JLabel("Uploaded Items");
		lblUploadedItems.setBounds(39, 84, 114, 14);
		add(lblUploadedItems);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(180, 165, 140, 142);
		add(scrollPane_2);
		
		JLabel lblBuyingRequests = new JLabel("Buying Requests");
		lblBuyingRequests.setBounds(206, 140, 114, 14);
		add(lblBuyingRequests);
		
	}

}
