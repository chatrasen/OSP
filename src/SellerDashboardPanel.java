import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;

public class SellerDashboardPanel extends JPanel {

	public JButton btnUploadAnItem;
	public JButton btnLogout;
	
	public JList<Object> listUploadedItems;
	public JList<Object> listNegoReq;
	public JList<Object> listBuyReq;
	
	public DefaultListModel<Object> modelUpload = new DefaultListModel<Object>();
	public DefaultListModel<Object> modelNego = new DefaultListModel<Object>();
	public DefaultListModel<Object> modelBuy = new DefaultListModel<Object>();

	public JButton btnUpdateProfile;
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
		
		listNegoReq = new JList<Object>(modelNego);
		scrollPane.setViewportView(listNegoReq);
		
		JLabel lblNegotiations = new JLabel("Negotiation Requests");
		lblNegotiations.setBounds(368, 84, 125, 14);
		add(lblNegotiations);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 100, 160, 162);
		add(scrollPane_1);
		
		listUploadedItems = new JList<Object>(modelUpload);
		scrollPane_1.setViewportView(listUploadedItems);
		
		JLabel lblUploadedItems = new JLabel("Uploaded Items");
		lblUploadedItems.setBounds(39, 84, 114, 14);
		add(lblUploadedItems);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(180, 165, 140, 142);
		add(scrollPane_2);
		
		listBuyReq = new JList<Object>(modelBuy);
		scrollPane_2.setViewportView(listBuyReq);
		
		JLabel lblBuyingRequests = new JLabel("Buying Requests");
		lblBuyingRequests.setBounds(206, 140, 114, 14);
		add(lblBuyingRequests);
		
		btnUpdateProfile = new JButton("Update Profile");
		btnUpdateProfile.setBounds(12, 10, 170, 25);
		add(btnUpdateProfile);
		
	}

}
