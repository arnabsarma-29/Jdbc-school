package com.jspider.school.model;
public class Teacher
{
	private int id;
	private String name;
	private String dept;
	private String subject;
	private int class_no;
	public Teacher (int id, String name, String dept, String subject, int class_no)
	{
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.subject = subject;
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
	public String getDept ()
	{
		return dept;
	}
	public String getSubject ()
	{
		return subject;
	}
	public int getClass_no ()
	{
		return class_no;
	}
	@Override
	public String toString()
	{
		return "teacher [id = " + id + ", name = " + name + ", dept = " + dept + ", subject = " + subject + ", class_no = " + class_no + "]";
	}
}