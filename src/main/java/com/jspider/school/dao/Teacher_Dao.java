package com.jspider.school.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.jspider.school.database.Db_Connection;
import com.jspider.school.model.Teacher;
public class Teacher_Dao
{
	public Teacher add (Teacher t)
	{
		String sql = "insert into teacher values (?, ?, ?, ?, ?)";
		try (Connection con = Db_Connection.getConnection (); PreparedStatement ps = con.prepareStatement (sql))
		{
			ps.setInt (1, t.getId ());
			ps.setString (2, t.getName ());
			ps.setString (3, t.getDept ());
			ps.setString (4, t.getSubject ());
			ps.setInt (5, t.getClass_no ());
			ps.executeUpdate ();
			return t;
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace ();
		}
		return null;
	}
	public Teacher update (int id, int class_no)
	{
		String sql = "update teacher set class_no = ? where id = ?";
		try (Connection con = Db_Connection.getConnection (); PreparedStatement ps = con.prepareStatement (sql))
		{
			ps.setInt (1, class_no);
			ps.setInt (2, id);
			ps.executeUpdate ();
			return new Teacher (id, null, null, null, class_no);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace ();
		}
		return null;
	}
	public boolean delete (int id)
	{
		String sql = "delete from teacher where id = ?";

		try (Connection con = Db_Connection.getConnection (); PreparedStatement ps = con.prepareStatement (sql))
		{
			ps.setInt (1, id);
			ps.executeUpdate ();
			return true;
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace ();
		}
		return false;
	}
	public List <Teacher> getAll ()
	{
		String sql = "select * from teacher";
		List <Teacher> list = new ArrayList <> ();
		try (Connection con = Db_Connection.getConnection (); PreparedStatement ps = con.prepareStatement (sql); ResultSet rs = ps.executeQuery ())
		{
			while (rs.next ())
			{
				Teacher t = new Teacher (rs.getInt (1), rs.getString (2), rs.getString (3), rs.getString (4), rs.getInt (5));
				list.add (t);
				System.out.println (t);
			}
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace ();
		}
		return list;
	}
	public void execute_query ()
	{
		String sql = "select t.*, s.id as student_id, s.name as student_name from teacher t join student s on t.class_no = s.class_no order by t.id, s.id";
		try (Connection con = Db_Connection.getConnection (); PreparedStatement ps = con.prepareStatement (sql); ResultSet rs = ps.executeQuery ())
		{
			while (rs.next ())
			{
				Teacher t = new Teacher (rs.getInt (1), rs.getString (2), rs.getString (3), rs.getString (4), rs.getInt (5));
				System.out.println (t + " | student_id = " + rs.getInt (6) + " | student_name = " + rs.getString (7));
			}
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace ();
		}
	}
	public void meta_data ()
	{
		try (Connection con = Db_Connection.getConnection ())
		{
			DatabaseMetaData m_data = con.getMetaData ();
			System.out.println ("Driver name: " + m_data.getDriverName ());
			System.out.println ("Driver version: " + m_data.getDriverVersion ());
			System.out.println ("DB Product Name: " + m_data.getDatabaseProductName ());
			System.out.println ("DB Product Version: " + m_data.getDatabaseProductVersion ());
			String sql = "select * from teacher limit 1";
			PreparedStatement ps = con.prepareStatement (sql);
			ResultSet rs = ps.executeQuery ();
			ResultSetMetaData data = rs.getMetaData ();
			System.out.println ("No. of columns: " + data.getColumnCount ());
			System.out.println ("Column type: " + data.getColumnTypeName (1));
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace ();
		}
	}
}