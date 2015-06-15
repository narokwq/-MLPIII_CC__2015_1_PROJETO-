package unipe.mpf.dados;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionFactory {
	public Connection getConnection(){
		 Properties propBanco = new Properties();
	     try {
	    	 
	    	 propBanco.load(new FileInputStream("src/unipe/mpf/resources/database.properties"));
	    	 
	         return DriverManager.getConnection("jdbc:postgresql://"+propBanco.getProperty("url")+"/"+propBanco.getProperty("database"), propBanco);

	     } catch (SQLException | IOException e) {

	         throw new RuntimeException(e);

	     } 

	 }
}
