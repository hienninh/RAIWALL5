package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.entity.JdbcUtils;

public class Ex4JdbcUtils {
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		JdbcUtils ex4 = new JdbcUtils();
		ex4.isConnectedForTesting();
		ex4.Connect();
//		ex4.disconnect();
	}

	
}
