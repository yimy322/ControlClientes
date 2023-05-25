package datos;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author yimy
 */
public class Conexion {
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/control_clientes?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "123456";
    
    private static BasicDataSource dataSource;
    
    public static DataSource getDataSource(){
        
        if (dataSource==null) {
            dataSource = new BasicDataSource();
            
            ds.setUrl(JDBC_URL);
            ds.setUsername(JDBC_USER);
            ds.setPassword(JDBC_PASSWORD);
            
            ds.setInitialSize(50);
        }
        
        
        
        return ds;
        
    } 
    
    public static Connection getConnection() throws SQLException{
        
        return getDataSource().getConnection();
        
    }
    
    public static void close(ResultSet rs) throws SQLException{
        
        rs.close();
        
    }
    
    public static void close(Statement smtm) throws SQLException{
        
        smtm.close();
        
    }
    
    public static void close(PreparedStatement smtm) throws SQLException{
        
        smtm.close();
        
    }
    
    public static void close(Connection conn) throws SQLException{
        
        conn.close();
        
    }
    
}
