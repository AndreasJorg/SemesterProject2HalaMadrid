package test;

import java.sql.SQLException;

import java.sql.Connection;
import db.DBConnection;
import db.DataAccessException;


public class TestConnection {

	public static void main(String[] args)  throws DataAccessException, SQLException {
		Connection con = DBConnection.getInstance().getConnection();
	}
		
}
 