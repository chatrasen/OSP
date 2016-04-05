import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ImageSpecs extends JPanel {

	public JTextArea textArea;
	public JLabel lblImage;
	public JButton btnBack;
	private JButton btnAddToCart;
	/**
	 * Create the panel.
	 */
	public ImageSpecs() {
		setLayout(null);
		
		lblImage = new JLabel("");
		lblImage.setBounds(10, 25, 172, 182);
		add(lblImage);
		
		JLabel lblSpecifications = new JLabel("Specifications");
		lblSpecifications.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSpecifications.setBounds(222, 25, 183, 25);
		add(lblSpecifications);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(195, 61, 234, 234);
		add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		
		btnBack = new JButton("Back");
		
		btnBack.setBounds(57, 259, 89, 23);
		add(btnBack);
		
		btnAddToCart = new JButton("Add to Cart");
		btnAddToCart.setBounds(258, 306, 89, 23);
		add(btnAddToCart);
		
	}	
}
