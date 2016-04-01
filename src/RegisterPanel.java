import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class RegisterPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public 	JButton btnCustomer;
	public 	JButton btnManager;
	
	public RegisterPanel() {
		setLayout(null);
		
		btnManager = new JButton("Manager");
		btnManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnManager.setBounds(259, 132, 89, 23);
		add(btnManager);
		
		btnCustomer = new JButton("Customer");
		
		btnCustomer.setBounds(103, 132, 103, 23);
		add(btnCustomer);
		
		JLabel lblRegisterAs = new JLabel("Register as");
		lblRegisterAs.setBounds(186, 97, 89, 14);
		add(lblRegisterAs);
		
	}

}
