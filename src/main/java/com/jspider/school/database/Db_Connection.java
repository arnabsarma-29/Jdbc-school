package com.jspider.school.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Db_Connection
{
	private static String url = "jdbc:postgresql://localhost:5432/jdbc_school";
	private static String uname = "postgres";
	private static String pwd = "123";
	public static Connection getConnection () throws ClassNotFoundException , SQLException
	{
		Class.forName ("org.postgresql.Driver");
		return DriverManager.getConnection (url, uname, pwd);
	}
}