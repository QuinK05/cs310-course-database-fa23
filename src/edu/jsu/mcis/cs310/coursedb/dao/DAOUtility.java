package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.*;
import java.util.ArrayList;

public class DAOUtility {
    
    public static final int TERMID_FA23 = 1;
    
    public static String getResultSetAsJson(ResultSet rs, ResultSetMetaData rsmd, int columnCount) {
        
        JsonArray records = new JsonArray();
        
        try {
        
            if (rs != null) {
                
                rsmd = rs.getMetaData();
                columnCount = rsmd.getColumnCount();
                
                while (rs.next()){
                
                JsonObject jsonObject = new JsonObject();
                
                for (int i = 1; i <= columnCount; ++i){
                    jsonObject.put(rsmd.getColumnLabel(i), rs.getString(i));
                }
                records.add(jsonObject);

            }
            
        }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return Jsoner.serialize(records);
        
    }

    static String getResultSetAsJson(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
