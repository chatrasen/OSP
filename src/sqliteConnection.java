import java.sql.*;
import javax.swing.*;

public class sqliteConnection {
	public static Connection dbConnector()
	{
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:user_data.sqlite");
			//JOptionPane.showMessageDialog(null, "Connection successful");
			return conn;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
