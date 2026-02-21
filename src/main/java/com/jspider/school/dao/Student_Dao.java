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
import com.jspider.school.model.Student;
public class Student_Dao
{
	public Student add (Student s)
	{
		String sql = "insert into student values (?, ?, ?)";
		try (Connection con = Db_Connection.getConnection (); PreparedStatement ps = con.prepareStatement (sql))
		{
			ps.setInt (1, s.getId ());
			ps.setString (2, s.getName ());
			ps.setInt (3, s.getClass_no ());
			ps.executeUpdate ();
			return s.isInserted () ? s : null;
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace ();
		}
		return null;
	}
	public Student update (int id, int class_no)
	{
		String sql = "update student set class_no = ? where id = ?";
		try (Connection con = Db_Connection.getConnection (); PreparedStatement ps = con.prepareStatement (sql))
		{
			ps.setInt (1, class_no);
			ps.setInt (2, id);
			ps.executeUpdate ();
			return new Student (id, null, class_no);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace ();
		}
		return null;
	}
	public boolean delete (int id)
	{
		String sql = "delete from student where id = ?";
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
	public List <Student> getAll ()
	{
		String sql = "select * from student";
		List <Student> list = new ArrayList <> ();
		try (Connection con = Db_Connection.getConnection (); PreparedStatement ps = con.prepareStatement (sql); ResultSet rs = ps.executeQuery ())
		{
			while (rs.next ())
			{
				Student s = new Student (rs.getInt (1), rs.getString (2), rs.getInt (3));
				list.add (s);
				System.out.println (s);
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
		String sql = "select s.*, t.name as teacher_name from student s join teacher t on s.class_no = t.class_no";
		try (Connection con = Db_Connection.getConnection (); PreparedStatement ps = con.prepareStatement (sql); ResultSet rs = ps.executeQuery ())
		{
			while (rs.next ())
			{
				Student s = new Student (rs.getInt (1), rs.getString (2), rs.getInt (3));
				System.out.println (s + " | teacher_name = " + rs.getString (4));
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
			String sql = "select * from student limit 1";
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