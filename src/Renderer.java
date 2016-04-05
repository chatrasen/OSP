import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class Renderer extends DefaultListCellRenderer implements ListCellRenderer<Object>{
	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus)
	{
		ImagesAndText is = (ImagesAndText) value; 
		setText(is.getName());
		setIcon(is.getImg());
			
		if(isSelected)
		{
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		}
		else
		{
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}
		setEnabled(true);
		setFont(list.getFont());
		
		return this;
	}
}
