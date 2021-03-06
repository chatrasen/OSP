import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BuyerDashboardPanel extends JPanel {
	public JButton btnDisplayCategories;
	public JList<String> listCategories;
	
	public DefaultListModel<String> model = new DefaultListModel<String>();
	public JList<Object> listDisplay;
	public JScrollPane scrollPane;
	public JScrollPane scrollPane_1;
	
	public DefaultListModel<Object> modelDisplay = new DefaultListModel<Object>();
	public DefaultListModel<Object> modelCart = new DefaultListModel<Object>();
	public DefaultListModel<Object> modelMessages = new DefaultListModel<Object>();

	public JButton btnLogout;
	public JScrollPane scrollPane_2;
	public JList<Object> listCart;
	public JLabel lblCart;
	public JScrollPane scrollPane_3;
	public JList<Object> listMessages;
	public JLabel lblMessages;
	public JButton btnPlaceOrder;
	public JButton btnUpdateProfile;

	/**
	 * Create the panel.
	 */
	public BuyerDashboardPanel() {
		setLayout(null);
		
		JLabel lblCategories = new JLabel("Categories");
		lblCategories.setBounds(43, 76, 74, 14);
		add(lblCategories);
		
		btnDisplayCategories = new JButton("Display Categories");
		
		btnDisplayCategories.setBounds(10, 274, 142, 23);
		add(btnDisplayCategories);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 142, 151);
		add(scrollPane);
		
		listCategories = new JList<String>(model);
		scrollPane.setViewportView(listCategories);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(175, 72, 220, 214);
		add(scrollPane_1);
		
		listDisplay = new JList<Object>(modelDisplay);
		
		scrollPane_1.setViewportView(listDisplay);
		
		btnLogout = new JButton("Logout");
		
		btnLogout.setBounds(450, 11, 89, 23);
		add(btnLogout);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(424, 76, 147, 123);
		add(scrollPane_2);
		
		listCart = new JList<Object>(modelCart);
		scrollPane_2.setViewportView(listCart);
		
		lblCart = new JLabel("Cart");
		lblCart.setBounds(454, 51, 46, 14);
		add(lblCart);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(434, 235, 137, 115);
		add(scrollPane_3);
		
		listMessages = new JList<Object>(modelMessages);
		scrollPane_3.setViewportView(listMessages);
		
		lblMessages = new JLabel("Messages");
		lblMessages.setBounds(454, 210, 85, 14);
		add(lblMessages);
		
		btnPlaceOrder = new JButton("Place Order");
		btnPlaceOrder.setBounds(211, 310, 147, 23);
		add(btnPlaceOrder);
		
		btnUpdateProfile = new JButton("Update Profile");
		btnUpdateProfile.setBounds(57, 10, 165, 25);
		add(btnUpdateProfile);
		
		
		
		
		//add(new JScrollPane(listCategories));
		
	}
}
