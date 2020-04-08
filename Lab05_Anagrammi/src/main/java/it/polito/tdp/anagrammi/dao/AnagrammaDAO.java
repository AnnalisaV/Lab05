package it.polito.tdp.anagrammi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.anagrammi.model.Parola;


public class AnagrammaDAO {

	public boolean parolaValida(Parola parola) {
		
		String sql = "SELECT * FROM parola WHERE nome= ? "; 
	
		try {
		Connection conn= ConnectDB.getConnection(); 
		PreparedStatement st= conn.prepareStatement(sql); 
		st.setString(1, parola.getWord());
		
		ResultSet res= st.executeQuery(); 
		
		if(res.next()) {
			conn.close(); 
			return true; 
			
		}else {
			conn.close(); 
			return false; // non ha trovato manco una riga 
		}
		
		
		}catch(SQLException e) {
		throw new RuntimeException(); 
	}

	}
	
	

}
