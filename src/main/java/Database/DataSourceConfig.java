package Database;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * 
 * @author Kiren Gondal
 *
 */

@Configuration
@EnableJdbcRepositories("packages.to.scan")
public class DataSourceConfig extends AbstractJdbcConfiguration {
	
	static Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);
	
	static String url = "jdbc:mysql://localhost:3306/dpadmin"; 
    static String user="root";
    static String password="Jahangirjk53,";
    
    // NamedParameterJdbcOperations is used internally to submit SQL statements to the database
	
    @Bean
    NamedParameterJdbcOperations operations() {
        return new NamedParameterJdbcTemplate(dataSource());
    }

    @Bean
    PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/dpadmin?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("Jahangirjk53");
        return dataSource;
    }
    
    //this method is used to insert Data in our Database for the employees
    public static void main (String[] args) { 
        try { 
        	
        	String sql = "Select * from mitarbeiter";
        	String sql1 = "Select * from administrator";
        	
            
            Connection conn = DriverManager.getConnection(url, user,password); 
            
            Statement st = conn.createStatement(); 
            
            //fill table mitarbeiter
            st.executeUpdate("INSERT INTO mitarbeiter " + 
                "VALUES (103, 'Ali', 'Ahmed', 'password')"); 

            st.executeUpdate("INSERT INTO mitarbeiter " + 
                 "VALUES (102, 'Nadia', 'Gondal', 'password')");
            
            //fill table admin            
            st.executeUpdate("INSERT INTO administrator " + 
                    "VALUES (101, 'Kiren', 'Gondal', 'admin')");
            
            System.out.println("successfully inserted");
            
            
            // The method shows us all the data saved in a table
            Statement s = conn.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            
            while (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("Employee ID:" +count);
            }            
            
            conn.close(); 
            
            
        } catch (Exception e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
        } 
}
}