package com.jspider.school;
import java.util.Scanner;
import com.jspider.school.dao.Student_Dao;
import com.jspider.school.dao.Teacher_Dao;
import com.jspider.school.model.Student;
import com.jspider.school.model.Teacher;
public class Driver
{
	public static void main (String [] args)
	{
		Scanner scn = new Scanner (System.in);
		boolean flag = true;
		while (flag)
		{
			System.out.println ("1. Student");
			System.out.println ("2. Teacher");
			System.out.println ("0. Exit");
			System.out.print ("Input: ");
			int in = scn.nextInt ();
			switch (in)
			{
				case 0:
					flag = false;
					System.out.println ("Program Terminated");
					break;
				case 1:
					studentMenu (scn);
					break;
				case 2:
					teacherMenu (scn);
					break;
				default:
					System.out.println ("Invalid Choice");
			}
		}
		scn.close ();
	}
	public static void studentMenu (Scanner scn)
	{
		Student_Dao s_dao = new Student_Dao ();
		System.out.println ("1. Insert");
		System.out.println ("2. Update");
		System.out.println ("3. Delete");
		System.out.println ("4. Show All");
		System.out.println ("5. Execute Query");
		System.out.println ("6. Meta Data");
		System.out.print ("Input: ");
		int in = scn.nextInt ();
		switch (in)
		{
			case 1:
				System.out.print ("Enter id: ");
				int id = scn.nextInt ();
				scn.nextLine ();
				System.out.print ("Enter name: ");
				String name = scn.nextLine ();
				System.out.print ("Enter class_no: ");
				int classNo = scn.nextInt ();
				Student s = new Student (id, name, classNo);
				s_dao.add (s);
				break;
			case 2:
				System.out.print ("Enter id: ");
				id = scn.nextInt ();
				System.out.print ("Enter new class_no: ");
				classNo = scn.nextInt ();
				s_dao.update (id, classNo);
				break;
			case 3:
				System.out.print ("Enter id: ");
				s_dao.delete (scn.nextInt ());
				break;
			case 4:
				s_dao.getAll ();
				break;
			case 5:
				s_dao.execute_query ();
				break;
			case 6:
				s_dao.meta_data ();
				break;
			default:
				System.out.println ("Invalid Choice");
		}
	}
	public static void teacherMenu (Scanner scn)
	{
		Teacher_Dao t_dao = new Teacher_Dao ();
		System.out.println ("1. Insert");
		System.out.println ("2. Update");
		System.out.println ("3. Delete");
		System.out.println ("4. Show All");
		System.out.println ("5. Execute Query");
		System.out.println ("6. Meta Data");
		System.out.print ("Input: ");
		int in = scn.nextInt ();
		switch (in)
		{
			case 1:
				System.out.print ("Enter id: ");
				int id = scn.nextInt ();
				scn.nextLine ();
				System.out.print ("Enter name: ");
				String name = scn.nextLine ();
				System.out.print ("Enter dept: ");
				String dept = scn.nextLine ();
				System.out.print ("Enter subject: ");
				String subject = scn.nextLine ();
				System.out.print ("Enter class_no: ");
				int classNo = scn.nextInt ();
				Teacher t = new Teacher (id, name, dept, subject, classNo);
				t_dao.add (t);
				break;
			case 2:
				System.out.print ("Enter id: ");
				id = scn.nextInt ();
				System.out.print ("Enter new class_no: ");
				classNo = scn.nextInt ();
				t_dao.update (id, classNo);
				break;
			case 3:
				System.out.print ("Enter id: ");
				t_dao.delete (scn.nextInt ());
				break;
			case 4:
				t_dao.getAll ();
				break;
			case 5:
				t_dao.execute_query ();
				break;
			case 6:
				t_dao.meta_data ();
				break;
			default:
				System.out.println ("Invalid Choice");
		}
	}
}