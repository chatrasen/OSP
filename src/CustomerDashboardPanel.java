import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CustomerDashboardPanel extends JPanel {
	
	public 	JButton btnSeller;
	public 	JButton btnBuyer;
	private JLabel lblYouHaveSuccessfully;
	/**
	 * Create the panel.
	 */
	public CustomerDashboardPanel() {
		setLayout(null);
		
		JLabel lblActAsA = new JLabel("Act as a");
		lblActAsA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblActAsA.setBounds(189, 138, 106, 14);
		add(lblActAsA);
		
		btnBuyer = new JButton("Buyer");
		btnBuyer.setBounds(110, 173, 89, 23);
		add(btnBuyer);
		
		btnSeller = new JButton("Seller");
		
		
		btnSeller.setBounds(244, 173, 89, 23);
		add(btnSeller);
		
		lblYouHaveSuccessfully = new JLabel("You have successfully logged in as a customer");
		lblYouHaveSuccessfully.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblYouHaveSuccessfully.setBounds(37, 39, 430, 31);
		add(lblYouHaveSuccessfully);
	}

}
