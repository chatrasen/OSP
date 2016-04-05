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
	private JTextField textSearch;
	public JButton btnDisplayCategories;
	public JList<String> listCategories;
	
	public DefaultListModel<String> model = new DefaultListModel<String>();
	public JList<Object> listDisplay;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	
	public DefaultListModel<Object> modelDisplay = new DefaultListModel<Object>();

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
		
		textSearch = new JTextField();
		textSearch.setBounds(101, 30, 209, 20);
		add(textSearch);
		textSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(320, 29, 89, 23);
		add(btnSearch);		
		
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
		
		
		
		
		//add(new JScrollPane(listCategories));
		
	}
}
