package com.wax.JavaBeen;

public class Class_Info {
	private String class_id ;
	private String class_grade ;
	private String class_name  ;
	private String class_major  ;
	private String class_academy  ;
	public String getClass_grade() {
		return class_grade;
	}
	public Class_Info(String class_id, String class_grade, String class_name, String class_major,
			String class_academy) {
		super();
		this.class_id = class_id;
		this.class_grade = class_grade;
		this.class_name = class_name;
		this.class_major = class_major;
		this.class_academy = class_academy;
	}
	public Class_Info() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Class_Info [class_id=" + class_id + ", class_grade=" + class_grade + ", class_name=" + class_name
				+ ", class_major=" + class_major + ", class_academy=" + class_academy + "]";
	}
	public void setClass_grade(String class_grade) {
		this.class_grade = class_grade;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getClass_major() {
		return class_major;
	}
	public void setClass_major(String class_major) {
		this.class_major = class_major;
	}
	public String getClass_academy() {
		return class_academy;
	}
	public void setClass_academy(String class_academy) {
		this.class_academy = class_academy;
	}
	public String getClass_id() {
		return class_id;
	}
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
	
}
