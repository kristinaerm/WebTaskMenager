/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermenager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Кристина
 */
public class Test {
     static {
        Locale.setDefault(Locale.ENGLISH);
             }
    public String testic() throws SQLException 
    {
        Statement st;
             ResultSet rs = null;
         try {
             Context initContext = new InitialContext();
             Context envContext = (Context) initContext.lookup("java:/comp/env");
             DataSource ds = (DataSource) envContext.lookup("jdbc/TestDB");
             Connection conn = ds.getConnection();
             
             System.out.println("Connection Established");
             
             
             st = conn.createStatement();
             rs = st.executeQuery("SELECT id_task FROM task");
             rs.next();
             
         } catch (NamingException ex) {
             Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
         }
       return rs.getString(1);
              
    }
}
