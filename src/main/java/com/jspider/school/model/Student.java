package com.jspider.school.model;
public class Student
{
	private int id;
	private String name;
	private int class_no;
	public Student (int id, String name, int class_no)
	{
		this.id = id;
		this.name = name;
		this.class_no = class_no;
	}
	public int getId ()
	{
		return id;
	}
	public String getName ()
	{
		return name;
	}
	public int getClass_no ()
	{
		return class_no;
	}
	@Override
	public String toString ()
	{
		return "student [id = " + id + ", name = " + name + ", class_no = " + class_no + "]";
	}
	public boolean isInserted ()
	{
		return true;
	}
	public boolean isUpdated ()
	{
		return true;
	}
	public boolean isDeleted ()
	{
		return true;
	}
}