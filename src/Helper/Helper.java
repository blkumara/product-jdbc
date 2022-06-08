package Helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Helper {

	Connection connection=null;
	public  Connection getConnectionObj()
	{
		Properties properties=new Properties();
		InputStream inputStream;
		try {
			inputStream = new FileInputStream("database.properties");
		
		
		properties.load(inputStream);
		
		String  url=properties.getProperty("url");
		String driver=properties.getProperty("driver");
		
			Class.forName(driver);
			connection=DriverManager.getConnection(url,properties);
			
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return connection;
	} 

}
