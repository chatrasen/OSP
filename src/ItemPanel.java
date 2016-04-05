import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class ItemPanel extends JPanel {
	public JTextField textCategory;
	public JTextField textPrice;
	public JTextField textAge;
	public JTextField textCompanyName;
	public JTextField textCity;
	public JTextField textWeight;
	public JTextField textDetails;
	public JTextField textImage;
	
	public JButton btnUploadItem;
	public JButton btnUploadImage;
	
	public Item item = new Item();

	/**
	 * Create the panel.
	 */
	public ItemPanel() {
		setLayout(null);
		
		JLabel lblCategories = new JLabel("Category");
		lblCategories.setBounds(75, 38, 68, 14);
		add(lblCategories);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(75, 63, 68, 14);
		add(lblPrice);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(75, 93, 46, 14);
		add(lblAge);
		
		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setBounds(75, 116, 95, 14);
		add(lblCompanyName);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(75, 141, 46, 14);
		add(lblCity);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setBounds(75, 177, 68, 14);
		add(lblWeight);
		
		JLabel lblDetails = new JLabel("Details");
		lblDetails.setBounds(75, 207, 57, 14);
		add(lblDetails);
		
		textCategory = new JTextField();
		textCategory.setBounds(177, 35, 129, 20);
		add(textCategory);
		textCategory.setColumns(10);
		
		textPrice = new JTextField();
		textPrice.setBounds(177, 60, 129, 20);
		add(textPrice);
		textPrice.setColumns(10);
		
		textAge = new JTextField();
		textAge.setBounds(177, 87, 129, 20);
		add(textAge);
		textAge.setColumns(10);
		
		textCompanyName = new JTextField();
		textCompanyName.setBounds(177, 113, 129, 20);
		add(textCompanyName);
		textCompanyName.setColumns(10);
		
		textCity = new JTextField();
		textCity.setBounds(177, 138, 129, 20);
		add(textCity);
		textCity.setColumns(10);
		
		textWeight = new JTextField();
		textWeight.setBounds(177, 169, 129, 20);
		add(textWeight);
		textWeight.setColumns(10);
		
		textDetails = new JTextField();
		textDetails.setBounds(177, 204, 129, 20);
		add(textDetails);
		textDetails.setColumns(10);
		
		btnUploadItem = new JButton("Upload Item");
		
		btnUploadItem.setBounds(144, 247, 121, 23);
		add(btnUploadItem);
		
		btnUploadImage = new JButton("Upload Image");
		btnUploadImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		          File selectedFile = fileChooser.getSelectedFile();
		          
		          textImage.setText(selectedFile.getAbsolutePath());
		        }
			}
		});
		btnUploadImage.setBounds(329, 84, 111, 23);
		add(btnUploadImage);
		
		textImage = new JTextField();
		textImage.setBounds(339, 113, 86, 20);
		add(textImage);
		textImage.setColumns(10);
		
	}
}
